package com.hotel.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 64)
	private int id;
	
	private String nom; 
	private String email; 
	private String telephone; 
	private String username;
	private String password;
	private int age;
	private char sexe; 
	private String privilege;
	
		
	public User() {}

	public User(int id, String nom, String email, String telephone, String username, String password,
			int age, char sexe, String privilege) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.telephone = telephone;
		this.username = username;
		this.password = password;
		this.age = age;
		this.sexe = sexe;
		this.privilege = privilege;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public char getSexe() {
		return sexe;
	}


	public void setSexe(char sexe) {
		this.sexe = sexe;
	}


	public String getPrivilege() {
		return privilege;
	}


	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
	
	
	// toString
	@Override
	public String toString() {
		return "---------------------------------\n"
				+ "User"
				+ "---------------------------------\n"
				+ "nom: " + this.nom
				+ "username: " + this.username
				+ "email: " + this.email
				+ "password: " + this.password
				+ "age: " + this.age
				+ "sexe: " + this.sexe
				+ "telephone: " + this.telephone
				+ "privilege: " + this.privilege
				;
	}

}
