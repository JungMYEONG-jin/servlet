package main.webapps;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/netInfo")
public class NetInfoServlet extends HttpServlet {

    public NetInfoServlet() {
        System.out.println(LocalDateTime.now() + " : " + "NetInfo Servlet constructor call");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Call by GET");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>Client request this uri by GET!");
        writer.print("<h1>Request Scheme : " + req.getScheme());
        writer.print("<h1>Request Method : " + req.getMethod());
        writer.print("<h1>Request Remote User : " + req.getRemoteUser());
        writer.print("<h1>Request Addr : " + req.getRemoteAddr());
        writer.print("<h1>Request Host : " + req.getRemoteHost());
        writer.print("<h1>Request Port : " + req.getRemotePort());
        writer.close();
    }
}
