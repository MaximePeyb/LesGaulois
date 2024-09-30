package histoire;

import personnages.Druide;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Romain;
//import villagegaulois.Musee;

public class Scenario {

	public static void main(String[] args) {
		Druide druide = new Druide("Panoramix", 5, 10);
		druide.parler("Je vais aller préparer une petite potion...");
		druide.preparerPotion();
		Gaulois obelix = new Gaulois("Obélix", 25);
		Gaulois asterix = new Gaulois("Astérix", 8);
		druide.booster(obelix);
		obelix.parler("Par Bélénos, ce n'est pas juste !");
		druide.booster(asterix);
		asterix.parler("Bonjour");
		Romain minus = new Romain("Minus", 6);
		Romain milexcus = new Romain("Milexcus", 8);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		milexcus.sEquiper(Equipement.CASQUE);
		minus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(minus);
		} while (!minus.getVainqueur());
		milexcus.parler("UN GAU... UN GAUGAU...");
		do {
			asterix.frapper(milexcus);
		} while (!milexcus.getVainqueur());
		
//		Partie a decommenter
		
//		Musee musee = new Musee();
//		asterix.faireUneDonnation(musee);

	}

}




































//package histoire;
//
//import personnages.*;
//
//public class Scenario {
//
//	public static void main(String[] args) {
//		Gaulois asterix = new Gaulois("Asterix",8);
//		Gaulois obelix= new Gaulois("Obelix",25);
//		Druide pano = new Druide("Panoramix",5,10);
//		Romain minus = new Romain("Minus",6);
//		
//		pano.parler("Bonjour, je suis le druide "+pano.getNom()+" et ma potion peut aller d'une force 5 à 10");
//		pano.parler("Je vais aller préparer une petite potion...");
//		pano.preparerPotion();
//		pano.booster(obelix);
//		obelix.parler(" Par Bélénos, ce n'est pas juste !");
//		pano.booster(asterix);
//		
//		asterix.parler("Bonjour");
//		
//		minus.parler("UN GAU... UN GAUGAU...");
//		
//		asterix.frapper(minus);
//
//	}
//
//}
