package main.webapps;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/local")
public class LocalTest extends HttpServlet {

    public LocalTest() {
        System.out.println(LocalDateTime.now() + " : " + "LocalTest Servlet constructor call");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int num = 0;
        String msg = req.getParameter("msg");

        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>Client request this uri by GET!");
        writer.print("<h1>Local Variable Test<br>");
        while (num++ < 10) {
            writer.print(msg+":"+num+"<br>");
            writer.flush();
            System.out.println(msg+":"+num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        writer.close();
    }
}
