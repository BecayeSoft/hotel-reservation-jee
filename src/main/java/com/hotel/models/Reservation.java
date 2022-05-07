package com.hotel.models;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Reservation {
	// @Column(nullable = false, length = 150)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 64)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_chambre")
	Chambre chambre;

	@ManyToOne
	@JoinColumn(name = "id_user")
	User user;

	Instant dateReservation;
	Instant dateEntree;
	Instant dateSortie;
	boolean isActive;
	double montant;

	int nb_personnes;
	String message;

	public Reservation() {
	}

	public Reservation(int id, Chambre chambre, User user, Instant dateReservation, Instant dateEntree,
			Instant dateSortie, boolean isActive, double montant, int nb_personnes, String message) {
		super();
		this.id = id;
		this.chambre = chambre;
		this.user = user;
		this.dateReservation = dateReservation;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.isActive = isActive;
		this.montant = montant;
		this.nb_personnes = nb_personnes;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Instant getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Instant dateReservation) {
		this.dateReservation = dateReservation;
	}

	public Instant getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Instant dateEntree) {
		this.dateEntree = dateEntree;
	}

	public Instant getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Instant dateSortie) {
		this.dateSortie = dateSortie;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public int getNb_personnes() {
		return nb_personnes;
	}

	public void setNb_personnes(int nb_personnes) {
		this.nb_personnes = nb_personnes;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

	// toString
	
	@Override
	public String toString() {
		return "\n-----------------\nRéservation\n-----------------" 
				+ "id: " + this.id 
				+ "\nChambre: " + this.chambre
				+ "\nuser: " + this.user
				+ "\ndateEntree: " + this.dateEntree
				+ "\ndateReservation: " + this.dateReservation
				+ "\ndateSortie: " + this.dateSortie
				+ "\nisActive: " + this.isActive
				+ "\nmontant: " + this.montant
				+ "\nnb_personnes: " + this.nb_personnes
				+ "\nmessage: " + this.message
				;
	}
	
}
