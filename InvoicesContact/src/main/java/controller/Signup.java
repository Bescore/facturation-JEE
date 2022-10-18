package controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UtilisateurDao;
import modele.Utilisateur;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Signup() {
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

		request.getRequestDispatcher("jsp/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// recuperer les informations du formulaire au submit
		String email = request.getParameter("email");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");
		System.out.println(nom);

		if (Pattern.matches("^[a-zA-Z0-9._%-]+[@]+[a-zA-Z0-9.-]+[.]+[a-zA-Z]{2,4}$", email)
				&& Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}.]:;',?/*~$^+=<>]).{8,20}$",
						password)
				&& Pattern.matches("^[a-zA-Z- ]+$", nom) && Pattern.matches("^[a-zA-Z- ]+$", prenom)
				&& password.equals(confirm_password)) {

			if (request.getParameter("connecter") != null && !email.isEmpty() && !nom.isEmpty() && !prenom.isEmpty()
					&& !password.isEmpty() && !confirm_password.isEmpty()) {
				
				// intancier et préparer le modèle
				Utilisateur newUser = new Utilisateur();

				// on lui donne les valeur du formulaire
				newUser.setEmail(email);
				newUser.setNom(nom);
				newUser.setPrenom(prenom);
				newUser.setPassword(password);
				
				// instancier utilisateurDao et faire le create dans la BDD
				UtilisateurDao newUserDao = new UtilisateurDao();
				
				//creer un le user
				newUserDao.Create(newUser);


			}
		}

		doGet(request, response);
	}

}
