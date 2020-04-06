import javax.swing.Icon;
import javax.swing.JButton;

public class ModelPuissance4 {
	 
	 public static  int LIGNE = 6; 		// Ligne MAX du plateau
	 public static  int COLONNE = 7; 	// Colonne MAX du plateau
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
	 
	 /**
	  * Utilise le La ligne i pour déduire combien de place libre il reste dans la colonne
	  * @param La ligne
	  * @return Nombre de place libre
	  */
	 public int nbJetonPlacerDansColonnes(int i){
		 int nbCaseVide = LIGNE;
		 for(int x = 0 ; x < LIGNE ;x++) {
			 if(this.plateau[x][i] != EtatPuissance4.CASEVIDE ) {
				 nbCaseVide--;
			 }
		 }
		 return nbCaseVide;
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
	 
	 public boolean PartieGagner(EtatPuissance4 joueur) {
		 for (int x=0; x < COLONNE; x++){
				for (int y=0; y< LIGNE; y++){
								//-----------------------Vérification de la Colonne-------------------------------
					if(plateau[x][y]==plateau[x][y+1] && plateau[x][y]==plateau[x][y+2] && plateau[x][y]==plateau[x][y+3] && plateau[x][y]== joueur){
						return true;			
					}
								//-----------------------Vérification de la ligne---------------------------------
					if(plateau[x][y]==plateau[x+1][y] && plateau[x][y]==plateau[x+2][y] && plateau[x][y]==plateau[x+3][y] && plateau[x][y]== joueur){
						return true;
					}
								//------------------Vérification de la diagonale joueur---------------------------
					if(plateau[x][y]==plateau[x+1][y+1] && plateau[x][y]==plateau[x+2][y+2] && plateau[x][y]==plateau[x+3][y+3]  && plateau[x][y] == joueur){
						return true;
					}
					if(plateau[x][y]==plateau[x-1][y-1] && plateau[x][y]==plateau[x-2][y-2] && plateau[x][y]==plateau[x-3][y-3]  && plateau[x][y] == joueur){
						return true;
					}
					if(plateau[x][y]==plateau[x-1][y+1] && plateau[x][y]==plateau[x-2][y+2] && plateau[x][y]==plateau[x-3][y+3] && plateau[x][y]  == joueur){
						return true;
					}
					if(plateau[x][y]==plateau[x+1][y-1] && plateau[x][y]==plateau[x+2][y-2] && plateau[x][y]==plateau[x+3][y-3] && plateau[x][y]  == joueur){
						return true;
					}
				}
			}
		 return false;
	 }
		
	 public void setCase(EtatPuissance4 etat, int ligne, int colonne) {
			this.plateau[ligne][colonne] = etat;		
	}
	 

		public String toString() {
			StringBuffer res = new StringBuffer();
			for(int i = 0; i < LIGNE; i++) {
				for(int y = 0; y < COLONNE; y++) {
					res.append(this.plateau[i][y]);
					res.append(" ");
				}
				res.append("\n");
			}
			return res.toString();
		}
	
}
/**
//retourne true si puissance 4 trouvé dans la grille
	public static boolean verif()
	{
		boolean aligne=false;
		if(verDiagDroit()|verDiagGauch()|verVertic()|verHoriz())
			aligne=true;
		return(aligne);
	}
	
	
	//fonctions de recherche de puissance 4
	public static boolean verDiagDroit()
	{
		boolean align=false;
		for(li=0;li<4;li++)
		{
			for(co=0;co<8;co++)
			{
				if((grille[li][co]==grille[li+1][co+1])&&
				   (grille[li][co]==grille[li+2][co+2])&&
				   (grille[li][co]==grille[li+3][co+3])&&
				   (grille[li][co]!="_"))
					align=true;
			}
		}
		return(align);
	}
	
	
	
	public static boolean verDiagGauch()
	{
		boolean align=false;
		for(li=0;li<4;li++)
		{
			for(co=3;co<11;co++)
			{
				if((grille[li][co]==grille[li+1][co-1])&&
				   (grille[li][co]==grille[li+2][co-2])&&
				   (grille[li][co]==grille[li+3][co-3])&&
				   (grille[li][co]!="_"))
					align=true;
			}
		}
		return(align);
	}
	
	
	
	public static boolean verVertic()
	{
		boolean align=false;
		for(li=0;li<4;li++)
		{
			for(co=0;co<11;co++)
			{
				if((grille[li][co]==grille[li+1][co])&&
				   (grille[li][co]==grille[li+2][co])&&
				   (grille[li][co]==grille[li+3][co])&&
				   (grille[li][co]!="_"))
					align=true;
			}
		}
		return(align);
	}
	
	
	
	public static boolean verHoriz()
	{
		boolean align=false;
		for(li=0;li<7;li++)
		{
			for(co=0;co<8;co++)
			{
				if((grille[li][co]==grille[li][co+1])&&
				   (grille[li][co]==grille[li][co+2])&&
				   (grille[li][co]==grille[li][co+3])&&
				   (grille[li][co]!="_"))
					align=true;
			}
		}
		return(align);
	}

*/