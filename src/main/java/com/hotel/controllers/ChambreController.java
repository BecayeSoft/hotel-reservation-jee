package com.hotel.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.ChambreDaoImpl;
import com.hotel.models.Chambre;

/**
 * Servlet implementation class ChambreController
 */
@WebServlet(urlPatterns = { "/chambres", "/chambres/new", "/chambres/save", "/chambres/edit",
"/chambres/delete" })
public class ChambreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String CATEGORIE_INDEX = "/WEB-INF/views/chambres/index.jsp";
	private final String CATEGORIE_FORM = "/WEB-INF/views/chambres/chambre-form.jsp";
	private ChambreDaoImpl dao;  
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ChambreController() {
        super();
        dao = new ChambreDaoImpl();
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
			Chambre obj = dao.getById(id);
			request.setAttribute("chambre", obj);
			dispatcher = request.getRequestDispatcher(CATEGORIE_FORM);
		} 
		else if (request.getRequestURI().endsWith("delete")) {
			String id = request.getParameter("id");
			Chambre obj = dao.getById(id);
			dao.delete(obj);
			request.setAttribute("chambres", dao.getAll());
			dispatcher = request.getRequestDispatcher(CATEGORIE_INDEX);
		} 
		else {
			request.setAttribute("chambres", dao.getAll());
			dispatcher = request.getRequestDispatcher(CATEGORIE_INDEX);
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Chambre obj = new Chambre();
		obj.setAvailable(Boolean.valueOf(request.getParameter("isAvailable")));
		
		obj.setCategorie(request.getParameter("id_categorie"));
		
		obj.setNum_batiment(Integer.valueOf(request.getParameter("num_batiment")));
		obj.setNum_etage(Integer.valueOf(request.getParameter("num_etage")));
		

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
