package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ActiviteDao;
import dao.ClientDao;
import modele.ActiviteJournaliere;
import modele.Calculs;
import modele.Clients;
import modele.GetCookie;

/**
 * Servlet implementation class Mesheures
 */
@WebServlet("/Mesheures")
public class Mesheures extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Mesheures() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		// recuperer le token en session
		String token = String.valueOf(session.getAttribute("token"));

		// creer clientdao
		ClientDao newClientDao = new ClientDao();

		// on utilise la fonction qui va recuperer le cookie
		String cookie = GetCookie.recupererCookie(request, token);
		if (cookie.equals(token)) { 

			// READ DES CLIENTS
			// declencher la methode et l'envoyer au jsp
			request.setAttribute("clients", newClientDao.Read());

			// année courate, affichage dans le jsp
			request.setAttribute("annee", Calendar.getInstance().get(Calendar.YEAR));
			
			//recuperer l'heure et la date courante (sera utilisé pour la facture
			SimpleDateFormat formatter = new SimpleDateFormat(" dd-MM-yyyy à HH:mm:ss");
			request.setAttribute("dateEtHeure", formatter.format(Calendar.getInstance().getTime()));

			request.getRequestDispatcher("jsp/mesheures.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/Deconnexion");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// recuperer les informations client/mois/année
		String idClient = request.getParameter("client");
		String mois = request.getParameter("mois");
		String annee = request.getParameter("annee");

		// creer activiteDao
		ActiviteDao newActiviteDao = new ActiviteDao();
		// creer client
		Clients newClient = new Clients();
		// cree activite
		ActiviteJournaliere newActivite = new ActiviteJournaliere();

		if (request.getParameter("selectionner") != null && idClient != null && mois != null
				&& Pattern.matches("^[0-9]{4}$", annee)) {

			// ajouter l'id client au nouveau client
			newClient.setId_personne(Integer.valueOf(idClient));

			// ajouter le client à la nouvelle activite
			newActivite.setClient(newClient);
			if (newActiviteDao.FindbyMoisAnnee(newActivite, Integer.valueOf(mois), annee).size() != 0) {

				// READ DES ACTIVITES SELON LE CLIENT ET LES DATES ET ENVOI AU JSP(prend 3
				// paramètres voir la methode)
				request.setAttribute("activites",
						newActiviteDao.FindbyMoisAnnee(newActivite, Integer.valueOf(mois), annee));

				// calcule du total d'heures effectués
				request.setAttribute("total_heure", Calculs
						.CalculTotalHeure(newActiviteDao.FindbyMoisAnnee(newActivite, Integer.valueOf(mois), annee)));

				// calcule de gain brut
				request.setAttribute("gains_brut", Calculs
						.CalculGainsBrut(newActiviteDao.FindbyMoisAnnee(newActivite, Integer.valueOf(mois), annee)));

				// estimation de la somme récupéré par l'ursaff sur ce client
				request.setAttribute("ursaff_prevision", Calculs
						.CalculUrsaff(newActiviteDao.FindbyMoisAnnee(newActivite, Integer.valueOf(mois), annee)));

				// gain net
				request.setAttribute("gains_net", Calculs
						.CalculGainNet(newActiviteDao.FindbyMoisAnnee(newActivite, Integer.valueOf(mois), annee)));
			} else {
				request.setAttribute("erreur", 1);
			}
			// pour recuperer info client
			if (newActiviteDao.FindbyMoisAnnee(newActivite, Integer.valueOf(mois), annee).size() != 0) {
				
				request.setAttribute("ce_client", newActiviteDao
						.FindbyMoisAnnee(newActivite, Integer.valueOf(mois), annee).get(0).getClient());
				
			}
		}
		doGet(request, response);
	}

}
