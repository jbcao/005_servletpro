package com.practise.h_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * 功能:用于读取cookie
 *
 * @author caojianbang
 * @date 6.5.22 2:59 PM
 */
@WebServlet("/ReadCookie")
public class ReadCookie extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out =response.getWriter();
        /**
         * cookie是通过request对象发送过来的
         * getCookies（）方法，返回的是一个数组，该数组中包含该所有的cookie
         * 没有提供通过名字获取cookie的方法
         * 实际过程中，是获取所有cookie信息，然后再选出你需要的哪一个
         * 浏览器只会携带该web应用下的cookie过来
         */
        Cookie cookie[]=request.getCookies();
        for (int i = 0; i <cookie.length ; i++) {
            Cookie cookie1=cookie[i];
            if("name".equals(cookie1.getName())){
                String val = URLDecoder.decode(cookie1.getValue(),"utf-8");
                out.println("cookie-name"+cookie1.getName()+"cookie-value"+val);
            }else {
                out.println("cookie-name"+cookie1.getName()+"cookie-value"+cookie1.getValue());
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
