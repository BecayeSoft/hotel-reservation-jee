<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Espace Administateur</title>
</head>
<body>
	<div class="container" style="width:50%;">
		<h1>Espace Administrateur</h1>
		<br>
		<h4>------------------------------------------------------------------</h4>
		<h4>Réservations</h4>
		<div>
		  <a href="/Hotel-Reservation-JEE/reservations" class="list-group-item list-group-item-action disabled">Voir la liste</a>
		  <a href="/Hotel-Reservation-JEE/reservations/new" class="list-group-item list-group-item-action">Ajouter</a>
		  <a href="/Hotel-Reservation-JEE/reservations/edit" class="list-group-item list-group-item-action">Modifier</a>
		  <a href="/Hotel-Reservation-JEE/reservations/delete" class="list-group-item list-group-item-action">Supprimer</a>
		</div>
		<br>
		<h4>------------------------------------------------------------------</h4>
		<h4>Chambres</h4>
		<div>
		  <a href="/Hotel-Reservation-JEE/chambres" class="list-group-item list-group-item-action disabled">Voir la liste</a>
		  <a href="/Hotel-Reservation-JEE/chambres/new" class="list-group-item list-group-item-action">Ajouter</a>
		  <a href="/Hotel-Reservation-JEE/chambres/edit" class="list-group-item list-group-item-action">Modifier</a>
		  <a href="/Hotel-Reservation-JEE/chambres/delete" class="list-group-item list-group-item-action">Supprimer</a>
		</div>
		<h4>------------------------------------------------------------------</h4>
		<h4>Catégories</h4>
		<div>
		  <a href="/Hotel-Reservation-JEE/categories" class="list-group-item list-group-item-action disabled">Voir la liste</a>
		  <a href="/Hotel-Reservation-JEE/categories/new" class="list-group-item list-group-item-action">Ajouter</a>
		  <a href="/Hotel-Reservation-JEE/categories/edit" class="list-group-item list-group-item-action">Modifier</a>
		  <a href="/Hotel-Reservation-JEE/categories/delete" class="list-group-item list-group-item-action">Supprimer</a>
		</div>
		
	</div>
</body>
</html>