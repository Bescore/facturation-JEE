package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FactureDao;

/**
 * Servlet implementation class DeleteFacture
 */
@WebServlet("/DeleteFacture")
public class DeleteFacture extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteFacture() {
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

		// creer nouvelle facture
		modele.Facture newFacture = new modele.Facture();

		// creer une factureDao
		FactureDao newFactureDao = new FactureDao();

		if (request.getParameter("action") != null && request.getParameter("id") != null
				&& !request.getParameter("id").isEmpty() && request.getParameter("action").equals("delete")) {

			newFacture.setId_facture(Integer.valueOf(request.getParameter("id")));

			newFactureDao.Delete(newFacture);
			
			response.sendRedirect(request.getContextPath() + "/Facture");
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
		doGet(request, response);
	}

}
