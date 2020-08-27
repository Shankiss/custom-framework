package com.zyuc.demo.dto.base;

/**
 * @Version 1.0
 * @Description TODO
 * @Date 2020/7/17 14:36
 * @Created by ChenHao
 */
public class PageBean {

    private int pageNum = 1;    //当前页,从请求那边传过来。

    private int pageSize = 10;    //每页显示的数据条数。

    public PageBean() {
    }

    public PageBean(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
