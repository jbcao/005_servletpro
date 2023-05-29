<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 18.5.22
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
  入门案例
--%>
<%--这句话不能丢，相当于是告诉浏览器，我是jsp,或者告诉浏览器--%>
<%--language表示jsp 里面的脚本语言 嵌在里面的是什么语言 Java片段，
import代表引入包
pageencoding 本页面的编码方式是什么 有中文得是--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="utf-8" %>
<%--引入dtd 根元素是html public 是网上的--%>
<%--版本可以升级一下，那样div 居中就可以用了--%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0.1 Transitional//EN">
<html>
<head>
    <%--因为页面还是在服务器那头--%>
    <%--meta：描述页面信息--%>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2">
    <meta http-equiv="description" content="this is my page">
        <%--引入css--%>
    <link rel="stylesheet" type="text/css" href="">
    <title>Title</title>
</head>
<body>

<%
    //在角号百分号之间可以写Java代码
    //就和我们在Java文件中写Java代码是一样的
    //只能在这里写
    //想访问这个页面，需要发布web应用
    //jsp写完了无需配置，比servlet简单一点
    //而且，改了以后，不需要重新reload web应用
    //jsp路径，从web root开始算
    out.print("hello world 当前日期"+new java.util.Date());
%>
</body>
</html>
