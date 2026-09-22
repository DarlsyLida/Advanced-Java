<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <title>directive elements$</title>
</head>
<h1> random number </h1>
<%
Random r=new Random();
int n=r.nextInt(6);
out.println("ans="+n);
%>

<%= n %>
</h1>

</head>
</html>