import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class MainMenu extends JPanel implements ActionListener{
	private PlayerPanel[] panels = new PlayerPanel[8];
	private BufferedImage image;
	MainMenu() {
		setLayout(null);
		setButtons();
		setPlayerPanels(8);
	}
	/**
	 * Sets title
	 */
	public void paint(Graphics g){
		try{
			image = ImageIO.read(new File("Pictures/Monopoly Title.jpg"));
		}catch(Exception E){}
		g.drawImage(image, 375, 0, 700, 125, null);
		for(int i=0;i<this.getComponentCount();i++){
			g.translate(this.getComponent(i).getX(), this.getComponent(i).getY());
			this.getComponent(i).paint(g);
			g.translate(-this.getComponent(i).getX(), -this.getComponent(i).getY());
		}
	}
	private void setButtons() {
		JButton[] buttons = {new JButton("Play"), new JButton("Exit")};
		for(int i = 0; i < buttons.length; i++) {
			buttons[i].addActionListener(this);
			buttons[i].setActionCommand(buttons[i].getText());
			buttons[i].setSize(100,50);
			buttons[i].setLocation((int)(725+200*(i-.5))-50,725);
			add(buttons[i]);
		}
	}
	/**
	 * Coinsides with setButtons (play and exit)
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Play") && readyPlayers()>=2){//starts the game, either human or all ai
			ArrayList<Player> players = generatePlayers();
			if(humanGame())
				new Game(players);
			else{
				//progress to ai game
			}
		}else
			System.exit(0);
	}
	/**
	 * Gives players color, name, and type(human or some strategy)
	 * @return players
	 */
	private ArrayList<Player> generatePlayers(){
		ArrayList<Player> players = new ArrayList<Player>();
		for(PlayerPanel p : panels){
			if(p.isHuman())//Handles humans
				players.add(new Player(p.getBackground(), p.getName(), "Human"));
			else if(p.isPlayer())//Handles AI
				players.add(new Player(p.getBackground(), p.getName(), p.getStrategy()));	
		}
		return players;
	}
	/**
	 * @return the amount of players
	 */
	private int readyPlayers() {
		int ready = 0;
		for(PlayerPanel p:panels){
			if(p.isPlayer())
				ready++;
		}
		return ready;
	}
	/**
	 * Checks if game contains humans
	 * @return true if human game, false otherwise
	 */
	private boolean humanGame() {
		boolean humanGame = false;
		for(PlayerPanel p: panels){
			if(p.isHuman()){
				humanGame = true;
			}
		}
		return humanGame;
	}
	/**
	 * @param numPlayers the number of player panels to be displayed.
	 * Works with up to 8 players. Also gives values to panels[].
	 */
	private void setPlayerPanels(int numPlayers) {
		for(int i = 0; i < panels.length; i++) {
			panels[i] = new PlayerPanel(i);
			panels[i].setSize(350, 290);
			if(i < 4)
				panels[i].setLocation(360+(375*(i-1)),130);
			else
				panels[i].setLocation(360+(375*(i-5)),430);
			add(panels[i]);
		}
	}
	class PlayerPanel extends JPanel implements ActionListener{
		private Color[] colors = new Color[] {new Color(255, 40, 40), 
				Color.YELLOW, new Color(0, 204, 0), new Color(30,144,255), 
				new Color(139,69,19), new Color (255, 140, 0), new Color (255,105,180),
				new Color(147,112,219)};
		private String[] names = new String[] {"Red", "Yellow", "Green", "Blue",
				"Brown", "Orange", "Pink", "Purple"};
		private int num;
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
			num = playerNum;
			setBackground(colors[num]);
			setLayout(null);
			name = new JTextField();
			name.setText(names[num]);
			strategy.setSize(205, 100);
			setNum(num);
			setOptions();
			setPreSelected(num);
		}
		public void paint(Graphics g){
			g.setColor(this.colors[num]);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			for(int i=0;i<this.getComponentCount();i++){
				g.translate(this.getComponent(i).getX(), this.getComponent(i).getY());
				if(this.getComponent(i).isVisible())
					this.getComponent(i).paint(g);
				g.translate(-this.getComponent(i).getX(), -this.getComponent(i).getY());
			}
		}
		/**
		 * Adds options to the options radioButtons
		 */
		private void setOptions() {
			for(int i = 0; i < options.length; i++) {
				options[i] = new JRadioButton(optionNames[i]);
				options[i].addActionListener(this);
				options[i].setActionCommand(optionNames[i]);
				options[i].setLocation(70,65+(int) (75*(i)));
				options[i].setSize(150, 20);
				group.add(options[i]);
				add(options[i]);
				if(i == 1) {
					add(name);
					name.setVisible(true);
					name.setBounds(90, 175, 60, 25);
				} else if(i == 2) {
					add(strategy);
					strategy.setVisible(false);
					strategy.setBounds(90, 250, 90, 25);
				}
			}	
		}
		/**
		 * Sets the preselected options when the mainMenu is first booted up
		 * @param num
		 */
		private void setPreSelected(int num){
			if(num == 0) {
				options[1].setSelected(true);
				isPlayer = true;
				isHuman = true;
				name.setVisible(true);
				strategy.setVisible(false);
			} else if(num >= 1 && num <= 3) {
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
		private void setNum(int num){
			JLabel number = new JLabel("Player " + (num+1));
			number.setFont(new Font("Arial",Font.BOLD,24));
			number.setLocation(25,15);
			number.setSize(100, 30);
			add(number);
		}
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
			if(e.getActionCommand().equals(optionNames[0])) {
				isPlayer = false;
				isHuman = false;
				name.setVisible(false);
				strategy.setVisible(false);
			} else if(e.getActionCommand().equals(optionNames[1])) {
				isPlayer = true;
				isHuman = true;
				name.setVisible(true);
				strategy.setVisible(false);
			} else if(e.getActionCommand().equals(optionNames[2])) {
				isPlayer = true;
				isHuman = false;
				name.setVisible(false);
				strategy.setVisible(true);
			}
		}
	}
}