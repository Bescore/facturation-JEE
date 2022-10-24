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
					<div class="row mx-auto">
						<div class="col col-xl my-2 ">

							<div class="card ">
								<div class="card-body ">
									<h5 class="my-3">Mes heures</h5>
									<h6 class="my-3">Client</h6>

									<select name="client" class="form-select"
										aria-label="Default select example">

										<option value=""><c:out value=""></c:out></option>

									</select>
									<h6 class="my-3">Mois</h6>
									<select name="mois" class="form-select"
										aria-label="Default select example">

										<option value=""><c:out value=""></c:out></option>

									</select>
									<h6 class="my-3">Année</h6>
									<div>
										<input value="2022" type="number" min="2022" size="4">
									</div>
									<button name="selectionner_mois" type="submit"
										class="btn btn-primary my-4">Selectionner client</button>

								</div>
								<div></div>
							</div>
						</div>

						<div class="col col-xl my-2 ">
							<div class="row">

								<div class="col col-xl my-2 ">

									<div class="card text-center ">
										<div class="card-body px-5 ">
											<h5 class="my-3">Total d'heures du mois</h5>
											<hr>


										</div>
										<div></div>
									</div>
								</div>
								<div class="col col-xl my-2 ">

									<div class="card text-center ">
										<div class="card-body px-5 ">
											<h5 class="my-3">Argent gagné</h5>
											<hr>


										</div>
										<div></div>
									</div>
								</div>
							</div>
							<div class="row">

								<div class="col col-xl my-2 ">

									<div class="card text-center ">
										<div class="card-body px-5 ">
											<h5 class="my-3">Prévision URSAFF</h5>
											<hr>


										</div>
										<div></div>
									</div>
								</div>
								<div class="col col-xl my-2 ">

									<div class="card text-center ">
										<div class="card-body px-5 ">
											<h5 class="my-3">Gain net</h5>
											<hr>


										</div>
										<div></div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row mx-auto">
						<div class="col col-xl my-2 ">

							<div class="card mx-auto ">
								<div class="card-body  table-responsive">

									<table class="table">
										<thead>
											<tr>
												<th scope="col">#</th>
												<th scope="col">First</th>
												<th scope="col">Last</th>
												<th scope="col">Handle</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<th scope="row">1</th>
												<td>Mark</td>
												<td>Otto</td>
												<td>@mdo</td>
											</tr>
											<tr>
												<th scope="row">2</th>
												<td>Jacob</td>
												<td>Thornton</td>
												<td>@fat</td>
											</tr>
											<tr>
												<th scope="row">3</th>
												<td colspan="2">Larry the Bird</td>
												<td>@twitter</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</main>
		<!-- ! Footer -->
		<c:import url="/Footer"></c:import>
	</div>