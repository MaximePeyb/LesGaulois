package histoire;

import personnages.*;

public class Scenario {

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",8);
		Gaulois obelix= new Gaulois("Obelix",25);
		Druide pano = new Druide("Panoramix",5,10);
		Romain minus = new Romain("Minus",6);
		
		pano.parler("Bonjour, je suis le druide "+pano.getNom()+" et ma potion peut aller d'une force 5 à 10");
		pano.parler("Je vais aller préparer une petite potion...");
		pano.preparerPotion();
		pano.booster(obelix);
		obelix.parler(" Par Bélénos, ce n'est pas juste !");
		pano.booster(asterix);
		
		asterix.parler("Bonjour");
		
		minus.parler("UN GAU... UN GAUGAU...");
		
		asterix.frapper(minus);

	}

}
