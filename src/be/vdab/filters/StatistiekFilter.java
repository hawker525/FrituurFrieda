package be.vdab.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Admin on 5/12/2016.
 */
@WebFilter(filterName = "StatistiekFilter", urlPatterns = "/statistiek.htm")
public class StatistiekFilter implements Filter {
    private static final String STATISTIEK = "statistiek";
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ConcurrentHashMap<String, AtomicInteger> cmh = (ConcurrentHashMap<String, AtomicInteger>) req.getServletContext().getAttribute(STATISTIEK);
        String url = ((HttpServletRequest) req).getRequestURI();
        AtomicInteger count = cmh.get(url);
        if(count != null) cmh.putIfAbsent(url, new AtomicInteger(0));
        cmh.get(url).incrementAndGet();
        req.getServletContext().setAttribute(STATISTIEK, cmh);
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        config.getServletContext().setAttribute(STATISTIEK, new ConcurrentHashMap<String, AtomicInteger>());
    }

}
