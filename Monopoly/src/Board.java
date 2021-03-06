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
public class Board extends JPanel{
	static PlayerInfoPanel infoPanel;
	private static ArrayList<Player> players;
	private int playerNum;
	private Player tracker;
	private ArrayList<Slot> board;
	private int totalMoves, firstX, firstY, secondX, secondY, thirdX, thirdY, fourthX, fourthY;
	private Image dbImage;
	private Graphics dbg;
	Image monoBoard;
	Image blueSquare;
	Image greenSquare;
	Image purpleSquare;
	Image redSquare;
	Board(){
		setPlayers(new ArrayList());
		createPlayers();
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
		firstX = 570;
		firstY = 600;
		secondX = 570;
		secondY = 610;
		thirdX = 570;
		thirdY = 620;
		fourthX = 570;
		fourthY = 630;
	}
	public Board(ArrayList<Player> players) {
		System.out.println("Fart");
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
		h.drawImage(monoBoard, 0, 50,this);
		h.setColor(Color.red);
		h.fillOval(firstX, firstY, 10, 10);
		h.setColor(Color.green);
		h.fillOval(secondX, secondY , 10, 10);
		h.setColor(Color.blue);
		h.fillOval(thirdX, thirdY, 10, 10);
		h.setColor(Color.orange);
		h.fillOval(fourthX, fourthY, 10, 10);
		repaint();
	}
	private void createPlayers(){
		Player a=new ParkerStrategy(1, this);
		Player b=new ParkerStrategy(2, this);
		Player c=new ParkerStrategy(3, this);
		Player d=new ParkerStrategy(4, this);
		//initializes 4 players
		getPlayers().add(a);
		String n = JOptionPane.showInputDialog(
				"Player 1 enter your name: (Red Piece)");
		a.setName(n);
		a.setPieceID(0);
		getPlayers().add(b);
		n = JOptionPane.showInputDialog(
				"Player 2 enter your name: (Green Piece)");
		b.setName(n);
		b.setPieceID(1);
		getPlayers().add(c);
		n = JOptionPane.showInputDialog(
				"Player 3 enter your name: (Blue Piece)");
		c.setName(n);
		c.setPieceID(2);
		getPlayers().add(d);
		n = JOptionPane.showInputDialog(
				"Player 4 enter your name: (Orange Piece)");
		d.setName(n);
		d.setPieceID(3);
		//added 4 players to array of players, set names
	}
	private void setBoard(){
		board=new ArrayList();
		PropertyCard medit=new PropertyCard("Mediterranean Ave.");
		PropertyCard balt=new PropertyCard("Baltic Ave.");
		PropertyCard orient=new PropertyCard("Oriental Ave.");
		PropertyCard verm=new PropertyCard("Vermont Ave.");
		PropertyCard conn=new PropertyCard("Connecticut Ave.");
		PropertyCard stcharles=new PropertyCard("St. Charles Place");
		PropertyCard states=new PropertyCard("States Ave.");
		PropertyCard virg=new PropertyCard("Virginia Ave.");
		PropertyCard stjames=new PropertyCard("St. James Place");
		PropertyCard tenn=new PropertyCard("Tennessee Ave.");
		PropertyCard newyork=new PropertyCard("New York Ave.");
		PropertyCard kent=new PropertyCard("Kentucky Ave.");
		PropertyCard ind=new PropertyCard("Indiana Ave.");
		PropertyCard illin=new PropertyCard("Illinois Ave.");
		PropertyCard atla=new PropertyCard("Atlantic Ave.");
		PropertyCard vent=new PropertyCard("Ventnor Ave.");
		PropertyCard marv=new PropertyCard("Marvin Gardens");
		PropertyCard pac=new PropertyCard("Pacific Ave.");
		PropertyCard northcar=new PropertyCard("North Carolina Ave.");
		PropertyCard penn=new PropertyCard("Pennsylvania Ave.");
		PropertyCard park=new PropertyCard("Park Place");
		PropertyCard boardw=new PropertyCard("Boardwalk");
		PropertyCard readingrail=new PropertyCard("Reading Railroad");
		PropertyCard bando=new PropertyCard("B. & O. Railroad");
		PropertyCard pennrail=new PropertyCard("Pennsylvania Railroad");
		PropertyCard shortl=new PropertyCard("Short Line Railroad");
		PropertyCard elcom=new PropertyCard("Electric Company");
		PropertyCard waterwork=new PropertyCard("Water Works");
		//ALL PROPERTIES SET
		Slot go=new Slot("GO");
		Slot commchest1=new Slot("Community Chest");
		Slot incometax=new Slot("Income Tax");
		Slot chance1=new Slot("Chance");
		Slot jail=new Slot("JAIL");
		Slot commchest2=new Slot("Community Chest");
		Slot freepark=new Slot("Free Parking");
		Slot chance2=new Slot("Chance");
		Slot gotojail=new Slot("Go to Jail");
		Slot commchest3=new Slot("Community Chest");
		Slot chance3=new Slot("Chance");
		Slot luxtax=new Slot("Luxury Tax");
		//REST OF THE SLOTS SET
		board.add(go);			//0
		board.add(medit);		//1
		board.add(commchest1);	//2
		board.add(balt);		//3
		board.add(incometax);	//4
		board.add(readingrail);	//5
		board.add(orient);		//6
		board.add(chance1);		//7
		board.add(verm);		//8
		board.add(conn);		//9
		board.add(jail);		//10
		board.add(stcharles);	//11
		board.add(elcom);		//12
		board.add(states);		//13
		board.add(virg);		//14
		board.add(pennrail);	//15
		board.add(stjames);		//16
		board.add(commchest2);	//17
		board.add(tenn);		//18
		board.add(newyork);		//19
		board.add(freepark);	//20
		board.add(kent);		//21
		board.add(chance2);		//22
		board.add(ind);			//23
		board.add(illin);		//24
		board.add(bando);		//25
		board.add(atla);		//26
		board.add(vent);		//27
		board.add(waterwork);	//28
		board.add(marv);		//29
		board.add(gotojail);	//30
		board.add(pac);			//31
		board.add(northcar);	//32
		board.add(commchest3);	//33
		board.add(penn);		//34
		board.add(shortl);		//35
		board.add(chance3);		//36
		board.add(park);		//37
		board.add(luxtax);		//38
		board.add(boardw);		//39
		for(int i = 0; i < 4; i++){
			getPlayers().get(i).setBoard(board);
		}
	}
	private boolean bankruptcy(){
		int num=tracker.playerID();
		if(tracker.bankruptcy()){
			//players.remove(tracker.playerID());
			//System.out.println(tracker.returnName()+" has gone bankrupt!");
			for(int i=0;i<tracker.playerProperties().size();i++){
				for(int j = 0; j<tracker.playerProperties().get(i).getNumHouses();j++)
					tracker.playerProperties().get(i).sellHouse();
				tracker.playerProperties().get(i).setNumHouses(-1);
				tracker.playerProperties().get(i).setOwned(false);
				if(tracker.equals(getPlayers().get(0))){
					firstX = -1;
					firstY = -1;
				}else if(tracker.equals(getPlayers().get(1))){
					secondX = -1;
					secondY = -1;
				}else if(tracker.equals(getPlayers().get(2))){
					thirdX = -1;
					thirdY = -1;
				}else if(tracker.equals(getPlayers().get(3))){
					fourthX = -1;
					fourthY = -1;
				}
				int playerRem = 0;
				for(int i1 = 0; i1 < getPlayers().size(); i1++) {
					if(getPlayers().get(i1) == tracker) {
						playerRem = i1;
					}
				}
				getPlayers().remove(playerRem);
	
				return true;
			}
		}else {
			return false;
		}
		return false;
	}
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
	private void movement(){
		if(tracker.returnPieceID() == 0){
			if(tracker.bankruptcy() == true){
				firstX = -1;
				firstY = -1;
			}else if(totalMoves == 1){
				firstX = 495;
				firstY = 560;
			}else if(totalMoves == 2){
				firstX = 445;
				firstY = 600;
			}else if(totalMoves == 3){
				firstX = 395;
				firstY = 600;
			}else if(totalMoves == 4){
				firstX = 345;
				firstY = 600;
			}else if(totalMoves == 5){
				firstX = 295;
				firstY = 600;
			}else if(totalMoves == 6){
				firstX = 245;
				firstY = 600;
			}else if(totalMoves == 7){
				firstX = 195;
				firstY = 600;
			}else if(totalMoves == 8){
				firstX = 145;
				firstY = 600;
			}else if(totalMoves == 9){
				firstX = 95;
				firstY = 600;
			}else if(totalMoves == 10){
				firstX = 40;
				firstY = 600;
			}else if(totalMoves == 11){
				firstX = 40;
				firstY = 550;
			}else if(totalMoves == 12){
				firstX = 40;
				firstY = 500;
			}else if(totalMoves == 13){
				firstX = 40;
				firstY = 450;
			}else if(totalMoves == 14){
				firstX = 40;
				firstY = 400;
			}else if(totalMoves == 15){
				firstX = 40;
				firstY = 350;
			}else if(totalMoves == 16){
				firstX = 40;
				firstY = 300;
			}else if(totalMoves == 17){
				firstX = 40;
				firstY = 250;
			}else if(totalMoves == 18){
				firstX = 40;
				firstY = 200;
			}else if(totalMoves == 19){
				firstX = 40;
				firstY = 150;
			}else if(totalMoves == 20){
				firstX = 40;
				firstY = 100;
			}else if(totalMoves == 21){
				firstX = 95;
				firstY = 100;
			}else if(totalMoves == 22){
				firstX = 145;
				firstY = 100;
			}else if(totalMoves == 23){
				firstX = 195;
				firstY = 100;
			}else if(totalMoves == 24){
				firstX = 245;
				firstY = 100;
			}else if(totalMoves == 25){
				firstX = 295;
				firstY = 100;
			}else if(totalMoves == 26){
				firstX = 345;
				firstY = 100;
			}else if(totalMoves == 27){
				firstX = 395;
				firstY = 100;
			}else if(totalMoves == 28){
				firstX = 445;
				firstY = 100;
			}else if(totalMoves == 29){
				firstX = 495;
				firstY = 100;
			}else if(totalMoves == 30){
				firstX = 570;
				firstY = 100;
			}else if(totalMoves == 31){
				firstX = 570;
				firstY = 150;
			}else if(totalMoves == 32){
				firstX = 570;
				firstY = 200;
			}else if(totalMoves == 33){
				firstX = 570;
				firstY = 250;
			}else if(totalMoves == 34){
				firstX = 570;
				firstY = 300;
			}else if(totalMoves == 35){
				firstX = 570;
				firstY = 350;
			}else if(totalMoves == 36){
				firstX = 570;
				firstY = 400;
			}else if(totalMoves == 37){
				firstX = 570;
				firstY = 450;
			}else if(totalMoves == 38){
				firstX = 570;
				firstY = 500;
			}else if(totalMoves == 39){
				firstX = 570;
				firstY = 550;
			}else if(totalMoves == 40 || totalMoves == 0){
				firstX = 570;
				firstY = 600;
			}
		}else if(tracker.returnPieceID() == 1){
			if(tracker.bankruptcy() == true){
				secondX = -1;
				secondY = -1;
			}else if(totalMoves == 1){
				secondX = 495;
				secondY = 610;
			}else if(totalMoves == 2){
				secondX = 445;
				secondY = 610;
			}else if(totalMoves == 3){
				secondX = 395;
				secondY = 610;
			}else if(totalMoves == 4){
				secondX = 345;
				secondY = 610;
			}else if(totalMoves == 5){
				secondX = 295;
				secondY = 610;
			}else if(totalMoves == 6){
				secondX = 245;
				secondY = 610;
			}else if(totalMoves == 7){
				secondX = 195;
				secondY = 610;
			}else if(totalMoves == 8){
				secondX = 145;
				secondY = 610;
			}else if(totalMoves == 9){
				secondX = 95;
				secondY = 610;
			}else if(totalMoves == 10){
				secondX = 40;
				secondY = 610;
			}else if(totalMoves == 11){
				secondX = 40;
				secondY = 560;
			}else if(totalMoves == 12){
				secondX = 40;
				secondY = 510;
			}else if(totalMoves == 13){
				secondX = 40;
				secondY = 460;
			}else if(totalMoves == 14){
				secondX = 40;
				secondY = 410;
			}else if(totalMoves == 15){
				secondX = 40;
				secondY = 360;
			}else if(totalMoves == 16){
				secondX = 40;
				secondY = 310;
			}else if(totalMoves == 17){
				secondX = 40;
				secondY = 260;
			}else if(totalMoves == 18){
				secondX = 40;
				secondY = 210;
			}else if(totalMoves == 19){
				secondX = 40;
				secondY = 160;
			}else if(totalMoves == 20){
				secondX = 40;
				secondY = 110;
			}else if(totalMoves == 21){
				secondX = 95;
				secondY = 110;
			}else if(totalMoves == 22){
				secondX = 145;
				secondY = 110;
			}else if(totalMoves == 23){
				secondX = 195;
				secondY = 110;
			}else if(totalMoves == 24){
				secondX = 245;
				secondY = 110;
			}else if(totalMoves == 25){
				secondX = 295;
				secondY = 110;
			}else if(totalMoves == 26){
				secondX = 345;
				secondY = 110;
			}else if(totalMoves == 27){
				secondX = 395;
				secondY = 110;
			}else if(totalMoves == 28){
				secondX = 445;
				secondY = 110;
			}else if(totalMoves == 29){
				secondX = 495;
				secondY = 110;
			}else if(totalMoves == 30){
				secondX = 570;
				secondY = 110;
			}else if(totalMoves == 31){
				secondX = 570;
				secondY = 160;
			}else if(totalMoves == 32){
				secondX = 570;
				secondY = 210;
			}else if(totalMoves == 33){
				secondX = 570;
				secondY = 260;
			}else if(totalMoves == 34){
				secondX = 570;
				secondY = 310;
			}else if(totalMoves == 35){
				secondX = 570;
				secondY = 360;
			}else if(totalMoves == 36){
				secondX = 570;
				secondY = 410;
			}else if(totalMoves == 37){
				secondX = 570;
				secondY = 460;
			}else if(totalMoves == 38){
				secondX = 570;
				secondY = 510;
			}else if(totalMoves == 39){
				secondX = 570;
				secondY = 560;
			}else if(totalMoves == 40 || totalMoves == 0){
				secondX = 570;
				secondY = 610;
			}
		}else if(tracker.returnPieceID() == 2){
			if(tracker.bankruptcy() == true){
				thirdX = -1;
				thirdY = -1;
			}else if(totalMoves == 1){
				thirdX = 495;
				thirdY = 620;
			}else if(totalMoves == 2){
				thirdX = 445;
				thirdY = 620;
			}else if(totalMoves == 3){
				thirdX = 395;
				thirdY = 620;
			}else if(totalMoves == 4){
				thirdX = 345;
				thirdY = 620;
			}else if(totalMoves == 5){
				thirdX = 295;
				thirdY = 620;
			}else if(totalMoves == 6){
				thirdX = 245;
				thirdY = 620;
			}else if(totalMoves == 7){
				thirdX = 195;
				thirdY = 620;
			}else if(totalMoves == 8){
				thirdX = 145;
				thirdY = 620;
			}else if(totalMoves == 9){
				thirdX = 95;
				thirdY = 620;
			}else if(totalMoves == 10){
				thirdX = 40;
				thirdY = 620;
			}else if(totalMoves == 11){
				thirdX = 40;
				thirdY = 550;
			}else if(totalMoves == 12){
				thirdX = 40;
				thirdY = 500;
			}else if(totalMoves == 13){
				thirdX = 40;
				thirdY = 450;
			}else if(totalMoves == 14){
				thirdX = 40;
				thirdY = 400;
			}else if(totalMoves == 15){
				thirdX = 40;
				thirdY = 350;
			}else if(totalMoves == 16){
				thirdX = 40;
				thirdY = 300;
			}else if(totalMoves == 17){
				thirdX = 40;
				thirdY = 250;
			}else if(totalMoves == 18){
				thirdX = 40;
				thirdY = 200;
			}else if(totalMoves == 19){
				thirdX = 40;
				thirdY = 150;
			}else if(totalMoves == 20){
				thirdX = 40;
				thirdY = 90;
			}else if(totalMoves == 21){
				thirdX = 95;
				thirdY = 90;
			}else if(totalMoves == 22){
				thirdX = 145;
				thirdY = 90;
			}else if(totalMoves == 23){
				thirdX = 195;
				thirdY = 90;
			}else if(totalMoves == 24){
				thirdX = 245;
				thirdY = 90;
			}else if(totalMoves == 25){
				thirdX = 295;
				thirdY = 90;
			}else if(totalMoves == 26){
				thirdX = 345;
				thirdY = 90;
			}else if(totalMoves == 27){
				thirdX = 395;
				thirdY = 90;
			}else if(totalMoves == 28){
				thirdX = 445;
				thirdY = 90;
			}else if(totalMoves == 29){
				thirdX = 495;
				thirdY = 90;
			}else if(totalMoves == 30){
				thirdX = 570;
				thirdY = 90;
			}else if(totalMoves == 31){
				thirdX = 570;
				thirdY = 150;
			}else if(totalMoves == 32){
				thirdX = 570;
				thirdY = 200;
			}else if(totalMoves == 33){
				thirdX = 570;
				thirdY = 250;
			}else if(totalMoves == 34){
				thirdX = 570;
				thirdY = 300;
			}else if(totalMoves == 35){
				thirdX = 570;
				thirdY = 350;
			}else if(totalMoves == 36){
				thirdX = 570;
				thirdY = 400;
			}else if(totalMoves == 37){
				thirdX = 570;
				thirdY = 450;
			}else if(totalMoves == 38){
				thirdX = 570;
				thirdY = 500;
			}else if(totalMoves == 39){
				thirdX = 570;
				thirdY = 550;
			}else if(totalMoves == 40 || totalMoves == 0){
				thirdX = 570;
				thirdY = 620;
			}
		}else if(tracker.returnPieceID() == 3){
			if(tracker.bankruptcy() == true){
				fourthX = -1;
				fourthY = -1;
			}else if(totalMoves == 1){
				fourthX = 495;
				fourthY = 630;
			}else if(totalMoves == 2){
				fourthX = 445;
				fourthY = 630;
			}else if(totalMoves == 3){
				fourthX = 395;
				fourthY = 630;
			}else if(totalMoves == 4){
				fourthX = 345;
				fourthY = 630;
			}else if(totalMoves == 5){
				fourthX = 295;
				fourthY = 630;
			}else if(totalMoves == 6){
				fourthX = 245;
				fourthY = 630;
			}else if(totalMoves == 7){
				fourthX = 195;
				fourthY = 630;
			}else if(totalMoves == 8){
				fourthX = 145;
				fourthY = 630;
			}else if(totalMoves == 9){
				fourthX = 95;
				fourthY = 630;
			}else if(totalMoves == 10){
				fourthX = 40;
				fourthY = 630;
			}else if(totalMoves == 11){
				fourthX = 40;
				fourthY = 550;
			}else if(totalMoves == 12){
				fourthX = 40;
				fourthY = 500;
			}else if(totalMoves == 13){
				fourthX = 40;
				fourthY = 450;
			}else if(totalMoves == 14){
				fourthX = 40;
				fourthY = 400;
			}else if(totalMoves == 15){
				fourthX = 40;
				fourthY = 350;
			}else if(totalMoves == 16){
				fourthX = 40;
				fourthY = 300;
			}else if(totalMoves == 17){
				fourthX = 40;
				fourthY = 250;
			}else if(totalMoves == 18){
				fourthX = 40;
				fourthY = 200;
			}else if(totalMoves == 19){
				fourthX = 40;
				fourthY = 150;
			}else if(totalMoves == 20){
				fourthX = 40;
				fourthY = 80;
			}else if(totalMoves == 21){
				fourthX = 95;
				fourthY = 80;
			}else if(totalMoves == 22){
				fourthX = 145;
				fourthY = 80;
			}else if(totalMoves == 23){
				fourthX = 195;
				fourthY = 80;
			}else if(totalMoves == 24){
				fourthX = 245;
				fourthY = 80;
			}else if(totalMoves == 25){
				fourthX = 295;
				fourthY = 80;
			}else if(totalMoves == 26){
				fourthX = 345;
				fourthY = 80;
			}else if(totalMoves == 27){
				fourthX = 395;
				fourthY = 80;
			}else if(totalMoves == 28){
				fourthX = 445;
				fourthY = 80;
			}else if(totalMoves == 29){
				fourthX = 495;
				fourthY = 80;
			}else if(totalMoves == 30){
				fourthX = 570;
				fourthY = 80;
			}else if(totalMoves == 31){
				fourthX = 570;
				fourthY = 150;
			}else if(totalMoves == 32){
				fourthX = 570;
				fourthY = 200;
			}else if(totalMoves == 33){
				fourthX = 570;
				fourthY = 250;
			}else if(totalMoves == 34){
				fourthX = 570;
				fourthY = 300;
			}else if(totalMoves == 35){
				fourthX = 570;
				fourthY = 350;
			}else if(totalMoves == 36){
				fourthX = 570;
				fourthY = 400;
			}else if(totalMoves == 37){
				fourthX = 570;
				fourthY = 450;
			}else if(totalMoves == 38){
				fourthX = 570;
				fourthY = 500;
			}else if(totalMoves == 39){
				fourthX = 570;
				fourthY = 550;
			}else if(totalMoves == 40 || totalMoves == 0){
				fourthX = 570;
				fourthY = 630;
			}
		}
	}
	public static void main(String[] args){
		Board a=new Board();
		infoPanel = new PlayerInfoPanel(getPlayers());
		a.playMonopoly();
	}
	public static ArrayList<Player> getPlayers() {
		return players;
	}
}