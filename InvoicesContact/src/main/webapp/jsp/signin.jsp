<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="fr">

<head>

  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Connexion | IC</title>
  <!-- bootstrap 5.0-->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
  <!-- bootstrap js 5.0-->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
  <!-- Favicon -->
  <link rel="shortcut icon" href="img/svg/logo.svg" type="image/x-icon">
  <!-- Custom styles -->
  <link rel="stylesheet" href="css/style.min.css">
</head>

<body  style="background: url('img/background/auth.jpg')">
  <div class="layer"></div>
<main class="page-center">
  <article class="sign-up">
    <h1 class="text-light sign-up__title">Bienvenue !</h1>
    <p class=" text-dark sign-up__subtitle">connectez-vous pour continuer</p>
    <form class="sign-up-form form" action="" method="">
      <label class="form-label-wrapper">
        <p class="form-label">Email</p>
        <input class="form-input" type="email" placeholder="entrer votre email" required>
      </label>
      <label class="form-label-wrapper">
        <p class="form-label">Mot de passe</p>
        <input class="form-input" type="password" placeholder="entrer votre mot de passe" required>
      </label>
      <a class="link-info forget-link" href="##">Mot de passe oublié?</a>
      <label class="form-checkbox-wrapper">
        <input class="form-checkbox" type="checkbox" required>
        <span class="form-checkbox-label">Se rappeler de moi la prochaine fois</span>
      </label>
      <button class="form-btn primary-default-btn transparent-btn">Se connecter</button>
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