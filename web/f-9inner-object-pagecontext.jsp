<%--
  功能：9大内置对象 pagecontext
  User: apple
  Date: 22.5.22
  Time: 9:00 PM
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%pageContext.setAttribute("abc","caojianbang");
out.print(pageContext.getAttribute("abc"));
%>

</body>
</html>
