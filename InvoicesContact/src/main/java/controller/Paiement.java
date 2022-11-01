package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FactureDao;
import modele.Facture;

/**
 * Servlet implementation class Paiement
 */
@WebServlet("/Paiement")
public class Paiement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Paiement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//récuperer l'identifiant de la facture
		String identifiantFacture=request.getParameter("facture");
		
		//Creer un nouveau "factureDao"
		FactureDao newFactureDao= new FactureDao();
		
		//Creer nouvelle facture
		Facture newFacture=new Facture();
		
		//ajouter l'identifiant à la facture
		newFacture.setIdentifiant(identifiantFacture);

		if(identifiantFacture!=null
				&& !identifiantFacture.isEmpty() 
				&& newFactureDao.Findby(newFacture).size()!=0 
				&& request.getParameter("v").equalsIgnoreCase(newFactureDao.Findby(newFacture).get(0).getSomme())) {
		
		
			
			//READ et set attribute de la facture
			request.setAttribute("facture",newFactureDao.Findby(newFacture).get(0));
			
			//PRIX A PAYER
			request.setAttribute("value",request.getParameter("v"));
			
			//verif
			request.setAttribute("verification_ok", 1);
			
		}else {
			request.setAttribute("paid", 1);
		}
		
		request.getRequestDispatcher("jsp/paiement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//récuperer l'identifiant de la facture
				String identifiantFacture=request.getParameter("facture");
				
				//Creer un nouveau "factureDao"
				FactureDao newFactureDao= new FactureDao();
				
				//Creer nouvelle facture
				Facture newFacture=new Facture();
				
				//ajouter l'identifiant à la facture
				newFacture.setIdentifiant(identifiantFacture);
		
		if(request.getParameter("v")!=null && request.getParameter("v").equals(newFactureDao.Findby(newFacture).get(0).getSomme())) {
			
			//update de la facture payée
			newFactureDao.UpdatePaiementClient(newFacture);
			
			response.sendRedirect(request.getContextPath() + "/Paiement?facture="+identifiantFacture+"&v="+request.getParameter("v")+"");
		}else {
			doGet(request, response);
		}
	}
}
