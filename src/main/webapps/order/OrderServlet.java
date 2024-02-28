package main.webapps.order;

import main.webapps.order.Fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

//@WebServlet("/orderFruit")
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
        HttpSession session = req.getSession();
        if (req.getParameter("apple") != null) {
            fruit = req.getParameter("apple");
            price = Integer.parseInt(req.getParameter("applePrice"));
            qty = Integer.parseInt(req.getParameter("appleQty"));
        } else if (req.getParameter("grape") != null) {
            System.out.println(" grape ");
            fruit = req.getParameter("grape");
            price = Integer.parseInt(req.getParameter("grapePrice"));
            qty = Integer.parseInt(req.getParameter("grapeQty"));
        } else if (req.getParameter("peach") != null) {
            fruit = req.getParameter("peach");;
            price = Integer.parseInt(req.getParameter("peachPrice"));
            qty = Integer.parseInt(req.getParameter("peachQty"));
        }
        Fruit ordered = new Fruit(fruit, price, qty);
        writer.println(ordered);
        List<Fruit> cart = new ArrayList<>();
        if (session.isNew()) {
            cart.add(ordered);
            session.setAttribute("cart", cart);
        } else {
            Object obj = session.getAttribute("cart");
            if (obj != null) {
                cart = (ArrayList<Fruit>) session.getAttribute("cart");
            }
            cart.add(ordered);
            session.setAttribute("cart", cart);
        }
        // move to cart page
        req.getRequestDispatcher("orderOutput").forward(req, resp);
        writer.close();
    }
}
