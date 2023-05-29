<%@ page import="com.jsp_el.bean.User" %>
<%@ page import="com.jsp_el.bean.Address" %>
<%--
  功能：
  Us: apple
  Date: 21.8.22
  Time: 9:03 PM
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<%
    User us = new User("jacken","114967",27);
    Address address = new Address();
    address.setCity("shhsh");
    us.setAddress(address);
    request.setAttribute("userObj", us);

%>
${userObj}
<br>
${userObj.name}<br>
${userObj.email}
<br>
<%--如果加""，则是当做普通字符串输出--%>
${"userObj"}

<%--取出城市--%>
<br>
${userObj.address.city}

