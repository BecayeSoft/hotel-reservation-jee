<%@page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- Bootstrap  -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<div class="container w-25">
		<h1 class="text-primary">Connectez-vous</h1>
		<h4>Authentifiez vous pour accéder à cette page</h4>
		<form action="" method="post">
			<c:set var="error" value="${error}" scope="page" />
			<input type="hidden" name="loginAction" value="loginAction">
	
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Nom d'utilisateur</label> 
				<input type="text" name="username" class="form-control" id="exampleInputEmail1" required>
				<div class="invalid-feedback">Le nom d'utilisateur est invalide.</div>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Mot de passe</label> 
				<input type="password" name="password" class="form-control" id="exampleInputPassword1" required>
				<div class="invalid-feedback">Le mot de passe est invalide.</div>
				<div id="emailHelp" class="form-text">Votre mot de passe ne	sera partagé qu'avec vos voisins</div>
			</div>
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">J'accepte
					la politique de confidentialité</label>
			</div>
			<p class="text-danger" >${error}</p>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>