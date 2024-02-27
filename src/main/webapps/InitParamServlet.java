package main.webapps;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Enumeration;

//@WebServlet("/initParam")
public class InitParamServlet extends HttpServlet {

    public InitParamServlet() {
        System.out.println(LocalDateTime.now() + " : " + "InitParamServlet constructor call");
    }

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        System.out.println("config call");
//        Enumeration<String> initParameterNames = config.getInitParameterNames();
//        while (initParameterNames.hasMoreElements()) {
//            String name = initParameterNames.nextElement();
//            System.out.println("config name : " + name + ", value : " + config.getInitParameter(name));
//        }
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Call by GET");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Client request this uri by GET!");
        Enumeration<String> initParameterNames = this.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String name = initParameterNames.nextElement();
            System.out.println("config name : " + name + ", value : " + this.getInitParameter(name));
        }
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
