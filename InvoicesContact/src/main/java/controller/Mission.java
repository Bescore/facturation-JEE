package controller;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClientDao;
import dao.MissionDao;
import dao.TypeDao;
import modele.Clients;
import modele.GetCookie;
import modele.Type;

/**
 * Servlet implementation class Mission
 */
@WebServlet("/Mission")
public class Mission extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mission() {
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
			
			// READ DES CLIENTS ET TYPE
			//creer un clientDao
			ClientDao newClientDao=new ClientDao();
			
			//declencher le read et renvoyer clients au jsp
			 request.setAttribute("clients", newClientDao.Read());
			// creer un typeDao
			 TypeDao newTypeDao=new TypeDao();
			
			 //declencher le read et renvoyer types au jsp
			 request.setAttribute("types",newTypeDao.Read());
			 
			// READ DES MISSIONS
			//creer mission dao
			 MissionDao newMissionDao=new MissionDao();
			 
			 request.setAttribute("missions", newMissionDao.Read());
			 
			
		request.getRequestDispatcher("jsp/mission.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/Deconnexion");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//recuperer les données du formulaire
		String types=request.getParameter("types");
		String clients=request.getParameter("clients");
		String tarif=request.getParameter("tarif");
		
		if(request.getParameter("ajouter_mission")!=null && types!=null && clients !=null && tarif!=null ) {
			
			
		
		// AJOUTER DES MISSIONS
		//creer nouveau client
		Clients newClient=new Clients();
		
		newClient.setId_personne(Integer.valueOf( clients));
		
		//creer un nouveau type
		Type newType=new Type();
		
		newType.setId_type(Integer.valueOf(types));
		
		
		//creer mission
		
		modele.Mission newMission=new modele.Mission();
		
		newMission.setClient(newClient);
		newMission.setType(newType);
		newMission.setTarif(Integer.valueOf(tarif));
		
		//creer le missionDao
		
		MissionDao newMissionDao=new MissionDao();
		
		//declencher la méthode create
		newMissionDao.Create(newMission);
		}
		
		doGet(request, response);
	}

}
