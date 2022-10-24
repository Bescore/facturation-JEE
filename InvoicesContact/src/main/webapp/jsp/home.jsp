<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>
<!-- bootstrap css -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<!-- bootstrap js -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
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
					<h2 class="main-title text-center my-4">Bonjour 👋, contents
						de vous revoir</h2>
					<div class="row mx-auto">
						<c:choose>
							<c:when test="${empty activite_en_cours }">
								<div class="col-12 col-xl my-2 ">

									<div class="card ">
										<div class="card-body ">
											<h5 class="my-3">Débutez votre journée</h5>
											<h6 class="my-3">Choisissez un client</h6>

											<select name="client" class="form-select"
												aria-label="Default select example">
												<c:forEach items="${clients }" var="element">
													<option value="${element.id_personne }"><c:out
															value="${element.nom } ${element.prenom }"></c:out></option>
												</c:forEach>
											</select>
											<h6 class="my-3">Choisissez le type service que vous
												allez fournir</h6>
											<select name="type" class="form-select"
												aria-label="Default select example">
												<c:forEach items="${types }" var="element">
													<option value="${element.id_type }">${element.type_mission }</option>
												</c:forEach>
											</select>
											<div class="mb-3">
												<label for="exampleInputEmail1" class="form-label my-2">Tarif
													(par heures)</label> <input name="tarif" type="number" min="1"
													class="form-control  border border-secondary  w-25"
													id="exampleInputEmail1" aria-describedby="emailHelp">
											</div>
											<button name="demarrer_journee" type="submit"
												class="btn btn-primary my-4">Démarrer</button>

										</div>
										<div></div>
									</div>
								</div>
							</c:when>
							<c:when test="${!empty activite_en_cours }">
								<div class="col-12 col-xl my-2 ">

									<div class="card text-center ">
										<div class="card-body px-5 ">
											<h5 class="my-3">Mon activité en cours</h5>
											<hr>
											<p class="my-3 fw-bold">
												Client :
												<c:out
													value="${activite_en_cours.client.prenom} ${activite_en_cours.client.nom}"></c:out>
											</p>
											<p class="my-3 fw-bold">
												Service :
												<c:out value="${activite_en_cours.type.type_mission}"></c:out>
											</p>

											<p class="my-3 fw-bold">
												Tarif :
												<c:out value="${activite_en_cours.tarif } €/h"></c:out>
											</p>
											<p class="my-3 fw-bold">
												Début :
												<c:out value="${activite_en_cours.debut } "></c:out>
											</p>
											<div></div>
											<button name="arreter_journee" type="submit"
												class="btn btn-danger my-4">Arrêter</button>
											<div>
												<div class="spinner-border text-primary" role="status">
													<span class="visually-hidden">Loading...</span>
												</div>
											</div>

										</div>
										<div></div>
									</div>
								</div>
							</c:when>
						</c:choose>
					</div>
					<c:if test="${!empty activites_recentes }">
					<h2 class="main-title text-center my-4">Dernière journée enregistrée</h2>
					<div class="row mx-auto">
						<div class="col-12 col-xl my-2 ">

							<div class="card text-center ">
								<div class="card-body rounded-3">
									<h5>Durée </h5>
									<div class="my-2"><c:out value=" ${activites_recentes.duree_activite } (H)"></c:out></div>

								</div>
							</div>
						</div>
						<div class="col-12 col-xl my-2 ">

							<div class="card text-center">
								<div class="card-body ">
									<h5>Client et mission</h5>
									<div class="my-2">
										<c:out
											value=" ${activites_recentes.client.prenom } ${activites_recentes.client.nom }"></c:out>
										--
										<c:out value=" ${activites_recentes.type.type_mission }"></c:out> -- <c:out value=" ${activites_recentes.tarif } €/heures"></c:out>
									</div>
								</div>
							</div>
						</div>
						<div class="col-12 col-xl my-2 ">

							<div class="card text-center ">
								<div class="card-body ">
									<h5>Argent gagné</h5>
									<div class="my-2"><c:out value=" ${somme_du} € (brut)"></c:out></div>
								</div>
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