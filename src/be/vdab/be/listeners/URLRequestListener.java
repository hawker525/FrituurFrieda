package be.vdab.be.listeners; /**
 * Created by maarten on 12/2/16.
 */

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener()
public class URLRequestListener implements ServletRequestListener, ServletContextListener{
    private static final String[] FILE_EXTENSIONS = {".css", ".js", ".png", ".jpeg"};
    private static final String STATISTIEK = "statistiek";
    // Public constructor is required by servlet spec
    public URLRequestListener() {
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        String s = ((HttpServletRequest) servletRequestEvent.getServletRequest()).getRequestURI();
        ServletContext sc = servletRequestEvent.getServletContext();
        if(s.endsWith(".htm") || s.endsWith(".html")){
            ConcurrentHashMap<String, AtomicInteger> cmh = (ConcurrentHashMap<String, AtomicInteger>) sc.getAttribute(STATISTIEK);
            cmh.putIfAbsent(s, new AtomicInteger(0));
            cmh.get(s).incrementAndGet();
            sc.setAttribute(STATISTIEK, cmh);
        }
//        boolean ends = true;
//        for (String end : FILE_EXTENSIONS) {
//            ends = !s.endsWith(end);
//        }
//        if(ends) System.out.println(s);
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
       servletContextEvent.getServletContext().setAttribute(STATISTIEK, new ConcurrentHashMap<String, AtomicInteger>());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
