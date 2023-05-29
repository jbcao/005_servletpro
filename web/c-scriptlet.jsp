<%--
  功能：脚本元素
  User: apple
  Date: 22.5.22
  Time: 7:36 PM
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--全局变量--%>
<%!
    int i = 900;
%>
<%--局部变量--%>
<% int k = 90; %>
<%--成员方法--%>
<%!
    public int getResult(int a, int b) {
        return a + b;
    }
%>
<%
    out.print("k=" + k);
    out.print("a+b="+getResult(100,400));
%>
<%--表达式--%>
<%=i
%>
<%=i*400-23
%>
<%
    out.print("i="+(++i)+"k="+(++k));
%>
</body>
</html>
