package FilterDemo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "FilterDemo")
public class FilterDemo implements Filter {

    private String[] pathlist;
    private String encoding;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest hreq = (HttpServletRequest) req;
        HttpServletResponse hresp = (HttpServletResponse) resp;
        String requestpath = ((HttpServletRequest) req).getServletPath();
        HttpSession httpSession = hreq.getSession();
        if(containsPath(requestpath)){
            chain.doFilter(req,resp);
        }else if(httpSession.getAttribute("username")==null){

        }else {
            chain.doFilter(req,resp);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

    public boolean containsPath(String path){
        for(String p:pathlist){
            if(p.equals(path)){
                return true;
            }
        }
        return false;
    }
}
