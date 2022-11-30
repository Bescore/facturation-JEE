package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DemandeDao;
import modele.GetCookie;

/**
 * Servlet implementation class DeleteDemande
 */
@WebServlet("/DeleteDemande")
public class DeleteDemande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDemande() {
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
			
			if(request.getParameter("id")!=null &&request.getParameter("action").equals("delete")) {
				
				int idDemande=Integer.valueOf(request.getParameter("id"));
				
				//nouvelle demande
				modele.Demande newDemande=new modele.Demande();
				
				newDemande.setId_demande(idDemande);
				
				//nouveau DemandeDao
				DemandeDao newDemandeDao=new DemandeDao();
				
				//supprimer la demande
				newDemandeDao.Delete(newDemande);
			}
			response.sendRedirect(request.getContextPath() + "/Demande");
		}else {
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
