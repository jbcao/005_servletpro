package com.practise.h_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能
 *
 * @author caojianbang
 * @date 6.5.22 6:39 PM
 */
@WebServlet("/CreateCookie2")
public class CreateCookie2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie cookie = new Cookie("name", "abc");
        Cookie cookie1 =new Cookie("age","15");
        cookie1.setMaxAge(1000);
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        response.addCookie(cookie1);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
