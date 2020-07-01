package com.zyuc.demo.entity;

import javax.validation.constraints.Max;
import java.util.Date;
import java.io.Serializable;

/**
 * (CoreRole)实体类
 *
 * @author makejava
 * @since 2020-04-27 17:56:41
 */
public class CoreRole implements Serializable {
    private static final long serialVersionUID = -11694618440165864L;

    @Max(value = 20,message = "id最大允许输入20！")
    private Integer id;
    /**
    * 角色编码
    */
    private String code;
    /**
    * 角色名称
    */
    private String name;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 1 可以配置 2 固定权限角色
    */
    private String type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}