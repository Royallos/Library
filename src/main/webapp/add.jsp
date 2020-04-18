<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
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
<a href="index.jsp">Home</a>
</body>
</html>
