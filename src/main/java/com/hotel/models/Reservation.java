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
	//@Column(nullable = false, length = 150)
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
	
	
	public Reservation() {}


	public Reservation(int id, Chambre chambre, User user, Instant dateReservation, Instant dateEntree,
			Instant dateSortie, boolean isActive, double montant) {
		super();
		this.id = id;
		this.chambre = chambre;
		this.user = user;
		this.dateReservation = dateReservation;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.isActive = isActive;
		this.montant = montant;
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
	
	
}
