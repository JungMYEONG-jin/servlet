package main.webapps.order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

//@WebServlet("/clearCart")
public class ClearCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        HttpSession session = req.getSession();
        if (session != null) {
            session.invalidate();
        }
        req.getRequestDispatcher("orderOutput").include(req, resp);
    }
}
