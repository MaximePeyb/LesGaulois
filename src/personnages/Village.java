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
		System.out.println("Dans le village du chef "+chef.getNom()+" vivent les l�gendaires gaulois : ");
		for (int i=0;i<nbVillageois;i++) {
			System.out.println(" - "+villageois[i].getNom());
		}
	}
	
	public static void main(String args[]) {
		Village village = new Village("Village des Irr�ductibles",30);
		//Gaulois gaulois = village.trouverHabitant(30);
		// Ayant g�r� ce cas dans trouverHabitant, aucune exception n'est lev�e. 
		// Elle serait lev�e car on d�passerait du tableau.
		
		Chef abrachef = new Chef("Abraracourcix", 6, village);
		village.setChef(abrachef);
		
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		village.ajouterVillageois(asterix);
		
//		Gaulois gaulois = village.trouverHabitant(1);
//		System.out.println(gaulois);
		//Le seul habitant enregistr� est Ast�rix, son indice dans le tableau est 0. 
		//En 1, il n'y a donc pas de gaulois. 
		
		Gaulois obelix = new Gaulois("Ob�lix",25);
		village.ajouterVillageois(obelix);
		
		village.afficherVillageois();
		
		
	}
}