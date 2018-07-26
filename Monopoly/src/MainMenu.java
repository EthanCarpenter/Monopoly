import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class MainMenu extends JPanel implements ActionListener{
	private ArrayList players = new ArrayList();
	private PlayerPanel[] panels = new PlayerPanel[8];
	MainMenu() {
		setLayout(null);		
		setTitle();
		setButtons();
		setPlayerPanels(1);
	}
	private void setTitle(){
		JLabel title = new JLabel("Monopoly");
		title.setFont(new Font("Castellar", 1, 100));
		title.setSize(700, 125);
		title.setLocation(450, 0);
		add(title);
	}
	private void setButtons() {
		JButton[] buttons = {new JButton("Play"), new JButton("Exit")};
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(this);
			buttons[i].setActionCommand(buttons[i].getText());
			buttons[i].setSize(100,50);
			buttons[i].setLocation((int) (725+200*(i-.5))-50,700);
			add(buttons[i]);
		}
	}
	/**
	 * Coinsides with setButtons (play and exit)
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("Play"))
			Monopoly.monopoly.setContentPane(new Board(players));
		else
			System.exit(0);
	}
	/**
	 * @param numPlayers the number of player panels to be displayed.
	 * Works with up to 8 players
	 */
	private void setPlayerPanels(int numPlayers) {
		PlayerPanel[] panels = new PlayerPanel[numPlayers];
		for(int i = 0; i < panels.length; i++) {
			panels[i] = new PlayerPanel(i);
			panels[i].setSize(350, 290);
			panels[i].setLocation(800+(450*(i-1))-175,250-100);
			add(panels[i]);
		}
	}
	class PlayerPanel extends JPanel implements ActionListener{
		private Color[] colors = new Color[] {new Color(255, 40, 40), 
				Color.YELLOW, new Color(0, 204, 0), Color.BLUE , 
				new Color(139,69,19), Color.WHITE};
		//Three options
		private ButtonGroup group = new ButtonGroup();
		private String[] optionNames = {"None", "Human Player", "Computer"};
		private JRadioButton[] options = new JRadioButton[3];
		//Comp Strategies
		private String[] stratNames = {"Easy" , "Hard"};
		private JComboBox<String> strategy = new JComboBox<String>(stratNames);
		//Human Player
		private boolean isHuman, isPlayer;
		private JTextField name;
		/**
		 * @param playerNum starts at 0
		 */
		public PlayerPanel(int playerNum) {
			setBackground(colors[playerNum]);
			setLayout(null);
			name = new JTextField();
			name.setText("Player " + playerNum+1);
			
			for(int i = 0; i < options.length; i++) {
				options[i] = new JRadioButton(optionNames[i]);
				options[i].addActionListener(this);
				options[i].setActionCommand(optionNames[i]);
				options[i].setBackground(new Color(0,0,0,0));
				options[i].setLocation(70,65+(int) (75*(i)));
				options[i].setSize(150, 20);
				group.add(options[i]);

				add(options[i]);

				if(i == 1) {
					add(name);
					name.setVisible(false);
					name.setBounds(90, 175, 60, 25);
				} else if(i == 2) {
					add(strategy);
					strategy.setVisible(false);
					strategy.setBounds(90, 252, 60, 25);
				}
			}
			setPreSelected(playerNum);
		}
		/**
		 * Sets the preselected options when the mainMenu is first booted up
		 * @param playerNum
		 */
		private void setPreSelected(int playerNum){
			if(playerNum == 0) {
				options[1].setSelected(true);
				isPlayer = true;
				isHuman = true;
				name.setVisible(true);
				strategy.setVisible(false);
			} else if(playerNum >= 1 && playerNum <= 3) {
				options[2].setSelected(true);
				isPlayer = true;
				isHuman = false;
				name.setVisible(false);
				strategy.setVisible(true);
				strategy.setSelectedIndex(1);
			} else {
				options[0].setSelected(true);
				isPlayer = false;
				isHuman = false;
				name.setVisible(false);
				strategy.setVisible(false);
			}
		}
		private void setPlayerNum(int playerNum){
			JLabel playernumber = new JLabel("Player " + playerNum);
			playernumber.setFont(new Font("Arial",Font.BOLD,24));
			playernumber.setLocation(25,15);
			playernumber.setSize(100, 30);
			add(playernumber);
		}
//		public void paint(Graphics g){
//			g.setColor(this.colors[playernum]);
//			g.fillRect(0, 0, this.getWidth(), this.getHeight());
//			for(int i=0;i<this.getComponentCount();i++){
//				g.translate(this.getComponent(i).getX(), this.getComponent(i).getY());
//				if(this.getComponent(i).isVisible()){
//					//					if(i!=0)
//					g.drawImage(buttonImage, -10, -8, this.getComponent(i).getWidth()+20, this.getComponent(i).getHeight()+16, null);
//					this.getComponent(i).paint(g);//needs to be specialized
//				}
//				g.translate(-this.getComponent(i).getX(), -this.getComponent(i).getY());
//			}
//		}
//		BufferedImage buttonImage;
		public boolean isPlayer() {
			return isPlayer;
		}
		public boolean isHuman(){
			return isHuman;
		}
		public String getName() {
			return name.getText();
		}
		public String getStrategy() {
			return (String)strategy.getSelectedItem();
		}
		public void actionPerformed(ActionEvent e) {

		}
	}
}