package com.practise.l_servletcontext.counter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 功能
 *
 * @author caojianbang
 * @date 15.5.22 11:32 PM
 */
@WebServlet("/CounterLogin")
public class CounterLogin extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 返回一个html页面
         * 用下面的方法写html不容易出错
         */
        response.setContentType("text/html;charset=gbk");
        //response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<img src='img/lea.gif' width=100px /><hr/>");
        out.println("<h1>用户登录</h1>");
        out.println("<form action='/servletpro/loginController' method='post'>");
        out.println("用户ID：<input type='text' name='id'/><br/>");
        out.println("密　码：<input type='password' name='password'/><br/>");
        out.println("<input type='submit' value='登录'/><br/>");
        out.println("</form>");
        /**
         * 先获取到，再进行判断
         */
        String err = (String) request.getAttribute("err");
        if (err != null) {
            out.println(err);

        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
