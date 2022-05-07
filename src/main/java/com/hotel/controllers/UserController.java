package com.hotel.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.UserDaoImpl;
import com.hotel.models.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet(urlPatterns = { "/account/new", "/account/save", "/account/login" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String REGISTER_FORM = "/WEB-INF/views/account/register-form.jsp";
	private final String LOGIN_FORM = "/WEB-INF/views/account/login-form.jsp";
	//private final String HOME = "/WEB-INF/views/home/index.jsp";
	private final String REGISTER_CONFIRMATION = "/WEB-INF/views/account/register-confirmation.jsp";
	private UserDaoImpl dao;  
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        dao = new UserDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		
		if (request.getRequestURI().endsWith("new")) {
			dispatcher = request.getRequestDispatcher(REGISTER_FORM);
		}
		else if (request.getRequestURI().endsWith("login")) {
			dispatcher = request.getRequestDispatcher(LOGIN_FORM);
		}
		else {
			System.err.println("Route non implémentée -> UserController ");
			dispatcher = request.getRequestDispatcher(REGISTER_CONFIRMATION);
			//response.sendRedirect(HOME_PAGE);
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setEmail(request.getParameter("email"));
		user.setNom(request.getParameter("nom"));
		user.setPassword(request.getParameter("password"));
		user.setSexe(request.getParameter("sexe").charAt(0));
		user.setTelephone(request.getParameter("telephone"));
		user.setUsername(request.getParameter("username"));
		
		user.setPrivilege("client");
		
		System.out.println(user);
		
		dao.saveUser(user);
	
		doGet(request, response);
	}

}
