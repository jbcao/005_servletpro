package com.practise.j_session;

import com.user.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 功能:用于创建session
 *
 * @author caojianbang
 * @date 8.5.22 5:20 PM
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        /**
         * 访问session
         * 重要：getSession 如果有session 则返回，如果没有session，则创建一个session，有则给，无则建
         * 创建后，就可以放入属性
         * idea使用中，经常出现使用一会后，中文无法输入问题，我增加了内存，不知道能否有效，还待验证,好像管用了
         * 也是可以存入对象的
         */
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("uname","宋江");
        httpSession.setAttribute("age","100");
        User cat= new User();
        cat.setName("small cat");
        httpSession.setAttribute("animal",cat);
        /**
         * 生命周期：默认30分钟
         * 修改是使用下面方法
         */
        httpSession.setMaxInactiveInterval(20);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
