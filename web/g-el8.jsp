
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" isELIgnored="false" %>

<%
    request.setAttribute("test","test");
%>


<%--isELIgnored是全局忽略，整个jsp页面，\可以单个忽略--%>
\${test}<br>
${test}<br>
${test}<br>