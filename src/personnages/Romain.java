package personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		assert force>0;
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

	public void recevoirCoup(int forceCoup) {
		assert this.force>0;
		int forceAvant = this.force;
		
		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
		} else {
			parler("J'abandonne...");
		}
		
		assert force<forceAvant;
	}
	
	public static void main(String[] args) {
		Romain testus = new Romain("Minus",6);
		testus.parler("Je peux parler !!");
		testus.recevoirCoup(2);
		testus.recevoirCoup(2);
	}
}
