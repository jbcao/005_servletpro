package com.practise.k_filter;

import com.user.domain.User;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**

 */
@WebFilter(filterName = "MyFilter")
public class MyFilter extends HttpServlet implements Filter {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        System.out.print("myfilter1...");
        //获取session
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        //看看请求的资源是什么
        String uri = httpServletRequest.getRequestURI();
        //如果请求的登录,处理登录的控制器，不然还没有创建session
        //
        if (uri.startsWith("servletpro/index.jsp")||uri.startsWith("/servletpro/LoginClServlet") ||uri.startsWith("/servletpro/LoginServlet")||uri.startsWith("/servletpro/img")) {
            //直接放行.
            chain.doFilter(request, response);
        } else {
            /**
             * 其他页面要查看是否登录成功，并放入session
             */
            HttpSession session = httpServletRequest.getSession();
            User user = (User) session.getAttribute("login");
            if (user != null) {
                //该用户合法,放行
                chain.doFilter(request, response);
            } else {
                request.setAttribute("err", "请好好登陆");
                httpServletRequest.getRequestDispatcher("/LoginServlet")
                        .forward(request, response);
            }
        }
    }

    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
    }
}