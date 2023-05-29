<%@ page import="java.util.Map" %>
<%@ page import="com.jsp_el.bean.User" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<%
    Map<String,User> map = new HashMap<>();
    User user = new User();
    user.setName("cao");
    map.put("user",user);

    request.setAttribute("map",map);
%>


${map.user.name}
