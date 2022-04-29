package com.hotel.models;

import com.sun.tools.javac.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Chambre {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, length = 150)
	private String id;

	@ManyToOne(optional = false)
	@Column(nullable = false, length = 150)
	@JoinColumn(name = "categorie", referencedColumnName = "id_categorie")
	private Categorie categorie;
	
	/*
	@ManyToOne
	@JoinColumn(name = "id")
	private Categorie categorie;
	*/
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Reservation> reservations;
	
	private String idCategorie;
	
	private int num_etage;
	private int num_batiment;

	private boolean isAvailable;
	private boolean hasBalcon;
	private boolean hasVue_sur_mer;
	private boolean hasSalle_sejour;
	private boolean hasCuisine;
	
	
	public Chambre() {}
	
	public Chambre(String idChambre, int num_etage, int num_batiment, String idCategorie) {
		super();
		this.id = idChambre;
		this.num_etage = num_etage;
		this.num_batiment = num_batiment;
		this.idCategorie = idCategorie;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public int getNum_etage() {
		return num_etage;
	}
	public void setNum_etage(int num_etage) {
		this.num_etage = num_etage;
	}
	
	public int getNum_batiment() {
		return num_batiment;
	}
	public void setNum_batiment(int num_batiment) {
		this.num_batiment = num_batiment;
	}

	public String getCategorie() {
		return idCategorie;
	}
	public void setCategorie(String idCategorie) {
		this.idCategorie = idCategorie;
	}
	
	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public boolean isHasBalcon() {
		return hasBalcon;
	}

	public void setHasBalcon(boolean hasBalcon) {
		this.hasBalcon = hasBalcon;
	}

	public boolean isHasVue_sur_mer() {
		return hasVue_sur_mer;
	}

	public void setHasVue_sur_mer(boolean hasVue_sur_mer) {
		this.hasVue_sur_mer = hasVue_sur_mer;
	}

	public boolean isHasSalle_sejour() {
		return hasSalle_sejour;
	}

	public void setHasSalle_sejour(boolean hasSalle_sejour) {
		this.hasSalle_sejour = hasSalle_sejour;
	}

	public boolean isHasCuisine() {
		return hasCuisine;
	}

	public void setHasCuisine(boolean hasCuisine) {
		this.hasCuisine = hasCuisine;
	}
}
