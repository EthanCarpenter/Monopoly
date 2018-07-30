import java.util.ArrayList;
/**
 * Sends data to Board
 * @author parkertewell
 */
public class Game {
	private ArrayList<Player> players;
	private Slot[]board = new Slot[40];
	/**
	 * Handles player data then passes it to the Board
	 * @param newPlayers
	 */
	public Game(ArrayList<Player> newPlayers){
		players = newPlayers;
		setBoard();
		Monopoly.monopoly.setContentPane(new Board(players));
		
	}
	private void setBoard(){
		board[0] = new Slot("GO");								//0
		board[1] = new PropertyCard("Mediterranean Ave.");		//1
		board[2] = new Slot("Community Chest");					//2
		board[3] = new PropertyCard("Baltic Ave.");				//3
		board[4] = new Slot("Income Tax");						//4
		board[5] = new PropertyCard("Reading Railroad");		//5
		board[6] = new PropertyCard("Oriental Ave.");			//6
		board[7] = new Slot("Chance");							//7
		board[8] = new PropertyCard("Vermont Ave.");			//8
		board[9] = new PropertyCard("Connecticut Ave.");		//9
		board[10] = new Slot("Jail");							//10
		board[11] = new PropertyCard("St. Charles Place");		//11
		board[12] = new PropertyCard("Electric Company");		//12
		board[13] = new PropertyCard("States Ave.");			//13
		board[14] = new PropertyCard("Virginia Ave.");			//14
		board[15] = new PropertyCard("Pennsylvania Railroad");	//15
		board[16] = new PropertyCard("St. James Place");		//16
		board[17] = new Slot("Community Chest");				//17
		board[18] = new PropertyCard("Tennessee Ave.");			//18
		board[19] = new PropertyCard("New York Ave.");			//19
		board[20] = new Slot("Free Parking");					//20
		board[21] = new PropertyCard("Kentucky Ave.");			//21
		board[22] = new Slot("Chance");							//22
		board[23] = new PropertyCard("Indiana Ave.");			//23
		board[24] = new PropertyCard("Illinois Ave.");			//24
		board[25] = new PropertyCard("B. & O. Railroad");		//25
		board[26] = new PropertyCard("Atlantic Ave.");			//26
		board[27] = new PropertyCard("Ventnor Ave.");			//27
		board[28] = new PropertyCard("Water Works");			//28
		board[29] = new PropertyCard("Marvin Gardens");			//29
		board[30] = new Slot("Go to Jail");						//30
		board[31] = new PropertyCard("Pacific Ave.");			//31
		board[32] = new PropertyCard("North Carolina Ave.");	//32
		board[33] = new Slot("Community Chest");				//33
		board[34] = new PropertyCard("Pennsylvania Ave.");		//34
		board[35] = new PropertyCard("Short Line Railroad");	//35
		board[36] = new Slot("Chance");							//36
		board[37] = new PropertyCard("Park Place");				//37
		board[38] = new Slot("Luxury Tax");						//38
		board[39] = new PropertyCard("Boardwalk");				//39
	}
}