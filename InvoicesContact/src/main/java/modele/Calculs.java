package modele;

import java.util.ArrayList;

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

	
	
	public static String CalculTotalHeure(ArrayList<ActiviteJournaliere>ActiviteTab) {
		//utilisé dans "mesheures"
		int heuresC=0;
		int minutesC=0;
		int secondesC=0;
		String TotalHeure=null;
		for (ActiviteJournaliere activiteJournaliere : ActiviteTab) {

			// la fonction split va mettre le format 00:00:00 sous forme de tableau en utilisant ":" comme séparateur
			// de ce fait on recupere [00,00,00], on recupere les valeurs avec leur index de tableau.. classique
			int heures= Integer.valueOf(activiteJournaliere.getDuree_activite().split(":")[0]) ;
			int minutes=Integer.valueOf(activiteJournaliere.getDuree_activite().split(":")[1]) ;
			int	secondes=Integer.valueOf(activiteJournaliere.getDuree_activite().split(":")[2]) ;
			
			// on ajout les valeurs aux variables
			heuresC+=heures;
			minutesC+=minutes;
			secondesC+=secondes;
			
			
		}
		//Pour finir on transforme le tout en chaine de character
		TotalHeure=String.valueOf(heuresC)+" heures "+String.valueOf(minutesC)+" minutes "+String.valueOf(secondesC)+" secondes ";
		
		return TotalHeure;
		
		
	}
	
	public static double CalculGainsBrut(ArrayList<ActiviteJournaliere>ActiviteTab) {
		
		
	 double addition=0;
		for (ActiviteJournaliere activiteJournaliere : ActiviteTab) {
			
		addition+=CalculSommeDu(activiteJournaliere.getDuree_activite(),activiteJournaliere.getTarif())	;
			
		}
		double resultat=Math.round(addition*100.00)/100.00;
		
		return resultat;
		
	}
	
	public static double CalculUrsaff(ArrayList<ActiviteJournaliere>ActiviteTab) {
		
	
		double somme=Calculs.CalculGainsBrut(ActiviteTab);
		
		
		//ils lui prennent 22,10%
		 double resultat= somme*0.22;
		 
		 resultat=Math.round(resultat*100.00)/100.00;
		 
		return resultat ;
	}

	public static double CalculGainNet(ArrayList<ActiviteJournaliere>ActiviteTab) {
		
		double gainBrut=CalculGainsBrut(ActiviteTab);
		double ursaff=CalculUrsaff(ActiviteTab);
		
		double resultat=gainBrut-ursaff;
		
		resultat=Math.round(resultat*100.00)/100.00;
		
		return resultat;
	}
	
}
