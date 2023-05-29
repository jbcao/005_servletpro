package com.jsp_el.bean;

/**
 * 功能
 *
 * @author caojianbang
 * @date 21.8.22 8:59 PM
 */
public class User {
 private String name;
 private String pass;
 private Integer age;
 private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User() {
    }

    public User (String name, String pass, Integer age) {
        this.name = name;
        this.pass = pass;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    public String getName() {
        System.out.println("getName方法被调用。。。");
        return name;
    }

    public String getEmail() {
        return "13062600385@163.com";
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
