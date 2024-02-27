package main.webapps;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/logoutServlet")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        req.getRequestDispatcher("index.html").include(req, resp);
        String pwd = req.getParameter("pwd");
        String id = req.getParameter("id");

        if (pwd.equals("admin123")) {
            HttpSession session = req.getSession(false);
            if (session != null) {
                session.invalidate();
                writer.println(id + " are successfully logged out!");
            } else {
                writer.println("Login Session Disconnected. Your Request ignored..");
                req.getRequestDispatcher("Login.html").include(req, resp);
            }
        } else {
            writer.println("Sorry, username or password error!");
            req.getRequestDispatcher("Logout.html").include(req, resp);
        }
        writer.close();
    }
}
