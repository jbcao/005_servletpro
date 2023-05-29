package com.practise.d_http.a_request.c_forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 功能
 *
 * @author caojianbang
 * @date 22.4.22 12:48 AM
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
       // request.getRequestDispatcher("/Servlet2").forward(request,response);
        //request.getRequestDispatcher("www.baidu.com").forward(request,response);
        response.sendRedirect("http://www.baidu.com");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
