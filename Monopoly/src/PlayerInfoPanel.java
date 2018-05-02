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
	private ArrayList<MonopolyPlayer> players;
	public PlayerInfoPanel(ArrayList<MonopolyPlayer> newPlayers){
		players = newPlayers;
		JPanel panel = setPanel();
		JFrame frame = new JFrame();
		frame.setTitle("Player Info");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setLocation(600,0);
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
	private JPanel setPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,4,0,0));
		for(int i = 0; i < 4; i++)
			panel.add(updatePanel(players.get(i),i));
		return panel;
	}
	public JPanel updatePanel(MonopolyPlayer player, int box){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		panel.add(new JLabel(player.name));
		panel.add(new JLabel("Money: " + player.playerMoney()));
		panel.add(new JLabel("Properties Owned: "));
		for(int i = 0; i < player.numberOfCards(); i++)
			panel.add(new JLabel(player.nthCard(0).name()));
		return panel;
	}
}