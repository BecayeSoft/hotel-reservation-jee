package com.hotel.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.dao.UserDaoImpl;
import com.hotel.models.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet(urlPatterns = { "/account", "/account/signup", "/account/login", "/account/logout", "/account/save", "/account/register-confirmation" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String REGISTER_FORM = "/WEB-INF/views/account/register-form.jsp";
	private final String LOGIN_FORM = "/WEB-INF/views/account/login-form.jsp";
	private final String REGISTER_CONFIRMATION = "/WEB-INF/views/account/register-confirmation.jsp";
	private final String HOME_PAGE = "/Hotel-Reservation-JEE";
	private final String REGISTER_CONFIRMATION_PAGE = "/WEB-INF/views/account/register-confirmation";
	
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
		
		if (request.getRequestURI().endsWith("signup")) {
			System.out.println("Sign up -> " + dispatcher);
			dispatcher = request.getRequestDispatcher(REGISTER_FORM);
		}
		else if (request.getRequestURI().endsWith("login")) {
			System.out.println("Log in -> " + dispatcher);
			dispatcher = request.getRequestDispatcher(LOGIN_FORM);
		}
		else if (request.getRequestURI().endsWith("logout")) {
			HttpSession session = request.getSession();
			session.removeAttribute("user");
			response.sendRedirect(HOME_PAGE);
			
			return;
		}
		else if (request.getRequestURI().endsWith("register-confirmation")) {
			System.out.println("Register Confirmation -> " + dispatcher);
			dispatcher = request.getRequestDispatcher(REGISTER_CONFIRMATION);
		}
		else {
			System.out.println("User/* -> " + dispatcher);
			//dispatcher = request.getRequestDispatcher(REGISTER_CONFIRMATION);
			//response.sendRedirect(HOME_PAGE);
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = null;
		if (request.getParameter("loginAction").equalsIgnoreCase("loginAction")) {
			System.out.println("Login Action\n-------------------------------");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			System.out.println("Parameters User: " + username + " - " + password);
			user = dao.loginUser(username, password);
			
			/*
			 * If a user is found, we allocate them a session,
			 * then redirect them to home page.
			 * Else, we display an error message (see login jsp file)
			 */
			if (user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect(HOME_PAGE);
				
				return;
			}
			else {
				request.setAttribute("error", "Nom d'utilisateur ou mot de passe incorrect!");
			}
		}
		
		else {
			System.out.println("SignIn Action\n-----------------");
			user = new User();
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
			
			response.sendRedirect(REGISTER_CONFIRMATION_PAGE);
			
			return;
		}
	
		doGet(request, response);
	}

}
