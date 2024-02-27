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

@WebServlet("/orderTest")
public class OrderServlet extends HttpServlet {

    public OrderServlet() {
        System.out.println(LocalDateTime.now() + " : " + "OrderServlet constructor call");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Call by GET");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Client request this uri by GET!");
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>Client request this uri by POST!<br>");
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        int qty = 0;
        int price = 0;
        String fruit = "";
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println("name = " + name);
            if (name.equals("apple")) {
                fruit = name;
                price = Integer.parseInt(req.getParameter("applePrice"));
                qty = Integer.parseInt(req.getParameter("appleQty"));
            } else if (name.equals("grape")) {
                fruit = name;
                price = Integer.parseInt(req.getParameter("grapePrice"));
                qty = Integer.parseInt(req.getParameter("grapeQty"));
            } else if (name.equals("peach")) {
                fruit = name;
                price = Integer.parseInt(req.getParameter("peachPrice"));
                qty = Integer.parseInt(req.getParameter("peachQty"));
            }
            writer.println("Client Query : " + name + " value : " + req.getParameter(name) + "<br>");
        }

        writer.println("You ordered " + fruit +", qty : " + qty + ", price : " + price + ", total : " + (price * qty));



        writer.close();
    }
}
