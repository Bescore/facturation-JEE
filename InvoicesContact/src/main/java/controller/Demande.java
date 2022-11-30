package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClientDao;
import dao.DemandeDao;
import dao.TypeDao;
import modele.Clients;
import modele.GetCookie;
import modele.Type;

/**
 * Servlet implementation class Demande
 */
@WebServlet("/Demande")
public class Demande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Demande() {
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
		
		//creer clientdao
		ClientDao newClientDao=new ClientDao();
		
		//creer typeDao
		TypeDao newTypeDao=new TypeDao();
		
		//creer demandeDao
		DemandeDao newDemandeDao=new DemandeDao();
		
		// on utilise la fonction qui va recuperer le cookie
		String cookie = GetCookie.recupererCookie(request, token);
		if (cookie.equals(token)) {
			
			//READ DES CLIENTS
			//declencher la methode et l'envoyer au jsp
			request.setAttribute("clients",  newClientDao.Read());
			
			//READ DES TYPES DE SERVICE
			//declencher la methode et l'envoyer au jsp
			request.setAttribute("types", newTypeDao.Read());
			
			//READ DES DEMANDES
			//declencher la methode et l'envoyer au jsp
			request.setAttribute("demandes", newDemandeDao.Read());
			
			
			request.getRequestDispatcher("jsp/demande.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/Deconnexion");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idClient=request.getParameter("clients");
		String idType=request.getParameter("types");
		String date=request.getParameter("date");
		String heure=request.getParameter("heure");
		String duree=request.getParameter("duree");
		
		//creer client
		Clients newClient=new Clients();
	
		newClient.setId_personne(Integer.valueOf(idClient));
		
		//Creer Type
		Type newType=new Type();
				
		newType.setId_type(Integer.valueOf(idType));
		
		//Creer la demandeDao
		DemandeDao newDemandeDao=new DemandeDao();
				
		
		if(request.getParameter("valider")!=null 
				&& idClient!=null
				&& idType!=null 
				&& date!=null 
				&& heure!=null 
				&& !date.isEmpty()
				&& !heure.isEmpty()) {
			
			//Creer une demande
			modele.Demande newDemande=new modele.Demande();
			
			newDemande.setClient(newClient);
			newDemande.setType(newType);
			newDemande.setDate(date);
			newDemande.setHeure(heure);
			newDemande.setDuree(duree);
			
			//declencher la methode create
			newDemandeDao.Create(newDemande);
			
			response.sendRedirect(request.getContextPath() + "/Demande");
			//ce return empêche de dupliquer l'action au refresh de la page
			return;
		}
		
		
		doGet(request, response);
	}

}
