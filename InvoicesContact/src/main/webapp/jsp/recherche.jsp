<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
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
	<!-- Ne pas envlever cette div, necessaire au mecanisme de certaines popup -->
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
					<c:if test="${!empty resultat }">
						<h2 class="main-title my-2">Résultat de votre recherche</h2>
						<div class="row mx-auto">
							<div class="card ">
								<div class="card-body table-responsive">
									<div class="col-12 col-xl my-2 ">

										<table class="text-center table table table-bordered">
											<thead>
												<tr>
													<th scope="col">Nom</th>
													<th scope="col">Prenom</th>
													<th scope="col">Email</th>
													<th scope="col">Téléphone</th>
													<th scope="col">Adresse</th>
													<th scope="col">Code postale</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${resultat }" var="element">
													<tr>
														<td>${element.nom }</td>
														<td>${element.prenom }</td>
														<td>${element.email }</td>
														<td>${element.telephone}</td>
														<td>${element.adresse }</td>
														<td>${element.code_postale }</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>

									</div>
								</div>
							</div>
					</c:if>
					<c:if test="${empty resultat }">
						<h2 class="main-title my-2">Aucun Résultat</h2>
						<div class="row mx-auto">
							<div class="card ">
								<div class="card-body table-responsive" style="width: 70%">
									<img alt="down" src="img/background/down.svg">
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