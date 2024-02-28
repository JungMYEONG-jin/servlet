package main.webapps.filter;

import javax.servlet.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MyFilterV7 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilterV7 init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("====MyFilterV7 in====");
        servletRequest.setCharacterEncoding(StandardCharsets.UTF_8.name());
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("====MyFilterV7 out====");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilterV7 destroy");
    }
}
