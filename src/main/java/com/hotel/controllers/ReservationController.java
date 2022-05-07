package com.hotel.controllers;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotel.dao.CategorieDaoImpl;
import com.hotel.dao.ChambreDaoImpl;
import com.hotel.dao.ReservationDaoImpl;
import com.hotel.dao.UserDaoImpl;
import com.hotel.models.Categorie;
import com.hotel.models.Chambre;
import com.hotel.models.Reservation;
import com.hotel.models.User;

/**
 * Servlet implementation class ReservationController
 */
@WebServlet(urlPatterns = { "/reservations", "/reservations/new", "/reservations/save", "/reservations/edit",
"/reservations/delete" })
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String INDEX = "/WEB-INF/views/reservations/index.jsp";
	private final String FORM = "/WEB-INF/views/reservations/reservation-form.jsp";
	private final String DETAILS = "/WEB-INF/views/reservations/reservation-details.jsp";
	private ReservationDaoImpl dao;  
	
	private int id_chambre_global;
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationController() {
        super();
        dao = new ReservationDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		
		if (request.getRequestURI().endsWith("new")) {
			System.out.println("New => Id_cambre_global: " + id_chambre_global);
			id_chambre_global = Integer.parseInt(request.getParameter("id_chambre"));
			dispatcher = request.getRequestDispatcher(FORM);
		} 
		else if (request.getRequestURI().endsWith("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Reservation obj = dao.getById(id);
			request.setAttribute("reservation", obj);
			dispatcher = request.getRequestDispatcher(FORM);
		} 
		else if (request.getRequestURI().endsWith("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Reservation obj = dao.getById(id);
			dao.delete(obj);
			request.setAttribute("reservations", dao.getAll());
			dispatcher = request.getRequestDispatcher(INDEX);
		} 
		else if (request.getRequestURI().endsWith("details")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Reservation obj = dao.getById(id);
			System.out.println(obj);
			request.setAttribute("reservation", obj);
			dispatcher = request.getRequestDispatcher(DETAILS);
		} 
		else {
			request.setAttribute("reservations", dao.getAll());
			dispatcher = request.getRequestDispatcher(INDEX);
		}

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reservation obj = new Reservation();
		
		System.out.println("Id_Chambre: " + id_chambre_global);
		Chambre chambre = new ChambreDaoImpl().getById( 
				id_chambre_global
			);
		
		System.out.println(chambre);
		// Montant
		Categorie cat = new CategorieDaoImpl().getById(
				chambre.getCategorie().getId()
		);
		System.out.println(cat);
		double montant = cat.getTarif();
		
		/*
		User user = new UserDaoImpl().getById( 
				Integer.parseInt(request.getParameter("id_user"))
			);
		 */
		User user = new User();
		user.setId(1);
		user.setNom(request.getParameter("nom"));
		user.setEmail(request.getParameter("email"));
		user.setTelephone(request.getParameter("telephone"));
		
		new UserDaoImpl().saveUser(user);
		

		System.out.println("Parameters:");
		System.out.println("Id_chambre:" + id_chambre_global);
		System.out.println("Id_user:" + request.getParameter("id_user"));
		System.out.println("Date entrée: " + request.getParameter("date_entree"));
		System.out.println("Date réservation: " + request.getParameter("date_reservation"));
		System.out.println("Date Sortie: " + request.getParameter("date_sortie"));
		System.out.println("Montant: " + montant);
		System.out.println("# personnes:" + request.getParameter("nb_personnes"));
		System.out.println("Message:" + request.getParameter("message"));

		obj.setChambre(chambre);
		

		// Conversion des strings en dates
		LocalDate date_entree = LocalDate.parse(request.getParameter("date_entree"));
		Instant date_entreeParsed = date_entree.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		
		LocalDate date_sortie = LocalDate.parse(request.getParameter("date_sortie"));
		Instant date_sortieParsed = date_sortie.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		
		obj.setDateEntree(date_entreeParsed);
		obj.setDateSortie(date_sortieParsed);
		
		// Date du jour
		obj.setDateReservation(Instant.now());   
		
		obj.setMontant(montant);
		
		obj.setMessage(request.getParameter("message"));
		obj.setNb_personnes(Integer.parseInt(request.getParameter("nb_personnes")));
		
		obj.setUser(user);

		/*
		 * Si la chambre est libre, on crée la réservation
		 */
		if (chambre.isAvailable()) {
			obj.setActive(true);
	
			//Reservation obj
			System.out.println("Chambre libre => Réservation activatée");
			System.out.println(obj);
			
			dao.create(obj);
			/*
			if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
				dao.create(obj);
			} 
			else {
				int id = Integer.parseInt(request.getParameter("id"));
				obj.setId(id);
				dao.update(obj);
			}
			*/
			doGet(request, response);
		}
		else {
			System.out.println("Disponibilité de la chambre: " + chambre.isAvailable());
		}
	}

}
