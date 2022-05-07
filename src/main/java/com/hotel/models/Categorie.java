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

	private String libelle;
	private double tarif;
	private String description;
	private String image_url;
	

	public Categorie() {}
	
	public Categorie(int idCategorie, String libelle, Collection<Chambre> chambres, double tarif, String description, String image_url) {
		super();
		this.id = idCategorie;
		this.libelle = libelle;
		this.chambres = chambres;
		this.tarif = tarif;
		this.description = description;
		this.image_url = image_url;
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
	
	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	@Override
	public String toString() {
		return "\n-----------------\nCategorie\n-----------------"
				+ "\nid: " + this.id
				+ "\nchambres: " + this.chambres
				+ "\nlibellé: " + this.libelle
				+ "\ndescription: " + this.description
				+ "\ntarif: " + this.tarif
				+ "\nimage: " + this.image_url
				;
	}
}
