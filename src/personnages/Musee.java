package personnages;

public class Musee {
	Trophee[] trophees = new Trophee[200];
	int nbTrophees = 0;
	
	public String extraireInstructionsOCaml() {
		String instr = "let musee = [";
		for (int i=0;i<nbTrophees-1;i++) {
			instr += "\""+trophees[i].donnerNom()+"\", \""+trophees[i].getEquipement()+"\"; ";
		}
		instr+="\""+trophees[nbTrophees-1].donnerNom()+"\", \""+trophees[nbTrophees-1].getEquipement()+"\"]";
		
		return instr;
	}
	
	public void donnerTrophee(Gaulois gaugau, Trophee troph) {
		if (nbTrophees==200) {
			System.out.println("Le musee est deja plein !");
		}else {
			trophees[nbTrophees]=troph;
			nbTrophees++;
		}
	}
}
