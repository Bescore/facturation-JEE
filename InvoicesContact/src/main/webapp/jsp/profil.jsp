<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Type d'activité</title>
<!-- jquery cdn -->
<script defer src="https://code.jquery.com/jquery-3.6.1.min.js"
	integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
	crossorigin="anonymous"></script>
<!-- bootstrap css -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<!-- bootstrap js -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<!-- Favicon -->
<link rel="shortcut icon" href="./img/svg/logo.svg" type="image/x-icon">
<!-- Custom styles -->
<link rel="stylesheet" href="./css/style.min.css">
</head>

<body>
	<div class="layer"></div>
	<!-- ! Body -->
	<a class="skip-link sr-only" href="#skip-target">Skip to content</a>
	<div class="page-flex">
		<!-- Structure de la page -->
		<c:import url="/Structure"></c:import>

		<!-- Contenu -->

		<!-- ! Main -->
		<main class="main users chart-page" id="skip-target">
			<form method="post">
				<div class="container">
					<h2 class="main-title my-2">Mes informations</h2>
					<c:if test="${empty modifier_utilisateur }">
						<div class="row">
							<div class="col-lg-4">
								<div class="card mb-4">
									<div class="card-body text-center">
										<img loading="lazy"
											src="img/avatar/avatar-illustrated-04.webp" alt="avatar"
											class="rounded-circle img-fluid" style="width: 150px;">
										<h5 class="my-4">${prenom }${nom}</h5>
										<p class="text-muted mb-4">Entrepreneur</p>
										<button type="submit" name="modifier" class="btn btn-outline-primary">Modifier</button>

									</div>
								</div>
								<div class="card mb-4 mb-lg-0">
									<div class="card-body p-0">
										<ul class="list-group list-group-flush rounded-3">
											<li
												class="list-group-item d-flex justify-content-between align-items-center p-4">
												<i class="fas fa-globe fa-lg text-warning"></i> <a
												href="https://www.impots.gouv.fr/accueil"> Impots</a>
											</li>
											<li
												class="list-group-item d-flex justify-content-between align-items-center p-4">
												<i class="fa-solid fa-u fa-lg" style="color: #333333;"></i>
												<a href="https://www.urssaf.fr/portail/home.html">Ursaff</a>
											</li>
											<li
												class="list-group-item d-flex justify-content-between align-items-center p-4">
												<i class="fab fa-twitter fa-lg" style="color: #55acee;"></i>
												<a href="https://twitter.com/?lang=fr">Twitter</a>
											</li>
											<li
												class="list-group-item d-flex justify-content-between align-items-center p-4">
												<i class="fab fa-instagram fa-lg" style="color: #ac2bac;"></i>
												<a href="https://www.instagram.com/?hl=fr">Instagram</a>
											</li>
											<li
												class="list-group-item d-flex justify-content-between align-items-center p-4">
												<i class="fa-brands fa-youtube fa-lg text-danger"></i> <a
												href="https://www.youtube.com">Youtube</a>
											</li>
										</ul>
									</div>
								</div>
							</div>
							<div class="col-lg-8">
								<div class="card mb-4">
									<div class="card-body">
										<div class="row">
											<div class="col-sm-3">
												<p class="mb-0">Nom</p>
											</div>
											<div class="col-sm-9">
												<p class="text-muted mb-0">${nom }</p>
											</div>
										</div>
										<hr>
										<div class="row">
											<div class="col-sm-3">
												<p class="mb-0">Prenom</p>
											</div>
											<div class="col-sm-9">
												<p class="text-muted mb-0">${prenom }</p>
											</div>
										</div>
										<hr>
										<div class="row">
											<div class="col-sm-3">
												<p class="mb-0">Email</p>
											</div>
											<div class="col-sm-9">
												<p class="text-muted mb-0">${email }</p>
											</div>
										</div>
										<hr>
										<div class="row">
											<div class="col-sm-3">
												<p class="mb-0">Téléphone</p>
											</div>
											<div class="col-sm-9">
												<p class="text-muted mb-0">${telephone }</p>
											</div>
										</div>
										<hr>
										<div class="row">
											<div class="col-sm-3">
												<p class="mb-0">Adresse</p>
											</div>
											<div class="col-sm-9">
												<c:if test="${!empty adresse }">
													<p class="text-muted mb-0">${adresse }</p>
												</c:if>
												<c:if test="${empty adresse }">
													<p class="text-muted mb-0">non renseigné</p>
												</c:if>
											</div>
										</div>
										<hr>
										<div class="row">
											<div class="col-sm-3">
												<p class="mb-0">Code Postale</p>
											</div>
											<div class="col-sm-9">
												<c:if test="${code_postale!=0}">
													<p class="text-muted mb-4">${code_postale }</p>
												</c:if>
												<c:if test="${empty code_postale || code_postale==0 }">
													<p class="text-muted mb-4">non renseigné</p>
												</c:if>
											</div>
										</div>
									</div>
								</div>
								<div class="row ">
									<div class="col-md-6  col-xl my-5">

										<script src="https://apps.elfsight.com/p/platform.js" defer></script>
										<div class="elfsight-app-75292b17-cf39-4276-9e01-57618f7e11bc"></div>

									</div>
								</div>
							</div>
						</div>
					</c:if>
					<c:if test="${!empty modifier_utilisateur }">
						<div class="row">
							<div class="col-12 col-xl-6 my-2  ">
								<div class="card">
									<div class="card-body">
										<h5 class="card-title">Changez le champs correspondant</h5>

										<div class="mb-3 ">
											<label for="exampleInputPassword1" class="form-label">Nom</label>
											<input name="nom" value="${modifier_utilisateur.nom }"
												title="texte sans accents, sans caractères spéciaux"
												type="text" class="form-control border"
												id="exampleInputPassword1">
										</div>
										<div class="mb-3 ">
											<label for="exampleInputPassword1" class="form-label">Prenom</label>
											<input name="prenom" value="${modifier_utilisateur.prenom }"
												title="texte sans accents, sans caractères spéciaux"
												type="text" class="form-control border"
												id="exampleInputPassword1">
										</div>
										<div class="mb-3 ">
											<label for="exampleInputPassword1" class="form-label">Téléphone</label>
											<input name="telephone" value="${modifier_utilisateur.telephone }"
												title="numéro de téléphone exclusivement" type="number"
												class="form-control border" id="exampleInputPassword1">
										</div>
										<div class="mb-3 ">
											<label for="exampleInputPassword1" class="form-label">Email</label>
											<input name="email" value="${modifier_utilisateur.email }"
												title="texte sans accents, sans caractères spéciaux"
												type="text" class="form-control border"
												id="exampleInputPassword1">
										</div>
										<div class="mb-3 ">
											<label for="exampleInputPassword1" class="form-label">Adresse</label>
											<input name="adresse" value="${modifier_utilisateur.adresse }"
												title="ex: 2 rue Brassens..PAS D'ESPACES À LA FIN"
												type="text" class="form-control border"
												id="exampleInputPassword1">
										</div>
										<div class="mb-3 ">
											<label for="exampleInputPassword1" class="form-label">Code
												postale</label> <input min="0" size="5" name="code_postale"
												title="code postale exclusivement" type="number" value="${modifier_utilisateur.code_postale}"
												class="form-control border " id="exampleInputPassword1">
										</div>
										<button name="valider" type="submit" class="btn btn-primary">
											<i class="fa-solid fa-pencil"></i>
										</button>

									</div>
								</div>
							</div>
							<div class="col-12 col-xl-6 my-2  d-flex justify-content-center align-items-center">
								<div class="card">
									<div class="card-body">
									<img loading="lazy" alt="" src="img/avatar/avatar-illustrated-04.webp">
									</div>
								</div>
							</div>
					</c:if>
				</div>
			</form>
		</main>

		<!-- ! Footer -->
		<c:import url="/Footer"></c:import>
	</div>