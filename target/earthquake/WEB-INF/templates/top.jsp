<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="pink darken-2">
	<div class="nav-wrapper container pink darken-2">
		<a href="#!" class="brand-logo white-text">EARTHQUAKE</a> 
		<a href="#" data-activates="mobile-demo" class="button-collapse white-text">
			<i class="material-icons">menu</i>
		</a>
		<ul class="right hide-on-med-and-down">
			<li><a href="index" class="active white-text">Início</a></li>
			<li><a href="about" class="white-text">Sobre</a></li>
			<li><a href="videos" class="white-text">Vídeos</a></li>
			<c:if test="${usuarioLogado != null}">
				<li class="page-scroll">
				    <a href="dashboard" class="white-text">Interno</a>
				</li>
			</c:if>
			<c:choose>
				<c:when test="${usuarioLogado != null}">
					<li class="page-scroll">
						<a href="<c:url value="/logout" />" class="white-text">Logout</a>
					</li>
				</c:when>
				<c:when test="${usuarioLogado == null}">
					<li class="page-scroll">
					    <a href="login" class="white-text">Login</a>
					</li>
				</c:when>
			</c:choose>
		</ul>
		<ul class="side-nav" id="mobile-demo">
			<li><a href="index">Início</a></li>
			<li><a href="about.html">Sobre</a></li>
			<li><a href="videos.html">Vídeos</a></li>
			<c:if test="${usuarioLogado != null}">
				<li class="page-scroll">
				    <a href="dashboard" class="white-text">Interno</a>
				</li>
			</c:if>
			<c:choose>
				<c:when test="${usuarioLogado != null}">
					<li class="page-scroll">
						<a href="<c:url value="/logout" />" class="white-text">Logout</a>
					</li>
				</c:when>
				<c:when test="${usuarioLogado == null}">
					<li class="page-scroll">
					    <a href="login" class="white-text">Login</a>
					</li>
				</c:when>
			</c:choose>
		</ul>
	</div>
</nav>