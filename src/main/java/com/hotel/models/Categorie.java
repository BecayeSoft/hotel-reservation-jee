package com.hotel.models;

import java.util.Collection;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 64)
	private int id;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
	private Collection<Chambre> chambres;
	
	/*
	@OneToMany(cascade = CascadeType.ALL, mappedBy="categorie")
	public Set<Order> getChambres() { return chambres; }
	
	@JoinColumnn(name="id_categorie", nullable=false)
	public Categorie getCategorie() { return categorie; }
	*/

	/*
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
	private Collection<Chambre> chambres;
	*/

	String libelle;
	
	double tarif;
	
	String description;
	
	public Categorie() {}
	
	public Categorie(int idCategorie, String libelle, Collection<Chambre> chambres, double tarif, String description) {
		super();
		this.id = idCategorie;
		this.libelle = libelle;
		this.chambres = chambres;
		this.tarif = tarif;
		this.description = description;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public Collection<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(Collection<Chambre> chambres) {
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
