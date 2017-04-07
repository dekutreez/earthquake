<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/WEB-INF/templates/header.jsp" />
</head>
<body>
	<jsp:include page="/WEB-INF/templates/top.jsp" />

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

	
	<div class="container">
		<c:if test="">
			<div class="section">
				<h5>Vídeos atuais</h5>
				<p>Disponível em breve!</p>
			</div>
		</c:if>
		<c:choose>
			<c:when test="${videosNew != null && videosNew.size() > 0 }">
				<div class="section">
					<h5>Vídeos atuais</h5>
					<div class="row">
						<c:forEach items="${videosNew}" var="video">
							<div class="col s12 m4">
								<div class="card">
									<div class="card-image waves-effect waves-block waves-light">
										<iframe width="360" height="270"
											src="${video.getEmbedLink()}"> </iframe>
									</div>
									<div class="card-content">
										<span class="card-title activator grey-text text-darken-4">Descrição<i
											class="material-icons right">more_vert</i></span>
									</div>
									<div class="card-reveal">
										<span class="card-title grey-text text-darken-4">${video.getTitulo()}<i
											class="material-icons right">close</i></span>
										<p>${video.getDescricao()}</p>
										<ul>
											<li>Servidor: <strong>${video.getServer()} </strong>
											</li>
											<li>Data: <strong>${video.getMesNome()} ${video.getAno()} </strong>
											</li>
											<li>Player - Role: <strong>${video.getNomePlayer()} - ${video.getJobPlayer()} </strong>
											</li>
										</ul>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</c:when>
			<c:when test="${videosNew == null || videosNew.size() == 0 }">
				<div class="section">
					<h5>Vídeos atuais</h5>
					<p>Disponível em breve!</p>
				</div>
			</c:when>
		</c:choose>

		<c:if test="${videosOld != null && videosOld.size() > 0 }">
			<div class="section">
				<h5>Vídeos antigos</h5>
				<div class="row">
					<c:forEach items="${videosOld}" var="video">
						<div class="col s12 m4">
							<div class="card">
								<div class="card-image waves-effect waves-block waves-light">
									<iframe width="360" height="270"
										src="${video.getEmbedLink()}"> </iframe>
								</div>
								<div class="card-content">
									<span class="card-title activator grey-text text-darken-4">Descrição<i
										class="material-icons right">more_vert</i></span>
								</div>
								<div class="card-reveal">
									<span class="card-title grey-text text-darken-4">${video.getTitulo()}<i
										class="material-icons right">close</i></span>
									<p>${video.getDescricao()}</p>
									<ul>
										<li>Servidor: <strong>${video.getServer()} </strong>
										</li>
										<li>Data: <strong>${video.getMesNome()} ${video.getAno()} </strong>
										</li>
										<li>Player - Role: <strong>${video.getNomePlayer()} - ${video.getJobPlayer()} </strong>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</c:if>
		
	</div>

	<jsp:include page="/WEB-INF/templates/footer.jsp" />

	<jsp:include page="/WEB-INF/templates/includes.jsp" />
</body>
</html>

</html>