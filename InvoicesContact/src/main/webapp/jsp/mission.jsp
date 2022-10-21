<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Missions et activités</title>
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
			<div class="container">
				<h2 class="main-title my-2">Gérer les missions</h2>

				<div class="row my-2 ">
					<div class="col col-xl-6 ">
						<div class="card">
							<div class="card-body table-responsive">
								<c:if test="${empty missions }">
									<div class="text-center">Aucune missions enregistré</div>
								</c:if>
								<c:if test="${!empty missions }">
									<table class="table table-striped">
										<thead>
											<tr>
												<th scope="col">#</th>
												<th scope="col">Client</th>
												<th scope="col">Type de mission</th>
												<th scope="col">Tarif (€)</th>
												<th scope="col">Client</th>
												<th scope="col">En cours</th>

											</tr>
										</thead>
										<tbody>
											<c:forEach items="${missions }" var="element">
												<tr>
													<th scope="row"><c:out value="${element.id_mission }"></c:out></th>
													<td><c:out value="${element.client.nom }"></c:out></td>
													<td><c:out value="${element.type.type_mission}"></c:out></td>
													<td><c:out value="${element.tarif }"></c:out></td>
													<td><a
														href="<%request.getContextPath();%>?id=${element.id_mission }&action=edit&value=${element.type }"><i
															class="fa-regular fa-pen-to-square"></i></a></td>
													<td><a
														href="<%request.getContextPath();%>?id=${element.id_mission }&action=delete&value=${element.type }"><i
															class="fa-solid fa-trash-can"></i></a></td>
												</tr>
											</c:forEach>

										</tbody>
									</table>
								</c:if>
							</div>
						</div>
					</div>
					<div class="col col-xl-6 ">
						<form method="post">
							<div class="card">
								<div class="card-body table-responsive">
									<h5 class=" my-3">Selection type de mission</h5>
									<select name="types" class="form-select my-2">
										<c:if test="${!empty types }">
											<c:forEach items="${types}" var="element">
												<option value="${element.id_type }"><c:out
														value="${element.type_mission}"></c:out></option>
											</c:forEach>
										</c:if>
									</select>
									<h5 class=" my-3">Selection du client</h5>
									<select name="clients" class="form-select my-2"
										aria-label="Default select example">
										<c:if test="${empty clients }">
											<option>--Vide--</option>
										</c:if>
										<c:if test="${!empty clients }">
											<c:forEach items="${clients}" var="element">
												<option value="${element.id_personne }"><c:out
														value="${element.nom} ${element.prenom}"></c:out></option>
											</c:forEach>
										</c:if>
									</select>
									<div class="mb-3 ">
										<label for="exampleInputPassword1" class="form-label">Tarif
											(par heures)</label> <input name="tarif" min="0"
											title="code postale exclusivement" type="number"
											class="form-control border" id="exampleInputPassword1">
									</div>
									<button name="ajouter_mission" type="submit"
										class="btn btn-primary my-3">Ajouter une mission</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="row my-2">
					<div class="col col-xl-6 ">
						<div class="card">
							<div class="card-body table-responsive">test</div>
						</div>
					</div>
				</div>
			</div>
		</main>

		<!-- ! Footer -->
		<c:import url="/Footer"></c:import>
	</div>