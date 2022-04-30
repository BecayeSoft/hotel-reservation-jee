package com.hotel.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Chambre {
	//@Column(nullable = false, length = 150)
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 64)
	private int id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_categorie")
	private Categorie categorie;
	
	/*
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_categorie")
	private Categorie categorie;
	*/
	
	/*
	@OneToMany
	@JoinColumn(name = "id")
	private List<Reservation> reservations;
	*/

	private boolean isAvailable;
	private boolean hasBalcon;
	private boolean hasCuisine;
	
	public Chambre() {}
	
	public Chambre(int id, Categorie categorie, boolean isAvailable, boolean hasBalcon, boolean hasCuisine) {
		super();
		this.id = id;
		this.categorie = categorie;
		this.isAvailable = isAvailable;
		this.hasBalcon = hasBalcon;
		this.hasCuisine = hasCuisine;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public boolean hasBalcon() {
		return hasBalcon;
	}
	public void hasBalcon(boolean hasBalcon) {
		this.hasBalcon = hasBalcon;
	}
	public boolean hasCuisine() {
		return hasCuisine;
	}
	public void hasCuisine(boolean hasCuisine) {
		this.hasCuisine = hasCuisine;
	}
	
}
