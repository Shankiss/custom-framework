package com.zyuc.demo.core;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.List;
import java.util.Properties;

/**
 * @Version 1.0
 * @Description 自定义xml注释模板
 * @Date 2020/7/24 14:51
 * @Created by ChenHao
 */
public class CommentGenerator extends DefaultCommentGenerator {

    // 定义一个是否使用修改后的模式的标识
    private boolean suppressAllComments = true;

    // 设置实体类 属性注释
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            if (StringUtility.stringHasValue(introspectedColumn.getRemarks())) {
                StringBuilder sb = new StringBuilder();
                field.addJavaDocLine("/**");
                sb.append(" * ");
                sb.append(introspectedColumn.getRemarks());
                field.addJavaDocLine(sb.toString());
                field.addJavaDocLine(" */");
            }
        } else {
            super.addFieldComment(field, introspectedTable, introspectedColumn);
        }
    }

    // 设置实体类 getter注释
    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        return;
    }

    // 设置实体类 setter注释
    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
       return;
    }

    // 去掉mapper原始注释
    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        } else {
            super.addGeneralMethodComment(method, introspectedTable);
        }
    }

    // 去掉mapping原始注释
    @Override
    public void addComment(XmlElement xmlElement) {
        if (suppressAllComments) {
            return;
        } else {
            super.addComment(xmlElement);
        }
    }

}
