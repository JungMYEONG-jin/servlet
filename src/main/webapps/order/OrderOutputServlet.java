package main.webapps.order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

//@WebServlet("/orderOutput")
public class OrderOutputServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        HttpSession session = req.getSession();
        Object obj = session.getAttribute("cart");
        long total = 0;
        if (obj != null) {
            List<Fruit> cart = (ArrayList<Fruit>) session.getAttribute("cart");
            writer.println("<h1>Your Shopping cart is <br>");
            for (Fruit fruit : cart) {
                writer.println(fruit + "<br>");
                total += fruit.getPrice() * fruit.getQty();
            }
            writer.println("<h2>Your Total Price is " + total + "<br>");
        } else {
            writer.println("<h1>Your Shopping cart is Empty!!<br>");
        }
        writer.close();
    }
}
