package com.hotel.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.CategorieDaoImpl;
import com.hotel.dao.ChambreDaoImpl;
import com.hotel.models.Categorie;
import com.hotel.models.Chambre;

/**
 * Servlet implementation class ChambreController
 */
@WebServlet(urlPatterns = { "/chambres", "/chambres/details", "/chambres/new", "/chambres/save", "/chambres/edit",
"/chambres/delete" })
public class ChambreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String INDEX = "/WEB-INF/views/chambres/index.jsp";
	private final String DETAILS = "/WEB-INF/views/chambres/details.jsp";
	private final String FORM = "/WEB-INF/views/chambres/chambre-form.jsp";
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
			dispatcher = request.getRequestDispatcher(FORM);
		} 
		else if (request.getRequestURI().endsWith("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Chambre obj = dao.getById(id);
			request.setAttribute("chambre", obj);
			dispatcher = request.getRequestDispatcher(FORM);
		} 
		else if (request.getRequestURI().endsWith("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Chambre obj = dao.getById(id);
			dao.delete(obj);
			request.setAttribute("chambres", dao.getAll());
			dispatcher = request.getRequestDispatcher(INDEX);
		} 
		else if (request.getRequestURI().endsWith("details")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Chambre obj = dao.getById(id);
			System.out.println(obj);
			request.setAttribute("chambre", obj);
			dispatcher = request.getRequestDispatcher(DETAILS);
		} 
		else {
			request.setAttribute("chambres", dao.getAll());
			dispatcher = request.getRequestDispatcher(INDEX);
		}

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Chambre obj = new Chambre();
		
		System.out.println("Parameters:");
		System.out.println("Id:" + request.getParameter("id_categorie"));
		System.out.println("Balcon: " + request.getParameter("hasBalcon"));
		System.out.println("Cuisine: " + request.getParameter("hasCuisine"));
		System.out.println("Vue sur mer: " + request.getParameter("hasVue_sur_mer"));

		Categorie categorie = new CategorieDaoImpl().getById( 
				Integer.parseInt(request.getParameter("id_categorie"))
			);
		obj.setCategorie(categorie);
		
		obj.setHasBalcon(Boolean.parseBoolean(request.getParameter("hasBalcon")));
		obj.setHasCuisine(Boolean.parseBoolean(request.getParameter("hasCuisine")));
		obj.setHasVue_sur_mer(Boolean.parseBoolean(request.getParameter("hasVue_sur_mer")));
		obj.setImage_url(request.getParameter("image"));
		
		if (request.getParameter("id_categorie") == null || request.getParameter("id_categorie").isEmpty()) {
			dao.create(obj);
		} 
		else {
			int id = Integer.parseInt(request.getParameter("id_categorie"));
			obj.setId(id);
			dao.update(obj);
		}
		
		doGet(request, response);
	}

}
