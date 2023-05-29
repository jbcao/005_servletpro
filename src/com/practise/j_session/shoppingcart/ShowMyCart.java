package com.practise.j_session.shoppingcart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * 功能:展示购买的书
 *
 * @author caojianbang
 * @date 13.5.22 2:08 PM
 */
@WebServlet("/ShowMyCart")
public class ShowMyCart extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HashMap<String, Book> hm = (HashMap<String, Book>) request.getSession().getAttribute("books");
        /**
         * 遍历
         */
        Iterator<String> iterator = hm.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Book book = hm.get(key);
            out.println("书名：" + book.getName() + " " + "数量" + book.getNum() + "<br/>");
        }

        out.println("已购<br/>");
        String url=response.encodeURL("/servletpro/ShowBook");
        out.println("<a href='"+url+"'>返回购物大厅</a>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
