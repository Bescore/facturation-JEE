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
			<div class="container">
				<h2 class="main-title my-2">Gérer types d'activités</h2>

				<div class="row my-2">
					<div class="col">
					<c:if test="${!empty types}">
						<div class="card">
							<div class="card-body table-responsive">
							<br/>
								<table class="table table-striped text-center">
									<thead>
										<tr>
											<th scope="col">Type de mission</th>
											<th scope="col">Modifier</th>
											<th scope="col">Supprimer</th>

										</tr>
									</thead>
									<tbody>
										<c:if test="${!empty types }">
											<c:forEach items="${types }" var="element">
												<tr>
													<td><c:out value="${element.type_mission }"></c:out></td>
													<td><a
														href="<%request.getContextPath();%>?id=${element.id_type }&action=edit&value=${element.type_mission }"><i
															class="fa-regular fa-pen-to-square"></i></a></td>
													<td><a
														href="<%request.getContextPath();%>?id=${element.id_type }&action=delete&value=${element.type_mission }"><i
															class="fa-solid fa-trash-can"></i></a></td>
												</tr>
											</c:forEach>
										</c:if>
									</tbody>
								</table>
							</div>
						</div>
						</c:if>
					</div>
				</div>

				<div class="row">
					<div class="col-12 col-xl-6">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">Ajouter / Modifier / Supprimer vos services</h5>
								<form method="post">
									<div class="mb-3 ">
										<label for="exampleInputPassword1" class="form-label">Entrez
											ici un nouveau type d'activité, ou modifier la</label>
										<c:choose>
											<c:when test="${empty value}">
												<input name="inputValue"
													title="texte sans accents, sans caractères spéciaux"
													type="text" class="form-control border"
													id="exampleInputPassword1">
											</c:when>
											<c:when test="${!empty edit}">
												<input name="inputValue"
													title="texte sans accents, sans caractères spéciaux"
													type="text" value="${value}" class="form-control border"
													id="exampleInputPassword1">
											</c:when>
											<c:when test="${!empty delete}">
												<input hidden="hidden"
													title="texte sans accents, sans caractères spéciaux"
													name="inputValue" type="text" value="${value}"
													class="form-control border my-2" id="exampleInputPassword1">
												<p class="text-warning">
													Vous allez supprimer cet élément êtes vous sûr ? <a
														class="text-success"
														href="<c:url value="/TypeActivite"></c:url>">annuler
														ici</a>
												</p>
											</c:when>
										</c:choose>
									</div>
									<button name="valider" type="submit" class="btn btn-primary">Valider</button>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>

		</main>

		<!-- ! Footer -->
		<c:import url="/Footer"></c:import>
	</div>