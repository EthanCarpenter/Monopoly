import java.util.ArrayList;

/*
 * Chance Xie and Will Cox
 * Monopoly
 * Independent Project
 */
public class MonopolySlot{
	private String name;
	private int giveMoney;
	private int takeMoney;
	MonopolySlot(String n){
		name=n;
		setSlotStats();
	}
	public String name(){
		return name;
	}
	public void setSlotStats(){
		if(name=="GO"){
			giveMoney=0;
			takeMoney=0;
		}else if(name=="Community Chest"){
			giveMoney=0;
			takeMoney=0;
		}else if(name=="Chance"){
			giveMoney=0;
			takeMoney=0;
		}else if(name=="Income Tax"){
			giveMoney=0;
			takeMoney=200;
		}else if(name=="JAIL"){
			giveMoney=0;
			takeMoney=0;
		}else if(name=="Free Parking"){
			giveMoney=0;
			takeMoney=0;
		}else if(name=="Go to Jail"){
			giveMoney=0;
			takeMoney=0;
		}else if(name=="Luxury Tax"){
			giveMoney=0;
			takeMoney=75;
		}
	}
	public void slotAction(MonopolyPlayer a,ArrayList<MonopolyPlayer> plist,ArrayList<MonopolySlot> board){
		giveAndTake(a,plist,board);
	}
	public void giveAndTake(MonopolyPlayer a,ArrayList<MonopolyPlayer> plist,ArrayList<MonopolySlot> board){
		if(name.equals("Go to Jail")){
			a.setTotalMoves(10);
			a.setPlayerPosition(10);
			a.setJail(true);
		}else if(a.isInJail()){
			//a.subtractMoney(50);
			//System.out.println("You have been fined $50 for being in jail. Roll doubles to get out.");
			System.out.println("Roll doubles or wait two turns to get out");
		}
		if(!(name.equals("Chance")||name.equals("Community Chest"))){
			System.out.println(giveMoney+" was added to "+a.returnName()+"'s balance!");
			a.addMoney(giveMoney);
			System.out.println(takeMoney+" was subtracted from "+a.returnName()+"'s balance!");
			a.subtractMoney(takeMoney);
		}
		if(name.equals("Chance")){
			ChanceCards chan=new ChanceCards();
			chan.chanceCard(a,plist,board);
		}if(name.equals("Community Chest")){
			CommunityChest chest=new CommunityChest();
			chest.communityChestCard(a,plist,board);
		}
	}
}