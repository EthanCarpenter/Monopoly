import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class MainMenu extends JPanel implements ActionListener{
	private JButton start = new JButton("Play"), exit = new JButton("Exit");
	private JButton[] buttons = new JButton[] {start, exit};
	PlayerPanel[] playerPanels = new PlayerPanel[6];
	public static void main(String[] args){
		System.out.println("test");
		//new MainMenu();
	}
	MainMenu() {
		this.setLayout(null);		

		//		for(int i = 0; i < panes.length; i++) {
		//			panes[i] = new JPanel();
		//			panes[i].setBackground(Color.WHITE);
		//			this.add(panes[i]);
		//		}
		JLabel Title =new JLabel("TransAmerica");
		Title.setFont(new Font("Arail", 1, 100));
		Title.setSize(700, 75);
		Title.setLocation(800-350, 50);
		this.add(Title);
		for(int i = 0; i <= 2; i++) {
			playerPanels[i] = new PlayerPanel(i + 1);
			playerPanels[i].setSize(350, 290);
			playerPanels[i].setLocation(800+(450*(i-1))-175,250-100);
			this.add(playerPanels[i]);
		}

		for(int i = 3; i <= 5; i++) {
			playerPanels[i] = new PlayerPanel(i + 1);
			playerPanels[i].setSize(350, 290);
			playerPanels[i].setLocation(800+(450*(i-4))-175,550-100);
			this.add(playerPanels[i]);
		}
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(this);
			buttons[i].setActionCommand(buttons[i].getText());
			buttons[i].setSize(100,50);
			buttons[i].setLocation((int) (800+200*(i-.5))-50,760);
			this.add(buttons[i]);
		}
//		try{
//			backg= ImageIO.read(new File("Pix/TransAmerica Background.jpg"));
//		}catch(Exception E){}

	}
	BufferedImage backg;
	public void paint(Graphics g){
		//g.drawImage(backg, 0, 0, 1600, 900, null);
		for(int i=0;i<this.getComponentCount();i++){
			g.translate(this.getComponent(i).getX(), this.getComponent(i).getY());
			this.getComponent(i).paint(g);
			g.translate(-this.getComponent(i).getX(), -this.getComponent(i).getY());
		}

	}

//	public ArrayList<Player> generate(ArrayList<Color> playerColors, ArrayList<String> playerNames, ArrayList<String> playerType){
//		ArrayList<Player> players = new ArrayList<Player>();
//		boolean slowMode = false;
//		for(int i = 0; i<playerType.size();i++){
//			if(playerType.get(i).equals("Human")){
//				players.add(new HumanPlayer(playerColors.get(i),playerNames.get(i)));
//				slowMode = true;
//			}else if(playerType.get(i).equals("Easy")){
//				players.add(new EasyStrategy(playerColors.get(i),playerNames.get(i)));
//			}else{
//				int[] playerScores = new int[players.size()];
//				for(int j = 0;j<playerScores.length;j++){
//					playerScores[j] = 12;
//				}
//				players.add(new HardStrategy(playerColors.get(i),playerScores, playerNames.get(i)));
//			}
//		}
//		return players;
//
//	}
	class PlayerPanel extends JPanel implements ActionListener{
		private ButtonGroup group = new ButtonGroup();
		private Color[] colors = new Color[] {new Color(255, 40, 40), Color.YELLOW, new Color(0, 204, 0), Color.BLUE , new Color(139,69,19), Color.white};
		private String[] optionNames = {"None", "Human Player", "Computer"};
		private JRadioButton[] options = new JRadioButton[3];
		private String[] stratNames = {"Easy" , "Hard"};
		private JComboBox<String> strategy = new JComboBox<String>(stratNames);
		private int noPlayers = 6;
		private boolean player = false;
		private boolean humanPlayer = false;
		private JTextField name;

		int playernum;
		public void paint(Graphics g){
			g.setColor(this.colors[playernum]);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			for(int i=0;i<this.getComponentCount();i++){
				g.translate(this.getComponent(i).getX(), this.getComponent(i).getY());
				if(this.getComponent(i).isVisible()){
						g.drawImage(buttonImage, -10, -8, this.getComponent(i).getWidth()+20, this.getComponent(i).getHeight()+16, null);
					this.getComponent(i).paint(g);//needs to be specialized
				}
				g.translate(-this.getComponent(i).getX(), -this.getComponent(i).getY());
			}
		}
		BufferedImage buttonImage;
		public PlayerPanel(int playerNum) {
			try {
				buttonImage=ImageIO.read(new File("Pix\\button-design3.png"));
			} catch (IOException e1) {}
			playernum=playerNum-1;
			setBackground(colors[playerNum - 1]);
			setLayout(null);
			JLabel playernumber = new JLabel("Player " + playerNum);
			playernumber.setFont(new Font("Arial",Font.BOLD,24));
			playernumber.setLocation(25,15);
			playernumber.setSize(100, 30);
			add(playernumber);
			name = new JTextField();
			name.setText("Player " + playerNum);
			
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
			this.setPreferredSize(new Dimension(400,200));
			if(playerNum == 1) {
				options[1].setSelected(true);
				noPlayers --;
				player = true;
				humanPlayer = true;
				name.setVisible(true);
				strategy.setVisible(false);
			} else if(playerNum >= 2 && playerNum <= 4) {
				options[2].setSelected(true);
				player = true;
				humanPlayer = false;
				name.setVisible(false);
				strategy.setVisible(true);
				strategy.setSelectedIndex(1);
			} else {
				options[0].setSelected(true);
				player = false;
				humanPlayer = false;
				name.setVisible(false);
				strategy.setVisible(false);
			}		
		}	
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals(optionNames[0])) {
				player = false;
				humanPlayer = false;
				name.setVisible(false);
				strategy.setVisible(false);
			} else if(e.getActionCommand().equals(optionNames[1])) {
				player = true;
				humanPlayer = true;
				name.setVisible(true);
				strategy.setVisible(false);
				//TransAmerica.transamerica.repaint();
			} else if(e.getActionCommand().equals(optionNames[2])) {
				player = true;
				humanPlayer = false;
				name.setVisible(false);
				strategy.setVisible(true);
			}
		}
		public boolean isPlayer() {
			return player;
		}
		public boolean isHuman(){
			return humanPlayer;
		}
		public String getName() {
			return name.getText();
		}
		public String getStrategy() {
			return (String)strategy.getSelectedItem();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}