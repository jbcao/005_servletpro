<%--
  功能：
  User: apple
  Date: 26.5.22
  Time: 8:52 PM
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <h1>登录</h1>
<form action="/servletpro/GoHallUi" method="post">
    <table >
        <tr><td>账号：</td><td><input type="text" name="id"/></td></tr>
        <tr><td>密码：</td><td><input type="password" name="pass" /></td></tr>
        <tr><td><input type="submit" value="登录" ></td><td><input type="reset" value="重置"/></td></tr>
    </table>
</form>
</body>
</html>
