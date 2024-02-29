<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="main.webapps.order.Book"%>
<%@ page import="main.webapps.dao.BookDAO"%>


<jsp:useBean id="vo" class="main.webapps.order.Book"/>

<jsp:setProperty name="vo" property="*"/>

<%
   /*String title = request.getParameter("title");
   String author = request.getParameter("author");
   String pub = request.getParameter("pub");
   Book book = new Book(title, author, pub);
   if(title.isEmpty() || author.isEmpty() || pub.isEmpty()){
           request.setAttribute("book", book);
           RequestDispatcher rd = request.getRequestDispatcher("book.jsp");
           rd.forward(request, response);
   }else{
       out.print(book);
   }*/
   if(vo.getTitle().isEmpty() || vo.getAuthor().isEmpty() || vo.getPub().isEmpty()){
              request.setAttribute("book", vo);
              RequestDispatcher rd = request.getRequestDispatcher("book.jsp");
              rd.forward(request, response);
      }else{
          out.print(vo);

          /* insert */
          BookDAO dao = new BookDAO();
          dao.insert(vo.getTitle(), vo.getAuthor(), vo.getPub());
   }
%>