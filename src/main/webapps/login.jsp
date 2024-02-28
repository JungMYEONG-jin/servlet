<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>

<% if(session.isNew() || session.getAttribute("id") == null) { %>

<%
   String error = (String) request.getAttribute("error");
   if(error == null) error = "";
%>
<%= error %>
<form action="logout.jsp" method="post">
    Name:<input type="text" name="id"><br>
    Password:<input type="password" name="pwd"><br>
    <input type="submit" value="login">
</form>
<% } else{ %>
<p>
    <a href="logout.jsp"/>로그아웃
</p>
<% }%>
</html>