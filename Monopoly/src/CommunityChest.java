/*
 * Chance Xie and Will Cox
 * Monopoly
 * Independent Project
 */
import java.util.ArrayList;
public class CommunityChest {
	private int random;
	public void communityChestCard(MonopolyPlayer a,ArrayList<MonopolyPlayer> b,ArrayList<MonopolySlot> board){
		random=(int) (15 * Math.random() + 1);
		if(random == 1){
			System.out.println(a.returnName()+" Advance to Go (Collect $200)");
			a.setTotalMoves(0);
			a.setPlayerPosition(0);
			a.passGo();
		}else if(random == 2){
			System.out.println(a.returnName()+" Bank error in your favor – Collect $200");
			a.addMoney(200);
		}else if(random == 3){
			System.out.println(a.returnName()+" Doctor's fees – Pay $50");
			a.subtractMoney(50);
		}else if(random == 4){
			System.out.println(a.returnName()+" Go directly to jail – Do not pass Go – Do not collect $200");
			a.setJail(true);
			a.setPlayerPosition(10);
			a.setTotalMoves(10);
		}else if(random == 5){
			System.out.println(a.returnName()+" Grand Opera Night – Collect $50 from every player for opening night seats");
			a.addMoney((b.size()-1)*50);
			for(int i=0;i<b.size();i++){
				if(!(a.playerID()==b.get(i).playerID())){
					b.get(i).subtractMoney(50);
				}
			}
		}else if(random == 6){
			System.out.println(a.returnName()+" Holiday Fund matures - Collect $100");
			a.addMoney(100);
		}else if(random == 7){
			System.out.println(a.returnName()+" Income tax refund – Collect $20");
			a.addMoney(20);
		}else if(random == 8){
			System.out.println(a.returnName()+" It is your birthday - Collect $10 from each player");
			a.addMoney((b.size()-1)*10);
			for(int i=0;i<b.size();i++){
				if(!(a.playerID()==b.get(i).playerID())){
					b.get(i).subtractMoney(10);
				}
			}
		}else if(random == 9){
			System.out.println(a.returnName()+" Life insurance matures – Collect $100");
			a.addMoney(100);
		}else if(random == 10){
			System.out.println(a.returnName()+" Pay school fees of $150");
			a.subtractMoney(150);
		}else if(random == 11){
			System.out.println(a.returnName()+" Receive $25 consultancy fee");
			a.addMoney(25);
		}else if(random == 12){
			System.out.println(a.returnName()+" You have won second prize in a beauty contest – Collect $10");
			a.addMoney(10);
		}else if(random == 13){
			System.out.println(a.returnName()+" You inherit $100");
			a.addMoney(100);
		}else if(random == 14){
			System.out.println(a.returnName()+" From sale of stock you get $50");
			a.addMoney(50);
		}else if(random == 15){
			System.out.println(a.returnName()+" Get out of Jail, Free");
			a.addGetOutOfJailFree();
		}
	}
	public static void main(String[] args){

	}
}