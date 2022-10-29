package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClientDao;
import dao.FactureDao;
import modele.GetCookie;

/**
 * Servlet implementation class Facture
 */
@WebServlet("/Facture")
public class Facture extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Facture() {
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
			
			
			//READ DES FACTURES
			//creer une factureDao
			FactureDao newFactureDao=new FactureDao();
			
			//read et set attribute
			request.setAttribute("factures", newFactureDao.Read());
			
			//NOMBRE DE FACTURES
			request.setAttribute("nombre_totale_factures",newFactureDao.Read().size());
			
			//NOMBRE DE FACTURES NON PAYEE
			request.setAttribute("nombre_factures_non_payee", newFactureDao.FindbyNombreFactureNonPayee());
			
			//NOMBRE DE FACTURE PAYEE
			request.setAttribute("nombre_factures_payee", newFactureDao.FindbyNombreFacturePayee());
			
			//SOMME TOTALE
			request.setAttribute("somme_totale",newFactureDao.FindbySommeTotale());
			
			//SOMME TOTALE PAYEE
			request.setAttribute("somme_totale_payee",newFactureDao.FindbySommeTotalePayee());
			
			//SOMME TOTALE NON PAYEE
			request.setAttribute("somme_totale_non_payee",newFactureDao.FindbySommeTotaleNonPayee());
			
			
			
		
		
			request.getRequestDispatcher("jsp/facture.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/Deconnexion");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
