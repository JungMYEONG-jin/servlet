package main.webapps;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/test5")
public class Test5 extends HttpServlet {
    private int cnt = 0;

    public Test5() {
        System.out.println(LocalDateTime.now() + " : " + "Test5 Servlet constructor call");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cnt++;
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>Client request this uri by GET!");
        writer.print("<h2>Client requested count : " + cnt);
        writer.close();
    }
}
