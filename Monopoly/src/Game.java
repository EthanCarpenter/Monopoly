import java.util.ArrayList;
/**
 * Sends data to Board
 * @author parkertewell
 */
public class Game {
	private ArrayList<Player> players;
	/**
	 * Generates player info then passes it to the Board
	 * @param newPlayers
	 */
	public Game(ArrayList<Player> newPlayers){
		players = newPlayers;
		Monopoly.monopoly.setContentPane(new Board(players));
		
	}
}