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
	public PlayerInfoPanel(ArrayList<Player> players){
		JPanel panel = setPanel(players);
		frame.setTitle("Player Info");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 900);
		frame.setLocation(1000,0);
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
	public void updateInfo(ArrayList<Player> players){
		JPanel panel = setPanel(players);
		//3frame.setVisible(false);
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
	private JPanel setPanel(ArrayList<Player> players){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,4,0,0));
		for(int i = 0; i < players.size(); i++)
			panel.add(updatePanel(players.get(i),i));
		return panel;
	}
	public JPanel updatePanel(Player player, int box){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		panel.add(new JLabel(player.name));
		panel.add(new JLabel("Money: " + player.playerMoney()));
		panel.add(new JLabel("Properties Owned: "));
		for(int i = 0; i < player.numberOfCards(); i++)
			panel.add(new JLabel(player.nthCard(i).name() +"("+(player.nthCard(i).getColor())+"), Houses: "+ (player.nthCard(i).getNumHouses()+1)));
		return panel;
	}
}