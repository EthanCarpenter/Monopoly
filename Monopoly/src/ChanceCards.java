import java.util.ArrayList;
/*
 * Chance Xie and Will Cox
 * Monopoly
 * Independent Project
 */
public class ChanceCards {
	private int random;
	public void chanceCard(Player a,ArrayList<Player> plist,ArrayList<Slot> board){
		random=(int) (15 * Math.random() + 1);
		if(random == 1){
			//ADVANCE TO GO AND COLLECT $200
			a.setPlayerPosition(0);
			a.setTotalMoves(0);
			a.passGo();
		}else if(random == 2){
			//ADVANCE TO ILLINOIS AVE. IF YOU PASS GO COLLECT $200
			if(a.playerPosition()>24)
				a.passGo();
			a.setTotalMoves(24);
			a.setPlayerPosition(24);
			board.get(24).slotAction(a, plist, board);
		}else if(random == 3){
			//ADVANCE TO ST. CHARLES PLACE IF YOU PASS GO COLLECT $200
			if(a.playerPosition()>11)
				a.passGo();
			a.setTotalMoves(11);
			a.setPlayerPosition(11);
			board.get(11).slotAction(a, plist, board);
		}else if(random == 4){
			//ADVANCE TO NEAREST UTILITY, IF UNOWNED YOU MAY BUY IT, IF YOU PASS GO COLLECT $200
			//WORK ON THIS (MAY 31)
			if(a.playerPosition() == 36)
				a.passGo();
			if(a.playerPosition()==7||a.playerPosition() == 36){
				a.setTotalMoves(12);
				a.setPlayerPosition(12);
				board.get(12).slotAction(a, plist, board);
			}else if(a.playerPosition() == 22){
				a.setTotalMoves(28);
				a.setPlayerPosition(28);
				board.get(28).slotAction(a, plist, board);
			}
		}else if(random == 5){
			//ADVANCE TO NEAREST RAILROAD, IF UNOWNED YOU MAY BUY IT, IF YOU PASS GO COLLECT $200
			if(a.playerPosition()==7){
				a.setPlayerPosition(15);
				a.setTotalMoves(15);
				board.get(15).slotAction(a, plist, board);
			}else if(a.playerPosition()==22){
				a.setPlayerPosition(25);
				a.setTotalMoves(25);
				board.get(25).slotAction(a, plist, board);
			}else if(a.playerPosition()==36){
				a.passGo();
				a.setPlayerPosition(5);
				a.setTotalMoves(5);
				board.get(5).slotAction(a, plist, board);
			}
		}else if(random == 6)
			//BANK PAYS YOU $50
			a.addMoney(50);
		else if(random == 7)
			//GET OUT OF JAIL FREE CARD
			a.addGetOutOfJailFree();
		else if(random == 8){
			//GO BACK THREE SPACES
			a.setTotalMoves(a.playerPosition()-3);
			a.setPlayerPosition(a.playerPosition()-3);
			board.get(a.playerPosition()).slotAction(a, plist, board);
		}else if(random == 9){
			//GO TO JAIL, DON'T COLLECT ANY MONEY
			a.setPlayerPosition(10);
			a.setTotalMoves(10);
			a.setJail(true);
		}else if(random == 11){
			//PAY $15 TO BANK (POOR TAX)
			a.subtractMoney(15);
		}else if(random == 12){
			//GO TO READING RAILROAD, IF YOU PASS GO COLLECT $200
			a.setPlayerPosition(5);
			a.setTotalMoves(5);
			a.passGo();
			board.get(5).slotAction(a, plist, board);
		}else if(random == 13){
			//GO TO BOARDWALK, IF YOU PASS GO COLLECT $200
			//ADD PASS GO
			a.setPlayerPosition(39);
			a.setTotalMoves(39);
			board.get(39).slotAction(a, plist, board);
		}else if(random == 14){
			//PAY EACH PLAYER $50 (ELECTED CHAIRMAN)
		}else if(random == 15)
			//BANK PAYS YOU $150 (LOAN MATURES)
			a.addMoney(150);
		else if(random == 10)
			//BANK PAYS YOU $100 (CROSSWORD PUZZLE)
			a.addMoney(100);
	}
}