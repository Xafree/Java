import javax.swing.JButton;

public class ModelPuissance4 {
	 
	 public static  int LIGNE = 7; 		// Ligne MAX du plateau
	 public static  int COLONNE = 6; 	// Colonne MAX du plateau 
	 private EtatPuissance4[][] plateau;
	 
	 public ModelPuissance4() {
		 plateau = new EtatPuissance4[LIGNE][COLONNE];
		 this.viderPlateau();
	 }
	 
	 public void viderPlateau() {
		for(int i= 0; i < LIGNE ; i++){
			for(int j= 0; j < COLONNE; j++){
				this.plateau[i][j] = EtatPuissance4.CASEVIDE; 
			}
		}
	 }
	 
	 public int colonneVide(EtatPuissance4[][] plateau, int i) {
		 return 1;
	 }
	 
	 public void placerPion() {
		 
	 }
	 public boolean PartieGagner(EtatPuissance4 joueur) {
		 for (int x=0; x<LIGNE; x++){
				for (int y=0; y<COLONNE; y++){
								//-----------------------Vérification de la Colonne-------------------------------
					if(plateau[x][y]==plateau[x][y+1] && plateau[x][y]==plateau[x][y+2] && plateau[x][y]==plateau[x][y+3] && plateau[x][y]== joueur){
						return true;			
					}
								//-----------------------Vérification de la ligne---------------------------------
					if(plateau[x][y]==plateau[x+1][y] && plateau[x][y]==plateau[x+2][y] && plateau[x][y]==plateau[x+3][y] && plateau[x][y]== joueur){
						return true;
					}
								//------------------Vérification de la diagonale joueur---------------------------
					if(plateau[x][y]==plateau[x+1][y+1] && plateau[x][y]==plateau[x+2][y+2] && plateau[x][y]==plateau[x+3][y+3]  && plateau[x][y]== joueur){
						return true;
					}
					if(plateau[x][y]==plateau[x-1][y-1] && plateau[x][y]==plateau[x-2][y-2] && plateau[x][y]==plateau[x-3][y-3]  && plateau[x][y]== joueur){
						return true;
					}
					if(plateau[x][y]==plateau[x-1][y+1] && plateau[x][y]==plateau[x-2][y+2] && plateau[x][y]==plateau[x-3][y+3] && plateau[x][y]== joueur){
						return true;
					}
					if(plateau[x][y]==plateau[x+1][y-1] && plateau[x][y]==plateau[x+2][y-2] && plateau[x][y]==plateau[x+3][y-3] && plateau[x][y]== joueur){
						return true;
					}
				}
			}
		 return false;
	 }
		
	 public void setCase(EtatPuissance4 etat, int i, int j) {
			this.plateau[i][j] = etat;
			
	}
	 
}
