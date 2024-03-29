<%@page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<section id="events" class="events">
		<div class="container" data-aos="">

			<div class="section-title">
				<h2>Catégories</h2>
				<p>Jetez un coup d'oeil à nos catégories</p>
			</div>

			<div class="events-slider swiper" data-aos="" data-aos-delay="100">
				<div class="swiper-wrapper">

					<!-- Categorie item -->
					<div class="swiper-slide">
						<!-- Categorie item -->
						<c:forEach var="c" items="${categories}">
							<div class="row event-item" style="margin-bottom: 5rem;">
								<div class="col-lg-6">
									<img
										src="${ c.image_url }"
										class="img-fluid" alt="">
								</div>
								<div class="col-lg-6 pt-4 pt-lg-0 content">
									<h3>${c.libelle}</h3>
									<div class="price">
										<p>
											<span>${c.tarif} dirhams</span>
										</p>
									</div>
									<p class="fst-italic">${c.description}</p>

									<ul>
										<li><a class="btn btn-danger btn-xs"
											href="/Hotel-Reservation-JEE/categories/chambres?id=${c.id}">Voir les chambres<i
												class="bi bi-check-circled"></i>
										</a></li>
									</ul>
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