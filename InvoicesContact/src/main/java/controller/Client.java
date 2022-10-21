package controller;

import java.io.IOException;

import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClientDao;
import modele.Clients;
import modele.GetCookie;

/**
 * Servlet implementation class Client
 */
@WebServlet("/Client")
public class Client extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Client() {
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

		// on utilise la fonction qui va recuperer le cookie
		String cookie = GetCookie.recupererCookie(request, token);
		if (cookie.equals(token)) {
			
		//Afficher les clients
		//creer un clientDao
		ClientDao newClientDao=new ClientDao();
		
		//declencher le read et envoit vers le jsp
		request.setAttribute("clients",newClientDao.Read());
			
			
		request.getRequestDispatcher("jsp/client.jsp").forward(request, response);
		}else {
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
		//AJOUTER CLIENT
		// recuperer les Èlements du formulaire
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		String adresse = request.getParameter("adresse");
		String code_postale = request.getParameter("code_postale");
		
		// creer client dao 
		ClientDao newClientDao = new ClientDao();

		if (request.getParameter("valider") != null && nom != null && prenom != null && email != null && adresse != null
				&& telephone != null && code_postale != null && Pattern.matches("^[a-zA-Z- ]+$", nom)
				&& Pattern.matches("^[a-zA-Z- ]+$", prenom)
				&& Pattern.matches("^[a-zA-Z0-9._%-]+[@]+[a-zA-Z0-9.-]+[.]+[a-zA-Z]{2,4}$", email)
				&& Pattern.matches("[0-9]{1,3}(?:(?:[,. ]){1}[-a-zA-Z‡‚‰ÈËÍÎÔÓÙˆ˘˚¸Á]+)+", adresse)) {

			// creer un nouveau client
			Clients newClient = new Clients();

			newClient.setNom(nom);
			newClient.setPrenom(prenom);
			newClient.setTelephone(telephone);
			newClient.setEmail(email);
			newClient.setAdresse(adresse);
			newClient.setCode_postale(Integer.valueOf(code_postale));

			
			//declancher la methode create
			newClientDao.Create(newClient);

		}
		
		//AFFICHER TABLEAU CLIENT
		if(request.getParameter("afficher_tableau")!=null) {
			
			//set attribute pour declencher l'affichage
			request.setAttribute("afficheTableau", 1);
			
		}
		//MODIFIER CLIENT(METTRE LES INFOS DANS LES CHAMPS AU CLIQUE DU BOUTON MODIFIER SOUS LE SELECT)
		if(request.getParameter("update_client")!=null&& request.getParameter("selection")!=null) {
			
			//recuperer l'id  du client selectionnÈ
			int idClient=Integer.valueOf(request.getParameter("selection"));
			
			//rechercher l'utilisateur et ses infos (by id) et les renvoyer au jsp
			 request.setAttribute("client_a_modifier", newClientDao.FindbyId(idClient));
			 
			 
		}
		//MODIFIER LE CLIENT(SI L'AFFICHAGE DU CLIENT DANS LES CHAMPS S'EST BIEN PASSEE)
		if (request.getParameter("modifier") != null && nom != null && prenom != null && email != null && adresse != null
				&& telephone != null && code_postale != null && Pattern.matches("^[a-zA-Z- ]+$", nom)
				&& Pattern.matches("^[a-zA-Z- ]+$", prenom)
				&& Pattern.matches("^[a-zA-Z0-9._%-]+[@]+[a-zA-Z0-9.-]+[.]+[a-zA-Z]{2,4}$", email)
				&& Pattern.matches("[0-9]{1,3}(?:(?:[,. ]){1}[-a-zA-Z‡‚‰ÈËÍÎÔÓÙˆ˘˚¸Á]+)+", adresse)) {
			
			// creer un nouveau client
			Clients newClient = new Clients();
			
			newClient.setNom(nom);
			newClient.setPrenom(prenom);
			newClient.setTelephone(telephone);
			newClient.setEmail(email);
			newClient.setAdresse(adresse);
			newClient.setCode_postale(Integer.valueOf(code_postale));
			
			//declancher la methode update
			newClientDao.Update(newClient);

		}
		//SUPPRIMER CLIENT
		if (request.getParameter("delete_client") != null && request.getParameter("email")!=null) {
			
			// creer un nouveau client
			Clients newClient = new Clients();
			
			//ajouter l'id ‡ l'objet
			newClient.setEmail(request.getParameter("email"));
			
			//declencher la methode delete
			newClientDao.Delete(newClient);
		}
		

		doGet(request, response);
	}

}
