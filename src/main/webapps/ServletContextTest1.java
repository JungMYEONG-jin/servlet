package main.webapps;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/context1")
public class ServletContextTest1 extends HttpServlet {
    private ServletContext servletContext;

    public ServletContextTest1() {
        System.out.println(LocalDateTime.now() + " : " + "Test5 Servlet constructor call");
    }

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        servletContext = config.getServletContext();
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        servletContext = this.getServletContext();
        writer.print("<h1>Client request this uri by GET!");
        writer.print("<h1>ServletContext " + servletContext);
        System.out.println("servletContext = " + servletContext.getContextPath());
        System.out.println("servletContext.getMajorVersion() = " + servletContext.getMajorVersion());
        System.out.println("servletContext = " + servletContext.getMinorVersion());
        System.out.println("servletContext = " + servletContext.getServerInfo());
        System.out.println("servletContext = " + servletContext.getInitParameter("contextConfig"));

        ShareObject obj1 = new ShareObject();
        obj1.setCount(100);
        obj1.setStr("message1");

        ShareObject obj2 = new ShareObject();
        obj2.setCount(200);
        obj2.setStr("message2");
        servletContext.setAttribute("data1", obj1);
        servletContext.setAttribute("data2", obj2);

        writer.close();
    }
}
