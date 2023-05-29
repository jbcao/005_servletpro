package com.jsp_el.bean;

import java.util.Objects;

/**
 * 功能
 *
 * @author caojianbang
 * @date 23.8.22 12:58 PM
 */
public class Student {
    private int id;
    private String name;



    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("equals方法别调用了");
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
