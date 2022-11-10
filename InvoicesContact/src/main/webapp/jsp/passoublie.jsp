<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">

<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Mot de passe oublié | IC</title>
<!-- bootstrap 5.0-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<!-- bootstrap js 5.0-->
<script defer
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
			<form class="sign-up-form form" method="post">
				<b>Vérifiez votre boîte mail !</b>
				<div class="text-center m-4">
				<a class="text-primary" href='<c:url value="/Signin"></c:url>'>Se connecter</a>
				</div>
			</form>
			
		</article>
		<!-- ALERT -->




	</main>
	<!-- jquery -->
	<script defer src="https://code.jquery.com/jquery-3.6.1.js"
		integrity="sha256-3zlB5s2uwoUzrXK3BT7AX3FyvojsraNFxCc2vC/7pNI="
		crossorigin="anonymous"></script>
	<!-- Alerts -->
	<script defer src="js/modal_alert.js"></script>
	<!-- Chart library -->
	<script defer src="plugins/chart.min.js"></script>
	<!-- Icons library -->
	<script defer src="plugins/feather.min.js"></script>
	<!-- Custom scripts -->
	<script defer src="js/script.js"></script>
</body>

</html>