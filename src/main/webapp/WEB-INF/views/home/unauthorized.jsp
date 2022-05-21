<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
main {
	width: 70%;
	margin: auto;
}

section {
	display: flex;
}

img {
	width: 400px;
	height: 400px;
}
button {
background: teal;
    color: white;
    height: 50px;
    width: 200px;
    border: none;
    border-radius: 10px;
    box-shadow: 2px 1px 14px teal;
}
a {
	color: white;
}
</style>
</head>
<body>
	<main>
		<h1>403 - Non Authorisé</h1>
		<section class="section--image">
		<div>
			<img src="https://vetri-suriya.web.app/devchallenges/404-not-found/Scarecrow.png" alt="">
		</div>
		<div class="section--content">
			<h2>Terrible news /!\</h2>
			<p>Nous avons de très mauvaises nouvelles pour vous, vous n'avez pas accès à cette page.</p>
			<button>
				<a href="/Hotel-Reservation-JEE">Revenir à l'accueil</a>
			</button>
		</div>
		</section>
	</main>
	

</body>
</html>