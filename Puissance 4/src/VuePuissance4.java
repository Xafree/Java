import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.net.URL;
import java.util.TimerTask;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VuePuissance4 extends JPanel{
	
	 public static  int LIGNE = 6; 											// Ligne MAX du plateau
	 public static  int COLONNE = 7; 										// Colonne MAX du plateau
	 private JLabel joueurCourant; 											// JLabel qui prend le tour du joueur
	 private JLabel score;													// Variable qui r�cup�re le nombre de tour
	 private JLabel avancerPartie;											// Indique l'�tat du jeu (ex : le nom du vainceur/ colonne pleinne)
	 private JButtonPlateauPuissance4[][]plateau; 							// Plateau du jeu
	 private JButtonPlateauPuissance4[]tableauActions;  					// Tableau qui va nous servir a choisir la colonne dans laquel on va placer le pion
	 URL caseImg = getClass().getResource("/Images/Case.png");  			// URL de l'icon utiliser
	 URL croisRouge = getClass().getResource("/Images/croix_rouge.png");  	// URL de l'icon croix rouge
	 

	public VuePuissance4(){
		this.setLayout(new BorderLayout());
		ControleurPuissance4 controler = new ControleurPuissance4(this);
		//cr�ation de l'ent�te de la fen�tre
		JPanel nord = new JPanel(new GridLayout(1,3));
		
		// Cr�ation des �l�ments
		JButton recommencer = new JButton("Recommencer");
		recommencer.addActionListener(controler);
		joueurCourant = new JLabel("Joueur 1");
		score = new JLabel("Joueur 1 : 0 | Joueur 2 : 0");
		
		
		// Ajout des �l�ments dans le dans les Diff�rent Panel
		nord.add(recommencer);
		nord.add(score);
		nord.add(joueurCourant);
		this.add(nord,BorderLayout.NORTH);
		
		// cr�ation d'un �lement centrale 
		JPanel centre = new JPanel(new GridLayout(7,7));
		
		// cr�ation du plateau de jeu 
		this.plateau = new JButtonPlateauPuissance4[LIGNE][COLONNE];
		Icon caseVide = new ImageIcon(caseImg);
		for(int i=0; i < LIGNE  ; i++){
			for(int j=0; j < COLONNE; j++){
				this.plateau[i][j] = new JButtonPlateauPuissance4(i,j);
				this.plateau[i][j].setIcon(caseVide);
				//On l'ajoute dans le JPanel central
				centre.add(this.plateau[i][j]);
			}
		}
		
		// Cr�ation des bouton de selection
		this.tableauActions = new JButtonPlateauPuissance4[COLONNE+1];
		for(int i  = 0 ; i < COLONNE ; i++) {
			this.tableauActions[i]= new JButtonPlateauPuissance4(i,0);
			this.tableauActions[i].addActionListener(controler);
			centre.add(this.tableauActions[i]);
		}
		
		// Ajout des boutons de selection dans le JPanel
		this.add(centre,BorderLayout.CENTER);
		
		// cr�ation du panel sud (bas de fenetre)
		JPanel sud = new JPanel(new GridLayout(1,2));
		
		//JLabel de cr�ation de gagnant
		this.avancerPartie = new JLabel("Partie en cour !");
		Icon croix_rouge = new ImageIcon(croisRouge);
		this.tableauActions[COLONNE]= new JButtonPlateauPuissance4(COLONNE,0);
		this.tableauActions[COLONNE].setIcon(croix_rouge);
		this.tableauActions[COLONNE].addActionListener(controler);
		// Ajout des diff�rents �l�ment dans les Diff�rents panel 
		sud.add(this.tableauActions[COLONNE]);
		sud.add(avancerPartie);
		this.add(sud,BorderLayout.SOUTH);
	}
	
	public void deplacerJetons(int column) {
		Icon caseVide = new ImageIcon(caseImg);
		int restriction = 0;
		for(int i = 5 ; i > restriction-1 ; i--) {
			if(i == 0) {
				this.setIconPlateau(0, column,caseVide);
			}else {
				this.setIconPlateau(i, column,this.plateau[i-1][column].getIcon());
			}
		}
	}
	
	public void setIconPlateau(int ligne, int colonne, Icon icon ){
		this.plateau[ligne][colonne].setIcon(icon);
	}
 
	public void setJoueurCourant(String joueurCourant) {
		this.joueurCourant.setText(joueurCourant);
	}

	public void setScore(String score) {
		this.score.setText(score);
	}

	public void setAvancerPartie(String texte) {
		this.avancerPartie.setText(texte);;
	}
	
	public void resetPlateau() {
		 Icon caseVide = new ImageIcon(caseImg);
			for(int i=0; i < LIGNE  ; i++){
				for(int j=0; j < COLONNE; j++){
					this.plateau[i][j].setIcon(caseVide);
				}
			}
	 }
		
	public void lockButton() {
		for(int i  = 0 ; i < COLONNE ; i++) {
			this.tableauActions[i].setEnabled(false);
		}
	}
	
	public void lockUnBouton(int i) {
		this.tableauActions[i].setEnabled(false);
	}
	
	public void unLockUnBouton(int i) {
		this.tableauActions[i].setEnabled(true);
	}
	
	public void unlockButton(){
		for(int i  = 0 ; i < COLONNE ; i++) {
			this.tableauActions[i].setEnabled(true);
		}
	}
}