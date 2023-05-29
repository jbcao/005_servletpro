<%--
  功能：
  User: apple
  Date: 22.8.22
  Time: 11:41 AM
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<%
    request.setAttribute("username","zhansan");
%>
<%--取出数据逼格输出到浏览器--%>
<%=request.getAttribute("username")%>
<br>
使用el表达式${username}

<br>
<%=request.getAttribute("user")%>
<br>
<%--使用el表达式进行页面展示，要求最终页面展示是友好的，
el表达式对null,进行了处理，如果是null，则在浏览器上显示空白，--%>
采用el表达式${user}

<hr>
<%--el表达式表面上是这种写法，实际上是要翻译成Java代码的，--%>
<%=request.getAttribute("username") == null ? "" : request.getAttribute("username")%>

