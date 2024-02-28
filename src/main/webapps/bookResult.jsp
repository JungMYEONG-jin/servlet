<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="main.webapps.order.Book"%>
<%@ page isELIgnored="false" %>

<%

Book b = (Book) request.getAttribute("book");
if(b != null){ %>
    <%= "book is not null" %>
<% }

%>

<h1> Your book is ${b}