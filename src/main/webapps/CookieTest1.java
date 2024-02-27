package main.webapps;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie1")
public class CookieTest1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("id", "guest");
        resp.addCookie(cookie);

        Cookie cookie2 = new Cookie("code", "guest1004");
        cookie2.setMaxAge(60* 60* 3);
        resp.addCookie(cookie2);

        Cookie cookie3 = new Cookie("sub", "java");
        cookie3.setMaxAge(60 * 60 * 24 * 10);
        resp.addCookie(cookie3);

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>Client request this uri by GET!");
        writer.close();
    }
}
