<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head><title>구구단 JSP</title></head>
<body>

  <h3>구구단</h3>
  <%
    for(int i=2;i<=9;i++){
        for(int j=1;j<10;j++){ %>
            <%=(i+" * "+j+" = "+i*j)%><br>
        <% } %><br>
    <% } %>
</body>
</html>