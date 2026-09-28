<%@ page session="true" %>

<!DOCTYPE html>
<html>

<head>

    <title>Cast Your Vote</title>

</head>

<body>

    <h2>Cast Your Vote</h2>

    <%
        String userName =
                (String) session.getAttribute("userName");
    %>

    <p>
        Welcome, <%= userName %>
    </p>

    <form action="VoteServlet" method="post">

        <h3>Select a Candidate</h3>

        <input type="radio"
               name="candidate"
               value="Narendra Modi"
               required>

        Narendra Modi

        <br><br>

        <input type="radio"
               name="candidate"
               value="Mohan Bhagwat">

        Mohan Bhagwat

        <br><br>

        <input type="radio"
               name="candidate"
               value="Amit Shah">

        Amit Shah

        <br><br>

        <input type="submit"
               value="Submit Vote">

    </form>

</body>

</html>