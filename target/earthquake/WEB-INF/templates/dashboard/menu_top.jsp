<!-- Navbar -->
<ul id="dropdown1" class="dropdown-content">
	<li><a href="#!">Sobre</a></li>
	<li class="divider"></li>
	<li><a href="#!">Ajuda</a></li>
	<li class="divider"></li>
	<li><a href="index">Sair</a></li>
</ul>
<nav>
	<div class="nav-wrapper white">
		<a href="#" data-activates="slide-out" id="button-collapse"
			class="left brand-logo margin-left-20"><i class="material-icons">menu</i></a>
		<ul class="right hide-on-med-and-down">
			<li>
				<div class="col s12 m8 offset-m2 l6 offset-l3">
					<div class="row valign-wrapper margin">
						<div class="col s3 valign-wrapper">
							<img src="/earthquake/resources/img/user.jpg" alt="" class="circle responsive-img"
								width="60" height="60">
						</div>
						<div class="col s9">
							<span class="black-text"> ${user.getNomeChar()} </span>
						</div>
					</div>
				</div>
			</li>
			<li><a id="dropdown" class="dropdown-button" href="#!"
				data-activates="dropdown1"><i class="material-icons">more_vert</i></a>
			</li>
		</ul>
	</div>
</nav>
