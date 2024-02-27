package main.webapps;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello3")
public class ThirdServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Call by GET");
    }

    //    public ThirdServlet() {
//        System.out.println(LocalDateTime.now() + " : " + "ThirdServlet constructor call");
//    }
//
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        res.setContentType("text/html; charset=utf-8");
//        System.out.println(LocalDateTime.now() + " : " + "ThirdServlet service call");
//        PrintWriter writer = res.getWriter();
//        writer.print("<html><head><title>Insert title here</title></head>");
//        writer.print("<body>this is writer</body>");
//        writer.print("<body>좋은 하루</body>");
//        writer.print("</html>");
//    }
//
//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        System.out.println(LocalDateTime.now() + " : " + "ThirdServlet init call");;
//    }
}
