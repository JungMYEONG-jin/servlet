package main.webapps;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/cookie3")
public class CookieTest3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cnt = 0;
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("count")) {
                cnt = Integer.parseInt(cookie.getValue());
            }
        }
        cnt++;
        Cookie cookie = new Cookie("count", cnt + "");
        cookie.setMaxAge(60 * 60 * 24 * 10);
        resp.addCookie(cookie);


        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>Client request this uri by GET!");
        writer.print("<h1>Visited Count : " + cnt + "<br>");
        writer.close();
    }
}
