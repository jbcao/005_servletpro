<%--
  功能：
  User: apple
  Date: 22.5.22
  Time: 9:23 PM
  Created by IntelliJ IDEA.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String num1 = request.getParameter("num1");
    String num2 = request.getParameter("num2");
    String oper = request.getParameter("oper");
    double res=0;
    double n1=Double.parseDouble(num1);
    double n2=Double.parseDouble(num2);
    if(oper.equals("+")){
res=n1+n2;
    }else if(oper.equals("-")){
        res=n1-n2;
    }else if(oper.equals("*")){
        res=n1*n2;
    }else if(oper.equals("/")){
        res=n1/n2;
    }
    out.print("结果是="+res);
%>
<%--<%=res %>--%>
</body>
</html>
