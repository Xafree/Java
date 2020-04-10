import java.awt.GridLayout;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
			JFrame f = new JFrame();
			f.setLayout(new GridLayout(1,1));
			f.add(new VuePuissance4());
			f.pack();
			f.setVisible(true);
			f.setSize(585,730);
			f.setTitle("Puissance 4");
			
	}

}
