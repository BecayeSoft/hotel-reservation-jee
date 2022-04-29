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
@WebServlet(urlPatterns = { "/users", "/users/new", "/users/save", "/users/edit",
"/users/delete" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String CATEGORIE_INDEX = "/WEB-INF/views/users/index.jsp";
	private final String CATEGORIE_FORM = "/WEB-INF/views/users/personne-form.jsp";
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
			dispatcher = request.getRequestDispatcher(CATEGORIE_FORM);
		} 
		else if (request.getRequestURI().endsWith("edit")) {
			String id = request.getParameter("id");
			User obj = dao.getById(id);
			request.setAttribute("personne", obj);
			dispatcher = request.getRequestDispatcher(CATEGORIE_FORM);
		} 
		else if (request.getRequestURI().endsWith("delete")) {
			String id = request.getParameter("id");
			User obj = dao.getById(id);
			dao.delete(obj);
			request.setAttribute("users", dao.getAll());
			dispatcher = request.getRequestDispatcher(CATEGORIE_INDEX);
		} 
		else {
			request.setAttribute("users", dao.getAll());
			dispatcher = request.getRequestDispatcher(CATEGORIE_INDEX);
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User obj = new User();
		/*
		obj.setDescription(request.getParameter("description"));
		obj.setLibelle(request.getParameter("libelle"));
		obj.setNb_chambres(Integer.valueOf(request.getParameter("nb_chambres")));
		obj.setTarif(Double.valueOf(request.getParameter("tarif")));
		*/

		if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
			dao.create(obj);
		} 
		else {
			String id = request.getParameter("id");
			obj.setId(id);
			dao.update(obj);
		}
		doGet(request, response);
	}

}
