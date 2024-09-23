package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;

	public Village(String nom, int nbVillageoisMax) {
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMax];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public String getNom() {
		return nom;
	}
	
	public void ajouterVillageois(Gaulois x) {
		if (nbVillageois < villageois.length) {
			villageois[nbVillageois++] = x;
		} else 
			System.out.println("Ce village est trop plein !!");
	}
	
	public Gaulois trouverHabitant(int nb) {
		if (nb<nbVillageois)
			return villageois[nb];
		System.out.println("Ce gaulois n'est pas dans mon village !");
		return null;
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+chef.getNom()+" vivent les légendaires gaulois : ");
		for (int i=0;i<nbVillageois;i++) {
			System.out.println(" - "+villageois[i].getNom());
		}
	}
	
	public static void main(String args[]) {
		Village village = new Village("Village des Irréductibles",30);
		//Gaulois gaulois = village.trouverHabitant(30);
		// Ayant géré ce cas dans trouverHabitant, aucune exception n'est levée. 
		// Elle serait levée car on dépasserait du tableau.
		
		Chef abrachef = new Chef("Abraracourcix", 6, village);
		village.setChef(abrachef);
		
		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);
		
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
		//Le seul habitant enregistré est Astérix, son indice dans le tableau est 0. 
		//En 1, il n'y a donc pas de gaulois. 
		
		Gaulois obelix = new Gaulois("Obélix",25);
		village.ajouterVillageois(obelix);
		
		village.afficherVillageois();
		
		
	}
}