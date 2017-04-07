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

	<div class="container">
		<div class="section">
			<div class="row">
				<div class="col l4 s12"></div>
				<div class="z-depth-4 card-panel col l4 s12">
					<form name="loginForm" method="post" th:action="@{/login}">
						<div class="row center pink darken-2">
							<div class="section">
								<img src="/earthquake/resources/img/user.jpg" alt="" height="124" width="124"
									class="circle responsive-img valign profile-image-login">
							</div>
						</div>		
						<c:if test="${msgSuccess != null}">
							<div class="alert alert-success">
							  <strong>Sucesso!</strong> ${msgSuccess}
							</div>
						</c:if>
						<c:if test="${param.error != null}">
							<div class="alert alert-danger">
								Usuário ou senha inválidos.
							</div>
						</c:if>
						<c:if test="${param.expired != null}">
							<div class="alert alert-danger">
								<strong>A sessão expirou!</strong> Favor logar novamante.
							</div>
						</c:if>

						<div class="row margin" style="padding: 10px 30px 10px 15px;">
							<div class="input-field col l12 s12 m12">
								<i class="material-icons prefix">account_circle</i> 
								<input id="username" name="username" type="text" class="validate"> 
								<label for="username">Usuário</label>
							</div>
						</div>

						<div class="row margin" style="padding: 10px 30px 10px 15px;">
							<div class="input-field col l12 s12 m12">
								<i class="material-icons prefix">lock</i> 
								<input id="password" name="password" type="password" class="validate">
								<label for="password">Senha</label>
							</div>
						</div>

						<div class="row" style="padding: 10px 30px 10px 15px;">
							<div class="input-field col l12 s12 m12">
								<input class="filled-in pink darken-2" name="remember-me" type="checkbox" id="remember-me" /> 
								<label for="remember-me">Remember me</label>
							</div>
						</div>

						<div class="row margin">
							<div class="input-field col s12">
								<button class="btn waves-effect waves-light col s12 pink darken-2" type="submit" name="action">Login</button>
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							</div>
						</div>

						<div class="row margin-20">
							<div class="input-field col s6 m6 l6">
								<p class="margin medium-small">
									<a href="registrar.html">Register Now!</a>
								</p>
							</div>
							<div class="input-field col s6 m6 l6">
								<p class="margin right-align medium-small">
									<a href="recuperar.html">Forgot password ?</a>
								</p>
							</div>
						</div>
					</form>
				</div>

				<div class="col l4 s12"></div>
			</div>
		</div>
	</div>


	<jsp:include page="/WEB-INF/templates/footer.jsp" />

	<jsp:include page="/WEB-INF/templates/includes.jsp" />
	<script type="text/javascript">
		$(document).ready(function() {
			$(".button-collapse").sideNav();
		});
	</script>
</body>
</html>
