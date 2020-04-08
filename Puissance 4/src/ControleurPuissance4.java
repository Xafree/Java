import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ControleurPuissance4 implements ActionListener {

	private EtatPuissance4 etatPartie;
	private VuePuissance4  vue;
	private  ModelPuissance4 modele;
	
	public ControleurPuissance4 (VuePuissance4 vue) {
		this.vue = vue;
		this.etatPartie = EtatPuissance4.JOUEUR1;
		this.modele = new ModelPuissance4() ;
		
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
				etatPartie = EtatPuissance4.JOUEUR2;
				
				//Phase de test 
				System.out.println("Colonne : "+sourcePlacement.getIndexI());
				System.out.println("ligne   : "+modele.nbJetonPlacerDansColonnes(sourcePlacement.getIndexJ()));
				System.out.println("Nombre jeton dans la colonne : "+modele.nbJetonPlacerDansColonnes(sourcePlacement.getIndexJ())+"\n");
				
				//Placement de pion 
				if(modele.nbJetonPlacerDansColonnes(sourcePlacement.getIndexI()) == 0) {
					int colonne = sourcePlacement.getIndexI()+1;
					vue.setAvancerPartie("Vous pouvez plus placer de jeton dans la colonne "+colonne);
				}else {
					modele.placerPion(sourcePlacement.getIndexI(),EtatPuissance4.JOUEUR1);
					vue.setIconPlateau(modele.nbJetonPlacerDansColonnes(sourcePlacement.getIndexI()),sourcePlacement.getIndexI(),JetonJaune);
				}
				
				// condition de victoire
				if(modele.PartieGagner()){
					vue.lockButton();
					vue.setAvancerPartie("Joueur 1 vous avez gagner la partie !");
					etatPartie = EtatPuissance4.JOUEUR1;
				}else if(modele.egalite()){
					vue.setAvancerPartie("Nous nous trouvons sur une égalité !");
					vue.lockButton();
				}else {
					vue.setJoueurCourant("Joueur 2 à vous de jouer !");
				}
				System.out.println(modele.toString());
				
				break;
			case JOUEUR2:
				etatPartie = EtatPuissance4.JOUEUR1;
				//Phase de test 
				System.out.println("Colonne choisi : "+sourcePlacement.getIndexI());
				System.out.println("ligne   : "+modele.nbJetonPlacerDansColonnes(sourcePlacement.getIndexJ()));
				System.out.println("Nombre de place libre : "+modele.nbJetonPlacerDansColonnes(sourcePlacement.getIndexJ())+"\n");
				
				//Placement de pion 
				if(modele.nbJetonPlacerDansColonnes(sourcePlacement.getIndexI()) == 0) {
					int colonne = sourcePlacement.getIndexI()+1;
					vue.setAvancerPartie("Vous pouvez plus placer de jeton dans la colonne "+colonne);
				}else {
					modele.placerPion(sourcePlacement.getIndexI(),EtatPuissance4.JOUEUR2);
					vue.setIconPlateau(modele.nbJetonPlacerDansColonnes(sourcePlacement.getIndexI()),sourcePlacement.getIndexI(),JetonRouge);
				}
				// condition de victoire
				if(modele.PartieGagner()){
					vue.lockButton();
					vue.setAvancerPartie("Joueur 2 vous avez gagner la partie !");
					etatPartie = EtatPuissance4.JOUEUR2;
				}else if(modele.egalite()){
					vue.setAvancerPartie("Nous nous trouvons sur une égalité !");
					vue.lockButton();
				}else {
					vue.setJoueurCourant("Joueur 1 à vous de jouer !");
				}
				
				System.out.println(modele.toString());
				break;
			default:
				break;				
			}
		}else {
			//Quand on appuie sur le bonton recommencer
			modele.viderPlateau();
			vue.setAvancerPartie("Partie recommencer");
			vue.unlockButton();
			vue.resetPlateau();
			System.out.println(modele.toString());
		}
	}

}
