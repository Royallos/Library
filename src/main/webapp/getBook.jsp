<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ page import="library.entity.Book" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>
<br>
<p>Id:${id}</p>
<p>Name: ${Book} </p>
<p>Author:${Author}</p>
<p>Genre: ${Genre} </p>
<p>ISBN: ${ISBN}</p>
</br>
<h2>Service for add book</h2>
<%
    List<Book> bookList = (List<Book>) request.getAttribute("book");
    for (Book bl:bookList) {
        out.println("<h2>"+bl.getTitle()+"</h2>");
        out.println("<p"+bl.getTitle()+"<br>\tAuthor: "+bl.getAuthorName()+"/\tSurname: "+bl.getAuthorSurname()+"</p>");
        out.println("<p>"+bl.getGenreName()+"</p>");
        out.print("<hr>");
    }
%>

<a href="index.jsp">Home</a>
</body>
</html>
