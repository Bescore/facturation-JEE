package modele;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class GetCookie {
	
	public static String recupererCookie( HttpServletRequest req,String sessionToken) {
		//declarer le tableau de cookie
		Cookie[] cookies = req.getCookies();
		//initialiser une cookie variable en dehors de la boucle
		Cookie cooked=null;
		//operer un for pour parcourir les cookies
		for (Cookie cookie : cookies) {
			//si il trouve le cookie
			if (cookie.getName().equals("INC_RESET")) {
				//si le cookie est égale à celui contenu dans la session
				if (sessionToken.equals(cookie.getValue())) {
					//cookie devient la variable initiaisé plus haut
					cooked= cookie;
					
				
				// (fin)si le token dans le cookie ne correspond pas on redirige vers la connexion
				}
			//(fin)si il trouve le cookie
			}
		//(fin)for
		}
		if(cooked==null) {
			//on retourne un string quelconque si cooked est null(evite les bugs)
			return "echec !";
		}else {
		//on retourne la valeur du cookie en (String) si cooked est non null
		return cooked.getValue();
		}
	}
	

}
