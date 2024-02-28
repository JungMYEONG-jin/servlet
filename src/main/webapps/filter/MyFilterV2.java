package main.webapps.filter;

import javax.servlet.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MyFilterV2 implements Filter {

    String code;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilterV2 init");
        code = filterConfig.getInitParameter("charset");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("====MyFilterV2 in====");
        servletRequest.setCharacterEncoding(code);
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("====MyFilterV2 out====");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilterV2 destroy");
    }
}
