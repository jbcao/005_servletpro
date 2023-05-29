package com.practise.j_session.checkcode;

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
 * @date 12.5.22 1:19 AM
 */
@WebServlet("/CheckCodeLoginController")
public class CheckCodeLoginController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        /**
         * 获取用户的id/password/输入验证码
         * 顺须是先验证码，然后再用户名密码
         * 这样可以减轻数据库的压力
         * 现在学了两个域对象request session
         * 生命周期：一个是一次请求 后者是默认30分钟
         */
        String checkcode = request.getParameter("checkcode");
        String code= (String) request.getSession().getAttribute("checkcode");
        if(checkcode.equals(code)){
            request.getRequestDispatcher("/Ok").forward(request,response);
        }else {
            request.setAttribute("err","验证码出错");
            request.getRequestDispatcher("/CheckCodeLoginServlet").forward(request,response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
