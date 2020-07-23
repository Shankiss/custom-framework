package com.zyuc.demo.dto.base;

/**
 * @Version 1.0
 * @Description TODO
 * @Date 2020/7/17 14:36
 * @Created by ChenHao
 */
public class PageBean {

    private int pageNo = 1;    //当前页,从请求那边传过来。

    private int pageSize = 10;    //每页显示的数据条数。

    public PageBean() {
    }

    public PageBean(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
