package org.aulaweb.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author john
 */
public class AdminRequiredFilter implements Filter {

    @Override
    public void destroy() {
        
    }
    
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        
        if (request.getSession().getAttribute("mail") != null) {
            chain.doFilter(servletRequest, servletResponse);
            
        } else {
            request.getRequestDispatcher("/admin/login").forward(servletRequest, servletResponse);
        }
    }
    
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        
    }
    

}
