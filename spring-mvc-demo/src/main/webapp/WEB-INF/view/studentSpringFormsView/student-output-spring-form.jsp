<%--
<jsp:useBean id="student" scope="request" type="com.max.student.springform.service.Student"/>
--%>
<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 15.11.2020
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>asd</title>
</head>
<body>
    The student is confirmed: ${student.firstName} ${student.lastName}
    <br><br>
    Country: ${student.country}
    <br><br>
    Favourite language: ${student.favouriteLanguage}
    <br><br>
    Operating systems:
    <br>
    <c:forEach var="currentOs" items="${student.operatingSystems}">
        <li>${currentOs}</li>
    </c:forEach>
</body>
</html>
