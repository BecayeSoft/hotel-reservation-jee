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
	@OneToMany
	@JoinColumn(name = "id")
	private List<Reservation> reservations;
	*/

	private boolean isAvailable = true;
	private boolean hasBalcon;
	private boolean hasCuisine;
	private boolean hasVue_sur_mer;
	private String image_url;
	
	
	public Chambre() {}
	
	
	public Chambre(int id, Categorie categorie, boolean isAvailable, boolean hasBalcon, boolean hasCuisine,
			boolean hasVue_sur_mer, String image_url) {
		super();
		this.id = id;
		this.categorie = categorie;
		this.isAvailable = isAvailable;
		this.hasBalcon = hasBalcon;
		this.hasCuisine = hasCuisine;
		this.hasVue_sur_mer = hasVue_sur_mer;
		this.image_url = image_url;
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

	public boolean isHasBalcon() {
		return hasBalcon;
	}

	public void setHasBalcon(boolean hasBalcon) {
		this.hasBalcon = hasBalcon;
	}

	public boolean isHasCuisine() {
		return hasCuisine;
	}

	public void setHasCuisine(boolean hasCuisine) {
		this.hasCuisine = hasCuisine;
	}

	public boolean isHasVue_sur_mer() {
		return hasVue_sur_mer;
	}

	public void setHasVue_sur_mer(boolean hasVue_sur_mer) {
		this.hasVue_sur_mer = hasVue_sur_mer;
	}
	
	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}


	// toString
	@Override
	public String toString() {
		return "\n-----------------\nChambre\n-----------------"
				+"id: " + this.id 
				+ "\nCategorie: " + this.categorie 
				+ "\nhasBalcon: " + this.hasBalcon 
				+ "\nhasCuisine: " + this.hasCuisine 
				+ "\nhasVue_sur_mer: " + this.hasVue_sur_mer 
				+ "\nisAvailable: " + this.isAvailable
				+ "\nimage_url: " + this.image_url
				;
	}
	
}
