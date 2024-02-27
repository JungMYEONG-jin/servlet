package main.webapps;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session")
public class SessionTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String msg = "";
        String param = req.getParameter("p");
        HttpSession httpSession = null;

        if (param.equals("create")) {
            httpSession = req.getSession();
            if (httpSession.isNew()) {
                msg = "New Session created";
            } else {
                msg = "Already Session existed";
            }
        } else if (param.equals("destroy")) {
            httpSession = req.getSession(false);
            if (httpSession != null) {
                httpSession.invalidate();
                msg = "Session invalidated";
            } else {
                msg = "No Session";
            }
        } else if (param.equals("add")) {
            httpSession = req.getSession(true);
            httpSession.setAttribute("data", "java");
            msg = "Data insert";
        } else if (param.equals("get")) {
            httpSession = req.getSession(false);
            if (httpSession != null && httpSession.getAttribute("data") != null) {
                msg = "session data value is " + httpSession.getAttribute("data").toString();
            } else {
                msg = "session has no data";
            }
        } else if (param.equals("remove")) {
            httpSession = req.getSession(false);
            if (httpSession != null) {
                httpSession.removeAttribute("data");
                msg = "session data removed";
            } else {
                msg = "session is null";
            }
        } else if (param.equals("replace")) {

        }


        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.print("<h1>Client request this uri by GET!");
        writer.print("<h1>Client Session status : " +  msg);
        writer.close();
    }
}
