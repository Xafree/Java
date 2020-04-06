import javax.swing.JButton;

public class JButtonPlateauPuissance4 extends JButton {

	private int i;
	private int j;
	
	public JButtonPlateauPuissance4(int i, int j) {
		this.i = i;
		this.j = j;
	}
	
	public int getIndexI() {
		return i;
	}
	
	public int getIndexJ() {
		return this.j;
	}
}