<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Gérer les clients</title>
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
				<c:when test="${empty afficheTableau && empty client_a_modifier }">
					<div class="container">
						<h2 class="main-title my-2">Gérer les clients</h2>



						<div class="row my-2">
							<div class="col-12 col-xl-6 my-2 ">
								<div class="card">
									<div class="card-body">
										<h5 class="card-title">Ajouter / Modifier / Supprimer</h5>
										<form method="post">
											<div class="mb-3 ">
												<label for="exampleInputPassword1" class="form-label">Nom</label>
												<input name="nom"
													title="texte sans accents, sans caractères spéciaux"
													type="text" class="form-control border"
													id="exampleInputPassword1">
											</div>
											<div class="mb-3 ">
												<label for="exampleInputPassword1" class="form-label">Prenom</label>
												<input name="prenom"
													title="texte sans accents, sans caractères spéciaux"
													type="text" class="form-control border"
													id="exampleInputPassword1">
											</div>
											<div class="mb-3 ">
												<label for="exampleInputPassword1" class="form-label">Téléphone</label>
												<input name="telephone"
													title="numéro de téléphone exclusivement" type="number"
													class="form-control border" id="exampleInputPassword1">
											</div>
											<div class="mb-3 ">
												<label for="exampleInputPassword1" class="form-label">Email</label>
												<input name="email"
													title="texte sans accents, sans caractères spéciaux"
													type="text" class="form-control border"
													id="exampleInputPassword1">
											</div>
											<div class="mb-3 ">
												<label for="exampleInputPassword1" class="form-label">Adresse</label>
												<input name="adresse" title="ex: 2 rue Brassens.."
													type="text" class="form-control border"
													id="exampleInputPassword1">
											</div>
											<div class="mb-3 ">
												<label for="exampleInputPassword1" class="form-label">Code
													postale</label> <input name="code_postale"
													title="code postale exclusivement" type="number"
													class="form-control border" id="exampleInputPassword1">
											</div>
											<button name="valider" type="submit" class="btn btn-primary">
												<i class="fa-solid fa-user-plus"></i>
											</button>
										</form>
									</div>
								</div>
							</div>
							<div class="col-12 col-xl-6 my-2 ">
								<c:if test="${empty clients }">
									<div class="card w-50">
										<div class="card-body ">Pas de clients, ajoutez en !</div>
									</div>
								</c:if>
								<c:if test="${!empty clients }">
									<div class="card">
										<div class="card-body">
											<form method="post">
												<h5 class="card-title">Liste des clients</h5>

												<select name="selection" class="form-select"
													aria-label="Default select example">
													<c:forEach items="${clients }" var="element">
														<option value="${element.id_personne }"><c:out
																value="${element.nom } ${element.prenom }"></c:out></option>
													</c:forEach>
												</select>

												<div>
													<button name="update_client" type="submit"
														class="btn btn-primary my-3">
														<i class="fa-regular fa-pen-to-square mx-4"></i>
													</button>
													<button name="afficher_tableau" type="submit"
														class="btn btn-primary my-3">Afficher le tableau</button>
												</div>
											</form>
										</div>
									</div>
								</c:if>
							</div>
						</div>
					</div>
				</c:when>
				<c:when test="${!empty afficheTableau }">
					<div class="container">
						<div class="col-12 ">
							<div class="card">

								<div class="card-body  ">
									<form method="post" class="table-responsive">
										<h5 class="card-title">Tableau des clients</h5>

										<table class="table table-striped ">
											<thead>
												<tr>
													<th scope="col">#</th>
													<th scope="col">Nom</th>
													<th scope="col">Prenom</th>
													<th scope="col">Téléphone</th>
													<th scope="col">Email</th>
													<th scope="col">Adresse</th>
													<th scope="col">Code postale</th>

												</tr>
											</thead>
											<tbody>
												<c:if test="${!empty clients}">
													<c:forEach items="${clients}" var="element">
														<tr>
															<th scope="row"><c:out
																	value="${element.id_personne }"></c:out></th>
															<td><c:out value="${element.nom }"></c:out></td>
															<td><c:out value="${element.prenom }"></c:out></td>
															<td><c:out value="${element.telephone }"></c:out></td>
															<td><c:out value="${element.email }"></c:out></td>
															<td><c:out value="${element.adresse }"></c:out></td>
															<td><c:out value="${element.code_postale }"></c:out></td>
														</tr>
													</c:forEach>
												</c:if>
											</tbody>
										</table>


										<div>
											<button name="invisible_tableau" type="submit"
												class="btn btn-primary my-3">Retour</button>
										</div>
									</form>
								</div>

							</div>
						</div>
					</div>
				</c:when>
				<c:when test="${!empty client_a_modifier }">
					<div class="container">
						<h2 class="main-title my-2">Gérer les clients</h2>
						<div class="row my-2">
							<div class="col-12 col-xl-6 my-2 ">
								<div class="card">
									<div class="card-body">
										<h5 class="card-title">Ajouter / Modifier / Supprimer</h5>
										<form method="post">
											<div class="mb-3 ">
												<label for="exampleInputPassword1" class="form-label">Nom</label>
												<input name="nom" value="${client_a_modifier.nom }"
													title="texte sans accents, sans caractères spéciaux"
													type="text" class="form-control border"
													id="exampleInputPassword1">
											</div>
											<div class="mb-3 ">
												<label for="exampleInputPassword1" class="form-label">Prenom</label>
												<input name="prenom" value="${client_a_modifier.prenom }"
													title="texte sans accents, sans caractères spéciaux"
													type="text" class="form-control border"
													id="exampleInputPassword1">
											</div>
											<div class="mb-3 ">
												<label for="exampleInputPassword1" class="form-label">Téléphone</label>
												<input name="telephone"
													value="${client_a_modifier.telephone }"
													title="numéro de téléphone exclusivement" type="number"
													class="form-control border" id="exampleInputPassword1">
											</div>
											<div class="mb-3 ">
												<label for="exampleInputPassword1" class="form-label">Email</label>
												<input name="email" value="${client_a_modifier.email}"
													title="texte sans accents, sans caractères spéciaux"
													type="text" class="form-control border"
													id="exampleInputPassword1">
											</div>
											<div class="mb-3 ">
												<label for="exampleInputPassword1" class="form-label">Adresse</label>
												<input name="adresse" value="${client_a_modifier.adresse }"
													title="ex: 2 rue Brassens.." type="text"
													class="form-control border" id="exampleInputPassword1">
											</div>
											<div class="mb-3 ">
												<label for="exampleInputPassword1" class="form-label">Code
													postale</label> <input name="code_postale"
													value="${client_a_modifier.code_postale }"
													title="code postale exclusivement" type="number"
													class="form-control border" id="exampleInputPassword1">
											</div>
											<button name="modifier" type="submit" class="btn btn-primary">
												<i class="fa-regular fa-pen-to-square mx-4"></i>
											</button>
											<button name="delete_client" type="submit"
												class="btn btn-primary my-3">
												<i class="fa-solid fa-trash-can mx-4"></i>
											</button>
											<button name="" type="submit" class="btn btn-primary">
												<i class="fa-solid fa-rotate-left"></i>
											</button>
										</form>
									</div>
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