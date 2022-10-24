package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ActiviteDao;
import dao.ClientDao;
import dao.TypeDao;
import modele.ActiviteJournaliere;
import modele.Calculs;
import modele.Clients;
import modele.GetCookie;
import modele.Type;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
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
		
		//creer activiteDao
		ActiviteDao newActiviteDao=new ActiviteDao();
		//creer clientdao
		ClientDao newClientDao=new ClientDao();
		//creer typeDao
		TypeDao newTypeDao=new TypeDao();
		
		// on utilise la fonction qui va recuperer le cookie
		String cookie = GetCookie.recupererCookie(request, token);
		if (cookie.equals(token)) {
			
			//READ DES CLIENTS
			//declencher la methode et l'envoyer au jsp
			request.setAttribute("clients",  newClientDao.Read());
			
			//READ DES TYPES DE SERVICE
			//declencher la methode et l'envoyer au jsp
			request.setAttribute("types", newTypeDao.Read());
			
			//READ DERNIERES ACTIVITES/JOURNEE EFFECTUEE
			if(newActiviteDao.RecentesActivites().size()!=0) {
			request.setAttribute("activites_recentes", newActiviteDao.RecentesActivites().get(0));
			//somme du
			
			request.setAttribute("somme_du",Calculs.CalculSommeDu(newActiviteDao.RecentesActivites().get(0).getDuree_activite(),newActiviteDao.RecentesActivites().get(0).getTarif()));
			}
			
			//CONTROLLER SI UNE EST ACTIVITE EN COURS
			if(newActiviteDao.FindbyaActiviteEnCours()!=null) {
			
				request.setAttribute("activite_en_cours", newActiviteDao.FindbyaActiviteEnCours());
				
			}
		
					
			
		
		request.getRequestDispatcher("jsp/home.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/Deconnexion");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//recuperer les id clients et type de service
		String idType=request.getParameter("type");
		String idClient=request.getParameter("client");
		String tarif=request.getParameter("tarif");
		
		
		
		
		
		//si tous les champs sont valides on demarrer une journée
		if(request.getParameter("demarrer_journee")!=null && idType !=null && idClient!=null && tarif!=null && !tarif.isEmpty()) {
			
			//CREATE DE L'ACTIVITE
			//creer type
			Type newType=new Type();
			
			newType.setId_type(Integer.valueOf(idType));
			
			//creer client
			Clients newClient=new Clients();
			
			newClient.setId_personne(Integer.valueOf(idClient));
			
			//creer nouvelle activite journaliere
			ActiviteJournaliere newActivite= new ActiviteJournaliere();
			
			//preparer activiteDao
			ActiviteDao newActiviteDao=new ActiviteDao();
			
			newActivite.setClient(newClient);
			newActivite.setType(newType);
			newActivite.setTarif(Integer.valueOf(tarif));
			
			//declencher la methode create
			newActiviteDao.Create(newActivite);
			
			//permet d'eviter la repetion de l'action au refresh de la page
			response.sendRedirect(request.getContextPath() + "/Home");
			return;
		}
		
		
		if(request.getParameter("arreter_journee")!=null) {
			
			//preparer activiteDao
			ActiviteDao newActiviteDao=new ActiviteDao();
			
			//ARRETER SA JOURNEE
			newActiviteDao.UpdateArreterActivite();
			
			//permet d'eviter la repetion de l'action au refresh de la page
			response.sendRedirect(request.getContextPath() + "/Home");
			return;
		}
		doGet(request, response);
	}

}
