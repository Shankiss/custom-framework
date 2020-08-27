package com.zyuc.demo.core.custom.mbg;

import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;

import java.util.Set;
import java.util.TreeSet;

/**
 * @Version 1.0
 * @Description 自定义mapper方法
 * @Date 2020/8/26 15:32
 * @Created by ChenHao
 */
public class CustomJavaMapperMethodGenerator extends AbstractJavaMapperMethodGenerator {

    @Override
    public void addInterfaceElements(Interface interfaze) {
        addInterfacePage(interfaze);
    }

    private void addInterfacePage(Interface interfaze) {
        // 先创建import对象
        Set<FullyQualifiedJavaType> importedTypes = new TreeSet<FullyQualifiedJavaType>();
        // 添加Lsit的包
        importedTypes.add(FullyQualifiedJavaType.getNewListInstance());
        // 创建方法对象
        Method method = new Method("custom");
        // 设置该方法为public
        method.setVisibility(JavaVisibility.PUBLIC);
        // 设置返回类型是List
        FullyQualifiedJavaType returnType = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType listType;
        // 设置List的类型是实体类的对象
        listType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        importedTypes.add(listType);
        // 返回类型对象设置为List
        returnType.addTypeArgument(listType);
        // 方法对象设置返回类型对象
        method.setReturnType(returnType);
        // 设置方法名称为我们在IntrospectedTable类中初始化的 “selectByObject”
        method.setName("page");

        // 设置参数类型是对象
        FullyQualifiedJavaType parameterType;
        parameterType = new FullyQualifiedJavaType(introspectedTable.getBaseRecordType());
        // import参数类型对象
        importedTypes.add(parameterType);
        // 为方法添加参数，变量名称record
        method.addParameter(new Parameter(parameterType, "record")); //$NON-NLS-1$

        context.getCommentGenerator().addGeneralMethodComment(method, introspectedTable);
        if (context.getPlugins().clientSelectByPrimaryKeyMethodGenerated(method, interfaze, introspectedTable)) {
            interfaze.addImportedTypes(importedTypes);
            interfaze.addMethod(method);
        }
    }

}
