import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VuePuissance4 extends JPanel{
	
	 public static  int LIGNE = 7; 		// Ligne MAX du plateau
	 public static  int COLONNE = 6; 	// Colonne
	 private JLabel joueurCourant; 		//JLabel qui prend le tour du joueur
	 private JLabel nbTour;				// Variable qui r�cup�re le nombre de tour
	 private JButton[][]plateau; 		// Plateau du jeu

	public VuePuissance4(){
		this.setLayout(new BorderLayout());
		
		//cr�ation de l'ent�te de la fen�tre
		JPanel nord = new JPanel(new GridLayout(1,3));
		
		// Cr�ation des �l�ments
		JButton recommencer = new JButton("Recommencer"); 
		joueurCourant = new JLabel("Joueur 1"); 
		nbTour = new JLabel("Tour 1");
		
		// Ajout des �l�ments dans le dans les Diff�rent Panel
		nord.add(recommencer);
		nord.add(nbTour);
		nord.add(joueurCourant);
		this.add(nord,BorderLayout.NORTH);
		
		// cr�ation d'un �lement centrale 
		JPanel centre = new JPanel(new GridLayout(7,6));
		// cr�ation du plateau de jeu 
		this.plateau = new JButton[LIGNE][COLONNE];
		URL casseImg = getClass().getResource("/CaseRouge.png");
		Icon casseVide = new ImageIcon(casseImg);
		for(int i= 0; i < LIGNE ; i++){
			for(int j= 0; j < COLONNE; j++){
				this.plateau[i][j] = new JButton(casseVide);
				this.plateau[i][j].setEnabled(true);
				//this.plateau[i][j].addActionListener(controler);
				//On l'ajoute dans le JPanel central
				centre.add(this.plateau[i][j]);
			}
		}
		// Cr�ation des bouton de selection
		for(int i  = 0 ; i < 7 ; i++) {
			int j = i+1;
			centre.add(new JButton(""+j+""));
		}
		// Ajout des boutons de selection dans le JPanel
		this.add(centre,BorderLayout.CENTER);
		// cr�ation du panel sud (bas de fenetre)
		JPanel sud = new JPanel(new GridLayout(1,6));
		//JLabel de cr�ation de gagnant
		JLabel etatPartie = new JLabel("Partie en cour !");
		// Ajout des diff�rents �l�ment dans les Diff�rents panel 
		sud.add(etatPartie);
		this.add(sud,BorderLayout.SOUTH);	
		
	}	
}
