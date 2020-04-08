import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VuePuissance4 extends JPanel{
	
	 public static  int LIGNE = 6; 								// Ligne MAX du plateau
	 public static  int COLONNE = 7; 							// Colonne MAX du plateau
	 private JLabel joueurCourant; 								// JLabel qui prend le tour du joueur
	 private JLabel nbTour;										// Variable qui récupère le nombre de tour
	 private JLabel avancerPartie;								// Indique l'état du jeu (ex : le nom du vainceur/ colonne pleinne)
	 private JButtonPlateauPuissance4[][]plateau; 				// Plateau du jeu
	 private JButtonPlateauPuissance4[]tableauActions;  		// Tableau qui va nous servir a choisir la colonne dans laquel on va placer le pion
	 URL caseImg = getClass().getResource("/Images/Case.png");  // URL de l'icon utiliser
	 

	public VuePuissance4(){
		this.setLayout(new BorderLayout());
		ControleurPuissance4 controler = new ControleurPuissance4(this);
		//création de l'entête de la fenêtre
		JPanel nord = new JPanel(new GridLayout(1,3));
		
		// Création des éléments
		JButton recommencer = new JButton("Recommencer");
		recommencer.addActionListener(controler);
		joueurCourant = new JLabel("Joueur 1");
		nbTour = new JLabel("Score : ");
		
		
		// Ajout des éléments dans le dans les Différent Panel
		nord.add(recommencer);
		nord.add(nbTour);
		nord.add(joueurCourant);
		this.add(nord,BorderLayout.NORTH);
		
		// création d'un élement centrale 
		JPanel centre = new JPanel(new GridLayout(7,6));
		
		// création du plateau de jeu 
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
		
		// Création des bouton de selection
		this.tableauActions = new JButtonPlateauPuissance4[COLONNE];
		for(int i  = 0 ; i < COLONNE ; i++) {
			this.tableauActions[i]= new JButtonPlateauPuissance4(i,0);
			this.tableauActions[i].addActionListener(controler);
			centre.add(this.tableauActions[i]);
		}
		
		// Ajout des boutons de selection dans le JPanel
		this.add(centre,BorderLayout.CENTER);
		
		// création du panel sud (bas de fenetre)
		JPanel sud = new JPanel(new GridLayout(1,6));
		
		//JLabel de création de gagnant
		this.avancerPartie = new JLabel("Partie en cour !");
		
		// Ajout des différents élément dans les Différents panel 
		sud.add(avancerPartie);
		this.add(sud,BorderLayout.SOUTH);	
		
	}
	
	public void setIconPlateau(int ligne, int colonne, Icon icon ) {
		this.plateau[ligne][colonne].setIcon(icon);
	}

	public void setJoueurCourant(String joueurCourant) {
		this.joueurCourant.setText(joueurCourant);
	}

	public void setNbTour(String nbTour) {
		this.nbTour.setText(nbTour);
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
	
	public void unlockButton(){
		for(int i  = 0 ; i < COLONNE ; i++) {
			this.tableauActions[i].setEnabled(true);
		}
	}
}
