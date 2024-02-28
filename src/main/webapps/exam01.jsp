<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.*, java.time.*" %>
<html>
<head><title>First JSP</title></head>
<body>
  <%
    double num = Math.random();
    if (num > 0.95) {
  %>
      <h2>You'll have a luck day!</h2><p>(<%= num %>)</p>
  <%
    } else {
  %>
      <h2>Well, life goes on ... </h2><p>(<%= num %>)</p>
  <%
    }
  %>
  <a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>
  <% Date d = new Date();
  %>
  <h3>Current Time is (<%= d %>)

  <%@ include file="exam02.jsp"%>
</body>
</html>