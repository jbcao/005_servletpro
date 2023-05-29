package com.practise.g_encoding;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 功能
 *
 * @author caojianbang
 * @date 18.4.22 9:40 PM
 */
@WebServlet("/RedirectEncoding")
public class RedirectEncoding extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String temp =URLEncoder.encode("你好你好","utf-8");
        response.sendRedirect("/servletpro/Welcome?username="+temp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
