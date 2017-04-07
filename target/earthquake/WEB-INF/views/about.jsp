<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="/WEB-INF/templates/header.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/templates/top.jsp"/>

	<div id="index-banner" class="parallax-container">
		<div class="section no-pad-bot">
			<div class="container">
				<br>
				<br> <br>
				<br>
			</div>
		</div>
		<div class="parallax">
			<img src="/earthquake/resources/img/background1.jpg" alt="woe">
		</div>
	</div>
	<br>
	<br>

	<div class="about-layout">
		<main class="main">
		<div class="container">
			<div class="section">
				<h5>Sobre a guild</h5>
			</div>
<!-- 			<div class="about-content card-panel col s12 m8 offset-m2"> -->
				<h1 class="header center text-lighten-2">${about.getTitulo()}</h1>
				<div class="center"><img src="http://orig04.deviantart.net/70a5/f/2012/121/7/d/nidoking_banner_by_rikkutakanashi-d4y71ut.jpg"></div>
				${about.getTexto()}
<!-- 			</div> -->
		</div>
		</main>
	</div>
	<br>
	<br>
	<div class="container">
		<div class="divider"></div>
		<div class="section">
			<h5>Staff</h5>
		</div>
		<div class="row">
			<div class="col s12 m2"></div>
			<div class="col s12 m2">
				<div class="card hoverable">
					<div class="card-image">
						<img
							src="http://i0.wp.com/ragnarokmania.com.br/wp-content/uploads/2016/06/Bardos-c%C3%B3pia.png?fit=147%2C116">
					</div>
					<div class="card-content center-align">
						<b class="center-align">Crizon</b>
					</div>
					<div class="card-action center-align">
						<i class="center-align"> gleader</i>
					</div>
				</div>
			</div>
			<div class="col s12 m2">
				<div class="card hoverable">
					<div class="card-image">
						<img
							src="http://i0.wp.com/ragnarokmania.com.br/wp-content/uploads/2016/06/Bardos-c%C3%B3pia.png?fit=147%2C116">
					</div>
					<div class="card-content center-align">
						<b>Lokier</b>
					</div>
					<div class="card-action center-align">
						<i>gleader</i>
					</div>
				</div>
			</div>
			<div class="col s12 m2">
				<div class="card hoverable">
					<div class="card-image">
						<img
							src="http://i0.wp.com/ragnarokmania.com.br/wp-content/uploads/2016/06/Bardos-c%C3%B3pia.png?fit=147%2C116">
					</div>
					<div class="card-content center-align">
						<b>Shyder</b>
					</div>
					<div class="card-action center-align">
						<i>gleader</i>
					</div>
				</div>
			</div>
			<div class="col s12 m2">
				<div class="card hoverable">
					<div class="card-image">
						<img
							src="http://i0.wp.com/ragnarokmania.com.br/wp-content/uploads/2016/06/Bardos-c%C3%B3pia.png?fit=147%2C116">
					</div>
					<div class="card-content center-align">
						<b>Lipe</b>
					</div>
					<div class="card-action center-align">
						<i>staff</i>
					</div>
				</div>
			</div>
			<div class="col s12 m2"></div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/templates/footer.jsp" />

	<jsp:include page="/WEB-INF/templates/includes.jsp" />

</body>
</html>
