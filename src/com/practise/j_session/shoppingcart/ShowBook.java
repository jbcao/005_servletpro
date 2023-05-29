package com.practise.j_session.shoppingcart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 功能
 *
 * @author caojianbang
 * @date 13.5.22 2:08 PM
 */
@WebServlet("/ShowBook")
public class ShowBook extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<h1>欢迎购买</h1>");
        /**
         * 取出DB
         * 用泛型，可以使用for增强
         */
        request.getSession();
        ArrayList<Book> db = DB.getDB();
        for (Book book : db) {
            /**encodeURL:通过将会话 ID 包含在指定 URL 中对该 URL 进行编码
             * 这里还并没有改变
             * 必须加一句话，访问一下session，即创建一下
             */
            String url = response.encodeURL("/servletpro/BuyBookCl?id=" + book.getId());
            /**
             * 之所以用response，是因为他是发送http回应头的
             * encode是编码
             * 希望href 是这样一种格式 href="/servletpro/BuyBookCl?id=1&JSESSIONID=jdjjdjbh"
             */
            out.println(book.getName() + "<a href='" + url + "'>点击购买</a><br/>");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
