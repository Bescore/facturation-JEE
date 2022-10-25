<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>

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
			<form method="post">
				<div class="container">
					<div class="row mx-auto">
						<div class="col col-xl my-2 ">

							<div class="card ">
								<div class="card-body ">
									<h5 class="my-3">Mes heures</h5>
									<h6 class="my-3">Client</h6>


									<select name="client" class="form-select"
										aria-label="Default select example">
										<c:forEach items="${clients}" var="element">
											<option value="${element.id_personne }"><c:out
													value=" ${element.nom } ${element.prenom }"></c:out></option>
										</c:forEach>
									</select>
									<h6 class="my-3">Mois</h6>
									<select name="mois" class="form-select"
										aria-label="Default select example">

										<option value="1">Janvier</option>
										<option value="2">Février</option>
										<option value="3">Mars</option>
										<option value="4">Avril</option>
										<option value="5">Mai</option>
										<option value="6">Juin</option>
										<option value="7">Juillet</option>
										<option value="8">Août</option>
										<option value="9">Septembre</option>
										<option value="10">Octobre</option>
										<option value="11">Novembre</option>
										<option value="12">Décembre</option>

									</select>
									<h6 class="my-3">Année</h6>
									<div>
										<input name="annee" value="${annee}" type="number" min="2022"
											size="4">
									</div>
									<button name="selectionner" type="submit"
										class="btn btn-primary my-4">Selectionner client</button>

								</div>
								<c:if test="${!empty erreur }">
									<div class="container">
										<div class="alert alert-danger" role="alert">
											<i class="fa-solid fa-triangle-exclamation mx-2"></i>Pas de
											données à ces dates
										</div>
									</div>
								</c:if>
							</div>
						</div>
						<c:if test="${ !empty activites}">
							<div class="col col-xl my-2 ">
								<div class="row">
									<div class="col col-xl my-1 ">

										<div class="card text-center ">
											<div class="card-body px-5 ">
												<h5 class="my-3">
													Informations concernant le client <b>${nom_client }
														${prenom_client}</b>
												</h5>
												<hr>
												<br>

											</div>
										</div>
									</div>

								</div>
								<div class="row">

									<div class="col col-xl my-2 ">

										<div class="card text-center ">
											<div class="card-body px-5 ">
												<h5 class="my-3">Total d'heures du mois</h5>
												<hr>
												<div>
													<c:out value="${total_heure }"></c:out>
												</div>

											</div>
										</div>
									</div>
									<div class="col col-xl my-2 ">

										<div class="card text-center ">
											<div class="card-body px-5 ">
												<h5 class="my-3">Gains brut</h5>
												<hr>
												<div>
													<c:out value="${gains_brut } €"></c:out>
												</div>

											</div>
										</div>
									</div>
								</div>
								<div class="row">

									<div class="col col-xl my-2 ">

										<div class="card text-center ">
											<div class="card-body px-5 ">
												<h5 class="my-3">
													URSAFF <span class="fs-6">(uniquement ce client)</span>
												</h5>
												<hr>
												<div>
													<c:out value="${ursaff_prevision } €"></c:out>
												</div>

											</div>
										</div>
									</div>
									<div class="col col-xl my-2 ">

										<div class="card text-center ">
											<div class="card-body px-5 ">
												<h5 class="my-3">Gains net</h5>
												<hr>
												<div>
													<c:out value="${gains_net } €"></c:out>
												</div>

											</div>
										</div>
									</div>
								</div>
							</div>
						</c:if>
					</div>
					<c:if test="${ !empty activites}">
						<div class="row mx-auto">
							<div class="col col-xl my-2   ">

								<div class="card mx-auto  overflow-auto" style="height: 14rem">
									<div class="card-body  table-responsive ">

										<table class="table table-striped table-hover  text-center">
											<thead>
												<tr>
													<th scope="col">Début</th>
													<th scope="col">Fin</th>
													<th scope="col">Durée</th>
													<th scope="col">Tarif</th>
													<th scope="col">Type de mission</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${activites}" var="element">
													<tr>
														<td><c:out value="${element.debut}"></c:out></td>
														<td><c:out value="${element.fin}"></c:out></td>
														<td><c:out value="${element.duree_activite}"></c:out></td>
														<td><c:out value="${element.tarif}"></c:out> €/h</td>
														<td><c:out value="${element.type.type_mission}"></c:out></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<div class="row mx-auto">
							<div class="col col-xl my-2 text-center  ">

								<button name="selectionner" type="submit"
									class="btn btn-primary my-4">Générer une facture</button>
							</div>
							<div class="col col-xl my-2  text-center ">

								<button name="selectionner" type="submit"
									class="btn btn-primary my-4">Selectionner client</button>
							</div>
							<div class="col col-xl my-2  text-center ">
								<button name="selectionner" type="submit"
									class="btn btn-primary my-4">Selectionner client</button>
							</div>
						</div>
					</c:if>
					<c:if test="${empty invoice  }">

						<div class="row mx-auto">
							<div class="col col-xl my-2 ">

								<div class="card ">
									<div class="card-body ">

										<h5 class="text-center">Facture</h5>
										<hr>
										<div class="row">

											<div class="row mx-auto">
												<div class="col col-xl my-2 ">
													<div class="card ">
														<div class="card-body text-center">
														${prenom} ${nom }<br>
														Siret : 814 408 928 00020<br>
														Tel : ${telephone}
														</div>
													</div>
												</div>


												<div class="col col-xl my-2 ">

													<div class="card ">
														<div class="card-body "></div>
													</div>
												</div>


												<div class="col col-xl my-2 ">

													<div class="card ">
														<div class="card-body "></div>
													</div>
												</div>
											</div>

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