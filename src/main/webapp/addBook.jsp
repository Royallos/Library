<%--
  Created by IntelliJ IDEA.
  User: Vorob
  Date: 20.04.2020
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>addBook</title>
</head>
<body>
<form action="/addBook" method="POST">
    id:
    <input name="id"/>
    <br><br>
    Title:
    <input name="Title"/>
    <br><br>
    Author:
    <input name="Author"/>
    <br><br>
    Genre:
    <input name="Genre"/>
    <br><br>
    ISBN
    <input name="ISBN"/>
    <br><br>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
