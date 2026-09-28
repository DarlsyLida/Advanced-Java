<!DOCTYPE html>
<html>
<head>

    <title>Voter Registration</title>

</head>

<body>

    <h2>Voter Registration</h2>

    <form action="RegisterServlet" method="post">

        <label>Name:</label>
        <input type="text" name="name" required>
        <br><br>

        <label>City:</label>
        <input type="text" name="city" required>
        <br><br>

        <label>Mobile Number:</label>
        <input type="text" name="mobile" required>
        <br><br>

        <label>Gender:</label>

        <input type="radio"
               name="gender"
               value="Male"
               required>
        Male

        <input type="radio"
               name="gender"
               value="Female">
        Female

        <br><br>

        <label>Age:</label>
        <input type="number"
               name="age"
               min="1"
               required>

        <br><br>

        <input type="submit"
               value="Register">

    </form>

</body>
</html>