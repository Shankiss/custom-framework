package com.zyuc.demo.core;

import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.XMLMapperGenerator;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;
import org.mybatis.generator.internal.util.messages.Messages;

/**
 * @Version 1.0
 * @Description 重定义mbg生成xml模板样式
 * @Date 2020/8/12 14:26
 * @Created by ChenHao
 */
public class InTroXmlMapperGenerator extends XMLMapperGenerator {

    public InTroXmlMapperGenerator() {
    }

    public XmlElement getSqlMapElement() {
        FullyQualifiedTable table = this.introspectedTable.getFullyQualifiedTable();
        this.progressCallback.startTask(Messages.getString("Progress.12", table.toString()));
        XmlElement answer = new XmlElement("mapper");
        String namespace = this.introspectedTable.getMyBatis3SqlMapNamespace();
        StringBuffer buffer = new StringBuffer();
        buffer.append(namespace.replace(".mapper","")).insert(25,"I");
        answer.addAttribute(new Attribute("namespace", buffer.toString()));
        this.context.getCommentGenerator().addRootComment(answer);
        this.addResultMapWithoutBLOBsElement(answer);
        this.addBaseColumnListElement(answer);
        this.addSelectByPrimaryKeyElement(answer);
        this.addInsertSelectiveElement(answer);
        this.addUpdateByPrimaryKeySelectiveElement(answer);
        this.addDeleteByPrimaryKeyElement(answer);

        return answer;
    }

    @Override
    protected void initializeAndExecuteGenerator(AbstractXmlElementGenerator elementGenerator, XmlElement parentElement) {
        elementGenerator.setContext(this.context);
        elementGenerator.setIntrospectedTable(this.introspectedTable);
        elementGenerator.setProgressCallback(this.progressCallback);
        elementGenerator.setWarnings(this.warnings);
        parentElement.addElement(new TextElement(""));
        elementGenerator.addElements(parentElement);
    }
}
