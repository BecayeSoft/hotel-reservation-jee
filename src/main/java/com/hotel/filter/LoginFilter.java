package com.hotel.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.models.User;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {
	
	private static final String LOGIN_PAGE = "/Hotel-Reservation-JEE/account/login";

    public LoginFilter() {
        System.out.println("Hello LoginFilter here!");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse= (HttpServletResponse) response;
		
		HttpSession session = httpServletRequest.getSession();
		
		User user = (User) session.getAttribute("user");

		if (user == null) {
			httpServletResponse.sendRedirect(LOGIN_PAGE);
			response.getWriter().append("Non authenticated: " + user).append(httpServletRequest.getContextPath());
		}
		else {			
			// pass the request along the com.hotel.filter chain
			chain.doFilter(httpServletRequest, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
