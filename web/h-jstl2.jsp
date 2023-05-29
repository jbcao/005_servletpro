<%@ page import="java.util.List" %>
<%@ page import="com.jsp_el.bean.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
var用来指定循环的变量
begin 开始
end   结束
step  步长

循环的变量存储到page域中
--%>

<c:forEach var="i" begin="1" end="10" step="1">
    ${i}<br>
</c:forEach>


<%
    //创建lis对象
    List<Student> students = new ArrayList<>();

    Student s1 = new Student(110,"稽查");
    Student s2 = new Student(120,"救护车");
    Student s3 = new Student(119,"消防车");

    students.add(s1);
    students.add(s2);
    students.add(s3);

    request.setAttribute("stus",students);
%>

<%--原来方式--%>
<%
    List<Student> list = (List<Student>) request.getAttribute("stus");
    for(Student student:list){
%>
<%=student.getId()%>--<%=student.getName()%><br>
<%
    }
%>

<hr>
<%--
items 循环的集合
var="s"代表集合中的student对象
varStatus var状态对象，里面有count属性，代表编号
--%>

<c:forEach  items="${stus}" var="student" varStatus="stuStatus">
    编号：${stuStatus.count},id:${student.id},name:${student.name}
</c:forEach>