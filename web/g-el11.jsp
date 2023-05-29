<%@ page import="com.jsp_el.bean.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
${10+20}<br>
${10+"90"}<br>
\${10+"asd"}<br>
\${"er"+"jj"}<br>



${"sdf"=="sdf"}<br>
<%
    Object o= new Object();
    request.setAttribute("o",o);
    request.setAttribute("o1",o);
%>
${o==o1}<br>


<%
    String s = new String("er");
    String s1 = new String("er");
    request.setAttribute("s",s);
    request.setAttribute("s1",s1);
%>
${s==s1}<br>



${"sdf"=="sdf"}<br>
<%
    Object o2= new Object();
    Object o3= new Object();
    request.setAttribute("o2",o2);
    request.setAttribute("o3",o3);
%>
${o2==o3}<br>


<%
    Student student1 = new Student(110,"policeman");
    Student student2 = new Student(110,"policeman");
    request.setAttribute("stu1",student1);
    request.setAttribute("stu2",student2);
%>
${stu1==stu2}<br>
${stu1 eq stu2}<br>
${!(stu1 eq stu2)}<br>
${not(stu1 eq stu2)}<br>
${stu1 != stu2}<br>
${200 != 200}<br>




${empty param.name}<br>
${!empty param.name}<br>
${not empty param.name}<br>



${empty param.name == null}<br>
${(empty param.name) == null}<br>



${param.name == null}<br>

