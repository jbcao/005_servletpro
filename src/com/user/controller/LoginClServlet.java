package com.user.controller;

import com.user.domain.User;
import com.user.service.UserService;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginClServlet
 */
@WebServlet("/LoginClServlet")
public class LoginClServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginClServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
//		用request中的getparameter（）方法接收数据
        //表单是以name属性将值带过来的
        //参数最好粘贴拷贝，不然很容易出错
        //很容易调试半天，发现i写成1,1写成l了，这种错误没有意义
        //该粘贴拷贝，就要粘贴拷贝
        String id = request.getParameter("id");
        String p = request.getParameter("password");
        /**
         * 所谓调用，就是创建一个对象，然后使用相应的方法
         */
        UserService userService = new UserService();
        User user = new User();
        user.setId(Integer.parseInt(id));
        user.setPwd(p);
        try {
            if (userService.checkUser(user)) {
                /**
                 * 得登录成功，才进行保存
                 * 将user保存到session中
                 */
                HttpSession session= request.getSession();
                session.setAttribute("login",user);
                request.getRequestDispatcher("/MainServlet").forward(request, response);
            } else {
                request.setAttribute("err","用户名不是数字或者密码错误");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
