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
			//ADVANCE TO GO AND COLLECT $200
			a.setTotalMoves(0);
			a.setPlayerPosition(0);
			a.passGo();
		}else if(random == 2){
			//BANK PAYS YOU $200 (BANK ERROR)
			a.addMoney(200);
		}else if(random == 3){
			//PAY $50 TO BANK (DOCTOR FEES)
			a.subtractMoney(50);
		}else if(random == 4){
			//GO TO JAIL, DON'T COLLECT ANY MONEY
			a.setJail(true);
			a.setPlayerPosition(10);
			a.setTotalMoves(10);
		}else if(random == 5){
			//COLLECT $50 FROM EACH PLAYER (OPERA)
			a.addMoney((b.size()-1)*50);
			for(int i=0;i<b.size();i++)
				if(!(a.playerID()==b.get(i).playerID()))
					b.get(i).subtractMoney(50);
		}else if(random == 6)
			//BANK PAYS YOU $100 (HOLIDAY)
			a.addMoney(100);
		else if(random == 7)
			//BANK PAYS YOU $20 (TAX REFUND)
			a.addMoney(20);
		else if(random == 8){
			//COLLECT $10 FROM EACH PLAYER (BIRTHDAY)
			a.addMoney((b.size()-1)*10);
			for(int i=0;i<b.size();i++)
				if(!(a.playerID()==b.get(i).playerID()))
					b.get(i).subtractMoney(10);
		}else if(random == 9)
			//BANK PAYS YOU $100 (LIFE INSURANCE)
			a.addMoney(100);
		else if(random == 10)
			//PAY BANK $150 (SCHOOL FEES)
			a.subtractMoney(150);
		else if(random == 11)
			//BANK PAYS YOU $25 (CONSULTANCY)
			a.addMoney(25);
		else if(random == 12)
			//BANK PAYS YOU $10 (BEAUTY CONTEST)
			a.addMoney(10);
		else if(random == 13)
			//BANK PAYS YOU $100 (INHERITANCE)
			a.addMoney(100);
		else if(random == 14)
			//BANK PAYS YOU $50 (STOCKS)
			a.addMoney(50);
		else if(random == 15)
			//GET OUT OF JAIL FREE CARD
			a.addGetOutOfJailFree();
	}
}