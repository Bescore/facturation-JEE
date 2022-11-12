package controller;

import java.io.IOException;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.crypto.bcrypt.BCrypt;

import modele.SendMail;

/**
 * Servlet implementation class Passoublie
 */
@WebServlet("/Passoublie")
public class Passoublie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Passoublie() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		//creer numero de facture
		// creer token ou generer un array de byte, hasher grâce à Bcrypt pour creer une chaine 
		//de caractère aleatoire
		BCrypt encoder = new BCrypt();
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[20];
		random.nextBytes(bytes);
		@SuppressWarnings("static-access")
		String token = encoder.hashpw(bytes,BCrypt.gensalt());
		@SuppressWarnings("static-access")
		String secret=encoder.hashpw("bibi",BCrypt.gensalt());
		
		
		
		//adresse de destination
		String email="jeanmar-97.1@hotmail.fr";
		
		//Nous permet de récupérer dynamiquement l'adresse peut importe l'hébergement de l'application(pourquoi 10,le nom du servlet "Passoublie" a 10 caractère)
		//href
		String href=""+request.getRequestURL().substring(0,request.getRequestURL().length()-10)+"Signup?token="+token+"&nom=dutaud&secret="+secret+"";
		
		//message
		String message="vous avez oublié votre mot de passe, cliquez <a href="+href+">ici</a>";
				
				
				
		SendMail.envoi(email, message);
		
		request.getRequestDispatcher("jsp/passoublie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
