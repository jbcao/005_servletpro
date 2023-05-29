package com.jsp_el.bean;

/**
 * 功能
 *
 * @author caojianbang
 * @date 23.8.22 2:08 AM
 */
public class Test {
    public static void main(String[] args) {
        Object o = new Object();
        Object o2 = new Object();
        System.out.println(o.toString());
        System.out.println(o2.toString());
        System.out.println(o.equals(o2));  //点进去看源码 object的equals方法，调用的是==比较的是地址  ，而其他的子类的equals方法,比较的是内容
    }
}
