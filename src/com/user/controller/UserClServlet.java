package com.user.controller;

import com.user.domain.User;
import com.user.service.UserService;

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
 * @date 1.5.22 10:09 PM
 */
@WebServlet("/UserClServlet")
public class UserClServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        /**
         * post中文乱码
         * 必须要在最前面设置
         * 如果取出后再设置会失效
         * 因为已经按照iso-8859-1方式编码过了，这时候如果想解决总问乱码，可以使用get的方式，但这种方式修改的挺多，不如之前那个
         */
        request.setCharacterEncoding("utf-8");
        String operType = request.getParameter("type");
        UserService userService = new UserService();
        if ("del".equals(operType)) {
            //接收数据
            String id = request.getParameter("id");
            //调用service完成删除
            //因为只用一次，所以就直接写在if里面
            if (userService.delUser(id)) {

                request.getRequestDispatcher("/Ok").forward(request, response);
            } else {
                //要防止真错了，要写一个页面
                //写很多个页面是很正常的事情
                request.setAttribute("info", "删除失败");
                request.getRequestDispatcher("/Err").forward(request, response);
            }
        } else if ("gotoUpdateView".equals(operType)) {
            String id = request.getParameter("id");
            User user = userService.getUserById(id);
            //为了让下一个界面使用user对象，可以将user放到request对象中去
            //要保证在同一次请求里面
            request.setAttribute("user", user);
            request.getRequestDispatcher("/UpdateUserView").forward(request, response);
        } else if ("update".equals(operType)) {

            /**
             *     接收用户信息
             *     取名字保持高度一致，就不怕写错了
             *     用户从浏览器提交过来的信息，不管是数字还是字母，都是以字符串方式进行接收
             *     将来还要验证用户提交的数据格式
             *     一般前端要进行一次验证，服务器端也要进行一次验证，双重保险
             *     这里不要嫌烦，必须要严格按照面向对象来传的
             *     要处理中文乱码，不然会乱码
             */
            String id = request.getParameter("id");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String grade = request.getParameter("grade");
            String passwd = request.getParameter("passwd");
            /**
             * 将接收到的信息，封装成一个user对象，
             * 如果嫌麻烦，可以构造成一个构造函数
             */
            User user = new User(Integer.parseInt(id), username, email, Integer.parseInt(grade), passwd);
            if (userService.updateUser(user)) {
                /**
                 * 带个信息过去。用于区分是修改还是什么
                 */
                request.setAttribute("info", "修改成功");
                request.getRequestDispatcher("/Ok").forward(request, response);
            } else {
                request.setAttribute("info", "修改失败");
                //要防止真错了，要写一个页面
                //写很多个页面是很正常的事情
                request.getRequestDispatcher("/Err").forward(request, response);
            }


        } else if ("gotoAddUser".equals(operType)) {
/**
 * 这里没什么要处理的
 */
            request.getRequestDispatcher("/AddUserView").forward(request, response);
        }else if("add".equals(operType)){
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String grade = request.getParameter("grade");
            String passwd = request.getParameter("passwd");
            User user = new User();
            user.setName(username);
            user.setEmail(email);
            user.setGrade(Integer.parseInt(grade));
            user.setPwd(passwd);
            if (userService.addUser(user)) {
                /**
                 * 带个信息过去。用于区分是修改还是什么
                 */
                request.setAttribute("info", "添加成功");
                request.getRequestDispatcher("/Ok").forward(request, response);
            } else {
                request.setAttribute("info", "添加失败");
                //要防止真错了，要写一个页面
                //写很多个页面是很正常的事情
                request.getRequestDispatcher("/Err").forward(request, response);
            }
        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
