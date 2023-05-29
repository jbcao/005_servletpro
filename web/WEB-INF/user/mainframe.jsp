<%--
  功能：
  User: apple
  Date: 24.5.22
  Time: 11:04 PM
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<img src='img/bg.jpg' width=100px/>
<hr/>
<h1>欢迎登录</h1><a href='/servletpro/index.jsp'>返回登录界面<a/>
    <h3>选择需要进行的操作<h3/>
        <a href='/servletpro/GotoManageController'>管理用户<a/><br/>
        <a href='/servletpro/UserClServlet?type=gotoAddUser'>添加用户<a/><br/>
            <%--<a href='#'>查找用户<a/><br/>--%>
                <%--<a href='#'>退出系统<a/><br/>--%>
                    <hr/>
                    <img src='img/year.jpeg' width=100px/>
</body>
</html>
