import javax.swing.JFrame;
public class Monopoly{
	static JFrame monopoly;
	public Monopoly() {
		monopoly = new JFrame();
		monopoly.setTitle("Monopoly");
		monopoly.setContentPane(new MainMenu());
		monopoly.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		monopoly.setExtendedState(JFrame.MAXIMIZED_BOTH);
		monopoly.setVisible(true);
	}
	public static void main(String[] args){
		new Monopoly();
	}
}