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
        <h2 class="main-title">Bonjour </h2>
        <div class="row text-center my-2">
        <div class="col my-2">
        
        <div id="ww_a920196c00efc" v='1.3' loc='id' a='{"t":"ticker","lang":"fr","ids":["wl4529"],"font":"Arial","sl_ics":"one_a","sl_sot":"celsius","cl_bkg":"rgba(0,97,247,1)","cl_font":"#FFFFFF","cl_cloud":"#FFFFFF","cl_persp":"#81D4FA","cl_sun":"#FFC107","cl_moon":"#FFC107","cl_thund":"#FF5722"}'>Weather Data Source: <a href="https://wetterlang.de/paris_wetter_30_tage/" id="ww_a920196c00efc_u" target="_blank">wetter 30 tage Paris</a></div><script async src="https://app1.weatherwidget.org/js/?id=ww_a920196c00efc"></script>
        
        
        </div>
         
        </div>
        <div class="row text-center">
        <div class="col">
       <script src="https://apps.elfsight.com/p/platform.js" defer></script>
<div class="elfsight-app-75292b17-cf39-4276-9e01-57618f7e11bc"></div>
        </div>
       
        </div>
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       
       
        
      </div>
    </main>
			
			
			
			
			
			
			
			
			
			

			<!-- ! Footer -->
			<c:import url="/Footer"></c:import>
	</div>