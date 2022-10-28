package controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TypeDao;
import modele.GetCookie;
import modele.Type;

/**
 * Servlet implementation class TypeActivite
 */
@WebServlet("/TypeActivite")
public class TypeActivite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TypeActivite() {
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
			
			// afficher la valeur dans l'input quand on clique sur modifier
			if (request.getParameter("value") != null) {
				request.setAttribute("value", request.getParameter("value"));

			}
			// afficher l'input delete si le parametre delete est presént
			if (request.getParameter("action") != null && request.getParameter("action").equals("delete")) {
				request.setAttribute("delete", 1);

			}
			// afficher l'input edit si le parametre edit est presént
			if (request.getParameter("action") != null && request.getParameter("action").equals("edit")) {
				request.setAttribute("edit", 1);

			}

			// afficher la liste des types
			// instancier TypeDao
			TypeDao newTypeDao = new TypeDao();

			// Setattribute and read
			request.setAttribute("types", newTypeDao.Read());

			request.getRequestDispatcher("jsp/typeactivite.jsp").forward(request, response);
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

		// on récupère les valeurs des champs
		String inputValue = request.getParameter("inputValue");

		// instancier un modele type
		Type newType = new Type();
		// instancer un dao type
		TypeDao newTypeDao = new TypeDao();

		// verifie si le bouton est cliqué, si on a bien un parametre id, si ce qui est
		// dans le champs est valide
		if (request.getParameter("valider") != null && request.getParameter("id") != null
				&& Pattern.matches("^[a-zA-Z ',]+$", inputValue)) {

			// recuperer l'id
			int id = Integer.valueOf(request.getParameter("id"));

			// utiliser un switch selon qu'on edit ou delete
			switch (request.getParameter("action")) {
			case "edit": {
				//UPDATE
				// recuperer la valeur du champs dans le type et id
				newType.setType_mission(inputValue);
				newType.setId_type(id);

				// faire l'edit
				newTypeDao.Update(newType);

				response.sendRedirect(request.getContextPath() + "/TypeActivite");
				break;
			}
			case "delete": {
				//DELETE
				// recuperer l'id
				newType.setId_type(id);

				// faire le delete
				newTypeDao.Delete(newType);

				response.sendRedirect(request.getContextPath() + "/TypeActivite");
				break;
			}
			default:
				doGet(request, response);
			}
			// fin si on ne rempli pas la toute premiere condition ( edit ou delete)
		} else {
			// si on arrive sur la page et on clique sur valider avec une entrée
			if (request.getParameter("valider") != null && inputValue != null && !inputValue.isEmpty()
					&& Pattern.matches("^[a-zA-Z- ',]+$", inputValue)) {
				//CREATE
				// recuperer la valeur du champs dans le type et id
				newType.setType_mission(inputValue);
				// faire le create
				newTypeDao.Create(newType);
				response.sendRedirect(request.getContextPath() + "/TypeActivite");
				
				//si rien n'est valide on revient à la page TypeActivite avec le do get
			} else {
				doGet(request, response);
			}
		}

	}

}
