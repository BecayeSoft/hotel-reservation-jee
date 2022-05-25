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
import javax.servlet.http.HttpSession;

import com.hotel.dao.CategorieDaoImpl;
import com.hotel.dao.ChambreDaoImpl;
import com.hotel.dao.ReservationDaoImpl;
import com.hotel.models.Categorie;
import com.hotel.models.Chambre;
import com.hotel.models.Reservation;
import com.hotel.models.User;

/**
 * Servlet implementation class ReservationController
 */
@WebServlet(urlPatterns = { "/reservations", "/reservations/details", "/reservations/new", "/reservations/save", "/reservations/edit",
"/reservations/delete" })
public class ReservationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String INDEX = "/WEB-INF/views/reservations/index.jsp";
	private final String FORM = "/WEB-INF/views/reservations/reservation-form.jsp";
	private final String DETAILS = "/WEB-INF/views/reservations/details.jsp";
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
		
		// Get the user
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		request.setAttribute("user", user);
		
		
		if (request.getRequestURI().endsWith("new")) {
			System.out.println("New => Id_cambre_global: " + id_chambre_global);
			
			if (request.getParameter("id_chambre") == null) {
				System.err.print("L'ID de la chambre n'a pas été envoyé en paramètre -> ReservationController.doGet() : at line 56");
			}
			else {
				id_chambre_global = Integer.parseInt(request.getParameter("id_chambre"));
			}
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
			System.out.println("Détails");
			int id = Integer.parseInt(request.getParameter("id"));
			Reservation obj = dao.getById(id);
			System.out.println(obj);
			
			Chambre c = obj.getChambre();
			System.out.println(c);
			
			User u = obj.getUser();
			if (u.getSexe() == 'f') {
				request.setAttribute("isFemale", true);
			}
			else {				
				request.setAttribute("isFemale", false);
			}
			
			System.out.println(obj.getUser());
			
			request.setAttribute("reservation", obj);
			dispatcher = request.getRequestDispatcher(DETAILS);
		} 
		else {
			if (user.getPrivilege().equalsIgnoreCase("admin")) {	
				System.out.println("All Reservations");
				request.setAttribute("reservations", dao.getAll());
			}
			else {
				System.out.println("Reservations by user");
				request.setAttribute("reservations", dao.getByUser(user.getId()));
			}
			
			dispatcher = request.getRequestDispatcher(INDEX);
		}

		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reservation obj = new Reservation();
		
		// Chambre
		System.out.println("Id_Chambre: " + id_chambre_global);
		Chambre chambre = new ChambreDaoImpl().getById( 
				id_chambre_global
			);
		System.out.println(chambre);
		obj.setChambre(chambre);
		
		// Montant
		Categorie cat = new CategorieDaoImpl().getById(
				chambre.getCategorie().getId()
		);
		System.out.println(cat);
		double montant = cat.getTarif();
		
		// User
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		obj.setUser(user);

		// Debugging
		System.out.println("Parameters:");
		System.out.println("Id_chambre:" + id_chambre_global);
		System.out.println("Id_user:" + request.getParameter("id_user"));
		System.out.println("Date entrée: " + request.getParameter("date_entree"));
		System.out.println("Date réservation: " + request.getParameter("date_reservation"));
		System.out.println("Date Sortie: " + request.getParameter("date_sortie"));
		System.out.println("Montant: " + montant);
		System.out.println("# personnes:" + request.getParameter("nb_personnes"));
		System.out.println("Message:" + request.getParameter("message"));

		

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
		 * If entry date is greater or equal exit day
		 * AND entry date is greater or equal reservation day,
		 * we confirm
		 * Else, we display an error message (see jsp file)
		 */
		if (date_entreeParsed.isBefore(date_sortieParsed) && date_entreeParsed.isAfter(Instant.now())) {
			obj.setActive(true);
			
			System.out.println("DateEntree=>" + date_entreeParsed);
			System.out.println("DateSortie=>" + date_sortieParsed);
			System.out.println("DataEntre - before - DateSortie =>" + date_entreeParsed.isBefore(date_sortieParsed));
			System.out.println("DataEntre - before - DateSortie =>" + date_entreeParsed.isAfter(Instant.now()));
			
			//Reservation obj
			System.out.println("Chambre libre => Réservation activatée");	// Activatée WTF Hahhaha
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
		else {
			System.out.println("error");
			request.setAttribute("error", "Date d'entrée ou date de sortie incorrecte!");
		}

		/*
		 * Si la chambre est libre, on crée la réservation
		 */
//		if (chambre.isAvailable()) {
//			obj.setActive(true);
//	
//			//Reservation obj
//			System.out.println("Chambre libre => Réservation activatée");	// Activatée WTF Hahhaha
//			System.out.println(obj);
//			
//
//			if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
//				dao.create(obj);
//			} 
//			else {
//				int id = Integer.parseInt(request.getParameter("id"));
//				obj.setId(id);
//				dao.update(obj);
//			}
//
//			doGet(request, response);
//		}
//		else {
//			System.out.println("Disponibilité de la chambre: " + chambre.isAvailable());
//		}
	}

}
