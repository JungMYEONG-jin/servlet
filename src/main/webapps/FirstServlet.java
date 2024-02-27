package main.webapps;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class FirstServlet extends HttpServlet {

    public FirstServlet() {
        System.out.println("FirstServlet constructor call");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("FirstServlet service call");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("FirstServlet init call");;
    }
}
