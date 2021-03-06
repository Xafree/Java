import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ControleurPuissance4 implements ActionListener {

	private EtatPuissance4 etatPartie;
	private VuePuissance4  vue;
	private ModelPuissance4 modele;
	private	int score_joueur1 = 0;
	private int score_joueur2 = 0;
	private boolean retirerJetonJoueur1 ;
	private boolean retirerJetonJoueur2 ;
	int NbRetirerJetonUtiliserJoueur1 = 0;
	int NbRetirerJetonUtiliserJoueur2 = 0;
	
	public ControleurPuissance4 (VuePuissance4 vue) {
		this.vue = vue;
		this.etatPartie = EtatPuissance4.JOUEUR1;
		this.modele = new ModelPuissance4() ;
		this.retirerJetonJoueur1 = false;
		this.retirerJetonJoueur2 = false;
		this.NbRetirerJetonUtiliserJoueur1 = 0;
		this.NbRetirerJetonUtiliserJoueur2 = 0;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		URL caseJetonJaune = getClass().getResource("/Images/CaseJaune.png");
		Icon JetonJaune = new ImageIcon(caseJetonJaune);
		URL caseJetonRouge = getClass().getResource("/Images/CaseRouge.png");
		Icon JetonRouge = new ImageIcon(caseJetonRouge);

		
		JButton source  = (JButton)arg0.getSource();
		if(!source.getText().equals("Recommencer")){
			JButtonPlateauPuissance4 sourcePlacement = (JButtonPlateauPuissance4) source;
			switch(etatPartie) {
			
				case JOUEUR1:
					
					if(retirerJetonJoueur1 == true && NbRetirerJetonUtiliserJoueur1 < 1) {
						vue.deplacerJetons(sourcePlacement.getIndexI());
						modele.deplacerJeton(sourcePlacement.getIndexI());
						etatPartie = EtatPuissance4.JOUEUR2;
						NbRetirerJetonUtiliserJoueur1++;
						vue.lockUnBouton(7);
						this.retirerJetonJoueur1 = false;
						
					}else {
						etatPartie = EtatPuissance4.JOUEUR2;
						vue.setAvancerPartie(" Partie en cour ! ");
						//Phase de test 
						
//						System.out.println("Colonne : "+sourcePlacement.getIndexI());
//						System.out.println("ligne   : "+modele.nbJetonPlacerDansColonnes(sourcePlacement.getIndexJ()));
//						System.out.println("Nombre jeton dans la colonne : "+(modele.nbJetonPlacerDansColonnes(sourcePlacement.getIndexI())-1)+"\n");
						//Placement de pion 


						if(sourcePlacement.getIndexI() == 7) {
							this.retirerJetonJoueur1 = true;
							etatPartie = EtatPuissance4.JOUEUR1;
							sourcePlacement.setEnabled(false);
							vue.setJoueurCourant("Joueur 1 � vous de jouer !");
							vue.setAvancerPartie(" Joueur 1 retir� un jeton ");
						}else if(modele.nbJetonPlacerDansColonnes(sourcePlacement.getIndexI()) == 0) {
							int colonne = sourcePlacement.getIndexI()+1;
							vue.setAvancerPartie("Vous pouvez plus placer de jeton dans la colonne "+colonne);
						}else {
							modele.placerPion(sourcePlacement.getIndexI(),EtatPuissance4.JOUEUR1);
							vue.setIconPlateau(modele.nbJetonPlacerDansColonnes(sourcePlacement.getIndexI()),sourcePlacement.getIndexI(),JetonJaune);	
							vue.setJoueurCourant("Joueur 2 � vous de jouer !");
						}
						
					}
					
					if( NbRetirerJetonUtiliserJoueur2 == 1) {
						vue.lockUnBouton(7);
					}else {
						vue.unLockUnBouton(7);
					}
					System.out.println(modele.toString());
					vue.setJoueurCourant("Joueur 2 � vous de jouer !");
					
					break;
					
				case JOUEUR2:

					if(retirerJetonJoueur2 && NbRetirerJetonUtiliserJoueur2 < 1) {
						vue.deplacerJetons(sourcePlacement.getIndexI());
						modele.deplacerJeton(sourcePlacement.getIndexI());
						etatPartie = EtatPuissance4.JOUEUR1;
						NbRetirerJetonUtiliserJoueur2++;
						vue.lockUnBouton(7);
						this.retirerJetonJoueur2 = false;
						System.out.println("test5");
					}else{
						etatPartie = EtatPuissance4.JOUEUR1;
						
						//Phase de test 
						
//						System.out.println("Colonne : "+sourcePlacement.getIndexI());
//						System.out.println("ligne   : "+modele.nbJetonPlacerDansColonnes(sourcePlacement.getIndexJ()));
//						System.out.println("Nombre jeton dans la colonne : "+(modele.nbJetonPlacerDansColonnes(sourcePlacement.getIndexI())-1)+"\n");
						
						//Placement de pion 
						if(sourcePlacement.getIndexI() == 7) {
							this.retirerJetonJoueur2 = true;
							System.out.println("test3");
							etatPartie = EtatPuissance4.JOUEUR2;
							System.out.println("test4");
							vue.setAvancerPartie(" Joueur 2 retir� un jeton ");
							vue.setJoueurCourant("Joueur 2 � vous de jouer !");
						}else if(modele.nbJetonPlacerDansColonnes(sourcePlacement.getIndexI()) == 0) {
							int colonne = sourcePlacement.getIndexI()+1;
							vue.setAvancerPartie("Vous pouvez plus placer de jeton dans la colonne "+colonne);
						}else {
							modele.placerPion(sourcePlacement.getIndexI(),EtatPuissance4.JOUEUR2);
							vue.setIconPlateau(modele.nbJetonPlacerDansColonnes(sourcePlacement.getIndexI()),sourcePlacement.getIndexI(),JetonRouge);	
						}
					}
					
					if( NbRetirerJetonUtiliserJoueur1 == 1) {
						vue.lockUnBouton(7);
					}else {
						vue.unLockUnBouton(7);
					}
					vue.setJoueurCourant("Joueur 1 � vous de jouer !");
					System.out.println(modele.toString());
					break;			
			}
		}else {
			//Quand on appuie sur le bonton recommencer
			modele.viderPlateau();
			this.retirerJetonJoueur2 = false;
			this.retirerJetonJoueur1= false;
			this.NbRetirerJetonUtiliserJoueur2 = 0;
			this.NbRetirerJetonUtiliserJoueur1 = 0;
			vue.setAvancerPartie("Partie recommencer");
			vue.unlockButton();
			vue.resetPlateau();
			vue.unLockUnBouton(7);
			System.out.println(modele.toString());
		}
		
		//Condition de victoire
		if(modele.PartieGagnerJaune()) {
			this.score_joueur1 = this.score_joueur1+1;
			vue.lockButton();
			vue.lockUnBouton(7);
			vue.setAvancerPartie("Joueur 1 vous avez gagner la partie !");
			vue.setScore("Joueur 1 : "+score_joueur1+" | Joueur 2 : "+score_joueur2+"");
			etatPartie = EtatPuissance4.JOUEUR1;
		}else if(modele.PartieGagnerRouge()) {
			this.score_joueur2 = this.score_joueur2+1;
			vue.lockButton();
			vue.lockUnBouton(7);
			vue.setAvancerPartie("Joueur 2 vous avez gagner la partie !");
			vue.setScore("Joueur 1 : "+score_joueur1+" | Joueur 2 : "+score_joueur2+"");
			etatPartie = EtatPuissance4.JOUEUR2;
		}else if(modele.egalite()){
			vue.setAvancerPartie("Nous nous trouvons sur une �galit� !");
			vue.lockButton();
			vue.lockUnBouton(7);
		}
	}
}

