package com.practise.d_http.a_request.b_form;

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
 * @date 20.4.22 11:17 PM
 */
@WebServlet("/MyInfoForm")
public class MyInfoForm extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<form action='/servletpro/RegisterCl' method='post' ><br/>");
        out.println("用户名：<input type='text' name='username'/><br/>");
        out.println("密　码：<input type='password' name='pass'/><br/>");
        out.println("性别：<input type='radio' name='sex' value='男'/>男<input type='radio' name='sex' value='女'/>女<br/>");
        out.println("爱好：<input type='checkbox' name='hobby' value='zq'>足球<input type='checkbox' name='hobby' value='yy '>音乐<input type='checkbox' name='hobby' value='sf'>书法<br/>");
        out.println("所在城市：<select name='city'><option value='sh'>上海</option><option value='bj'>北京</option> </select><br/>");
        out.println("个人介绍<textarea cols='20' rows='10' name='intro'>请输入你的 介绍。。。</textarea><br/>");
        out.println("<input type='hidden' name='hidden1' value='abc'/>");
        out.println("<input type='submit' value='提交信息' />");
        out.println("</form>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
