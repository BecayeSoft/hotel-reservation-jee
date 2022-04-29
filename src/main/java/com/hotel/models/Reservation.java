package com.hotel.models;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, length = 150)
	String id;
	
	
	//@ManyToOne
	//@JoinColumn(name = "id", referencedColumnName = "ID")
	Chambre chambre;
	
	//@OneToOne
	//@JoinColumn(name = "id", referencedColumnName = "ID")
	User user;
	
	Instant dateReservation;
	Instant dateEntree;
	Instant dateSortie;
	boolean isActive;
	double montant;
	
	
	public Reservation() {}
	
	public Reservation(String idReservation, Chambre chambre, Instant dateReservation, Instant dateEntree,
			Instant dateSortie, boolean isActive, User user, double montant) {
		super();
		this.id = idReservation;
		//this.chambre = chambre;
		this.dateReservation = dateReservation;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
		this.isActive = isActive;
		this.user = user;
		this.montant = montant;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
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
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	
}
