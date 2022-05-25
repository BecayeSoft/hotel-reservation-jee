<%@page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
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

<!-- =======================================================
  * Template Name: Restaurantly - v3.7.0
  * Template URL: https://bootstrapmade.com/restaurantly-restaurant-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>
<body>
	<!-- ======= Events Section ======= -->
	<section style="width: 80%; margin: auto;" id="events" class="events">
		<div class="container" data-aos="">

			<div class="section-title">
				<h2>Liste des réservations</h2>
				<p>Réservations effectuées</p>
			</div>

			<div class="events-slider swiper" data-aos="" data-aos-delay="100">
				<div class="swiper-wrapper">

					<!-- Categorie item -->
					<div class="swiper-slide">
						<!-- Categorie item -->
						<c:forEach var="r" items="${reservations}">
							<div class="row event-item"
								style="margin-bottom: 5rem; display: flex;">
								<div style="flex-basis:50%" class="col-lg-6">
									<img style="width: 90%;" src="${r.chambre.image_url}"
										class="img-fluid" alt="">
								</div>
								<div class="col-lg-6 pt-4 pt-lg-0 content">
									<h3>Réservation</h3>
									<div class="price">
										<p>
											<span>${r.montant} dirhams</span>
										</p>
									</div>
									<p class="fst-italic">${chambre.categorie.description}</p>

									<ul>
										<li>Effectuée le:
											<fmt:parseDate  value="${r.dateReservation}"  type="date" pattern="yyyy-MM-dd" var="parsedDate" />
											<fmt:formatDate value="${parsedDate}" type="date" pattern="dd/MM/yyyy à hh:mm" var="formarttedDate" />
											<c:out value="${ formarttedDate }"></c:out>
										</li>
										<li>Date d'entrée:
											<fmt:parseDate  value="${r.dateEntree}"  type="date" pattern="yyyy-MM-dd" var="parsedDate" />
											<fmt:formatDate value="${parsedDate}" type="date" pattern="dd/MM/yyyy" var="formarttedDate" />
											<c:out value="${ formarttedDate }"></c:out>
										</li>
										<li>Effectuée le:
											<fmt:parseDate  value="${r.dateSortie}"  type="date" pattern="yyyy-MM-dd" var="parsedDate" />
											<fmt:formatDate value="${parsedDate}" type="date" pattern="dd/MM/yyyy" var="formarttedDate" />
											<c:out value="${ formarttedDate }"></c:out>
										</li>
									</ul>

									<div>
										<a class="btn btn-danger btn-xs"
											href="/Hotel-Reservation-JEE/reservations/details?id=${r.id}"> <i
											class="bi bi-check-circled">Détails</i>
										</a>
										<a class="btn btn-danger btn-xs"
											href="/Hotel-Reservation-JEE/reservations/edit?id=${r.id}"> <i
											class="bi bi-check-circled">Modifier</i>
										</a>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<!-- End testimonial item -->

				</div>
				<div class="swiper-pagination"></div>
			</div>

		</div>
	</section>
	<!-- End Events Section -->

</body>
</html>