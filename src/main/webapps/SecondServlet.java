package main.webapps;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.time.LocalDateTime;

@WebServlet("/hello2")
public class SecondServlet extends HttpServlet {

    public SecondServlet() {
        System.out.println(LocalDateTime.now() + " : " + "SecondServlet constructor call");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html; charset=utf-8");
        System.out.println(LocalDateTime.now() + " : " + "Second Servlet service call");
        PrintWriter writer = res.getWriter();
        writer.print("<html><head><title>Insert title here</title></head>");
        writer.print("<body>this is writer</body>");
        writer.print("<body>좋은 하루</body>");
        writer.print("</html>");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println(LocalDateTime.now() + " : " + "SecondServlet init call");;
    }
}
