package controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCrypt;

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
	@SuppressWarnings("static-access")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		BCrypt encoder = new BCrypt();

		// verifier les champs attendu
		if (request.getParameter("token") != null && request.getParameter("token").length() == 60
				&& request.getParameter("secret") != null && encoder.checkpw("bibi", request.getParameter("secret"))
				&& request.getParameter("name") != null && request.getParameter("name").equals("dutaud")) {

			request.getRequestDispatcher("jsp/signup.jsp").forward(request, response);
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

		// recuperer les informations du formulaire au submit
		String email = request.getParameter("email");
		String nom = request.getParameter("nom");
		String telephone = request.getParameter("telephone");
		String prenom = request.getParameter("prenom");
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("confirm_password");

		if (Pattern.matches("^[a-zA-Z0-9._%-]+[@]+[a-zA-Z0-9.-]+[.]+[a-zA-Z]{2,4}$", email)
				&& Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()�[{}.]:;',?/*~$^+=<>]).{8,20}$",
						password)
				&& Pattern.matches("^[a-zA-Z- ]+$", nom) && Pattern.matches("^[a-zA-Z- ]+$", prenom)
				&& password.equals(confirm_password)) {

			if (request.getParameter("connecter") != null && !email.isEmpty() && !nom.isEmpty() && !prenom.isEmpty()
					&& !password.isEmpty() && !confirm_password.isEmpty() && !telephone.isEmpty()) {

				// intancier et pr�parer le mod�le
				Utilisateur newUser = new Utilisateur();

				// on lui donne les valeur du formulaire
				newUser.setEmail(email);
				newUser.setNom(nom);
				newUser.setPrenom(prenom);
				newUser.setTelephone(telephone);
				newUser.setPassword(password);

				// instancier utilisateurDao et faire le create dans la BDD
				UtilisateurDao newUserDao = new UtilisateurDao();

				// creer un le user
				newUserDao.Create(newUser);

				response.sendRedirect(request.getContextPath() + "/Signup");
				return;
			} else {
				doGet(request, response);
				return;
			}
		}

		doGet(request, response);
	}

}
