<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 14.11.2020
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Name input HTML-form - Spring Playground</title>
</head>
<body>

<h1>Show Name From Parameters</h1>
<form action="/studentName/showNameFromParameters" method="get">
    <input type="text" name="studentName" placeholder="What's your name?"/>
    <input type="submit"/>
</form>

<br>
<br>

<h1>Show Name From HttpServletRequest's Parameter And Model</h1>
<form action="/studentName/showNameFromHttpServletRequestParameterAndModel" method="get">
    <input type="text" name="studentName" placeholder="What's your name?"/>
    <input type="submit"/>
</form>

<br>
<br>

<h1>Show Name From @RequestParam And Model</h1>
<form action="/studentName/showNameFromRequestParamAndModel" method="get">
    <input type="text" name="studentName" placeholder="What's your name?"/>
    <input type="submit"/>
</form>

</body>
</html>
