package me.ning.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "CharsetFilter")
public class CharsetFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
