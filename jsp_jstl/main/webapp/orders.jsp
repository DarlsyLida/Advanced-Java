<HTML>
<HEAD>
    <TITLE>A Catalog Order Form</TITLE>
</HEAD>
<BODY>
<H1 ALIGN="center">A Sample Order Form</H1>
<%!
    String item[] = {"DVD", "CD", "Diskette"};
    double price[] = {19.99, 12.99, 1.99};
    int quantity[] = {2, 9, 24};
%>
<TABLE ALIGN="center" BGCOLOR="lightgray" BORDER="1" WIDTH="75%">
<TR>
    <TD>Item</TD>
    <TD>Price</TD>
    <TD>Quantity</TD>
    <TD>Total Price</TD>
</TR>
<% for (int i=0; i<3; i++) { %>
    <TR>
        <TD><%= item[i] %></TD>
        <TD><%= price[i] %></TD>
        <TD><%= quantity[i] %></TD>
        <TD><%= price[i] * quantity[i] %></TD>
    </TR>
<% } //end for loop %>
</TABLE>
</BODY>
</HTML>