package com.practise.j_session;

import com.user.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * 功能：用于获取session
 *
 * @author caojianbang
 * @date 8.5.22 7:14 PM
 */
@WebServlet("/GetSessionServlet")
public class GetSessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        /**
         * 获取session
         */
        HttpSession session = request.getSession();
        /**
         * 通过名字获取绑定对象，有则返回对象，没有则返回null
         * session创建你是看不见的额，是存在内存里面的，只能通过现象来看确实存在
         * 不像cookie是放在文件里面，也可以通过抓取来看
         * 如果浏览器关闭了，再去访问那个session,就不在了，得在一个会话里面
         */
        String uname = (String) session.getAttribute("uname");
        System.out.println("名字"+uname);
        User animal = (User) session.getAttribute("animal");
        if(animal!=null){
            out.println("animal name is"+animal.getName());
        }
        if(uname==null){
            out.println("没有session uname");

        }else {
            out.println("uname 的 sessionID"+uname);
            out.println(session.getId());
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
