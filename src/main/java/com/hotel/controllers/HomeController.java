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

/**
 * Servlet implementation class HomeController
 */
@WebServlet(urlPatterns = {""})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String INDEX = "/WEB-INF/views/home/index.jsp";
	private CategorieDaoImpl daoCategorie;  
	private ChambreDaoImpl daoChambre;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        
        System.out.println("Home controller here");
        
        daoCategorie = new CategorieDaoImpl();
        daoChambre = new ChambreDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		
		request.setAttribute("categories", daoCategorie.getAll());
		request.setAttribute("chambres", daoChambre.getAll());
		
		dispatcher = request.getRequestDispatcher(INDEX);
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
