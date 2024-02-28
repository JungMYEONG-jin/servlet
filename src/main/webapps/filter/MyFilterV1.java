package main.webapps.filter;

import javax.servlet.*;
import java.io.IOException;

public class MyFilterV1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilterV1 init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("====MyFilterV1 in====");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("====MyFilterV1 out====");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilterV1 destroy");
    }
}
