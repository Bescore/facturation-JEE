package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClientDao;
import dao.TypeDao;
import modele.Clients;
import modele.GetCookie;

/**
 * Servlet implementation class Recherche
 */
@WebServlet("/Recherche")
public class Recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Recherche() {
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

			if (request.getParameter("recherche_input") != null && !request.getParameter("recherche_input").isEmpty()) {

				String motRecherche = request.getParameter("recherche_input");

				// creer un client
				Clients newClient = new Clients();

				newClient.setNom(motRecherche);

				// Creer un clientDao
				ClientDao newClientDao = new ClientDao();

				if (newClientDao.SearchClient(newClient).size() != 0) {

					// READ et set ATTRIBUTE
					request.setAttribute("resultat", newClientDao.SearchClient(newClient));

				}

			}
			request.getRequestDispatcher("jsp/recherche.jsp").include(request, response);
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
		doGet(request, response);
	}

}
