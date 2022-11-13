<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Gérer les clients</title>

<!-- jquery cdn -->
<script src="https://code.jquery.com/jquery-3.6.1.min.js"
	integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
	crossorigin="anonymous"></script>
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
			<c:choose>
				<c:when test="${!empty clients && !empty types}">
					<div class="container">
						<h2 class="main-title my-4">Gérer les demandes</h2>
						<div class="row my-2 ">
							<div class="col-12 col-xl-3 my-2  ">
								<form method="post">
									<div class="card">
										<div class="card-body">
											<h5 class="card-title my-4">Choisissez le client</h5>
											<select class="form-select" name="clients"
												aria-label="Default select example">
												<c:forEach items="${clients }" var="element">
													<option value="${element.id_personne }">${element.nom }
														${element.prenom }</option>
												</c:forEach>
											</select>
											<h5 class="card-title my-4">Choisissez type d'activité
												demandé</h5>
											<select class="form-select" name="types"
												aria-label="Default select example">
												<c:forEach items="${types }" var="element">
													<option value="${element.id_type }">${element.type_mission }</option>
												</c:forEach>
											</select>
											<h5 class="card-title my-3">Date</h5>
											<input type="date" name="date" required>
											<h5 class="card-title my-4">Heure</h5>
											<select class="form-select" name="heure"
												aria-label="Default select example">
												<option value="07:00:00">7 h</option>
												<option value="08:00:00">8 h</option>
												<option value="09:00:00">9 h</option>
												<option value="010:00:00">10 h</option>
												<option value="011:00:00">11 h</option>
												<option value="012:00:00">12 h</option>
												<option value="013:00:00">13 h</option>
												<option value="014:00:00">14 h</option>
												<option value="015:00:00">15 h</option>
												<option value="16:00:00">16 h</option>
												<option value="17:00:00">17 h</option>
												<option value="18:00:00">18 h</option>
												<option value="19:00:00">19 h</option>
												<option value="20:00:00">20 h</option>
											</select>
											<h5 class="card-title my-4">Durée</h5>
											<select class="form-select" name="duree"
												aria-label="Default select example">
												<option value="01:00:00">1 heure</option>
												<option value="02:00:00">2 heures</option>
												<option value="03:00:00">3 heures</option>
												<option value="04:00:00">4 heures</option>
												<option value="05:00:00">5 heures</option>
												<option value="06:00:00">6 heures</option>
												<option value="07:00:00">7 heures</option>
												<option value="08:00:00">8 heures</option>
												<option value="09:00:00">9 heures</option>
												<option value="10:00:00">10 heures</option>
											</select>
											<button name="valider" type="submit"
												class="btn btn-primary my-3">Valider</button>
										</div>
									</div>
								</form>
							</div>
							<div class="col-12 col-xl-9 my-2  ">
								<div class="card">
									<div class="card-body overflow-auto">
									<c:if test="${!empty demandes }">
										<h5 class="card-title my-4">Vos demandes</h5>
										<table class="table table table-bordered text-center">
											<thead>
												<tr>
													<th scope="col">Client</th>
													<th scope="col">Type</th>
													<th scope="col">Date</th>
													<th scope="col">Heure</th>
													<th scope="col">Durée</th>
													<th scope="col">Supprimer</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${demandes}" var="element">
													<tr>
														<th scope="row">${element.client.nom }
															${element.client.prenom }</th>
														<td>${element.type.type_mission }</td>
														<td>${element.date }</td>
														<td>${element.heure }</td>
														<td>${element.duree }</td>
														<td><a
														href="<%request.getContextPath();%>DeleteDemande?id=${element.id_demande }&action=delete"><i
															class="fa-solid fa-trash-can"></i></a></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										</c:if>
										<c:if test="${empty demandes }">
										<h5 class="card-title my-4">Ajouter les demandes des clients</h5>
										<img alt="Aucune donnée" src="img/background/consulting.svg">
										</c:if>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:when>
				<c:when test="${empty clients || empty types}">
					<div class="container">
					<h2 class="main-title my-4">Demandes non disponible, ajoutez des client et des services !</h2>
						<div class="row my-2 d-flex ">
							<div class="col-12 col-xl my-2  ">
								<div class="card">
									<div class="card-body d-flex justify-content-center align-items-center">
										<img alt="Aucune demandes" loading="lazy"  class="p-5" src="img/background/demande.svg">
									</div>
								</div>
							</div>
						</div>
				</c:when>
			</c:choose>
		</main>

		<!-- ! Footer -->
		<c:import url="/Footer"></c:import>
	</div>