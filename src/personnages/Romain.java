package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private boolean vainqueur = false;

	public Romain(String nom, int force) {
		this.nom = nom;
		assert force > 0;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// pr�condition
		assert force > 0;
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;

		// if (force > 0) { // parler("A�e");
		// } else {
		// equipementEjecte = ejecterEquipement();
		// parler("J'abandonne...");
		// }
		
		if (forceCoup==0) {
			parler("M�me pas mal !");
		}
		
		if (force <= 0) {
			parler("A�e");
			vainqueur=true;
		}
		
		equipementEjecte = ejecterEquipement();
		parler("J'abandonne...");
		// post condition la force a diminu�
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte;
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
			for (int i = 0; i < nbEquipement;i++) {
				if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		if(forceCoup > 0) {
			return forceCoup;
		}
		return 0;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'�quipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
				nbEquipement--;
			}
		}
		return equipementEjecte;
	}

//	public void recevoirCoup(int forceCoup) {
//		assert this.force>0;
//		int forceAvant = this.force;
//		
//		force -= forceCoup;
//		if (force > 0) {
//			parler("A�e");
//		} else {
//			parler("J'abandonne...");
//		}
//		
//		assert force<forceAvant;
//	}

	public void sEquiper(Equipement e) {
		switch (nbEquipement) {
		case 2:
			System.out.println("Le soldat Minus est d�j� bien prot�g� !");
			break;
		case 1:
			if (e == equipements[0]) {
				parler("Je poss�de d�j� un " + e + " !");
				break;
			}
		case 0:
			equipements[nbEquipement++] = e;
			parler("Je m'�quipe avec un " + e + ".");
			break;
		default:
			System.out.println("Probl�me... switch sEquiper Romain");
		}
	}

	public static void main(String[] args) {
		Romain testus = new Romain("Minus", 6);
		testus.parler("Je peux parler !!");
		testus.recevoirCoup(2);
		testus.recevoirCoup(2);

		testus.sEquiper(Equipement.CASQUE);
		testus.sEquiper(Equipement.CASQUE);
		testus.sEquiper(Equipement.BOUCLIER);
		testus.sEquiper(Equipement.CASQUE);
	}

	public int getForce() {
		return this.force;
	}

	public boolean getVainqueur() {
		return vainqueur;
	}
}
