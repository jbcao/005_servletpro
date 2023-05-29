<%--
  功能：
  User: apple
  Date: 24.5.22
  Time: 10:05 PM
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
<form action='/servletpro/LoginClServlet' method='post'>
    用户ID：<input type='text' name='id'/><br/>
    密　码：<input type='password' name='password'/><br/>
    <input type='submit' value='登录'/><br/>
</form>
<hr/>
<img src='img/year.jpeg' width=100px/>

</body>
</html>
