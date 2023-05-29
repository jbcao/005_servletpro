package com.user.view;

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
 * @date 3.5.22 5:38 PM
 */
@WebServlet("/AddUserView")
public class AddUserView extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<img src='img/lea.gif' width=100px />欢迎登录&nbsp<a href='/servletpro/MainServlet'>返回主界面<a/>&nbsp<a href='/servletpro/CheckCodeLoginServlet'>安全退出<a/><hr/>");
        out.println("<form action='/servletpro/UserClServlet?type=add' method='post'>");
        out.println("<h2>添加用户</h2>");
        out.println("<table border=1 bordercolor=silver border=0 cellspacing=0 >");
        out.println("<tr><td>用户名</td><td><input type='text' name='username' /></td></tr>");
        out.println("<tr><td>email</td><td><input type='text' name='email' /></td></tr>");
        out.println("<tr><td>级别</td><td><input type='text' name='grade'/></td></tr>");
        out.println("<tr><td>密码</td><td><input type='text' name='passwd'/></td></tr>");
        out.println("<tr><td><input type='submit' value='添加用户'/></td><td><input type='reset' value='重新填写'/></td></tr>");
        out.println("</table><br/>");
        out.println("</form>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
