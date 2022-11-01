<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!-- ! Footer -->
<footer class="footer">
	<div class="container footer--flex">
		<div class="footer-start">
			<p>2022 © Invoices and contact</p>
		</div>
		<ul class="footer-end">
			<li><a
				href="https://www.linkedin.com/in/jean-marie-lator-74543a202/">About</a></li>
			<li><a href="mailto:jeanmar-97.1@hotmail.fr">Support</a></li>
			<li><a href="https://github.com/Bescore">Github</a></li>
		</ul>
	</div>
</footer>
<div id="fademe"
	style="height: 100%; width: 100%; background-color: white; position: absolute; top: 0; right: 0; z-index: 10;"></div>

<script>
	$(document).ready(function() {
		$('#fademe').fadeOut(500);
	});
</script>

<!-- fontawsome cdn -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />


<script src="/html2pdf.bundle.min.js"></script>
<!-- printThis -->
<script defer src="js/printThis.js"></script>
<!-- genererFacture -->
<script defer src="js/genererFacture.js"></script>
<!-- Alerts -->
<script defer src="js/modal_alerts"></script>
<!-- Chart library -->
<script defer src="plugins/chart.min.js"></script>
<!-- Icons library -->
<script defer src="plugins/feather.min.js"></script>
<!-- Custom scripts -->
<script defer src="js/script.js"></script>

</body>
</html>