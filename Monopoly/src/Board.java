/*
 * William Cox and Parker Tewell
 * Monopoly
 * Independent Project
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	public Board(ArrayList<Player> players) {
		
	}
	private void setPlayers(ArrayList arrayList) {
		players = arrayList;
	}
	/**
	 * Swaps the ownership of the properties
	 * @param trader
	 * @param tradee
	 * @param traderProperty property trader gives
	 * @param tradeeProperty property tradee gives
	 */
	public void trading(int traderID, int tradeeID,
	 PropertyCard traderProperty, PropertyCard tradeeProperty){
		for(int i = 0; i < getPlayers().get(traderID-1).playerProperties().size(); i++)
			if(getPlayers().get(traderID-1).nthCard(i).equals(traderProperty)){
				getPlayers().get(tradeeID-1).addCard(getPlayers().get(traderID-1).nthCard(i));
				getPlayers().get(traderID-1).removeCard(getPlayers().get(traderID-1).nthCard(i));
				break;
			}
		for(int i = 0; i < getPlayers().get(tradeeID-1).playerProperties().size(); i++)
			if(getPlayers().get(tradeeID-1).nthCard(i).equals(tradeeProperty)){
				getPlayers().get(traderID-1).addCard(getPlayers().get(tradeeID-1).nthCard(i));
				getPlayers().get(tradeeID-1).removeCard(getPlayers().get(tradeeID-1).nthCard(i));
				break;
			}
	}
	public ArrayList returnBoard(){
		return board;
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
//	private void createPlayers(){
//		Player a=new ParkerStrategy(1, this);
//		Player b=new ParkerStrategy(2, this);
//		Player c=new ParkerStrategy(3, this);
//		Player d=new ParkerStrategy(4, this);
//		//initializes 4 players
//		getPlayers().add(a);
//		String n = JOptionPane.showInputDialog(
//				"Player 1 enter your name: (Red Piece)");
//		a.setName(n);
//		a.setPieceID(0);
//		getPlayers().add(b);
//		n = JOptionPane.showInputDialog(
//				"Player 2 enter your name: (Green Piece)");
//		b.setName(n);
//		b.setPieceID(1);
//		getPlayers().add(c);
//		n = JOptionPane.showInputDialog(
//				"Player 3 enter your name: (Blue Piece)");
//		c.setName(n);
//		c.setPieceID(2);
//		getPlayers().add(d);
//		n = JOptionPane.showInputDialog(
//				"Player 4 enter your name: (Orange Piece)");
//		d.setName(n);
//		d.setPieceID(3);
//		//added 4 players to array of players, set names
//	}
	
	private String setPlayerTracker(){
		int index=getPlayers().size();
		if(playerNum%index==0)
			tracker=getPlayers().get(0);
		else if(playerNum%index==1)
			tracker=getPlayers().get(1);
		else if(playerNum%index==2)
			tracker=getPlayers().get(2);
		else if(playerNum%index==3){
			tracker=getPlayers().get(3);
		}
		String playerName=tracker.returnName();
		return playerName;
	}
	public Player playerWinner() {
		int bankruptcyCounter=0;
		Player winName = null;
		int maxMoney = 0;
		for(int i=0;i<4;i++){
			if(getPlayers().get(i).bankruptcy()){
				bankruptcyCounter++;
			}
		}
		if(bankruptcyCounter==3){
			for(int i=0;i<getPlayers().size();i++){
				if(getPlayers().get(i).bankruptcy() == false){
					winName = getPlayers().get(i);
					//winName = getPlayers().get(i).returnName();
					//System.out.println(getPlayers().get(i).returnName() + " WON THE GAME!!!");
				}
			}
		}else {
			for(int i = 0; i < getPlayers().size(); i++) {
				if(getPlayers().get(i).playerMoney() > maxMoney) {
					maxMoney = getPlayers().get(i).playerMoney();
					winName = getPlayers().get(i);
				}
			}
			//System.out.println(getPlayers().get(winIndex).returnName() + " WON THE GAME!!!");
		}
		return winName;
	}
	public String winner(){
		int bankruptcyCounter=0;
		String winName = "";
		int maxMoney = 0;
		for(int i=0;i<4;i++){
			if(getPlayers().get(i).bankruptcy()){
				bankruptcyCounter++;
			}
		}
		if(bankruptcyCounter==3){
			for(int i=0;i<getPlayers().size();i++){
				if(getPlayers().get(i).bankruptcy() == false){
					winName = getPlayers().get(i).returnName();
				}
			}
		}else {
			for(int i = 0; i < getPlayers().size(); i++) {
				if(getPlayers().get(i).playerMoney() > maxMoney) {
					maxMoney = getPlayers().get(i).playerMoney();
					winName = getPlayers().get(i).returnName();
				}
			}
		}
		return winName;
	}
	public void playMonopoly(){
		int numBankrupt = 0;
		int numWon = 0;
		boolean rollDouble;
		int playerDoubleCounter=0;
		int lastPlayerIndex;
		playerNum = 0;
		while(getPlayers().size()>1 && numWon == 0) {
			numBankrupt = 0;
			String name=setPlayerTracker();
			for(int i=0; i<getPlayers().size();i++){
				if(getPlayers().get(i).bankruptcy() == true){
					numBankrupt++;

				}
				//System.out.println("NUM BANKRUPT" + numBankrupt);
				lastPlayerIndex = getPlayers().size()-1;
				if(numBankrupt == 3 && numWon == 0){
					winner();
					numWon++;
					
					//playerNum = 0;
				}else if(getPlayers().get(lastPlayerIndex).numTurns() >=1000 && numWon == 0) {
					winner();
					numWon++;
				}

			}
			if(!tracker.bankruptcy() && numWon == 0){
				do{

					//System.out.println("It is "+name+"'s turn!");
					tracker.beforeRoll();
					int dice=tracker.rollDice();
					if(tracker.isInJail()){
						System.out.println("Player is in jail.");
						tracker.addJailTurn();
						if(tracker.numTurnsInJail() >= 2){
							System.out.println("Player stayed 2 turns in jail. Player payed $50 to be free!");
							tracker.subtractMoney(50);
							tracker.setJail(false);
							tracker.resetJailTurns();
						}
						//tracker.subtractMoney(50);
					}
					//System.out.println(tracker.returnName()+" rolled a "+tracker.getDice1()+" and a "+tracker.getDice2()
					//+" for a total of "+dice+".");
					rollDouble=tracker.playerDoubleRoll();

					if(tracker.isInJail() == false && tracker.playerMoney()>0){
						tracker.totalMoves(tracker.getDice1(), tracker.getDice2());
						totalMoves= tracker.returnMoves();
						tracker.setPlayerPosition(tracker.playerPosition()+dice);
						movement();
						//System.out.println(tracker.returnName()+" landed on "+board.get(tracker.playerPosition()).name());
						/***/
						tracker.afterRoll(board.get(tracker.playerPosition()));
						board.get(tracker.playerPosition()).slotAction(tracker,getPlayers(),board);
						/***/
						if(tracker.getDice1() == tracker.getDice2()){
							playerDoubleCounter++;
						}

						if(totalMoves >= 40){
							tracker.setTotalMoves(totalMoves - 40);
							tracker.passGo();
						}
						totalMoves = tracker.returnMoves();
						movement();
					}else if(tracker.isInJail() == true){
						tracker.setTotalMoves(10);
						tracker.setPlayerPosition(10);
						board.get(10).slotAction(tracker, getPlayers(), board);
					}
					bankruptcy();

				}while(playerDoubleCounter<3&&rollDouble&&tracker.playerMoney()>0);
				rollDouble=false;
				if(playerDoubleCounter==3){
					//THREE DOUBLE ROLLS, GO TO JAIL
					tracker.setTotalMoves(10);
					movement();
					tracker.setJail(true);
				}
				tracker.setDoubleRoll(0);
				playerDoubleCounter=0;
				infoPanel.updatePanel(tracker, playerNum);
				infoPanel.updateInfo(getPlayers());
			}
			playerNum++;
		}
	}
	public int numPropertiesOwned(){
		int numOwned = 0;
		for(Player player : getPlayers())
			numOwned = numOwned + player.numberOfCards();
		return numOwned;
	}
	
}