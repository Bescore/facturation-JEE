<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Type d'activité</title>
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
        <div class="card">
  <div class="card-body table-responsive">
    <h5 class="card-title">Liste des types disponibles</h5>
    <table class="table table-striped">
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
  <c:if test="${!empty clients }">
  <c:forEach items="${types }" var="element">
    <tr>
      <th scope="row"><c:out value="${element.id_client }"></c:out></th>
      <td><c:out value="${element.type_mission }"></c:out></td>
      <td><a href="<%request.getContextPath();%>?id=${element.id_personne }&action=edit"><i class="fa-regular fa-pen-to-square"></i></a></td>
      <td><a href="<%request.getContextPath();%>?id=${element.id_personne }&action=delete"><i class="fa-solid fa-trash-can"></i></a></td>
    </tr>
    </c:forEach>
    </c:if>
  </tbody>
</table>
  </div>
  </div>
  </div>
  </div>
       
       <div class="row">
        <div class="col-12 col-xl-6 ">
        <div class="card">
  <div class="card-body">
    <h5 class="card-title">Ajouter / Modifier / Supprimer</h5>
    <form  method="post">
  <div class="mb-3 ">
    <label  for="exampleInputPassword1" class="form-label">Nom</label>
    <input name="inputValue" title="texte sans accents, sans caractères spéciaux" type="text" class="form-control border" id="exampleInputPassword1">
  </div>
  <div class="mb-3 ">
    <label  for="exampleInputPassword1" class="form-label">Prenom</label>
    <input name="inputValue" title="texte sans accents, sans caractères spéciaux" type="text" class="form-control border" id="exampleInputPassword1">
  </div>
  <div class="mb-3 ">
    <label  for="exampleInputPassword1" class="form-label">Téléphone</label>
    <input name="inputValue" title="texte sans accents, sans caractères spéciaux" type="text" class="form-control border" id="exampleInputPassword1">
  </div>
  <div class="mb-3 ">
    <label  for="exampleInputPassword1" class="form-label">Email</label>
    <input name="inputValue" title="texte sans accents, sans caractères spéciaux" type="text" class="form-control border" id="exampleInputPassword1">
  </div>
  <div class="mb-3 ">
    <label  for="exampleInputPassword1" class="form-label">Adresse</label>
    <input name="inputValue" title="texte sans accents, sans caractères spéciaux" type="text" class="form-control border" id="exampleInputPassword1">
  </div>
  <div class="mb-3 ">
    <label  for="exampleInputPassword1" class="form-label">Code postale</label>
    <input name="inputValue" title="texte sans accents, sans caractères spéciaux" type="number" class="form-control border" id="exampleInputPassword1">
  </div>
  <button name="valider" type="submit" class="btn btn-primary">Valider</button>
</form>
  </div>
        </div>
       </div> 
      </div>
    </main>

			<!-- ! Footer -->
			<c:import url="/Footer"></c:import>
	</div>