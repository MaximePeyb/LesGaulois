package personnages;

public class Gaulois {

	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.effetPotion = force;
	}

	public int getEffetPotion() {
		return effetPotion;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] tropheesRomains = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; tropheesRomains != null && i < tropheesRomains.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = tropheesRomains[i];
		}
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup(force * effetPotion / 3);
//	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci, Druide. Je sens que ma force est " + forcePotion + " décuplée");
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void faireUneDonation(Musee musee) {
		parler("Je donne au musée tout mes trophées :");
		for (int i=0; i<nbTrophees;i++) {
			System.out.print("\n- "+trophees[i]);
			musee.donnerTrophee(this, new Trophee(this, trophees[i]));
		}
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		System.out.println(asterix.nom);
		System.out.println(asterix);

		asterix.parler("Je peux parler !");

		Romain debilius = new Romain("Debilius", 6);
		asterix.boirePotion(6);
		asterix.frapper(debilius);
	}
}
