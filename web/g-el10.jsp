
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>


<%--
el隐式对象
   pageContext
   param
   paramValues
   initParam
 
--%>

用户名：<%=request.getParameter("username")%>
<br>
用户名：${param.username}
<br>



爱好：<%=request.getParameter("aihao")%><br>
爱好：${param.aihao}<br>



一维数组：<%=request.getParameterValues("aihao")%><br>
一维数组：${paramValues.aihao}<br>


爱好：${paramValues.aihao[0]}、${paramValues.aihao[1]}、${paramValues.aihao[2]}<br>


pageNum:<%=application.getInitParameter("pageNum")%><br>
pageSize:<%=application.getInitParameter("pageSize")%><br>


pageNum:${initParam.pageSize}<br>
pageSize:${initParam.pageNum}<br>