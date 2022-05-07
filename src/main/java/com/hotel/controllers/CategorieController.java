package com.hotel.controllers;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class CategorieController
 */
@WebServlet(urlPatterns = { "/categories", "/categories/new", "/categories/save", "/categories/edit",
"/categories/delete", "/categories/chambres" })
public class CategorieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String CATEGORIE_INDEX = "/WEB-INF/views/categories/index.jsp";
	private final String CATEGORIE_FORM = "/WEB-INF/views/categories/categorie-form.jsp";
	private final String CHAMBRE_LIST = "/WEB-INF/views/categories/chambres-list.jsp";
	private CategorieDaoImpl dao;  
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public CategorieController() {
        super();
        dao = new CategorieDaoImpl();
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
			int id = Integer.parseInt(request.getParameter("id"));
			Categorie obj = dao.getById(id);
			request.setAttribute("categorie", obj);
			dispatcher = request.getRequestDispatcher(CATEGORIE_FORM);
		} 
		else if (request.getRequestURI().endsWith("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Categorie obj = dao.getById(id);
			dao.delete(obj);
			request.setAttribute("categories", dao.getAll());
			dispatcher = request.getRequestDispatcher(CATEGORIE_INDEX);
		} 
		else if (request.getRequestURI().endsWith("chambres")) {
			int id = Integer.parseInt(request.getParameter("id"));
			List<Chambre> chambres = new ChambreDaoImpl().getByCategory(id);
			
			System.out.println("\n-----------------"
								+ "First chambre => Categorie"
								+ "\n-----------------");
			System.out.println(chambres.get(0).getCategorie().getDescription());
			
			request.setAttribute("chambres", chambres);
			dispatcher = request.getRequestDispatcher(CHAMBRE_LIST);
		} 
		else {
			request.setAttribute("categories", dao.getAll());
			dispatcher = request.getRequestDispatcher(CATEGORIE_INDEX);
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Categorie obj = new Categorie();
		obj.setDescription(request.getParameter("description"));
		obj.setLibelle(request.getParameter("libelle"));
		//obj.setChambres(Integer.valueOf(request.getParameter("nb_chambres")));
		obj.setTarif(Double.valueOf(request.getParameter("tarif")));
		obj.setImage_url(request.getParameter("image"));

		System.out.println(obj);
		
		if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
			dao.create(obj);
		} 
		else {
			int id = Integer.parseInt(request.getParameter("id"));
			obj.setId(id);
			dao.update(obj);
		}
		doGet(request, response);
		
	}

}
