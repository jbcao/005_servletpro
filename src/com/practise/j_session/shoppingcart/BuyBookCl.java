package com.practise.j_session.shoppingcart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 功能
 *
 * @author caojianbang
 * @date 13.5.22 2:07 PM
 */
@WebServlet("/BuyBookCl")
public class BuyBookCl extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        /**
         * 这里看着作用不大
         * 但是将来如若有作者，日期，版本 各种信息的时候，你会发现通过id来获取信息是很方便的
         */
        Book bookInfo=DB.getBookById(id);
        /**
         * 如果将书名存放入request域中，那样只能购买一本，只能跟一次请求进行关联
         * 但实际构成可能是多次
         * 应该放入session
         */
        HttpSession session = request.getSession();
        /**
         * 要保证arrayList不是新的，始终使用一个
         * 从session中取出books
         * 第一次购物为空，
         */
        HashMap<String, Book> hm = (HashMap<String, Book>) session.getAttribute("books");
        if (hm == null) {
            Book book = new Book();
            book.setId(id);
            book.setName(bookInfo.getName());
            book.setNum(1);
            /**
             * linkedHashMap是有序的
             * 购买的商品会按照顺序排列下来
             */
            hm = new LinkedHashMap<String, Book>();
            hm.put(id, book);
            session.setAttribute("books", hm);
        } else {
            /**
             * 遍历ArrayList。看看有没有这个书对象，但是这样太麻烦
             *判断hm里面是否有该书
             */
            if (hm.containsKey(id)) {
                /**
                 * 表示书已经购买过一次
                 * 取出数量加一
                 */
                Book book = hm.get(id);
                int num = book.getNum();
                book.setNum(num + 1);
            }else {
                Book book = new Book();
                book.setId(id);
                book.setName(bookInfo.getName());
                book.setNum(1);
                hm.put(id, book);
            }
            /**
             * 更新也可以，不更新也可以
             * 因为是引用
             */
            session.setAttribute("books", hm);
        }
        request.getRequestDispatcher("/ShowMyCart").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
