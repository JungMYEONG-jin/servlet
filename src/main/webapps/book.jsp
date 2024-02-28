<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="bookorder.jsp" method="post">
    Title:<input type="text" name="title" value="${book.getTitle()}"><br>
    Author:<input type="text" name="author" value="${book.getAuthor()}"><br>
    Publisher:<input type="text" name="pub" value="${book.getPub()}"><br>
    <input type="submit" value="등록">
</form>
</body>
</html>