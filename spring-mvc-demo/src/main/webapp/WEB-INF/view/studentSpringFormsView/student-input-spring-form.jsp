<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 15.11.2020
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Input Spring Form - Spring Playground</title>
</head>
<body>
<form:form action="/springForm/studentOutputSpringForm" modelAttribute="student">

    First name: <form:input path="firstName"/>
    <br><br>
    Second name: <form:input path="lastName"/>
    <br><br>
    Country:
    <form:select path="country">
        <%--<form:option value="RU" label="Russian Federation"/>
        <form:option value="US" label="USA"/>
        <form:option value="DE" label="Germany"/>
        <form:option value="FR" label="France"/>
        <form:option value="ES" label="Spain"/>--%>
        <form:options items="${student.countryOptions}"/>
    </form:select>
    <br><br>
    Favourite language:
    <br>
    <ul>
        <li>Java <form:radiobutton path="favouriteLanguage" value="Java"/></li>
        <li>C# <form:radiobutton path="favouriteLanguage" value="C#"/></li>
        <li>PHP <form:radiobutton path="favouriteLanguage" value="PHP"/></li>
        <li>Ruby <form:radiobutton path="favouriteLanguage" value="Ruby"/></li>
    </ul>
    <br><br>
    Favourite language:
    <br>
    Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/><br>
    Windows <form:checkbox path="operatingSystems" value="Windows"/><br>
    Linux <form:checkbox path="operatingSystems" value="Linux"/><br>
    Solaris <form:checkbox path="operatingSystems" value="Solaris"/><br>


    <input type="submit" value="Submit"/>

</form:form>
</body>
</html>