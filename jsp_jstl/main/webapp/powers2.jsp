<html>
<head>
    <title>Powers of 2</title>
</head>
<body>
<center>
<table border="2" align="center">
    <th>Exponent</th>
    <th>2^Exponent</th>
    <% for (int i=0; i<=10; i++) { //start for loop %>
        <tr>
            <td><%= i%></td>
            <td><%= Math.pow(2, i) %></td>
        </tr>
    <% } //end for loop %>
</table>
</center>
</body>
</html>