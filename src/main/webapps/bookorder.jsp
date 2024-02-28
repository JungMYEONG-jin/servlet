<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="main.webapps.order.Book"%>


<%
   String title = request.getParameter("title");
   String author = request.getParameter("author");
   String pub = request.getParameter("pub");
   Book book = new Book(title, author, pub);
   if(title.isEmpty() || author.isEmpty() || pub.isEmpty()){
           request.setAttribute("book", book);
           RequestDispatcher rd = request.getRequestDispatcher("book.jsp");
           rd.forward(request, response);
   }else{
       out.print(book);
   }
%>