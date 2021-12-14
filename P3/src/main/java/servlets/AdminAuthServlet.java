package servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import display.javabean.CustomerBean;

/**
 * Servlet Filter implementation class AdminAuthServlet
 */
@WebFilter("/AdminAuthServlet")
public abstract class AdminAuthServlet implements Filter {

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String requestPath = request.getRequestURI();
   		CustomerBean customerBean = (CustomerBean) session.getAttribute("customerBean");
        if (needsAuthAdmin(requestPath) || customerBean == null || customerBean.getEmailUser().equals("") || !customerBean.getRol().equals("admin")) {
            	response.sendRedirect(request.getContextPath() + "/notAuth.jsp"); // No permission
        } else {
            chain.doFilter(req, res); // Logged-in user is admin, so just continue request.
       	} 
	}
	
	private boolean needsAuthAdmin(String url) {
        String[] validNonAuthenticationUrls =
            { "homeAdmin.jsp" };
        for(String validUrl : validNonAuthenticationUrls) {
            if (url.endsWith(validUrl)) {
                return false;
            }
        }
        return true;
    }
}
