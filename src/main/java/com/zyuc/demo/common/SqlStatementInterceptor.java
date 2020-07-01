package com.zyuc.demo.common;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Matcher;

/**
 * @Version 1.0
 * @Description mybatis日志拦截并打印
 * @Date 2020/4/28 9:18
 * @Created by ChenHao
 */
@Component
@Intercepts(value = {
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class SqlStatementInterceptor implements Interceptor {

    private static Logger logger = LoggerFactory.getLogger(SqlStatementInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return invocation.proceed();//执行sql过程
        } finally {
            long endTime = System.currentTimeMillis();
            MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];//获取xml中的一个select/update/insert/delete节点，主要描述的是一条SQL语句
            Object parameter = "";
            if (invocation.getArgs().length > 1) {
                parameter = invocation.getArgs()[1];
            }
            String sqlId = mappedStatement.getId(); // 获取到节点的id,即sql语句的id
            String resultType = mappedStatement.getResultMaps().get(0).getType().getName();//获取结果类型
            BoundSql boundSql = mappedStatement.getBoundSql(parameter);// BoundSql就是封装myBatis最终产生的sql类
            Configuration configuration = mappedStatement.getConfiguration();// 获取节点的配置
            StringBuilder sb = new StringBuilder();

            String lineSeparator = System.getProperty("line.separator", "\n");
            sb.append(lineSeparator + "┏━━━━━ Debug ").append(lineSeparator).append("┣ SQL：\t "
                    + getSql(configuration, boundSql) + lineSeparator).append("┣ 参数：\t " + parameter + "(" + parameter.getClass().getName() + ")" + lineSeparator)
                    .append("┣ 位置：\t " + sqlId + lineSeparator).append("┣ 耗时：\t " + (endTime - startTime) + "ms" +
                    lineSeparator).append("┣ 返回：\t " + resultType + lineSeparator).append("┗━━━━━ Debug ").append(lineSeparator);

            logger.info(sb.toString());
        }
    }

    /**
     * 获取带参SQL
     *
     * @param configuration 节点的配置
     * @param boundSql      封装myBatis最终产生的sql类
     * @return
     */
    public static String getSql(Configuration configuration, BoundSql boundSql) {
        Object parameterObject = boundSql.getParameterObject();//获取参数
        List<ParameterMapping> parameterMappings = boundSql
                .getParameterMappings();
        String sql = boundSql.getSql().replaceAll("[\\s]+", " ");//sql语句中多个空格都用一个空格代替
        if (parameterMappings.size() > 0 && parameterObject != null) {
            TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry(); //获取类型处理器注册器，类型处理器的功能是进行java类型和数据库类型的转换。如果根据parameterObject.getClass(）可以找到对应的类型，则替换
            if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                sql = sql.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(parameterObject)));
            } else {
                MetaObject metaObject = configuration.newMetaObject(parameterObject);//MetaObject主要是封装了originalObject对象，提供了get和set的方法用于获取和设置originalObject的属性值,主要支持对JavaBean、Collection、Map三种类型对象的操作
                for (ParameterMapping parameterMapping : parameterMappings) {
                    String propertyName = parameterMapping.getProperty();
                    if (metaObject.hasGetter(propertyName)) {
                        Object obj = metaObject.getValue(propertyName);
                        sql = sql.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(obj)));
                    } else if (boundSql.hasAdditionalParameter(propertyName)) {
                        Object obj = boundSql.getAdditionalParameter(propertyName);//该分支是动态sql
                        sql = sql.replaceFirst("\\?", Matcher.quoteReplacement(getParameterValue(obj)));
                    } else {
                        sql = sql.replaceFirst("\\?", "缺失");//打印出缺失，提醒该参数缺失并防止错位
                    }
                }
            }
        }
        return sql;
    }

    /**
     * 对SQL进行格式化
     *
     * @param obj
     * @return
     */
    private static String getParameterValue(Object obj) {
        String value = null;
        if (obj instanceof String) {
            value = "'" + obj.toString() + "'";
        } else if (obj instanceof Date) {
            DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT, Locale.CHINA);
            value = "'" + formatter.format(new Date()) + "'";
        } else {
            if (obj != null) {
                value = obj.toString();
            } else {
                value = "";
            }
        }
        return value;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

}

