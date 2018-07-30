/*
 * William Cox and Parker Tewell
 * Monopoly
 * Independent Project
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.*;
/**
 * Displays info from Game
 * @author parkertewell
 */
public class Board extends JPanel{
	static PlayerInfoPanel infoPanel;
	//private static ArrayList<Player> players;
	private Player tracker;
	private ArrayList<Slot> board;
	private Image dbImage;
	private Graphics dbg;
	Image monoBoard;
	Image blueSquare;
	Image greenSquare;
	Image purpleSquare;
	Image redSquare;
	Board(){

		//setPlayers(new ArrayList());
		
		setBoard();
		ImageIcon a = new ImageIcon("Pictures//americanMonopoly.gif");
		monoBoard = a.getImage();
		ImageIcon b = new ImageIcon("Pictures//Blue Square.png");
		blueSquare = b.getImage();
		ImageIcon c = new ImageIcon("Pictures//Green Square.png");
		greenSquare = c.getImage();
		ImageIcon d = new ImageIcon("Pictures//Purple Square.png");
		purpleSquare = d.getImage();
		ImageIcon e = new ImageIcon("Pictures//Red Square.png");
		redSquare = e.getImage();
		//setTitle("Monopoly");
		setSize(600,650);
		//setResizable(false);
		setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void paint(Graphics g){
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
	}
	public void paintComponent(Graphics h){
//		h.drawImage(monoBoard, 0, 50,this);
//		h.setColor(Color.red);
//		h.fillOval(firstX, firstY, 10, 10);
//		h.setColor(Color.green);
//		h.fillOval(secondX, secondY , 10, 10);
//		h.setColor(Color.blue);
//		h.fillOval(thirdX, thirdY, 10, 10);
//		h.setColor(Color.orange);
//		h.fillOval(fourthX, fourthY, 10, 10);
//		repaint();
	}
}
/**
 * @author ptewel5086
 * Displays the money, properties owned
 */
class PlayerInfoPanel {
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
			panel.add(new JLabel(player.nthCard(i).name() +
					"("+(player.nthCard(i).getColor())+"), Houses: "
					+ (player.nthCard(i).getNumHouses()+1)));
		return panel;
	}
}