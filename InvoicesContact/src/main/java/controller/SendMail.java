package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class SendMail
 */
@WebServlet("/SendMail")
public class SendMail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendMail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//session
		HttpSession session = request.getSession();
		
		//générer une facture
		if( request.getParameter("nom")!=null ) {
			
			String nom_user=(String) session.getAttribute("nom");
			String prenom_user=(String) session.getAttribute("prenom");
			String adresse_user=(String) session.getAttribute("adresse");
			String mail_user=(String) session.getAttribute("mail");
			
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			String email=request.getParameter("email");
			String adresse=request.getParameter("adresse");
			String totalHeure=request.getParameter("totalHeure");
			String telephone=request.getParameter("tel");
			String apayer=request.getParameter("apayer");
			String datetime=request.getParameter("datetime");
			
			
			//SendMail.envoi(mois, annee)
			
			String message="<h2>Facture par : "+nom_user+" "+prenom_user+"</h2><hr><br><div>Nom : "+nom+"</div><br><div> Prenom : "+prenom+"</div><br><div> Adresse"
					+ " : "+adresse+"</div><br><div> Total d'heures travaillé : "+totalHeure+"</div><br><div> Telephone"
							+ " : "+telephone+"</div><br><div> A règler : "+apayer+" €</div><br>" ;
			
			String message1="<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "	<head>\r\n"
					+ "		<meta charset=\"utf-8\" />\r\n"
					+ "		<title>Facture</title>\r\n"
					+ "\r\n"
					+ "		<style>\r\n"
					+ "			.invoice-box {\r\n"
					+ "				max-width: 800px;\r\n"
					+ "				margin: auto;\r\n"
					+ "				padding: 30px;\r\n"
					+ "				border: 1px solid #eee;\r\n"
					+ "				box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);\r\n"
					+ "				font-size: 16px;\r\n"
					+ "				line-height: 24px;\r\n"
					+ "				font-family: \"Helvetica Neue\", \"Helvetica\", Helvetica, Arial, sans-serif;\r\n"
					+ "				color: #555;\r\n"
					+ "			}\r\n"
					+ "\r\n"
					+ "			.invoice-box table {\r\n"
					+ "				width: 100%;\r\n"
					+ "				line-height: inherit;\r\n"
					+ "				text-align: left;\r\n"
					+ "			}\r\n"
					+ "\r\n"
					+ "			.invoice-box table td {\r\n"
					+ "				padding: 5px;\r\n"
					+ "				vertical-align: top;\r\n"
					+ "			}\r\n"
					+ "\r\n"
					+ "			.invoice-box table tr td:nth-child(2) {\r\n"
					+ "				text-align: right;\r\n"
					+ "			}\r\n"
					+ "\r\n"
					+ "			.invoice-box table tr.top table td {\r\n"
					+ "				padding-bottom: 20px;\r\n"
					+ "			}\r\n"
					+ "\r\n"
					+ "			.invoice-box table tr.top table td.title {\r\n"
					+ "				font-size: 45px;\r\n"
					+ "				line-height: 45px;\r\n"
					+ "				color: #333;\r\n"
					+ "			}\r\n"
					+ "\r\n"
					+ "			.invoice-box table tr.information table td {\r\n"
					+ "				padding-bottom: 40px;\r\n"
					+ "			}\r\n"
					+ "\r\n"
					+ "			.invoice-box table tr.heading td {\r\n"
					+ "				background: #eee;\r\n"
					+ "				border-bottom: 1px solid #ddd;\r\n"
					+ "				font-weight: bold;\r\n"
					+ "			}\r\n"
					+ "\r\n"
					+ "			.invoice-box table tr.details td {\r\n"
					+ "				padding-bottom: 20px;\r\n"
					+ "			}\r\n"
					+ "\r\n"
					+ "			.invoice-box table tr.item td {\r\n"
					+ "				border-bottom: 1px solid #eee;\r\n"
					+ "			}\r\n"
					+ "\r\n"
					+ "			.invoice-box table tr.item.last td {\r\n"
					+ "				border-bottom: none;\r\n"
					+ "			}\r\n"
					+ "\r\n"
					+ "			.invoice-box table tr.total td:nth-child(2) {\r\n"
					+ "				border-top: 2px solid #eee;\r\n"
					+ "				font-weight: bold;\r\n"
					+ "			}\r\n"
					+ "\r\n"
					+ "			@media only screen and (max-width: 600px) {\r\n"
					+ "				.invoice-box table tr.top table td {\r\n"
					+ "					width: 100%;\r\n"
					+ "					display: block;\r\n"
					+ "					text-align: center;\r\n"
					+ "				}\r\n"
					+ "\r\n"
					+ "				.invoice-box table tr.information table td {\r\n"
					+ "					width: 100%;\r\n"
					+ "					display: block;\r\n"
					+ "					text-align: center;\r\n"
					+ "				}\r\n"
					+ "			}\r\n"
					+ "\r\n"
					+ "			/** RTL **/\r\n"
					+ "			.invoice-box.rtl {\r\n"
					+ "				direction: rtl;\r\n"
					+ "				font-family: Tahoma, \"Helvetica Neue\", \"Helvetica\", Helvetica, Arial,\r\n"
					+ "					sans-serif;\r\n"
					+ "			}\r\n"
					+ "\r\n"
					+ "			.invoice-box.rtl table {\r\n"
					+ "				text-align: right;\r\n"
					+ "			}\r\n"
					+ "\r\n"
					+ "			.invoice-box.rtl table tr td:nth-child(2) {\r\n"
					+ "				text-align: left;\r\n"
					+ "			}\r\n"
					+ "		</style>\r\n"
					+ "	</head>\r\n"
					+ "\r\n"
					+ "	<body>\r\n"
					+ "		<div class=\"invoice-box\">\r\n"
					+ "			<table cellpadding=\"0\" cellspacing=\"0\">\r\n"
					+ "				<tr class=\"top\">\r\n"
					+ "					<td colspan=\"2\">\r\n"
					+ "						<table>\r\n"
					+ "							<tr>\r\n"
					+ "								<td class=\"title\">\r\n"
					+ "									<img\r\n"
					+ "										src='https://publicdomainvectors.org/photos/secretlondon_Blue_eye.png'\r\n"
					+ "										style=\"width: 100%; max-width: 100px\"\r\n"
					+ "									/>\r\n"
					+ "								</td>\r\n"
					+ "\r\n"
					+ "								<td>\r\n"
					+ "									Facture par : "+nom_user+" "+prenom_user+"<br />\r\n"
					+ "									Créé: "+datetime+"<br />\r\n"
					+ "								</td>\r\n"
					+ "							</tr>\r\n"
					+ "						</table>\r\n"
					+ "					</td>\r\n"
					+ "				</tr>\r\n"
					+ "\r\n"
					+ "				<tr class=\"information\">\r\n"
					+ "					<td colspan=\"2\">\r\n"
					+ "						<table>\r\n"
					+ "							<tr>\r\n"
					+ "								<td>\r\n"
					+ "									Entreprise "+nom_user+" "+prenom_user+".<br />\r\n"
					+ "									Adresse : "+adresse_user+"<br />\r\n"
					+ "								</td>\r\n"
					+ "\r\n"
					+ "								<td>\r\n"
					+ "									"+nom+" "+prenom+"<br />\r\n"
					+ "									"+email+"<br />\r\n"
					+ "									"+telephone+"<br />\r\n"
					+ "									"+adresse+"<br />\r\n"
					+ "								</td>\r\n"
					+ "							</tr>\r\n"
					+ "						</table>\r\n"
					+ "					</td>\r\n"
					+ "				</tr>\r\n"
					+ "\r\n"
					+ "				<tr class=\"heading\">\r\n"
					+ "					<td>Méthode de paiement possible via cette facture</td>\r\n"
					+ "\r\n"
					+ "					<td>Paypal / Carte Bancaire</td>\r\n"
					+ "				</tr>\r\n"
					+ "\r\n"
					+ "				<tr class=\"details\">\r\n"
					+ "					<td>Lien ici</td>\r\n"
					+ "				</tr>\r\n"
					+ "\r\n"
					+ "				<tr class=\"heading\">\r\n"
					+ "					<td>Total d'heures</td>\r\n"
					+ "\r\n"
					+ "					<td>Montant à règler</td>\r\n"
					+ "				</tr>\r\n"
					+ "\r\n"
					+ "				<tr class=\"item\">\r\n"
					+ "					<td>"+totalHeure+"</td>\r\n"
					+ "\r\n"
					+ "					<td></td>\r\n"
					+ "				</tr>\r\n"
					+ "				<tr class=\"total\">\r\n"
					+ "					<td></td>\r\n"
					+ "\r\n"
					+ "					<td>Total : "+apayer+" euros</td>\r\n"
					+ "				</tr>\r\n"
					+ "			</table>\r\n"
					+ "		</div>\r\n"
					+ "	</body>\r\n"
					+ "</html>";
			modele.SendMail.envoi(email,message1);

		}
		response.sendRedirect(request.getContextPath() + "/Mesheures");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
