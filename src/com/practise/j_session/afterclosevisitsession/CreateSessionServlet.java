package com.practise.j_session.afterclosevisitsession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 功能
 *
 * @author caojianbang
 * @date 12.5.22 4:45 PM
 */
@WebServlet("/CreateSessionServlet")
public class CreateSessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60*30);
        response.addCookie(cookie);
        session.setAttribute("name" ,"caojianbangnnnn");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
