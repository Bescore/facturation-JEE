package controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UtilisateurDao;
import modele.GetCookie;
import modele.Utilisateur;

/**
 * Servlet implementation class Profil
 */
@WebServlet("/Profil")
public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		// recuperer le token en session
		String token = String.valueOf(session.getAttribute("token"));
		
		
		// on utilise la fonction qui va recuperer le cookie
		String cookie = GetCookie.recupererCookie(request, token);
		if (cookie.equals(token)) { 
		
		request.getRequestDispatcher("jsp/profil.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/Deconnexion");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		//creer nouveau UtilisateurDao
		UtilisateurDao newUtilisateurDao=new UtilisateurDao();
		
		
		//CHANGER LE VISUEL AU CLIQUE DU BOUTON MODIFIER
		if(request.getParameter("modifier")!=null) {
			
			//recuperer l'id  de l'utilisateur selectionné
			int id_user=(int) session.getAttribute("id_user");
			
			//rechercher l'utilisateur et ses infos (by id) et les renvoyer au jsp
			 request.setAttribute("modifier_utilisateur", newUtilisateurDao.FindbyId(id_user).get(0));
			 
			 
		}
		
		if(request.getParameter("valider")!=null 
				&& request.getParameter("nom") != null 
				&& request.getParameter("prenom") != null 
				&& request.getParameter("email") != null 
				&& request.getParameter("adresse") != null
				&& request.getParameter("telephone") != null 
				&& request.getParameter("code_postale") != null 
				&& Pattern.matches("^[a-zA-Z- ]+$", request.getParameter("nom"))
				&& Pattern.matches("^[a-zA-Z- ]+$", request.getParameter("prenom"))
				&& Pattern.matches("^[a-zA-Z0-9._%-]+[@]+[a-zA-Z0-9.-]+[.]+[a-zA-Z]{2,4}$", request.getParameter("email"))
				&& Pattern.matches("[0-9]{1,3}(?:(?:[,. ]){1}[-a-zA-Zàâäéèêëïîôöùûüç]+)+", request.getParameter("adresse"))) {
			
			//on met les données du formulaire dans des variables
			String nom=request.getParameter("nom");
			String prenom=request.getParameter("prenom");
			String email=request.getParameter("email");
			String adresse=request.getParameter("adresse");
			String telephone=request.getParameter("telephone");
			String code_postale=request.getParameter("code_postale");
			
			
			//On recupère l'id de l'utilisateur  dans la session
			int id_user=(int) session.getAttribute("id_user");
			
			//On crée un nouvel utilisateur
			Utilisateur newUser= new Utilisateur();
			
			newUser.setId_personne(id_user);
			newUser.setNom(nom);
			newUser.setPrenom(prenom);
			newUser.setEmail(email);
			newUser.setAdresse(adresse);
			newUser.setTelephone(telephone);
			newUser.setCode_postale(Integer.valueOf(code_postale));
			
			//On lance l'update avec l'utilisateurDao créé plus haut !
			
			
			if (newUtilisateurDao.Update(newUser)) {
			
			//ON met à jour les informations en session
			session.setAttribute("nom", nom);
			session.setAttribute("prenom", prenom);
			session.setAttribute("email", email);
			session.setAttribute("telephone", telephone);
			session.setAttribute("adresse", adresse);
			session.setAttribute("code_postale", code_postale);
			
			}	
		}
		doGet(request, response);
	}

}
