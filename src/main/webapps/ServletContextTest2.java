package main.webapps;

import jdk.nashorn.internal.runtime.SharedPropertyMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/context2")
public class ServletContextTest2 extends HttpServlet {

    public ServletContextTest2() {
        System.out.println(LocalDateTime.now() + " : " + "ServletContextTest2 Servlet constructor call");
    }

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        servletContext = config.getServletContext();
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>Client request this uri by GET!");
        ServletContext servletContext = this.getServletContext();
        ShareObject data1 = (ShareObject) servletContext.getAttribute("data1");
        ShareObject data2 = (ShareObject) servletContext.getAttribute("data2");
        writer.print("<h1>ServletContext data1 : " + data1);
        writer.print("<h1>ServletContext data2 : " + data2);
        writer.close();
    }
}
