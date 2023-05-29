<%@ page import="com.jsp_el.bean.User" %><%--
  功能：
  User: apple
  Date: 22.8.22
  Time: 2:12 PM
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<%
    User user = new User();
    user.setName("caojainbang");
    request.setAttribute("jjjj",user);
    request.setAttribute("a.b",user);
    request.setAttribute("jjjj[name]","jjj");
%>


${jjjj.name}
<br>


${jjjj[name]}
<br>
<%--不加""会将整体看成有特殊字符的变量--%>
${requestScope["jjjj[name]"]}
<br>


${requestScope["a.b"]}
