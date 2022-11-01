<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Paiement</title>
<!-- Font awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
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
<!-- Paypal -->
<script
	src="https://www.paypal.com/sdk/js?client-id=AT_x8pu54r3q_wqaOm1HZ_PTNDc8XkDfPxCzYDNZ3lQoBRt8_p6Cm9-83gghAWadYCQRZEITcrs0jPod&currency=USD"></script>
<script defer src="js/paypal.js"></script>
</head>

</head>
<body>
	<div class="container">
		<br>
		<br>
		<h1 class="text-center m-4">Paiement</h1>
		<div class="row ">
			<div class="col-12 col-xl">
				<div class="card">
					<div class="card-body table-responsive">
						<img alt="paiement" src="img/background/paiement.svg">
					</div>
				</div>
			</div>
			<c:if test="${ empty paid}">
				<div class="col-12 col-xl  my-2">
					<div class="card p-5">
						<c:if test="${not empty verification_ok }">
							<b class="card-body table-responsive m-2">
								Bienvenue ${facture.client.prenom } vous êtes sur le point de
								régler <b>${value}</b> €
							</b>
							<hr>
						</c:if>
						<form id="myForm" method="post" class=" text-center">
							<c:if test="${not empty verification_ok }">
								<div id="paypal-button-container"></div>
								<input hidden="hidden" id="v" name="v" type="text" value="${value}">
							</c:if>
						</form>
					</div>
				</div>
			</c:if>
			<c:if test="${ !empty paid}">
				<div class="col-12 col-xl  my-2">
					<div class="card p-5">
						<div class="card-body table-responsive m-2">
							<b>Cette facture est payée merci !</b>
							<hr>
							<div class="text-center"><i class="fa-solid fa-circle-check fa-4x text-success"></i></div>
						</div>
						
					</div>
				</div>
			</c:if>
		</div>
	</div>
</body>
</html>