<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Al Ribat Hotel</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Playfair+Display:ital,wght@0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
<link href="assets/vendor/aos/aos.css" rel="stylesheet">
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="assets/vendor/glightbox/css/glightbox.min.css"
	rel="stylesheet">
<link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	type="text/javascript"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
	type="text/javascript"></script>


<!-- =======================================================
  * Template Name: Restaurantly - v3.7.0
  * Template URL: https://bootstrapmade.com/restaurantly-restaurant-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->

<style type="text/css">
body {
	color: #000;
	overflow-x: hidden;
	height: 100%;
	background-image: url("https://i.imgur.com/GMmCQHC.png");
	background-repeat: no-repeat;
	background-size: 100% 100%
}

.card {
	padding: 30px 40px;
	margin-top: 60px;
	margin-bottom: 60px;
	border: none !important;
	box-shadow: 0 6px 12px 0 rgba(0, 0, 0, 0.2)
}

.blue-text {
	color: #00BCD4
}

.form-control-label {
	margin-bottom: 0
}

input, textarea, button {
	padding: 8px 15px;
	border-radius: 5px !important;
	margin: 5px 0px;
	box-sizing: border-box;
	border: 1px solid #ccc;
	font-size: 18px !important;
	font-weight: 300
}

input:focus, textarea:focus {
	-moz-box-shadow: none !important;
	-webkit-box-shadow: none !important;
	box-shadow: none !important;
	border: 1px solid #00BCD4;
	outline-width: 0;
	font-weight: 400
}

.btn-block {
	text-transform: uppercase;
	font-size: 15px !important;
	font-weight: 400;
	height: 43px;
	cursor: pointer
}

.btn-block:hover {
	color: #fff !important
}

button:focus {
	-moz-box-shadow: none !important;
	-webkit-box-shadow: none !important;
	box-shadow: none !important;
	outline-width: 0
}

label {
	display: block;
}
</style>
</head>

<body>
	<!-- ======= Book A Table Section ======= -->
	<section id="book-a-table" class="book-a-table">
		<div class="container" data-aos="fade-up">

			<div class="section-title">
				<h2>Bienvenue !</h2>
				<h4>S'enregistrer</h4>
			</div>

			<div class="container-fluid px-1 py-5 mx-auto">
				<div class="row d-flex justify-content-center">
					<div class="col-xl-7 col-lg-8 col-md-9 col-11 text-center">
						<div class="card">
							<form class="form-card" action="save" method="post">
								
								<div class="row justify-content-between text-left">
		
									<div class="form-group col-sm-6 flex-column d-flex">
										<label class="form-control-label px-3"> Nom </label> <input
											type="text" id="fname" name="nom" placeholder=""
											onblur="validate(1)">
									</div>
									
									<div class="form-group col-sm-6 flex-column d-flex">
										<label class="form-control-label px-3">Pseudonyme </label> <input
											type="text" id="fname" name="username" placeholder=""
											onblur="validate(1)">
									</div>
									
									<div class="form-group col-sm-6 flex-column d-flex">
										<label class="form-control-label px-3">Email</label> <input
											type="email" id="email" name="email" placeholder=""
											onblur="validate(3)">
									</div>
								</div>
								
								<div class="row justify-content-between text-left">
									<div class="form-group col-sm-6 flex-column d-flex">
										<label class="form-control-label px-3"> Age</label> <input
											type="number" id="mob" name="age" placeholder="Age"
											onblur="validate(4)">
									</div>
								</div>
								<div class="row justify-content-between text-left">
									<div class="form-group col-sm-6 flex-column d-flex">
										<label class="form-control-label px-3"> Password</label> <input
											type="password" id="mob" name="password" placeholder="Password"
											onblur="validate(4)">
									</div>
								</div>
								<div class="row justify-content-between text-left">
									<div class="form-group col-sm-6 flex-column d-flex">
										<label class="form-control-label px-3"> Telephone</label> <input
											type="text" id="mob" name="telephone" placeholder="Tel"
											onblur="validate(4)">
									</div>
								</div>
								
								<div class="row justify-content-between text-left">
									<div class="form-group col-sm-6 flex-column d-flex">
										<label class="form-control-label px-3">Sexe</label> 
										<select	class="form-control" name="sexe">
											<option value="m">Homme</option>
											<option value="s">Femme</option>
											<option value="b">Non binaire</option>
										</select>
									</div>
								</div>
								
								<div class="row justify-content-end">
									<div class="form-group col-sm-6">
										<button type="submit" class="btn-block btn-warning">Valider</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>

		</div>
	</section>
	<!-- End Book A Table Section -->
</body>
</html>
