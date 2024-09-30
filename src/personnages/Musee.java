package personnages;

public class Musee {
	Trophee[] trophees = new Trophee[200];
	int nbTrophees = 0;
	
	public void donnerTrophee(Gaulois gaugau, Trophee troph) {
		if (nbTrophees==200) {
			System.out.println("Le musee est deja plein !");
		}else {
			trophees[nbTrophees]=troph;
			nbTrophees++;
		}
	}
}
