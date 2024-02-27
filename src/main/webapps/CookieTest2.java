package main.webapps;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie2")
public class CookieTest2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>Client request this uri by GET!");
        writer.print("<h1>Cookie List<br>");
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            writer.print("<h1>Cookie name : " + name + ", value : " + value + "<br>");
        }
        writer.close();
    }
}
