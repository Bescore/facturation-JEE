<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--Sidebar-->
<aside class="sidebar">
	<div class="sidebar-start">
		<div class="sidebar-head">
			<a href='<c:url value="/Home"></c:url>' class="logo-wrapper"
				title="Home"> <span class="sr-only">Home</span> <span><img
					src="img/background/logo_facturation.png" aria-hidden="true"></span>
				<span class="logo-text"> <span class="logo-subtitle">Invoices
						and contact</span>
			</span>

			</a>
			<button class="sidebar-toggle transparent-btn" title="Menu"
				type="button">
				<span class="sr-only">Toggle menu</span> <span
					class="icon menu-toggle" aria-hidden="true"></span>
			</button>
		</div>
		<div class="sidebar-body">
			<ul class="sidebar-body-menu">
				<li><a class="active" href='<c:url value="/Home"></c:url>'><span
						class="icon home" aria-hidden="true"></span>Accueil</a></li>
				<li><a class="show-cat-btn" href="##"> <span
						class="icon user-3" aria-hidden="true"></span>Clients <span
						class="category__btn transparent-btn" title="Open list"> <span
							class="sr-only">Open list</span> <span class="icon arrow-down"
							aria-hidden="true"></span>
					</span>
				</a>
					<ul class="cat-sub-menu">
						<li><a href="<c:url value="/Client"></c:url>">Gérer les
								clients</a></li>
						<li><a href="<c:url value="/Demande"></c:url>">Demandes
								des clients</a></li>
					</ul></li>
				<li><a class="show-cat-btn" href="##"> <span
						class="icon edit" aria-hidden="true"></span>Activités <span
						class="category__btn transparent-btn" title="Open list"> <span
							class="sr-only">Open list</span> <span class="icon arrow-down"
							aria-hidden="true"></span>
					</span>
				</a>
					<ul class="cat-sub-menu">
						<li><a href='<c:url value="/Mesheures"></c:url>'>Mes
								heures</a></li>
						<li><a href='<c:url value="/TypeActivite"></c:url>'>Gérer
								types d'activités</a></li>
					</ul></li>
				<li><a class="show-cat-btn" href="##"> <span
						class="icon paper" aria-hidden="true"></span>Comptabilité <span
						class="category__btn transparent-btn" title="Open list"> <span
							class="sr-only">Open list</span> <span class="icon arrow-down"
							aria-hidden="true"></span>
					</span>
				</a>
					<ul class="cat-sub-menu">
						<li><a href="<c:url value="/Facture"></c:url>">Mes
								factures</a></li>
						<li><a href="<c:url value="/Statistiques"></c:url>">Statistiques</a></li>
					</ul></li>
				<li>
			</ul>
		</div>
	</div>
	<div class="sidebar-footer">
		<a href="##" class="sidebar-user"> <span class="sidebar-user-img">
				<picture>
				<source srcset="img/avatar/avatar-illustrated-02.webp"
					type="image/webp">
				<img src="img/avatar/avatar-illustrated-02.png" alt="User name"></picture>
		</span> <span class="sidebar-user-info"> <span
				class="sidebar-user__title">L. jean-marie</span> <span
				class="sidebar-user__subtitle">Concepteur</span>
		</span>
		</a>
	</div>
</aside>
<div class="main-wrapper">
	<!-- ! Main nav -->
	<nav class="main-nav--bg">
		<div class="container main-nav">
			<div class="main-nav-start">
				<form method="post" action="<%request.getContextPath();%>Recherche">
					<div class="search-wrapper">
						<input type="text" name="recherche_input"
							placeholder="Rechercher un client..." required>
						<button type="submit" name="rechercher"
							class="btn btn-primary m-2">
							<i class="fa-solid fa-magnifying-glass"></i>
						</button>
					</div>
				</form>
			</div>
			<div class="main-nav-end">
				<c:if test="${!empty nom }">
					<div class="text-primary" style="font-weight: bold !important">
						<c:out value="${prenom } ${nom }"></c:out>
					</div>
				</c:if>
				<button class="sidebar-toggle transparent-btn" title="Menu"
					type="button">
					<span class="sr-only">Toggle menu</span> <span
						class="icon menu-toggle--gray" aria-hidden="true"></span>
				</button>
				<button class="theme-switcher gray-circle-btn" type="button"
					title="changer de theme">
					<span class="sr-only">Switch theme</span> <i class="sun-icon"
						data-feather="sun" aria-hidden="true"></i> <i class="moon-icon"
						data-feather="moon" aria-hidden="true"></i>
				</button>
				<div class="notification-wrapper">
					<button class="gray-circle-btn dropdown-btn" title="notifications"
						type="button">
						<span class="sr-only">To messages</span>
						<!-- la ligne du dessous, dans la classe possibilité de passer la cloche active et incative -->
						<span class="icon notification inactive" aria-hidden="true"></span>
					</button>
					<ul class="users-item-dropdown notification-dropdown dropdown">
						<li><a href="##"> <span
								class="notification-dropdown-icon info"> <i
									data-feather="check"></i>
							</span> <span class="notification-dropdown-text"> <span
									class="notification-dropdown__title">En developpement...</span>
									<span class="notification-dropdown__subtitle">Les
										notifications..</span>
							</span>
						</a></li>
					</ul>
				</div>
				<div class="nav-user-wrapper">
					<button class="nav-user-btn dropdown-btn" title="profil"
						type="button">
						<span class="sr-only">My profile</span> <span class="nav-user-img">
							<picture>
							<source srcset="img/avatar/avatar-illustrated-01.webp"
								type="image/webp">
							<img src="img/avatar/avatar-illustrated-01.png" alt="User name"></picture>
						</span>
					</button>
					<ul class="users-item-dropdown nav-user-dropdown dropdown">
						<li><a href='<c:url value="/Profil"></c:url>'> <i
								data-feather="user" aria-hidden="true"></i> <span>Mes
									informations</span>
						</a></li>
						<li><a class="danger"
							href="<c:url value="/Deconnexion"></c:url>"> <i
								data-feather="log-out" aria-hidden="true"></i> <span>Déconnexion</span>
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>