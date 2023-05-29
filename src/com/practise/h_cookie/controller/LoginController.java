package com.practise.h_cookie.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 功能
 *
 * @author caojianbang
 * @date 8.5.22 2:03 AM
 */
@WebServlet("/CheckCodeLoginController2")
public class LoginController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String val = request.getParameter("iskeepinfo");
        if (val != null && val.equals("keep")) {
            //2 weeks
            Cookie ciikie = new Cookie("id", id);
            ciikie.setMaxAge(7 * 2 * 24 * 3600);
            response.addCookie(ciikie);
            request.getRequestDispatcher("/OkView").forward(request, response);
        } else if (val != null && val.equals("nokeep")) {
            Cookie cookies[] = request.getCookies();
            for (Cookie c : cookies
                    ) {
                if (c.getName().equals("id")) {
                    c.setMaxAge(0);
                    response.addCookie(c);

                }
            }
            //无论是否保存都能正确跳转
            request.getRequestDispatcher("/OkView").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
