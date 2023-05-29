package com.practise.h_cookie.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 功能 cookie保存用户名以及密码
 *
 * @author caojianbang
 * @date 8.5.22 2:04 AM
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>用户登录</h1>");
        out.println("<form action='/servletpro/CheckCodeLoginController' method='post'>");
        //默认情况下是没有填值的
        //值可以从cookie里面取
        //打开login页面的时候，就要尝试取读取这个相应的cookie，如果有就填进去
        //从cookie中选出keep cookie
        //
        String id = "";
        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("id")) {
                    id = c.getValue();

                }

            }

        }
        //能取出来就取出来，取不出来就是个空字符串
        out.println("用户ID：<input type='text' name='id' value='" + id + "'/><br/>");
        out.println("密　码：<input type='password' name='password'/><br/>");
        out.println("<input type='checkbox' name='iskeepinfo' value='keep'/>save user   name and passwd ?<br/>");
        out.println("<input type='checkbox' name='iskeepinfo' value='nokeep'/>不保存 user   name and passwd ?<br/>");
        out.println("<input type='submit' value='登录'/><br/>");
        out.println("</form>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
