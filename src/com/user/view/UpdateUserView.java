package com.user.view;

import com.user.domain.User;

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
 * @date 3.5.22 3:28 AM
 */

@WebServlet("/UpdateUserView")
public class UpdateUserView extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 获取从控制器传递过来的user对象
        //属性名如果不存在，就会显示为空

        //得到的是对象，需要转一下
        User user=(User) request.getAttribute("user");

        /**
         *         做一个表格
         *         需要用输入框展示值，用value获取值，然后就可以修改值
         *         输入框取名字有讲究，最好跟表字段名相匹配，保持高度一致
         *         要能修改，得用form表单
         *         注意，得是表单包表格
         *         表单也是可以带信息的
         *         readonly就是只读
         */
        out.println("<img src='img/lea.gif' width=100px />欢迎登录&nbsp<a href='/servletpro/MainServlet'>返回主界面<a/>&nbsp<a href='/servletpro/CheckCodeLoginServlet'>安全退出<a/><hr/>");
        out.println("<form action='/servletpro/UserClServlet?type=update' method='post'>");
        out.println("<h2>修改用户</h2>");
        out.println("<table border=1 bordercolor=white border=0 cellspacing=0 >");
        out.println("<tr><td>id</td><td><input type='text' name='id' readonly value='"+user.getId()+"'/></td></tr>");
        out.println("<tr><td>用户名</td><td><input type='text' name='username' value='"+user.getName()+"'/></td></tr>");
        out.println("<tr><td>email</td><td><input type='text' name='email' value='"+user.getEmail()+"'/></td></tr>");
        out.println("<tr><td>级别</td><td><input type='text' name='grade' value='"+user.getGrade()+"'/></td></tr>");
        out.println("<tr><td>密码</td><td><input type='text' name='passwd' value='"+user.getPwd()+"'/></td></tr>");
        out.println("<tr><td><input type='submit' value='修改用户'/></td><td><input type='reset' value='重新填写'/></td></tr>");
        out.println("</table><br/>");
        out.println("</form>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
