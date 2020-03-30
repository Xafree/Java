import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VuePuissance4 extends JPanel{
	
	 private JLabel joueurCourant;
	 private JLabel nbTour;
	 private JButton[][]plateau;

	public VuePuissance4(){
		// création du panel principal
		this.setLayout(new BorderLayout());
		//création de l'entête de la fenêtre
		JPanel nord = new JPanel(new GridLayout(1,3));
		JButton recommencer = new JButton("Recommencer"); // bouton de reset
		joueurCourant = new JLabel("Joueur 1"); // JLabel
		nbTour = new JLabel("Tour 1");
		nord.add(recommencer);
		nord.add(nbTour);
		nord.add(joueurCourant);
		this.add(nord,BorderLayout.NORTH);
		
		
		JPanel centre = new JPanel(new GridLayout(7,6));
		this.plateau = new JButton[7][6];
		for(int i= 0; i < 7 ; i++){
			for(int j= 0; j < 6; j++){
				this.plateau[i][j] = new JButton("");
				this.plateau[i][j].setEnabled(false);
				//this.plateau[i][j].addActionListener(controler);
				centre.add(this.plateau[i][j]);
			}
		}
		
		for(int i  = 0 ; i < 7 ; i++) {
			int j = i+1;
			centre.add(new JButton(""+j+""));
		}
		
		this.add(centre,BorderLayout.CENTER);

		JPanel sud = new JPanel(new GridLayout(1,6));
		JLabel etatPartie = new JLabel("Partie en cour !");
		sud.add(etatPartie);
		this.add(sud,BorderLayout.SOUTH);	
		
	}
	
}
