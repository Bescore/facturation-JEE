<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Mes_heures</title>

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
			<form method="post" id="form">
				<div class="container">
					<div class="row mx-auto">
						<div class="col col-xl my-2 ">

							<div class="card ">
								<div class="card-body ">
									<h5 class="my-3">Mes heures</h5>
									<h6 class="my-3">Client</h6>


									<select name="client" class="form-select"
										aria-label="Default select example">
										<c:if test="${empty clients }">
										<option>-- Pas de clients --</option>
										</c:if>
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
									<c:if test="${!empty clients }">
									<button name="selectionner" type="submit"
										class="btn btn-primary my-4">Selectionner client</button>
									</c:if>

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
													Informations concernant le client <b>${ce_client.nom }
														${ce_client.prenom}</b>
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
					<c:if test="${empty activites }">
					<div class="row mx-auto ">
					<div class="col col-xl">
						<div class="card">
							<div class="card-body">
								<img style="width: 100%; height: 18rem; objectif-fit: cover;"
									src="img/background/heure.svg">
							</div>
						</div>
						</div>
						</div>
						</c:if>
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
								<div class="col col-xl my-2 text-end  ">

									<button type="button" class="btn btn-primary my-4"
										id="FactureBtn" onClick="return imprimerFacture()">Imprimer
										facture</button>
									<button name="genererFacture" type="button"
										data-bs-toggle="modal" data-bs-target="#exampleModal"
										class="btn btn-primary my-4">Générer et envoyer la
										facture au client</button>
								</div>
							</div>
						</c:if>
						<c:if test="${empty invoice  }">
							<input id="inputFacture" name="inputFacture_html" hidden="hidden"
								type="text">
							<div hidden="hidden" id="imprimerFactureDiv">
								<div class="row mx-auto">
									<div class="col col-xl my-2 ">

										<div class="card ">
											<div class="card-body ">

												<h5 class="text-center">Facture</h5>
												<hr>
												<br> <br> <br>
												<div class="row">
													<div class="row mx-auto">
														<div class="col col-xl my-2 text-start "
															style="font-size: 13px">
															Facture par : ${prenom} ${nom }<br> Siret : 814 408
															928 00020<br> Tel : ${telephone}<br>


														</div>
														<div class="col col-xl my-2 text-end"
															style="font-size: 13px">
															L'entreprise ${prenom} ${nom }<br> Adresse:
															${adresse }, Code Postale: ${code_postale }<br>
															Facture crée le : ${dateEtHeure}<br> <br>
															Adressé à : ${ce_client.nom } ${ce_client.prenom }<br>
															Adresse: ${ce_client.adresse}, ${ce_client.code_postale }<br>
															Téléphone : ${ce_client.telephone }

														</div>
													</div>
												</div>
												<br> 
												<div class="row">
													<div class="col col-xl my-2 ">
														<div class="card ">
															<div class="card-body text-center ">
																<p class="fw-bold text-dark">Détails des heures</p>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col col-xl my-2">
														<div class="card mx-auto  overflow-auto">
															<div class="card-body  table-responsive ">

																<table style="font-size: 13px"
																	class="table table-striped table-hover  text-center">
																	<thead>
																		<tr>
																			<th scope="col">Début</th>
																			<th scope="col">Fin</th>
																			<th scope="col">Durée</th>
																			<th scope="col">Type de mission</th>
																			<th scope="col">Tarif</th>
																		</tr>
																	</thead>
																	<tbody>
																		<c:forEach items="${activites}" var="element">
																			<tr>
																				<td><c:out value="${element.debut}"></c:out></td>
																				<td><c:out value="${element.fin}"></c:out></td>
																				<td><c:out value="${element.duree_activite}"></c:out></td>
																				<td><c:out value="${element.type.type_mission}"></c:out></td>
																				<td><c:out value="${element.tarif}"></c:out>
																					€/h</td>
																			</tr>
																		</c:forEach>
																	</tbody>
																</table>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col col-xl my-2 ">
														<div class="card ">
															<div class="card-body text-center ">
																<p class="fw-bold text-dark">Paiement</p>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col col-xl-4 my-2 right-50"></div>
													<div class="col col-xl-4 my-2 right-50"></div>
													<div class="col col-xl-4 my-2 right-50">
														<div class="card ">
															<div class="card-body text-center">
																<p class="fw-bold text-dark" style="font-size: 13px">Total
																	d'heures : ${total_heure }</p>
															</div>
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col col-xl-4 my-2 right-50"></div>
													<div class="col col-xl-4 my-2 right-50"></div>
													<div class="col col-xl-4 my-2 right-50">
														<div class="card ">
															<div class="card-body text-center">
																<p class="fw-bold text-dark" style="font-size: 13px">A
																	payer : ${gains_brut } €</p>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- Modal -->
							<div class="modal fade" id="exampleModal" tabindex="-1"
								aria-labelledby="exampleModalLabel" aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered">
									<div class="modal-content p-3">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Envoyer la facture au client</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">Vous allez générer une facture
											et l'envoyer au client par mail êtes vous sûr?</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-outline-primary"
												data-bs-dismiss="modal">Non</button>
											<a
												href="<c:url value="/SendMail?nom=${ce_client.nom }
											&prenom=${ce_client.prenom }&adresse=${ce_client.adresse }, ${ce_client.code_postale}
											&tel=${ce_client.telephone }&totalHeure=${total_heure }&apayer=${gains_brut }&id_client=${ce_client.id_personne }
											&email=${ce_client.email }&datetime=${dateEtHeure}"></c:url>"
												class="btn btn-outline-danger">Oui</a>
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