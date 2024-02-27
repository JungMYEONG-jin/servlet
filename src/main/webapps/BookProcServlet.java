package main.webapps;

import main.webapps.order.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/bookProc")
public class BookProcServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String pub = req.getParameter("pub");
        Book book = new Book(title, author, pub);
        // request
        req.setAttribute("book", book);
        RequestDispatcher bookoutput = req.getRequestDispatcher("bookoutput");
        bookoutput.forward(req, resp);
        writer.close();
    }
}
