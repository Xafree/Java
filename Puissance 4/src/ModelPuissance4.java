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
	 
	 public boolean PartieGagner() {
		 return verifLigne() || this.verifColonne()|| verifDiagDroit() || verifDiagGauche();
		}
		
	 public boolean verifLigne() {
		 boolean verif = false;
		 for (int x=0; x < LIGNE  ; x++){
			for (int y=0; y < COLONNE ; y++){
				if( x < LIGNE-3) {
					if((this.plateau[x][y]==this.plateau[x+1][y])&&
							(this.plateau[x][y]==this.plateau[x+2][y])&&
							(this.plateau[x][y]==this.plateau[x+3][y])&&
							(this.plateau[x][y]!=EtatPuissance4.CASEVIDE))
							verif = true;
				}
			}
		 }
		 return verif;
	 }
	 
	 public boolean verifColonne() {
		 boolean verif = false;
		 for (int i=0; i < LIGNE  ; i++){
			for (int y=0; y < COLONNE ; y++){
				if( y < COLONNE-3) {
					if((this.plateau[i][y]==this.plateau[i][y+1])&&
							(this.plateau[i][y]==this.plateau[i][y+2])&&
							(this.plateau[i][y]==this.plateau[i][y+3])&&
							(this.plateau[i][y]!=EtatPuissance4.CASEVIDE))
							verif = true;
				}
			}
		 }
		 return verif;
	 }
	 
	 public boolean verifDiagDroit() {
			boolean verif = false;
			for(int i=0 ; i < LIGNE ; i++){
				for(int y=0 ; y<COLONNE ;y ++){
					if( y < COLONNE-3 && i < LIGNE-3) {
						if((this.plateau[i][y]==this.plateau[i+1][y+1])&&
							(this.plateau[i][y]==this.plateau[i+2][y+2])&&
							(this.plateau[i][y]==this.plateau[i+3][y+3])&&
							(this.plateau[i][y]!=EtatPuissance4.CASEVIDE))
							verif=true;
					}
				}
			}
			return verif;
	 }
	 
	 public boolean verifDiagGauche() {
			boolean verif = false;
			for(int i=0 ; i < LIGNE ; i++){
				for(int y=0 ; y<COLONNE ;y ++){
					if( y < COLONNE-3 && i < LIGNE-3) {
						if((this.plateau[i][y]==this.plateau[i+1][y-1])&&
							(this.plateau[i][y]==this.plateau[i+2][y-2])&&
							(this.plateau[i][y]==this.plateau[i+3][y-3])&&
							(this.plateau[i][y]!=EtatPuissance4.CASEVIDE))
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
//retourne true si puissance 4 trouvé dans la this.plateau
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
				if((this.plateau[li][co]==this.plateau[li+1][co+1])&&
				   (this.plateau[li][co]==this.plateau[li+2][co+2])&&
				   (this.plateau[li][co]==this.plateau[li+3][co+3])&&
				   (this.plateau[li][co]!="_"))
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
				if((this.plateau[li][co]==this.plateau[li+1][co-1])&&
				   (this.plateau[li][co]==this.plateau[li+2][co-2])&&
				   (this.plateau[li][co]==this.plateau[li+3][co-3])&&
				   (this.plateau[li][co]!="_"))
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
				if((this.plateau[li][co]==this.plateau[li+1][co])&&
				   (this.plateau[li][co]==this.plateau[li+2][co])&&
				   (this.plateau[li][co]==this.plateau[li+3][co])&&
				   (this.plateau[li][co]!="_"))
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
				if((this.plateau[li][co]==this.plateau[li][co+1])&&
				   (this.plateau[li][co]==this.plateau[li][co+2])&&
				   (this.plateau[li][co]==this.plateau[li][co+3])&&
				   (this.plateau[li][co]!="_"))
					align=true;
			}
		}
		return(align);
	}
	
	
	
	
	

			
			
			 public boolean verDiagDroit(){
			boolean align=false;
			for( int li=0;li<4;li++){
				for(int co=0;co<8;co++){
					if((this.plateau[li][co]==this.plateau[li+1][co+1])&&
					   (this.plateau[li][co]==this.plateau[li+2][co+2])&&
					   (this.plateau[li][co]==this.plateau[li+3][co+3])&&
					   (this.plateau[li][co] != EtatPuissance4.CASEVIDE))
						align=true;
				}
			}
			return(align);
		}

	public boolean verDiagGauch(){
			boolean align=false;
			for( int li=0;li<4;li++){
				for(int co=3;co<11;co++){
					if((this.plateau[li][co]==this.plateau[li+1][co-1])&&
					   (this.plateau[li][co]==this.plateau[li+2][co-2])&&
					   (this.plateau[li][co]==this.plateau[li+3][co-3])&&
					   (this.plateau[li][co]!= EtatPuissance4.CASEVIDE))
						align=true;
				}
			}
			return(align);
		}
		
		
				public boolean verVertic(){
			boolean align=false;
			for( int li=0;li<4;li++){
				for(int co=0;co<11;co++){
					if((this.plateau[li][co]==this.plateau[li+1][co])&&
					   (this.plateau[li][co]==this.plateau[li+2][co])&&
					   (this.plateau[li][co]==this.plateau[li+3][co])&&
					   (this.plateau[li][co]!= EtatPuissance4.CASEVIDE))
						align=true;
				}
			}
			return(align);
		}
*/