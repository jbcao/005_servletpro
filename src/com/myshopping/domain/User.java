package com.myshopping.domain;

/**
 * 功能
 *
 * @author caojianbang
 * @date 28.4.22 7:31 PM
 */
public class User {
    private int id;
    private  int grade;
    private String name;
    private String email;
    private  String tel;
    private String pwd;


    /**
     * 无参构造函数不能省
     * 将来使用反射的时候会用到
     * 或者希望直接调用无参的构造函数需要有，不然会报错
     */

    public User() {
    }

    public User(int id, String pwd) {
        this.id = id;
        this.pwd = pwd;
    }

    public User(int id, String name, String email, int grade, String pwd) {
        this.id = id;
        this.grade = grade;
        this.name = name;
        this.email = email;
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


}
