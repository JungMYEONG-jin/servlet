<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<% String path = request.getParameter("p"); %>

<%-- <jsp:forward page="exam03.jsp"></jsp:forward> --%>
<%-- <jsp:forward page="<%= path %>"/> --%>
<jsp:forward page="${param.p}"/>