import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ControleurPuissance4 implements ActionListener {

	private EtatPuissance4 etat;
	private VuePuissance4  vue;
	private  ModelPuissance4 modele;
	
	public ControleurPuissance4 (VuePuissance4 vue) {
		this.vue = vue;
		this.modele = new ModelPuissance4() ;
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
			
		JButton source  = (JButton)arg0.getSource();
		
		if(!source.getText().equals("Recommencer")){
			switch(etat) {
			case JOUEUR1 :
				
				
				break;
			case JOUEUR2:
				
				
				break;
			default :
				
			}
		}
	}

}
