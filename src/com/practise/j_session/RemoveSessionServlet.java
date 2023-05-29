package com.practise.j_session;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;
        import java.io.IOException;

/**
 * 功能
 *
 * @author caojianbang
 * @date 8.5.22 10:38 PM
 */
@WebServlet("/RemoveSessionServlet")
public class RemoveSessionServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        session.removeAttribute("uname");
        session.setAttribute("s1","iiii");
        session.setAttribute("s2","kkk");
        session.removeAttribute("s2");
        String  s1 = (String) session.getAttribute("s1");
        String  s2= (String) session.getAttribute("s2");
        System.out.println("s1:"+s1+"s2:"+s2);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
