import javax.swing.Icon;
import javax.swing.JButton;

public class ModelPuissance4 {
	 
	 public static  int LIGNE = 6; 		// Ligne MAX du plateau
	 public static  int COLONNE = 7; 	// Colonne MAX du plateau
	 private EtatPuissance4[][] plateau;
	 
	 public ModelPuissance4() {
		 this.plateau = new EtatPuissance4[LIGNE][COLONNE];
		 this.viderPlateau();
	 }
	 
	 public void viderPlateau() {
		for(int i= 0; i < LIGNE ; i++){
			for(int j= 0; j < COLONNE; j++){
				this.plateau[i][j] = EtatPuissance4.CASEVIDE; 
			}
		}
	 }
	 
	 /**
	  * Utilise la colonne i pour savoir combien il reste de place libre (pour savoir combien on a placer de jeton dans 1 colonne)
	  * @param Colonne i
	  * @return Nombre de place libre
	  */
	 public int nbJetonPlacerDansColonnes(int i){
		 if(i != 7) {
			 int nbCaseVide = LIGNE;
			 for(int x = 0 ; x < LIGNE ;x++) {
				 if(this.plateau[x][i] != EtatPuissance4.CASEVIDE ) {
					 nbCaseVide--;
				 }
			 }
			 return nbCaseVide;
		 }
		 return 0;
	 }
	 
	 public void placerPion(int colonne,EtatPuissance4 joueur){
		 
		 if(this.nbJetonPlacerDansColonnes(colonne) == 0) {
		 	 System.out.println("Il y a plus de place dans cette colonne");
		 }
		 
		 if(this.nbJetonPlacerDansColonnes(colonne) != 0) {
			 this.setCase(joueur,LIGNE-this.nbJetonPlacerDansColonnes(colonne), colonne);
		 }else {
			 this.setCase(joueur,this.nbJetonPlacerDansColonnes(colonne), colonne);
		  }
		 

	 }
	 
	 /**
	  * Renvoie vrai si tout les colonnes du tableau sont remplis
	  * @return isFullColumn
	  */
	 public boolean egalite() {
		 int isFullColumn = 0;
			for (int y=0; y < COLONNE ; y++){
				if(this.ColumnIsFull(y)){
					isFullColumn ++;
				}
			}
		 return (isFullColumn == COLONNE);
	 }
	 
	 /**
	  * Renvoie si une colonne `column` est remplis
	  * @param column
	  * @return vrai si la colonne est remplis
	  */
	 public boolean ColumnIsFull(int column) {
		 return (this.nbJetonPlacerDansColonnes(column) == 0) ;
				
	 }
	 
	 public void deplacerJeton(int column) {
		// int i = 5;		 
		 for(int i = 0; i < LIGNE; i++) {
			 if(i+1 >= LIGNE) {
				 this.plateau[i][column]=EtatPuissance4.CASEVIDE;
				 
			 }else {
				 this.plateau[i][column]=this.plateau[i+1][column];
			 }
		}
	 }
	 
	 public boolean PartieGagnerRouge() { 
		 return verifLigneRouge() || this.verifColonneRouge()|| this.verifDiagDroitRouge()|| this.verifDiagGaucheRouge();
	}
		
	 public boolean verifLigneRouge() { 
		 boolean verif = false;
		 for (int x=0; x < LIGNE  ; x++){
			for (int y=0; y < COLONNE ; y++){
				if( x < LIGNE-3) {
					if((this.plateau[x][y]==this.plateau[x+1][y])&&
							(this.plateau[x][y]==this.plateau[x+2][y])&&
							(this.plateau[x][y]==this.plateau[x+3][y])&&
							(this.plateau[x][y]==EtatPuissance4.JOUEUR2))
							verif = true;
				}
			}
		 }
		 return verif;
	 }
	 
	 public boolean verifColonneRouge() {
		 boolean verif = false;
		 for (int i=0; i < LIGNE  ; i++){
			for (int y=0; y < COLONNE ; y++){
				if( y < COLONNE-3) {
					if((this.plateau[i][y]==this.plateau[i][y+1])&&
							(this.plateau[i][y]==this.plateau[i][y+2])&&
							(this.plateau[i][y]==this.plateau[i][y+3])&&
							(this.plateau[i][y]==EtatPuissance4.JOUEUR2))
							verif = true;
				}
			}
		 }
		 return verif;
	 }
	 
