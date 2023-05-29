<%@ page import="java.util.ArrayList" %>
<%@ page import="com.myshopping.domain.Book" %><%--
  功能：
  Us: apple
  Date: 27.5.22
  Time: 4:16 PM
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
<h1>我的购物车</h1>
<%--知识点
web-inf里面直接请求，跳不进去
可以调到控制器，然后通过控制器，进行转发
如果在session中取id 和password传过去，会导致重新创建购物车，
正确的解决办法是：控制器链--%>
<a href="/servletpro/GoHallUi">返回购物大厅</a>
<form action="/servletpro/ShoppingClServlet?type=update" method="post">
    <table border="1" style="border-collapse:collapse;width: 600px">
        <tr>
            <td>bookId</td>
            <td>书名</td>
            <td>价格</td>
            <td>出版社</td>
            <td>数量</td>
            <td>删除</td>
        </tr>
        <%
            ArrayList al = (ArrayList) request.getAttribute("bookList");
            for (int i = 0; i < al.size(); i++) {
                Book book = (Book) al.get(i);
        %>
        <tr>
            <td><%=book.getId()%>
            </td>
            <td><%=book.getName()%>
            </td>
            <td><%=book.getPrice()%>
            </td>
            <td><%=book.getPublishHouse()%>
            </td>
            <td><input type="text" name="booknum" value="<%=book.getShoppingNum()%>"/><input type="hidden" name="id" value="<%=book.getId()%>">本</td>
            <td><a href="/servletpro/ShoppingClServlet?type=del&id=<%=book.getId()%>">删除</a></td>
        </tr>
        <%
            }
        %>
<%--知识点
到底哪一个改变了，怎样传递参数
影藏表单--%>
        <tr>
            <td colspan="6"><input type="submit" value="update"></td>
        </tr>
        <%--这里就相当于域表达式，就是取出request域中信息--%>

        <tr>
            <td colspan="6">所有书的总价${totalPrice}</td>
        </tr>
    </table>
</form>
<a href="/servletpro/GoMyOrderServlet">提交订单</a>
</body>
</html>
