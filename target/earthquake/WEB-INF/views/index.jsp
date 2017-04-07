<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/WEB-INF/templates/header.jsp"/>
</head>
<body>

	<jsp:include page="/WEB-INF/templates/top.jsp"/>

	<div id="index-banner" class="parallax-container">
		<div class="section no-pad-bot">
			<div class="container">
				<br>
				<br>
				<h1 class="header center pink-text text-lighten-2 shadow">EARTHQUAKE</h1>
				<div class="row center">
					<h5 class="header col s12 pink-text shadow">OLD SCHOOL RAGNAROK GUILD</h5>
				</div>
				<br>
				<br>
			</div>
		</div>
		<div class="parallax">
			<img class="blur" src="/earthquake/resources/img/background1.jpg" alt="woe">
		</div>
	</div>

	<div class="container">
		<div class="section">

			<!--   Icon Section   -->
			<div class="row">
				<c:forEach items="${intros}" var="intro">
					<c:if test="${intro.getPosition() == 1}">
						<div class="col s12 m4">
							<div class="icon-block">
								<h2 class="center pink-text">
									<i class="material-icons">${intro.getIcon()}</i>
								</h2>
								<h5 class="center">${intro.getTitulo() }</h5>
		
								<p class="light">${intro.getTexto()}</p>
							</div>
						</div>
					</c:if>
				</c:forEach>
			</div>

		</div>
	</div>

	<div class="parallax-container valign-wrapper">
		<div class="parallax">
			<img class="blur" src="/earthquake/resources/img/background2.jpg" alt="pvm">
		</div>
	</div>

	<div class="container">
		<div class="section">

			<div class="row">
				<div class="col s12 center">
					<c:forEach items="${intros}" var="intro">
						<c:if test="${intro.getPosition() == 2}">
							<h3>
								<i class="mdi-content-send brown-text">${intro.getTitulo()}</i>
							</h3>
							<p class="left-align light">${intro.getTexto()}</p>
						</c:if>
					</c:forEach>
				</div>
			</div>

		</div>
	</div>

	<div class="parallax-container valign-wrapper">

		<div class="parallax">
			<img class="blur" src="/earthquake/resources/img/background3.jpg" alt="pvm"
				class="">
		</div>
	</div>

	<jsp:include page="/WEB-INF/templates/footer.jsp" />

	<jsp:include page="/WEB-INF/templates/includes.jsp" />
	<script type="text/javascript">
		$(document).ready(function() {
			$(".button-collapse").sideNav();
			$('.parallax').parallax();
		});
	</script>
</body>
</html>
