import javax.swing.JFrame;
import javax.swing.JPanel;
public class Monopoly{
	static JFrame monopoly;
	public Monopoly() {
		monopoly = new JFrame();
		monopoly.setTitle("Monopoly");
		monopoly.add(new MainMenu());
		monopoly.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		monopoly.setExtendedState(JFrame.MAXIMIZED_BOTH);
		monopoly.dispose();
		monopoly.setVisible(true);
	}
	public static void updateJPanel(JPanel newPanel) {
		JFrame f = new JFrame();
		f.setTitle("Monopoly");
		f.add(newPanel);
		Monopoly.monopoly = f;
		Monopoly.monopoly.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Monopoly.monopoly.dispose();
		Monopoly.monopoly.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Monopoly.monopoly.setVisible(true);
		Monopoly.monopoly.repaint();
	}
	public static void main(String[] args){
		new Monopoly();
	}
}