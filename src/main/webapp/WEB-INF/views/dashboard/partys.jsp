<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/WEB-INF/templates/header.jsp" />
</head>
<body>

	<jsp:include page="/WEB-INF/templates/dashboard/menu_lateral.jsp"/>

	<jsp:include page="/WEB-INF/templates/dashboard/menu_top.jsp"/>
	
	<div class="container">
	
		<c:set var="last" scope="page" value="${0}"/>
		<c:forEach items="${partys}" varStatus="loop" step="4">
			<div class="row">
				<c:forEach items="${partys}" var="party" varStatus="inside" begin="${last}" end="${last+3}">
					<!-- PARTY BEGIN -->
					<div class="col s12 m3">
						<div class="card">
							<div class="card-image">
								<img src="/earthquake/resources/img/background_nidoking.jpg"> <span
									class="card-title">${party.getNome()}</span>
							</div>
							<div class="card-content">
								<ul>
									<c:forEach items="${party.getUsuarios()}" var="player">
										<li class="padding-bt-5">
											<div class="row valign-wrapper margin">
												<div class="col s3">
													<img src="/earthquake/resources/img/user.jpg" alt="" class="circle responsive-img"
														width="48" height="128">
												</div>
												<div class="col s9">
													<span class="black-text" style="font-size: 13px !important;">
														${player.getNomeChar()} </span>
													<div class="black-text" style="font-size: 13px !important;">
														<b>${player.getJob().getDescricao()}</b>
													</div>
												</div>
											</div>
										</li>
									</c:forEach>
								</ul>
							</div>
							<div class="card-action">
								<a href="#">This is a link</a>
							</div>
						</div>
					</div>
					<!-- PARTY END -->
					 <c:set var="last" scope="page" value="${last+1}"/>
				</c:forEach>
			</div>
		</c:forEach>
	</div>

	<jsp:include page="/WEB-INF/templates/includes.jsp" />

	<script type="text/javascript">
		$(document).ready(function() {
			$("#dropdown").dropdown({
				hover : true
			});
			$("#button-collapse").sideNav();
		});
	</script>
</body>
</html>