<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 26.11.2020
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Confirmation Form - Spring Playground</title>
</head>
<body>
    The customer is confirmed: ${customer.firstName} ${customer.lastName}
    <br><br>
    Free Passes: ${customer.freePasses}
    <br><br>
    Postal Code: ${customer.postalCode}
    <br><br>
    Course Code: ${customer.courseCode}
</body>
</html>
