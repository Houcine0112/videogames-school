package fr.plil.sio.web;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This filter checks if the user is authenticated (i.e. the session contains an
 * user attribute). If not, it redirects the request on the client-side to the
 * login page.
 *
 * @author Julien Iguchi-Cartigny
 */
@WebFilter(urlPatterns = "/protected/*", dispatcherTypes = DispatcherType.REQUEST)
public class AccessControlFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession(true);
        User user = (User) session.getAttribute("user");
        if (user == null) {
            String urlRoot = ((HttpServletRequest) request).getContextPath();
            ((HttpServletResponse)response).sendRedirect(urlRoot + "/login.jsp");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
