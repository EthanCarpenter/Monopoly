import javax.swing.JFrame;
/**
 * @author ptewel5086
 * Displays the money, properties owned
 */
public class PlayerInfoPanel {
	public PlayerInfoPanel(MonopolyBoard game){
		JFrame frame = new JFrame();
		frame.setTitle("Player Info");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
	}
}