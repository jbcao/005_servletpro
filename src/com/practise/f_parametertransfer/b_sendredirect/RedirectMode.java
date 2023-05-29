package com.practise.f_parametertransfer.b_sendredirect;

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
 * @date 15.4.22 10:05 PM
 */
@WebServlet("/RedirectMode")
public class RedirectMode extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String p=request.getParameter("password");
        String u=request.getParameter("username");
        //将字符串写到前面的好处是防止为空，空是没有equals方法的
        if("admin".equals(u)&&"pass".equals(p)) {
            //servlet提供两种跳转的方式
            //一种叫转发forward
            //一种叫重定向sendredirct
            //使用response里面的方法
            //也有固定的格式  /web应用名/servlet url
            response.sendRedirect("/UserManager/RedirectMainPage?u="+u);
        }else {
            //跳回
            response.sendRedirect("/UserManager/CheckCodeLoginServlet");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
