<%@ page contentType="application/msword;charset=UTF-8" language="java" %>

<%
    response.setHeader("Content-Disposition", "attachment; filename=\"today.doc\"");
%>

<html>
<body>

<h1>Today's Date</h1>

Today is: <%= new java.util.Date() %>

</body>
</html>