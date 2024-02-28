package main.webapps.filter;

import javax.servlet.*;
import java.io.IOException;

public class OrderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("OrderFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("====OrderFilter in====");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("====OrderFilter out====");
    }

    @Override
    public void destroy() {
        System.out.println("OrderFilter destroy");
    }
}
