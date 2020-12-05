<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 26.11.2020
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Registration Form - Spring Playground</title>

    <style>
        .error {color:red}
    </style>
</head>
<body>

    <i>Fill out the form. (*) means required</i>

    <br><br>

    <form:form action="customerConfirmationSpForm" modelAttribute="customer">

        First name: <form:input path="firstName"/>

        <br><br>

        Last name (*): <form:input path="lastName"/>
        <form:errors path="lastName" cssClass="error"/>

        <br><br>

        Free Passes (*): <form:input path="freePasses"/>
        <form:errors path="freePasses" cssClass="error"/>

        <br><br>

        Postal Code (*): <form:input path="postalCode"/>
        <form:errors path="postalCode" cssClass="error"/>

        <br><br>

        Course Code (*): <form:input path="courseCode"/>
        <form:errors path="courseCode" cssClass="error"/>

        <br><br>

        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>
