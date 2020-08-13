package com.zyuc.demo.core;

import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.codegen.AbstractJavaClientGenerator;
import org.mybatis.generator.codegen.mybatis3.IntrospectedTableMyBatis3Impl;

import java.util.List;

/**
 * @Version 1.0
 * @Description 重命名sql语句id
 * @Date 2020/8/12 14:23
 * @Created by ChenHao
 */
public class IntrospectedTable extends IntrospectedTableMyBatis3Impl {

    protected void calculateXmlMapperGenerator(AbstractJavaClientGenerator javaClientGenerator,
                                               List<String> warnings,
                                               ProgressCallback progressCallback) {

        xmlMapperGenerator = new IntroXmlMapperGenerator();

        initializeAbstractGenerator(xmlMapperGenerator, warnings,
                progressCallback);
    }

    @Override
    protected void calculateXmlAttributes() {
        this.setMyBatis3XmlMapperFileName(this.calculateMyBatis3XmlMapperFileName());
        this.setMyBatis3XmlMapperPackage(this.calculateSqlMapPackage());
        this.setMyBatis3FallbackSqlMapNamespace(this.calculateMyBatis3FallbackSqlMapNamespace());
        this.setSqlMapFullyQualifiedRuntimeTableName(this.calculateSqlMapFullyQualifiedRuntimeTableName());
        this.setSqlMapAliasedFullyQualifiedRuntimeTableName(this.calculateSqlMapAliasedFullyQualifiedRuntimeTableName());
        this.setDeleteByPrimaryKeyStatementId("delete");
        this.setInsertSelectiveStatementId("insert");
        this.setSelectByPrimaryKeyStatementId("get");
        this.setUpdateByPrimaryKeySelectiveStatementId("update");
        this.setBaseResultMapId("BaseResultMap");
        this.setBaseColumnListId("Base_Column_List");
    }

}
