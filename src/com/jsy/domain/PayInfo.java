package com.jsy.domain;

import java.sql.Date;

/**
 * 功能
 *
 * @author caojianbang
 * @date 3.6.22 10:04 PM
 */
public class PayInfo {
 private int   id;
    private String  title ;
    private String  content;
    private String linkman ;
    private Date publishDate ;
    private int  keepDays ;
    //byte节省一点内存
    private byte checkState ;
    private byte typeId;
    private String tel;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    //养成习惯写一个无参数构造方法
    public PayInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public int getKeepDays() {
        return keepDays;
    }

    public void setKeepDays(int keepDays) {
        this.keepDays = keepDays;
    }

    public byte getCheckState() {
        return checkState;
    }

    public void setCheckState(byte checkState) {
        this.checkState = checkState;
    }

    public byte getTypeId() {
        return typeId;
    }

    public void setTypeId(byte typeId) {
        this.typeId = typeId;
    }

}

