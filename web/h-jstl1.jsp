
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<%--引入核心标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--核心标签库中的if标签

test属性必须有
    支持el
    属性值必须是boolean
--%>
<c:if test="${empty param.name}">
    <h1>用户名不能为空</h1>
</c:if>


<%--没有else标签，可以搞多个if
   var属性 不是必须
          test中的属性值

   scope  指定var存储的域，page request session application
--%>

<c:if test="${not empty param.name}" var="i" scope="page">
    <h1>欢迎你${param.name}<h1>
</c:if>
<br>



<%--通过el将i从域中取出--%>
${i}


