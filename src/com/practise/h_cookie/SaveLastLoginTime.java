package com.practise.h_cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能
 *
 * @author caojianbang
 * @date 8.5.22 2:31 PM
 */
@WebServlet("/SaveLastLoginTime")
public class SaveLastLoginTime extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Cookie cookies[] =request.getCookies();
        boolean b=false;
        if(cookies!=null){
            System.out.println("kkk");
            for(Cookie c:cookies){
                String name=c.getName();
                if("lasttime".equals(name)){
                    out.println("上次登录时间"+c.getValue());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'ri'HH:mm:ss");
                    String now=simpleDateFormat.format(new Date());
                    c.setValue(now);
                    c.setMaxAge(7*24*3600);
                    response.addCookie(c);
                    b=true;
                    break;
                }
            }
        }
        if(!b){
            out.println("第一次登录");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'ri'HH:mm:ss");
            String now=simpleDateFormat.format(new Date());
            System.out.println(now);
            Cookie c1=new Cookie("lasttime",now);
            c1.setMaxAge(7*24*3600);
            response.addCookie(c1);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
