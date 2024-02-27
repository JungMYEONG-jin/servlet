package main.webapps;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Enumeration;

@WebServlet("/queryTest")
public class QueryStringServlet extends HttpServlet {

    public QueryStringServlet() {
        System.out.println(LocalDateTime.now() + " : " + "Temp Servlet constructor call");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Call by GET");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Client request this uri by GET!");
        writer.println("Client query : " + req.getQueryString());

        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            if (name.equals("hobby")) {
                String[] parameterValues = req.getParameterValues(name);
                for (String parameterValue : parameterValues) {
                    writer.println("Client Query : " + name + " value : " + parameterValue + "<br>");
                }
            } else {
                writer.println("Client Query : " + name + " value : " + req.getParameter(name) + "<br>");
            }
        }
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Client request this uri by POST!");
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            if (name.equals("hobby")) {
                String[] parameterValues = req.getParameterValues(name);
                for (String parameterValue : parameterValues) {
                    writer.println("Client Query : " + name + " value : " + parameterValue + "<br>");
                }
            } else {
                writer.println("Client Query : " + name + " value : " + req.getParameter(name) + "<br>");
            }
        }
        writer.close();
    }
}
