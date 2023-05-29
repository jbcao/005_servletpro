<%@ page import="java.util.ArrayList" %>
<%@ page import="com.myshopping.domain.Book" %><%--
  功能：
  Us: apple
  Date: 26.5.22
  Time: 9:27 PM
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>欢迎购物大厅</h1>  <a href="servletpro/index,jsp">返回重新登录</a>
<table border="1" style="border-collapse:collapse;width: 600px">
    <tr><td>书名</td><td>价格</td><td>出版社</td><td>点击购买</td></tr>
    <%
        ArrayList<Book> al=(ArrayList<Book>)request.getAttribute("books");
        for(int i=0;i<al.size();i++){
            Book book = al.get(i);
    %>
    <tr><td><%=book.getName()%></td><td><%=book.getPrice()%></td><td><%=book.getPublishHouse()%></td><td><a href="/servletpro/ShoppingClServlet?type=add&id=<%=book.getId()%>">点击购买</a></td></tr>
    <%
        }
    %>


   <tr><td colspan="4"><input type="button" value="查看购物车" ></td></tr>
</table>
</body>
</html>
