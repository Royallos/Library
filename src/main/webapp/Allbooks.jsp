<%--
  Created by IntelliJ IDEA.
  User: Vorob
  Date: 18.04.2020
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>AllBooks</title>
</head>
<body>
<ul>
    <c:forEach var="book" items="${books}">
        <li><a href="/books?action=edit&bookId=${book.id}"><c:out value="${book.title}" /></a></li>
        <c:out value="${book.genre}" />
        <c:out value="${book.author}" />
    </c:forEach>
</ul>
<form action="/books" method="POST">
    Title:
    <input name="title" value="${book.title}" />${book.title}
    <br><br>
    Genre:
    <input name="genre" value="${book.genre}" />${book.genre}
    <br><br>
    Author:
    <input name="author" value="${book.author}" />${book.author}
    <br><br>
    <input type="hidden" name="bookId" value="${book.id}" />${book.id}
    <input type="submit" value="Submit" />
</form>
</body>
</html>
