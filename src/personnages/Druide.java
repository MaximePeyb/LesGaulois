package personnages;

import java.util.*;

public class Druide {
	private String nom;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forcePotion = 1;

	public Druide(String nom, int effetPotionMin, int effetPotionMax) {
		this.nom = nom;
		this.effetPotionMin = effetPotionMin;
		this.effetPotionMax = effetPotionMax;
		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " � "
				+ effetPotionMax + ".");
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}
	
	public void preparerPotion() {
		Random rd = new Random();
		
		// forcePotion = rd.nextInt(effetPotionMax+1); debug : A REMETTRE
		forcePotion = 5;
		
		while (forcePotion<effetPotionMin)
			forcePotion = rd.nextInt(effetPotionMax+1);
		
		if (forcePotion >7) 
			parler("J'ai pr�par� une super potion de force");
		else
			parler("Je n'ai pas trouv� tous les ingr�dients, ma potion est seulement de force "+forcePotion);
	}

	private String prendreParole() {
		return "Le druide " + nom + " : ";
	}
	
	public void booster(Gaulois theG) {
		if (theG.getNom()=="Obelix") 
			parler("Non, Ob�lix !... Tu n�auras pas de potion magique !");
		
		else {
			theG.setForce(forcePotion);
		}
	}
	
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",5,10);
		for (int i=0;i<5;i++) {
			panoramix.preparerPotion();
		}
	}
}
