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

		<div class="row">

			<!-- PARTY BEGIN -->
			<div class="col s12 m3">
				<div class="card">
					<div class="card-image">
						<img src="/earthquake/resources/img/background_nidoking.jpg"> <span
							class="card-title">${user.getParty().getNome()}</span>
					</div>
					<div class="card-content">
						<ul>
							<c:forEach items="${user.getParty().getUsuarios()}" var="player">
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


			<div class="col s12 m3">
				<div class="card">
					<div class="card-content">
						<span class="card-title">Doações</span>
						<div class="divider"></div>
						<ul>
							<c:forEach items="${donations}" var="donation">
								<li>
									<h5>${donation.getDonation().getDescricao()}</h5>
									<div class="progress">
										<div class="determinate" style="width: ${donation.getPorcentagemDoada()}%"></div>
									</div>
									<p>${donation.getQuantidadeDoada()} / ${donation.getDonation().getLimiteMinimo()}</p>
								</li>
								<div class="divider"></div>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>

			<div class="col s12 m6">
				<div class="card">
					<div class="card-content">
						<span class="card-title">Últimas Atualizações</span>
						<ul>
							<li>
								<p>
									[ 04/04/2017 14:15 ] <b>felipe do desencantar</b> - adicionou
									um vídeo
								</p>
							</li>
							<li>
								<p>
									[ 04/04/2017 15:26 ] <b>segen</b> - alterou descrição do site
								</p>
							</li>
						</ul>
					</div>

				</div>
			</div>


		</div>

		<div class="row">
			<div class="col s12 m4">
				<div class="card">
					<div class="card-content">
						<span class="card-title">Ranking de Stuffs Doados</span>
						<table>
							<thead>
								<tr>
									<th>Nick</th>
									<th>Pts</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${donationsRank}" var="ranking">
									<tr>
										<td>${ranking.getKey().getNomeChar()}</td>
										<td>${ranking.getValue()}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
				</div>
			</div>

			<div class="col s12 m4">
				<div class="card">
					<div class="card-content">
						<span class="card-title">Stuffs da Guild</span>
						<table>
							<thead>
								<tr>
									<th>Item</th>
									<th>Qtd</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${guildConsumiveisEtc}" var="stuff">
									<tr>
										<td>${stuff.getNome()}</td>
										<td>${stuff.getQuantidade()}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
				</div>
			</div>

			<div class="col s12 m4">
				<div class="card">
					<div class="card-content">
						<span class="card-title">Equips da Guild</span>
						<table>
							<thead>
								<tr>
									<th>Item</th>
									<th>Qtd</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${guildGears}" var="gear">
									<tr>
										<td>${gear.getNome()}</td>
										<td>${gear.getQuantidade()}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>
				</div>
			</div>

		</div>
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