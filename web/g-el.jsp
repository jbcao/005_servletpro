<%--
  功能：
  User: apple
  Date: 21.8.22
  Time: 5:10 PM
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% //向request作用域中存储useername为张三
request.setAttribute("username","zhangsan");
request.setAttribute("obj",new Object());%>

<br>

<%--将request域当中的数据取出来，并且还要输出到浏览器，使用Java代码--%>
<%=request.getAttribute("username")%>
<br>
<%=request.getAttribute("obj")%>
<br>
<hr>
<%--使用EL表达式--%>
${username} <br>
${obj} <br>
</body>
</html>
