<%--
  功能：
  User: apple
  Date: 22.8.22
  Time: 12:07 AM
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<%
    pageContext.setAttribute("data","pagecontext");
    request.setAttribute("data","request");
    session.setAttribute("data","session");
    application.setAttribute("data","application");
%>
${data}
<br>
${pageScope.data}<br>
${requestScope.data}<br>
${sessionScope.data}<br>
${applicationScope.data}

