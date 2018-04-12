import java.util.ArrayList;
/*
 * Chance Xie and Will Cox
 * Monopoly
 * Independent Project
 */
public class ChanceCards {
	private int random;
	public void chanceCard(MonopolyPlayer a,ArrayList<MonopolyPlayer> plist,ArrayList<MonopolySlot> board){
		random=(int) (15 * Math.random() + 1);
		if(random == 1){
			System.out.println(a.returnName()+": Advance to Go (Collect $200)");
			a.setPlayerPosition(0);
			a.setTotalMoves(0);
			a.passGo();
		}else if(random == 2){
			System.out.println(a.returnName()+": Advance to Illinois Ave. - If you pass Go, collect $200");
			if(a.playerPosition()>24){
				a.passGo();
			}
			a.setTotalMoves(24);
			a.setPlayerPosition(24);
			board.get(24).slotAction(a, plist, board);
		}else if(random == 3){
			System.out.println(a.returnName()+": Advance to St. Charles Place – If you pass Go, collect $200");
			if(a.playerPosition()>11){
				a.passGo();
			}
			a.setTotalMoves(11);
			a.setPlayerPosition(11);
			board.get(11).slotAction(a, plist, board);
		}else if(random == 4){
			System.out.println(a.returnName()+": Advance token to nearest Utility. "
			+ "If unowned, you may buy it from the Bank.");
			if(a.playerPosition() == 36){
				a.passGo();
			}
			if(a.playerPosition()==7||a.playerPosition() == 36){
				a.setTotalMoves(12);
				a.setPlayerPosition(12);
				board.get(12).slotAction(a, plist, board);
			}else if(a.playerPosition() == 22){
				a.setTotalMoves(28);
				a.setPlayerPosition(28);
				board.get(12).slotAction(a, plist, board);
			}
			//USE
			
		}else if(random == 5){
			System.out.println(a.returnName()+": Advance token to the nearest Railroad"
			+ " If Railroad is unowned, you may buy it from the Bank.");
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
		}else if(random == 6){
			System.out.println(a.returnName()+": Bank pays you dividend of $50");
			a.addMoney(50);
		}else if(random == 7){
			System.out.println(" Get out of Jail Free – This card may be kept until needed, or traded/sold "
			+ "{This card may be kept until needed or sold - Get Out of Jail Free}");
			System.out.println(a.returnName()+" Get out of Jail, Free");
			a.addGetOutOfJailFree();
		}else if(random == 8){
			System.out.println(a.returnName()+": Go Back 3 Spaces");
			a.setTotalMoves(a.playerPosition()-3);
			a.setPlayerPosition(a.playerPosition()-3);
			board.get(a.playerPosition()).slotAction(a, plist, board);
		}else if(random == 9){
			System.out.println(a.returnName()+": Go to Jail – Go directly to Jail – Do not pass Go, do not collect $200");
			a.setPlayerPosition(10);
			a.setTotalMoves(10);
			a.setJail(true);
		}else if(random == 11){
			System.out.println(a.returnName()+": Pay poor tax of $15");
			a.subtractMoney(15);
		}else if(random == 12){
			System.out.println(a.returnName()+": Take a trip to Reading Railroad");
			a.setPlayerPosition(5);
			a.setTotalMoves(5);
			a.passGo();
			board.get(5).slotAction(a, plist, board);
		}else if(random == 13){
			System.out.println(a.returnName()+": Take a walk on the Boardwalk");
			a.setPlayerPosition(39);
			a.setTotalMoves(39);
			board.get(39).slotAction(a, plist, board);
		}else if(random == 14){
			System.out.println(a.returnName()+": You have been elected Chairman of the Board");
		}else if(random == 15){
			System.out.println(a.returnName()+": Your building loan matures – Collect $150");
			a.addMoney(150);
		}else if(random == 10){
			System.out.println(a.returnName()+": You have won a crossword competition - Collect $100");
			a.addMoney(100);
		}
	}
	public static void main(String[] args){
		
	}
}