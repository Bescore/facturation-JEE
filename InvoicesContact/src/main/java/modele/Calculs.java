package modele;



public class Calculs {
	
	public static double CalculSommeDu(String temps, float prix_par_heure) {
		
		
		//Calculer somme en fonction du temps
		
		// la fonction split va mettre le format 00:00:00 sous forme de tableau en utilisant ":" comme séparateur
		// de ce fait on recupere [00,00,00], on recupere les valeurs avec leur index de tableau.. classique
			int heures= Integer.valueOf(temps.split(":")[0]) ;
			int minutes=Integer.valueOf(temps.split(":")[1]) ;
			int	secondes=Integer.valueOf(temps.split(":")[2]) ;
			
			
			//Calcule de toute les valeurs en seconde
			//1h= 3600secondes,1minutes= 60secondes,1secondes= 1secondes
			int heuresEnSeconde=heures*3600;
			int minutesESeconde=minutes*60;
			int	secondeEnSecondes=secondes;
			
			
			//le nombre de secondes total fois le prix à la seconde
			double addition=(heuresEnSeconde+minutesESeconde+secondeEnSecondes)*((prix_par_heure/60)/60 );
			double resultat=Math.round(addition*100.00)/100.00;

		return resultat ;	
	}

}
