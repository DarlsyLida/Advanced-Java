<%@ page session="true" %>

<!DOCTYPE html>
<html>

<head>

    <title>Vote Successful</title>

</head>

<body>

    <h2>Vote Submitted Successfully!</h2>

    <p>
        Thank you,
        <%= session.getAttribute("userName") %>
    </p>

    <p>
        Your vote has been recorded successfully.
    </p>

    <p>
        You voted for:
        <strong>
            <%= session.getAttribute("candidate") %>
        </strong>
    </p>

</body>

</html>