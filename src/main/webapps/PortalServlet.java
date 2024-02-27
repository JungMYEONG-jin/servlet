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

@WebServlet("/portal")
public class PortalServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        String site = req.getParameter("site");
        if (site.equals("naver")) {
            resp.sendRedirect("https://naver.com");
        } else if (site.equals("daum")) {
            resp.sendRedirect("https://daum.net");
        }
        writer.close();
    }
}
