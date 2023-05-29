<%@ page import="java.util.ArrayList" %>
<%@ page import="com.us.domain.User" %>
<%--
  功能：
  Us: apple
  Date: 25.5.22
  Time: 3:25 AM
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<img src='img/bg.jpg' width=100px/>欢迎登录&nbsp<a href='/servletpro/MainServlet'>返回主界面</a>&nbsp<a
        href='/servletpro/index.jsp'>安全退出</a>
<hr/>
<h1>管理用户</h1>
<table border=1 bordercolor=silver cellspacing=0>
    <tr>
        <th>id</th>
        <th>用户名</th>
        <th>email</th>
        <th>级别</th>
        <th>删除</th>
        <th>修改</th>
    </tr>
    <%
        ArrayList<User> al = (ArrayList<User>) request.getAttribute("al");
        for (User u : al) {
    %>
    <tr>
        <td><%=u.getId()%>
        </td>
        <td><%=u.getName()
        %>
        </td>
        <td><%=u.getEmail()
        %>
        </td>
        <td><%=u.getGrade()%>
        </td>
        <td><a onclick='confirmOper()' href='/servletpro/UserClServlet?type=del&id=" + u.getId() + "'>删除</a>
        </td>
        <td><a href='/servletpro/UserClServlet?type=gotoUpdateView&id=" + u.getId() + "'>修改</a></td>
    </tr>
    <%
        }
    %>
</table>
<br/>
<%
    int pageCount = (int) request.getAttribute("pageCount");
    for (int i = 1; i <= pageCount; i++) {
%>
<a href='/servletpro/GotoManageController?pageNow=<%=i%>'><font size='2'><<%=i %>><font/></a>
<%
    }
%>
</body>
</html>
