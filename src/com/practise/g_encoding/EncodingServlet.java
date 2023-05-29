package com.practise.g_encoding;



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
 * @date 18.4.22 11:15 AM
 */
@WebServlet("/EncodingServlet")
public class EncodingServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //post方法
        //request.setCharacterEncoding("utf-8");
        //get方式
        try {
            byte b[]=request.getParameter("username").getBytes("utf-8");
            String u2 = new String(b, "utf-8");
            System.out.println(u2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
