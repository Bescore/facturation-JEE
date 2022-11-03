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
<link rel="shortcut icon" href="img/svg/logo.svg" type="image/x-icon">
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
			<div class="container">
				<c:if test="${empty factures }">
					<h2 class="main-title my-2">Consulter vos heures pour générer
						des factures</h2>
					<div class="row">
						<div class="col-12 col-xl">
							<div class="card">
								<div class="card-body " style="height: 18rem;">
									<img loading="lazy" alt="consult" src="img/background/consulting.svg">
								</div>
							</div>
						</div>
				</c:if>
				<c:if test="${!empty factures }">
					<h2 class="main-title my-2">Consutlter mes factures</h2>
					<div class="row">
						<div class="col-12 col-xl">
							<div class="card">
								<div class="card-body table-responsive" style="height: 18rem;">
									<table
										class="table text-center table-striped table table table-bordered">
										<thead>
											<tr>
												<th scope="col">Identifiant</th>
												<th scope="col">Somme</th>
												<th scope="col">Nombre d'heures</th>
												<th scope="col">Clients</th>
												<th scope="col">Date d'envoi et de création</th>
												<th scope="col">Payé</th>
												<th scope="col">Suppr.</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${factures }" var="element">
												<tr>
													<td>${element.identifiant }</td>
													<td>${element.somme }€</td>
													<td>${element.nbr_totale_heure }</td>
													<c:if test="${not empty element.client.nom }">
														<td>${element.client.nom } ${element.client.prenom }</td>
													</c:if>
													<c:if test="${ empty element.client.nom }">
														<td>Ancien client</td>
													</c:if>
													<td>${element.date}</td>
													<c:choose>
														<c:when test="${element.payee==1}">
															<td><i class="fa-solid fa-circle-check text-success"></i></td>
														</c:when>
														<c:when test="${element.payee==0}">
															<td><i class="fa-solid fa-circle-xmark text-danger"></i></td>
														</c:when>
													</c:choose>
													<td><a
														href="<%request.getContextPath();%>DeleteFacture?id=${element.id_facture }&action=delete"><i
															class="fa-solid fa-trash-can"></i></a></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
						<div class="row my-3">
							<div class="col-12 col-xl text-center my-2">
								<div class="card">
									<div class="card-body">

										<div>Nombre de factures</div>
										<hr>
										<div class="m-3" style="font-size: 1.5rem">${nombre_totale_factures }</div>

									</div>
								</div>
							</div>
							<div class="col-12 col-xl text-center my-2 ">
								<div class="card">
									<div class="card-body">

										<span>Nombre de factures payés</span>
										<hr>
										<div class="m-3" style="font-size: 1.5rem">${nombre_factures_payee }</div>
									</div>
								</div>
							</div>
							<div class="col-12 col-xl text-center my-2 ">
								<div class="card">
									<div class="card-body">

										<div>Nombre de factures en attente de paiement</div>
										<hr>
										<div class="m-3" style="font-size: 1.5rem">${nombre_factures_non_payee }</div>
									</div>
								</div>
							</div>
						</div>
						<div class="row my-3 text-light">
							<div class="col-12 col-xl text-center my-2">
								<div class="card bg-primary">
									<div class="card-body">

										<div>Somme totale</div>
										<hr>
										<div class="m-3" style="font-size: 1.5rem">${somme_totale }
											€</div>
									</div>
								</div>
							</div>
							<div class="col-12 col-xl text-center my-2 ">
								<div class="card bg-success">
									<div class="card-body">

										<div>Somme totale payée</div>
										<hr>
										<div class="m-3" style="font-size: 1.5rem">${somme_totale_payee }
											€</div>
									</div>
								</div>
							</div>
							<div class="col-12 col-xl text-center my-2 ">
								<div class="card bg-warning">
									<div class="card-body">

										<div>Somme totale non payée</div>
										<hr>
										<div class="m-3" style="font-size: 1.5rem">${somme_totale_non_payee}
											€</div>
									</div>
								</div>
							</div>
						</div>
					</c:if>
			</div>
		</main>

		<!-- ! Footer -->
		<c:import url="/Footer"></c:import>
	</div>