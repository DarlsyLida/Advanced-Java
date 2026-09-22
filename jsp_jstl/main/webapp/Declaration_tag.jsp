<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>use for declarative tag$</title>
</head>
<body>

<%!
int a=20;
int b=5;
String name="University";

public int op_div()
{
return a/b;
}

public String reverse_str()
{
    StringBuffer bf=new StringBuffer(name);
    return bf.reverse().toString();
}
%>

<%
out.println("division="+op_div());
%>
<%= reverse_str()%>

</body>
</html>