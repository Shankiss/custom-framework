package com.zyuc.demo.core.custom.mbg;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.codegen.mybatis3.MyBatis3FormattingUtilities;
import org.mybatis.generator.codegen.mybatis3.xmlmapper.elements.AbstractXmlElementGenerator;

/**
 * @Version 1.0
 * @Description 自定义mapper.xml
 * @Date 2020/8/26 15:31
 * @Created by ChenHao
 */
public class CustomAbstractXmlElementGenerator extends AbstractXmlElementGenerator {

    @Override
    public void addElements(XmlElement parentElement) {
        //增加一条空行
        parentElement.addElement(new TextElement(""));
        // 增加base_query
        XmlElement sql = new XmlElement("sql");
        sql.addAttribute(new Attribute("id", "Base_Query"));
        //在这里添加where条件
        XmlElement selectTrimElement = new XmlElement("trim"); //设置trim标签
        selectTrimElement.addAttribute(new Attribute("prefix", "where"));
        selectTrimElement.addAttribute(new Attribute("prefixOverrides", "AND | OR")); //添加where和and
        StringBuilder sb = new StringBuilder();
        for(IntrospectedColumn introspectedColumn : introspectedTable.getAllColumns()) {
            XmlElement selectNotNullElement = new XmlElement("if"); //$NON-NLS-1$
            sb.setLength(0);
            sb.append("null != ");
            sb.append(introspectedColumn.getJavaProperty());
            selectNotNullElement.addAttribute(new Attribute("test", sb.toString()));
            sb.setLength(0);
            // 添加and
            sb.append(" and ");
            sb.append(MyBatis3FormattingUtilities.getEscapedColumnName(introspectedColumn));
            // 添加等号
            sb.append(" = ");
            sb.append(MyBatis3FormattingUtilities.getParameterClause(introspectedColumn));
            selectNotNullElement.addElement(new TextElement(sb.toString()));
            selectTrimElement.addElement(selectNotNullElement);
        }
        sql.addElement(selectTrimElement);
        parentElement.addElement(sql);

        // 公用select
        sb.setLength(0);
        sb.append("select");
        //换行缩进·
        sb.append("\r\n\t");
        sb.append(" <include refid=\"Base_Column_List\" />");
        sb.append("\r\n\t");
        sb.append(" from ");
        sb.append(introspectedTable.getFullyQualifiedTableNameAtRuntime());
        TextElement selectText = new TextElement(sb.toString());

        // 公用include
        XmlElement include = new XmlElement("include");
        include.addAttribute(new Attribute("refid", "Base_Query"));

        // 增加page
        parentElement.addElement(new TextElement(""));
        XmlElement page = new XmlElement("select");
        page.addAttribute(new Attribute("id", "page"));
        page.addAttribute(new Attribute("resultMap", "BaseResultMap"));
        page.addAttribute(new Attribute("parameterType", introspectedTable.getBaseRecordType()));
        page.addElement(selectText);
        page.addElement(include);
        parentElement.addElement(page);
    }
}
