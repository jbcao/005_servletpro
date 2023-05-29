<%@ page import="com.myshopping.domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.myshopping.domain.Book" %><%--
  功能：
  Us: apple
  Date: 29.5.22
  Time: 10:03 PM
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>我的订单</h1>
<table border="1" style="border-collapse: collapse">
    <tr>
        <td colspan="2">个人信息</td>
    </tr>
    <tr>
        <td>用户名</td>
        <td><%=((User) session.getAttribute("loginUser")).getName()%>
        </td>
    </tr>
    <tr>
        <td>邮件</td>
        <td><%=((User) session.getAttribute("loginUser")).getEmail()%>
        </td>
    </tr>
    <tr>
        <td>级别</td>
        <td><%=((User) session.getAttribute("loginUser")).getGrade()%>
        </td>
    </tr>
</table>
<br/>
<table border="1" style="border-collapse: collapse">
    <tr>
        <td>bookId</td>
        <td>书名</td>
        <td>价格</td>
        <td>出版社</td>
        <td>数量</td>
    </tr>
    <%
        ArrayList al = (ArrayList) request.getAttribute("orderInfo");
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
        <td><%=book.getPublishHouse()
        %>
        </td>
        <td><%=book.getShoppingNum()%>
        </td>
    </tr>
    <%
        }
    %>
    <tr><td colspan="5">总价格：<%=request.getAttribute("totalPrice")%></td></tr>

</table>
<%--知识点
 buttont跳转--%>
<input type="button" value="购买" onclick="goSubmitOrder()">
<script type="text/javascript">
    function goSubmitOrder() {
        //也可以传递参数
        window.location.href="/servletpro/SubmitOrderServlet";
    }
</script>
</body>
</html>
