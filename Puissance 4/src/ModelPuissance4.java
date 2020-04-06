import javax.swing.JButton;

public class ModelPuissance4 {
	 
	 public static  int LIGNE = 7; 		// Ligne MAX du plateau
	 public static  int COLONNE = 6; 	// Colonne
	 private EtatPuissance4[][] plateau;
	 
	 public ModelPuissance4() {
		 plateau = new EtatPuissance4[LIGNE][COLONNE];
	 }
	 
	 public void videPlateau() {
		for(int i= 0; i < LIGNE ; i++){
			for(int j= 0; j < COLONNE; j++){
				this.plateau[i][j] = EtatPuissance4.CASEVIDE; 
			}
		}
	 }
	 
	 public boolean PartieGagner() {
		 return false;
	 }
		
	 public void setCase(EtatPuissance4 etat, int i, int j) {
			this.plateau[i][j] = etat;
			
	}
	 
}
