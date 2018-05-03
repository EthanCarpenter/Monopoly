import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * @author ptewel5086
 * Displays the money, properties owned
 */
public class PlayerInfoPanel {
	private JFrame frame = new JFrame();
	public PlayerInfoPanel(ArrayList<MonopolyPlayer> players){
		JPanel panel = setPanel(players);
		frame.setTitle("Player Info");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setLocation(600,0);
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
	public void updateInfo(ArrayList<MonopolyPlayer> players){
		JPanel panel = setPanel(players);
		//3frame.setVisible(false);
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
	private JPanel setPanel(ArrayList<MonopolyPlayer> players){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,4,0,0));
		for(int i = 0; i < players.size(); i++)
			panel.add(updatePanel(players.get(i),i));
		return panel;
	}
	public JPanel updatePanel(MonopolyPlayer player, int box){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		panel.add(new JLabel(player.name));
		panel.add(new JLabel("Money: " + player.playerMoney()));
		panel.add(new JLabel("Properties Owned: "));
		System.out.println(player.numberOfCards()+"qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
		for(int i = 0; i < player.numberOfCards(); i++){
			panel.add(new JLabel(player.nthCard(i).name()));
			System.out.println(player.nthCard(i).name()+"ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
		}
		return panel;
	}
}