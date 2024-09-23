package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement equipement[] = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		this.nom = nom;
		assert force>0;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert this.force>0;
		int forceAvant = this.force;
		
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			parler("J'abandonne...");
		}
		
		assert force<forceAvant;
	}
	
	public void sEquiper(Equipement e) {
		switch (nbEquipement){
			case 2:
				System.out.println("Le soldat Minus est déjà bien protégé !");
				break;
			case 1:
				if(e==equipement[0]) {
					parler("Je possède déjà un "+e+" !");
					break;
				} 
			case 0:
				equipement[nbEquipement++] = e;
				parler("Je m'équipe avec un "+e+".");
				break;
			default:
				System.out.println("Problème... switch sEquiper Romain");
		}
	}
	
	public static void main(String[] args) {
		Romain testus = new Romain("Minus",6);
		testus.parler("Je peux parler !!");
		testus.recevoirCoup(2);
		testus.recevoirCoup(2);
		
		testus.sEquiper(Equipement.CASQUE);
		testus.sEquiper(Equipement.CASQUE);
		testus.sEquiper(Equipement.BOUCLIER);
		testus.sEquiper(Equipement.CASQUE);
	}
}
