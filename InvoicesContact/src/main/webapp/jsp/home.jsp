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
        <h2 class="main-title my-2">Météo aujourd'hui</h2>
        <div class="row">
        <div class="col-xl-4 ">
        
<div  id="ww_4b91c79dbcd16" v='1.3' loc='id' a='{"t":"horizontal","lang":"fr","ids":[],"font":"Arial","sl_ics":"one_a","sl_sot":"celsius","cl_bkg":"rgba(0,97,247,1)","cl_font":"#FFFFFF","cl_cloud":"#FFFFFF","cl_persp":"#81D4FA","cl_sun":"#FFC107","cl_moon":"#FFC107","cl_thund":"#FF5722"}'>Weather Data Source: <a href="https://wetterlang.de/paris_wetter_30_tage/" id="ww_4b91c79dbcd16_u" target="_blank">Paris wetter 30 tage</a></div><script async src="https://app1.weatherwidget.org/js/?id=ww_4b91c79dbcd16"></script>
        
        </div>
        <div class="col-xl-8 my-auto">
        <div id="ww_5b3e74b852e56" v='1.3' loc='id' a='{"t":"ticker","lang":"fr","ids":["wl4529"],"font":"Arial","sl_ics":"one_a","sl_sot":"celsius","cl_bkg":"rgba(0,97,247,1)","cl_font":"#FFFFFF","cl_cloud":"#FFFFFF","cl_persp":"#81D4FA","cl_sun":"#FFC107","cl_moon":"#FFC107","cl_thund":"#FF5722"}'>Weather Data Source: <a href="https://wetterlang.de/paris_wetter_30_tage/" id="ww_5b3e74b852e56_u" target="_blank">wetterlang.de</a></div><script async src="https://app1.weatherwidget.org/js/?id=ww_5b3e74b852e56"></script>
        </div>
        </div>
        <div class="row">
      
       <div class="col">
       <h2 class="main-title  my-1">Actualités </h2>
       <script defer src="https://apps.elfsight.com/p/platform.js"></script>
<div class="elfsight-app-75292b17-cf39-4276-9e01-57618f7e11bc"></div>
        </div>
        </div>
        
      </div>
    </main>

			<!-- ! Footer -->
			<c:import url="/Footer"></c:import>
	</div>