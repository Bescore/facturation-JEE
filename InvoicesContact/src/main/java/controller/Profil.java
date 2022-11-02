package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UtilisateurDao;

/**
 * Servlet implementation class Profil
 */
@WebServlet("/Profil")
public class Profil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getRequestDispatcher("jsp/profil.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		//creer nouveau UtilisateurDao
		UtilisateurDao newUtilisateurDao=new UtilisateurDao();
		
		
		//CHANGER LE VISUEL AU CLIQUE DU BOUTON MODIFIER
		if(request.getParameter("modifier")!=null) {
			
			//recuperer l'id  du client selectionné
			int id_user=(int) session.getAttribute("id_user");
			
			//rechercher l'utilisateur et ses infos (by id) et les renvoyer au jsp
			 request.setAttribute("modifier_utilisateur", newUtilisateurDao.FindbyId(id_user).get(0));
			 
			 
		}
		
		
		
		
		
		doGet(request, response);
	}

}
