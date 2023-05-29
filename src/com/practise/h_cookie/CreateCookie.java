package com.practise.h_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 功能
 *    创建cookie，并回写给浏览器
 * @author caojianbang
 * @date 6.5.22 1:13 AM
 */
@WebServlet("/CreateCookie")
public class CreateCookie extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        /**
         * 创建一个cookie
         * 创建是在服务器创建
         * 存放是在浏览器这一头
         * cookie只能创建简单的String类型
         */
        String val = URLEncoder.encode("曹建邦","utf-8");
        Cookie cookie = new Cookie("name", val);
        /**
         * 以后学习面向对象的话，第一个考虑的是对象的创建，第二个考虑生命周期有多长
         * setMaxAge用于设置生命周期，
         * 是按秒来进行设置的
         * 如过不进行设置，就是个短命鬼
         */
        cookie.setMaxAge(3600);
        /**
         * 把cookie信息回写给浏览器
         * 将指定cookie写给response，也就是给http
         * 浏览器看到的cookie如下
         * Set-Cookie: name=cjb; Max-Age=3600; Expires=Fri, 06-May-2022 03:36:27 GMT
         */
        response.addCookie(cookie);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
