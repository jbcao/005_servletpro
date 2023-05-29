package com.jsy.domain;

import java.util.ArrayList;

/**
 * 功能:分页bean
 *
 * @author caojianbang
 * @date 3.6.22 10:26 PM
 */
public class PageBean {
    private int pageNow;
    private int pageSize;
    private int pageCount;
    private int rowcount;

    public int getRowcount() {
        return rowcount;
    }

    public void setRowcount(int rowcount) {
        this.rowcount = rowcount;
    }

    private ArrayList al = new ArrayList();

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public ArrayList getAl() {
        return al;
    }

    public void setAl(ArrayList al) {
        this.al = al;
    }
}
