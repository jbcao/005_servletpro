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
 * @date 21.4.22 2:30 AM
 */
@WebServlet("/RegisterCl")
public class RegisterCl extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String u =request.getParameter("username");
        String p=request.getParameter("pass");
        String sax=request.getParameter("sax");
        String[] hobbies = request.getParameterValues("hobby");
        String city = request.getParameter("city");
        String intro = request.getParameter("intro");
        String hidden1 = request.getParameter("hidden1");
        if(hobbies!=null){
          for(int i=0;i<hobbies.length;i++){
              out.println("爱好"+hobbies[i]);
          }
        }else {
            out.println("no hobby");
        }
        out.println("用户名："+u+"<br/>");
        out.println("密码："+p+"<br/>");
        out.println("性别："+sax+"<br/>");
        out.println("city："+city+"<br/>");
        out.println("intro："+intro+"<br/>");
        out.println("hidden："+hidden1+"<br/>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
