<%@ page import="com.jsp_el.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    String[]  name= {"s","jjj","oo"};
    request.setAttribute("name",name);


    User[] users =new User[10];
    User u1= new User("jdj","kk",90);
    User u2= new User("jdj","kk",90);
    users[0]=u1;
    users[1]=u2;
    request.setAttribute("users",users);


    List<String> list = new ArrayList<>();
    list.add("1");
    list.add("2");
    list.add("3");
    list.add("4");
    request.setAttribute("list",list);


    Set<String> set=new HashSet<>();
    set.add("a");
    set.add(("b");
    request.setAttribute("set",set);

%>




<%--el表达式取出数组--%>
${name}<br>
${name[0]}<br>
${name[1]}<br>
${name[3]}
<%--el表达式数组越界不影响，取不到数据会输出空白--%>



<%--取出数组中对象元素--%>
<br>
${users[0].name}



<%--取出list--%>
${list}<br>
<%--取出数组中的元素--%>
${list[0]}<br>
${list[1]}<br>
${list[2]}<br>
${list[3]}<br>


<%--取出set对象，没讲取出set中的元素--%>
${set}