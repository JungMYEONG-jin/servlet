<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Logout</title>
</head>
<%

    RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
    if(request.getMethod().equals("POST")){
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        if(id.isEmpty() || pwd.isEmpty()){
            request.setAttribute("error", "ID or Password is empty...!");
            rd.forward(request, response);
            return;
        }
        if(pwd.equals("admin123")){
            if(session.isNew() || session.getAttribute("id") == null){
                session.setAttribute("id", id);
                System.out.println("login!");
            }else{
                System.out.println("Already logged in!");
            }
        }else{
            request.setAttribute("error", "Wrong Password...!");
            rd.forward(request, response);
            return;
        }
    }else if(request.getMethod().equals("GET")){
        if(session != null && session.getAttribute("id") != null){
            session.invalidate();
            System.out.println("logged out!");
        }else{
            System.out.println("nog logged in");
        }

    }
    rd.forward(request, response);
%>
</html>