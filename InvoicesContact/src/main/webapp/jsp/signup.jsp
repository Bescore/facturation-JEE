<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Creer un nouveau compte | IC</title>
<!-- bootstrap 5.0-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<!-- bootstrap js 5.0-->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<!-- Favicon -->
<link rel="shortcut icon" href="img/svg/logo.svg" type="image/x-icon">
<!-- Custom styles -->
<link rel="stylesheet" href="css/style.min.css">
</head>

<body style="background: url('img/background/auth.jpg')">
	<div class="layer"></div>
	<main class="page-center">
		<article class="sign-up">
			<h1 class="text-light sign-up__title">Vous allez recréer un compte</h1>
			<form class="sign-up-form form"  method="post">
				<label class="form-label-wrapper">
					<span  class="form-label">Nom</span> <input name="nom" class="form-input" type="text"
					required>
				</label> <label class="form-label-wrapper">
					<span class="form-label">Prenom</span> <input name="prenom" class="form-input"
					type="text" required>
				</label> <label class="form-label-wrapper">
					<span class="form-label">Email</span> <input name="email" class="form-input"
					type="email" required>
				</label>
				<label class="form-label-wrapper">
					<span class="form-label">Téléphone</span> <input min="0" name="telephone" class="form-input"
					type="number" required>
				</label> <label class="form-label-wrapper">
					<span class="form-label">Mot de passe</span> <input name="password" class="form-input"
					type="password" required>
				</label> <label class="form-label-wrapper">
					<span class="form-label">Confirmer mot de passe</span> <input name="confirm_password"
					class="form-input" type="password" required>
				</label>
				<button name="connecter" class="form-btn primary-default-btn transparent-btn">Se
					connecter</button>
			</form>
		</article>
	</main>
	<!-- Chart library -->
	<script src="./plugins/chart.min.js"></script>
	<!-- Icons library -->
	<script src="plugins/feather.min.js"></script>
	<!-- Custom scripts -->
	<script src="js/script.js"></script>
</body>

</html>