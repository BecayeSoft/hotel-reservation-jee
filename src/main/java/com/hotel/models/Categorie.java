package com.hotel.models;

import com.sun.tools.javac.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, length = 150)
	String id;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
	private List<Chambre> chambres;

	String libelle;
	double tarif;
	String description;
	
	public Categorie() {}
	
	public Categorie(String idCategorie, String libelle, List<Chambre> chambres, double tarif, String description) {
		super();
		this.id = idCategorie;
		this.libelle = libelle;
		this.chambres = chambres;
		this.tarif = tarif;
		this.description = description;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public List<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(List<Chambre> chambres) {
		this.chambres = chambres;
	}
	
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