	 public boolean verifDiagDroitRouge() { 
			boolean verif = false;
			for(int i=0 ; i < LIGNE ; i++){
				for(int y=0 ; y<COLONNE ;y ++){
					if( y < COLONNE-3 && i < LIGNE-3) {
						if((this.plateau[i][y]==this.plateau[i+1][y+1])&&
							(this.plateau[i][y]==this.plateau[i+2][y+2])&&
							(this.plateau[i][y]==this.plateau[i+3][y+3])&&
							(this.plateau[i][y]==EtatPuissance4.JOUEUR2))
							verif=true;
					}
				}
			}
			return verif;
	 }
	 
	 public boolean verifDiagGaucheRouge() { 
			boolean verif = false;
			for(int i=0 ; i < LIGNE ; i++){
				for(int y=0 ; y<COLONNE ;y ++){
					if( y > 3 && i < LIGNE-3){
						if( (this.plateau[i][y]==this.plateau[i+1][y-1])&&
							(this.plateau[i][y]==this.plateau[i+2][y-2])&&
							(this.plateau[i][y]==this.plateau[i+3][y-3])&&
							(this.plateau[i][y]==EtatPuissance4.JOUEUR2))
							verif=true;
					}
				}
			}
			return verif;
	 }
	 
	 public boolean PartieGagnerJaune() {
		 return verifLigneJaune() || this.verifColonneJaune()|| this.verifDiagDroitJaune()|| this.verifDiagGaucheJaune();
	 }
	 
	 public boolean verifLigneJaune() {
		 boolean verif = false;
		 for (int x=0; x < LIGNE  ; x++){
			for (int y=0; y < COLONNE ; y++){
				if( x < LIGNE-3) {
					if((this.plateau[x][y]==this.plateau[x+1][y])&&
							(this.plateau[x][y]==this.plateau[x+2][y])&&
							(this.plateau[x][y]==this.plateau[x+3][y])&&
							(this.plateau[x][y]==EtatPuissance4.JOUEUR1))
							verif = true;
				}
			}
		 }
		 return verif;
	 }
	 
	 public boolean verifColonneJaune() {  
		 boolean verif = false;
		 for (int i=0; i < LIGNE  ; i++){
			for (int y=0; y < COLONNE ; y++){
				if( y < COLONNE-3) {
					if((this.plateau[i][y]==this.plateau[i][y+1])&&
							(this.plateau[i][y]==this.plateau[i][y+2])&&
							(this.plateau[i][y]==this.plateau[i][y+3])&&
							(this.plateau[i][y]==EtatPuissance4.JOUEUR1))
							verif = true;
				}
			}
		 }
		 return verif;
	 }
	 
	 public boolean verifDiagDroitJaune() {  
			boolean verif = false;
			for(int i=0 ; i < LIGNE ; i++){
				for(int y=0 ; y<COLONNE ;y ++){
					if( y < COLONNE-3 && i < LIGNE-3) {
						if((this.plateau[i][y]==this.plateau[i+1][y+1])&&
							(this.plateau[i][y]==this.plateau[i+2][y+2])&&
							(this.plateau[i][y]==this.plateau[i+3][y+3])&&
							(this.plateau[i][y]==EtatPuissance4.JOUEUR1))
							verif=true;
					}
				}
			}
			return verif;
	 }
	 
	 public boolean verifDiagGaucheJaune() {
			boolean verif = false;
			for(int i = 0 ; i < LIGNE ; i++){
				for(int y = 0 ; y <COLONNE ;y ++){
					if( y > 3 && i < LIGNE-3){
						if( (this.plateau[i][y]==this.plateau[i+1][y-1])&&
							(this.plateau[i][y]==this.plateau[i+2][y-2])&&
							(this.plateau[i][y]==this.plateau[i+3][y-3])&&
							(this.plateau[i][y]==EtatPuissance4.JOUEUR1))
							verif=true;
					}
					
				}
			}
			
			return verif;
	 }
	 
	 public void setCase(EtatPuissance4 etat, int ligne, int colonne) {
			this.plateau[ligne][colonne] = etat;		
	}
	 
	public String toString() {
		StringBuffer res = new StringBuffer();
		for(int i = 0; i < LIGNE ; i++) {
			for(int y = 0; y < COLONNE ; y++) {
				res.append(this.plateau[(LIGNE-1)-i][(COLONNE-1)-y]);
				res.append(" ");
			}
			res.append("\n");
		}
		return res.toString();
	}
	
}