<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>
    <c:when test="${param.age<18}">
        青年
    </c:when>
    <c:when test="${param.age<35}">
        成年
    </c:when>
    <c:when test="${param.age<90}">
        中年
    </c:when>
    <c:otherwise>
        老年
    </c:otherwise>
</c:choose>