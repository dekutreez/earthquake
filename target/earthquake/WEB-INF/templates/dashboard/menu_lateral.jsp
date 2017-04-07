<ul id="slide-out" class="side-nav" style="transform: translateX(0px);">
	<li>
		<div class="userView">
			<div class="background">
				<img src="/earthquake/resources/img/background_nidoking.jpg">
			</div>
			<a href="#!user"><img class="circle" src="/earthquake/resources/img/user.jpg"></a> <a
				href="#!name"><span class="white-text name">${user.getNomeChar()}</span></a> <a href="#!email"><span class="white-text email">${user.getJob().getDescricao()}
					- ${user.getRole()}</span></a>
		</div>
	</li>
	<li><a class="waves-effect" href="/earthquake/dashboard">Inicio</a></li>
	<li><a class="waves-effect" href="/earthquake/dashboard/partys">Party</a></li>
	<li><a class="waves-effect" href="#!">Submeter Vídeos</a></li>
	<li><div class="divider"></div></li>
	<li><a class="subheader">Admin</a></li>
	<li><a class="waves-effect" href="#!">Editar Party</a></li>
	<li><a class="waves-effect" href="#!">Alterar Textos</a></li>
	<li><a class="waves-effect" href="#!">Aceitar Vídeos</a></li>
	<li class="no-padding">
		<ul class="collapsible collapsible-accordion padding">
			<li><a class="collapsible-header">Membros<i
					class="material-icons">arrow_drop_down</i></a>
				<div class="collapsible-body">
					<ul>
						<li><a class="waves-effect" href="#!">Editar Perfil</a></li>
						<li><a class="waves-effect" href="#!">Editar Papel</a></li>
						<li><a class="waves-effect" href="#!">Alterar Dados</a></li>
					</ul>
				</div></li>
		</ul>
	</li>
	<li><a class="waves-effect" href="index">Sair</a></li>
</ul>