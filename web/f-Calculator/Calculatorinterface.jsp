<%--
  功能：计算器
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
    <script type="text/javascript" src="../js/calculator.js"></script>
</head>
<body>
<%
    String num1 = request.getParameter("num1");
    String num2 = request.getParameter("num2");
    String oper = request.getParameter("oper");
    double res = 0;
    double n1 = 0;
    double n2 = 0;

    if (num1 != null && num2 != null && oper != null) {
        n1 = Double.parseDouble(num1);
        n2 = Double.parseDouble(num2);
        if (oper.equals("+")) {
            res = n1 + n2;
        } else if (oper.equals("-")) {
            res = n1 - n2;
        } else if (oper.equals("*")) {
            res = n1 * n2;
        } else if (oper.equals("/")) {
            res = n1 / n2;
        }
    }

%>
<form action="/jsppro/f-Calculator/Calculatorinterface.jsp" method="post">
    第一个数:<input type="text" name="num1" id="num1" value="<%=n1 %>"/><br/>
    运算法：<select name="oper">
    <option value="+">+</option>
    <option value="-">-</option>
    <option value="*">*</option>
    <option value="/">/</option>
</select><br/>
    第二个数:<input type="text" name="num2" id="num2" value="<%=n2 %>"/><br/>
    <input type="submit" value="等于" onclick="return checkNum()"/>
</form>
<hr/>
结果是:<%=res %>
</body>
</html>
