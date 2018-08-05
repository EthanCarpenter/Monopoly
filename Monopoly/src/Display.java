/*
 * William Cox and Parker Tewell
 * Monopoly
 * Independent Project
 */
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 * Displays info from Game
 * @author parkertewell
 */
public class Display extends JPanel{
	private InfoPanel infoPanel;
	private Image dbImage;
	private Graphics dbg;
	private JFrame frame;
	public Display(ArrayList<Player> players){
		repaint();
		frame = new JFrame();
		frame.setLayout(new GridLayout(0,2));
		frame.add(new Board(players));
		frame.add(new InfoPanel(players));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.dispose();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.repaint();
	}
//	public void paint(Graphics g){
//		dbImage = createImage(getWidth(), getHeight());
//		dbg = dbImage.getGraphics();
//		paintComponent(dbg);
//		g.drawImage(dbImage, 0, 0, this);
//	}
}
/**
 * @author parkertewell
 * Displays Images like the Board and shows players on the board
 */
class Board extends JPanel {
	Image monoBoard;
	Image blueSquare;
	Image greenSquare;
	Image purpleSquare;
	Image redSquare;
	public Board (ArrayList<Player> players) {
		try{
			monoBoard = ImageIO.read(new File("Pictures/Board.gif"));
		}catch(Exception E){}
	}
	public void paintComponent(Graphics h){
		h.drawImage(monoBoard, 0, 0,this);
//		h.setColor(Color.red);
//		h.fillOval(firstX, firstY, 10, 10);
//		h.setColor(Color.green);
//		h.fillOval(secondX, secondY , 10, 10);
//		h.setColor(Color.blue);
//		h.fillOval(thirdX, thirdY, 10, 10);
//		h.setColor(Color.orange);
//		h.fillOval(fourthX, fourthY, 10, 10);
	}
}
/**
 * @author ptewel5086
 * Displays the money, properties owned
 */
class InfoPanel extends JPanel{
	/**
	 * Displays the info of each player in players
	 * @param players
	 */
	public InfoPanel(ArrayList<Player> players){
		setLayout(new GridLayout(2,players.size(),0,0));
		for(int i = 0; i < players.size(); i++)
			add(updatePanel(players.get(i),i));
	}
	public void updateInfo(ArrayList<Player> players){
		setVisible(true);
	}
	public JPanel updatePanel(Player player, int box){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
		panel.setBackground(player.color);
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