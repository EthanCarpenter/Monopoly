import java.util.ArrayList;
/*
 * Chance Xie and Will Cox
 * Monopoly
 * Independent Project
 */
public class PropertyCard extends MonopolySlot{
	private int PURPLE=0,LIGHTGREEN=1,VIOLET=2,
			ORANGE=3,RED=4,YELLOW=5,DARKGREEN=6,
			DARKBLUE=7,UTILITIES=8,RAILROAD=9;
	private int cost, rent, houseRent;
	private int propertytype;
	private boolean owned=false;
	private String name;
	private MonopolyPlayer owner;
	private int numRailroads = 0, numHouses = -1;
	int dicetotal; //CHANGE
	//private MonopolyPlayer tempOwner;
	protected boolean ableToBuyHouses = false;
	//Buy 4 houses and then buy a hotel, 
	//array resizes to 1 when a hotel is purchased
	protected House[] houses = new House[5];
	PropertyCard(String property){
		super(property);
		name=property;
		//tempOwner = new MonopolyPlayer();
		setPropertyStats();
	}
	public boolean owned(){
		return owned;
	}
	public void setAbleToBuyHouses(boolean bool){
		System.out.println(name + " is able to build houses!");
		ableToBuyHouses=bool;
	}
	public void setOwned(boolean bool){
		owned=bool;
	}
	public void buyHouse(){
<<<<<<< Upstream, based on branch 'master' of https://github.com/EthanCarpenter/Monopoly
		if(ableToBuyHouses && owner.playerMoney()>=
				new House(name, numHouses).getPrice()){
			houseRent = new House(name, numHouses).getRent();
=======
		if(ableToBuyHouses && owner.playerMoney()>=new House(name, numHouses).getPrice()){
			rent = rent + new House(name, numHouses).getRent();
>>>>>>> 5c6cafe MINECRAFT
			numHouses ++;
		}
	}
	public void setOwner(MonopolyPlayer own){
		String type = typetoString();
		if(own.afterRoll(this) && own.playerMoney() > cost){
			owner=own;
			owned=true;
			owner.subtractMoney(cost);
			System.out.println(own.returnName()+" has bought "+name+" for $"+cost+"!");
			if(type.equals("PURPLE")){
				owner.addPurple();
			}else if(type.equals("LIGHTGREEN")){
				owner.addLightGreen();
			}else if(type.equals("VIOLET")){
				owner.addViolet();
			}else if(type.equals("ORANGE")){
				owner.addOrange();
			}else if(type.equals("RED")){
				owner.addRed();
			}else if(type.equals("YELLOW")){
				owner.addYellow();
			}else if(type.equals("DARKGREEN")){
				owner.addDarkGreen();
			}else if(type.equals("DARKBLUE")){
				owner.addDarkBlue();
			}else if(type.equals("UTILITIES")){
				owner.addUtilities();
			}else if(type.equals("RAILROAD")){
				owner.addRails();
			}
		}else if(own.playerMoney() < cost){
			System.out.println("insufficient funds.");
		}
	}
	public int railroadsOwned(){
		return numRailroads;
	}
	public void slotAction(MonopolyPlayer a,ArrayList<MonopolyPlayer> plist,ArrayList<MonopolySlot> board){
		if(!owned){
			setOwner(a);
		}else{
			System.out.print(a.returnName()+" has landed on "
					+owner.returnName()+"'s property!");
			giveAndTake(a);
		}
	}
	public int cost(){
		return cost;
	}
	public int rent(){
		return rent;
	}
	public String name(){
		return name;
	}
	public int type(){
		return propertytype;
	}
	public String typetoString(){
		String typeName;
		if(propertytype==0){
			typeName="PURPLE";
		}else if(propertytype==1){
			typeName="LIGHTGREEN";
		}else if(propertytype==2){
			typeName="VIOLET";
		}else if(propertytype==3){
			typeName="ORANGE";
		}else if(propertytype==4){
			typeName="RED";
		}else if(propertytype==5){
			typeName="YELLOW";
		}else if(propertytype==6){
			typeName="DARKGREEN";
		}else if(propertytype==7){
			typeName="DARKBLUE";
		}else if(propertytype==8){
			typeName="UTILITIES";
		}else{
			typeName="RAILROAD";
		}
		return typeName;
	}
	private void setPropertyStats(){
		if(name.equals("Mediterranean Ave.")){
			cost=60;
			rent=2;
			propertytype=0;
		}else if(name.equals("Baltic Ave.")){
			cost=60;
			rent=4;
			propertytype=0;
		}else if(name.equals("Oriental Ave.")){
			cost=100;
			rent=6;
			propertytype=1;
		}else if(name.equals("Vermont Ave.")){
			cost=100;
			rent=6;
			propertytype=1;
		}else if(name.equals("Connecticut Ave.")){
			cost=120;
			rent=8;
			propertytype=1;
		}else if(name.equals("St. Charles Place")){
			cost=140;
			rent=10;
			propertytype=2;
		}else if(name.equals("States Ave.")){
			cost=140;
			rent=10;
			propertytype=2;
		}else if(name.equals("Virginia Ave.")){
			cost=160;
			rent=12;
			propertytype=2;
		}else if(name.equals("St. James Place")){
			cost=180;
			rent=14;
			propertytype=3;
		}else if(name.equals("Tennessee Ave.")){
			cost=180;
			rent=14;
			propertytype=3;
		}else if(name.equals("New York Ave.")){
			cost=200;
			rent=16;
			propertytype=3;
		}else if(name.equals("Kentucky Ave.")){
			cost=220;
			rent=18;
			propertytype=4;
		}else if(name.equals("Indiana Ave.")){
			cost=220;
			rent=18;
			propertytype=4;
		}else if(name.equals("Illinois Ave.")){
			cost=240;
			rent=20;
			propertytype=4;
		}else if(name.equals("Atlantic Ave.")){
			cost=260;
			rent=22;
			propertytype=5;
		}else if(name.equals("Ventnor Ave.")){
			cost=260;
			rent=22;
			propertytype=5;
		}else if(name.equals("Marvin Gardens")){
			cost=280;
			rent=22;
			propertytype=5;
		}else if(name.equals("Pacific Ave.")){
			cost=300;
			rent=26;
			propertytype=6;
		}else if(name.equals("North Carolina Ave.")){
			cost=300;
			rent=26;
			propertytype=6;
		}else if(name.equals("Pennsylvania Ave.")){
			cost=320;
			rent=28;
			propertytype=6;
		}else if(name.equals("Park Place")){
			cost=350;
			rent=35;
			propertytype=7;
		}else if(name.equals("Boardwalk")){
			cost=400;
			rent=50;
			propertytype=7;
		}else if(name.equals("Electric Company")){
			cost=150;
			rent=(4*dicetotal);
			propertytype=8;
		}else if(name.equals("Water Works")){
			cost=150;
			rent=(4*dicetotal);
			propertytype=8;
		}else if(name.equals("Reading Railroad")){
			cost=200;
			rent = 25;
			propertytype=9;
		}else if(name.equals("Pennsylvania Railroad")){
			cost=200;
			rent = 25;
			propertytype=9;
		}else if(name.equals("B. & O. Railroad")){
			cost=200;
			rent = 25;
			propertytype=9;
		}else if(name.equals("Short Line Railroad")){
			cost=200;
			rent = 25;
			propertytype=9;
		}
	}
	public boolean ableToBuyHouses(){
		return ableToBuyHouses;
	}
	public void giveAndTake(MonopolyPlayer a){
		int totalDice = a.getDice1() + a.getDice2();
		String type = typetoString();
		int purpleRent = owner.numPurple();
		int lightGreenRent = owner.numLightGreen();
		int violetRent = owner.numViolet();
		int orangeRent = owner.numOrange();
		int redRent = owner.numRed();
		int yellowRent = owner.numYellow();
		int darkGreenRent = owner.numDarkGreen();
		int darkBlueRent = owner.numDarkBlue();
		int utilitiesRent = owner.numUtilities();
		int railRent = owner.numRails();
		int modRent = 0;
		if(type.equals("PURPLE")){
			if(purpleRent == 1){
				modRent = rent;
			}else if(purpleRent == 2){
<<<<<<< Upstream, based on branch 'master' of https://github.com/EthanCarpenter/Monopoly
				modRent = (rent * 2) + houseRent;
=======
				if(numHouses == -1)
					modRent = rent * 2;
				else
					modRent = rent * 2 + (houses[numHouses].getRent());
>>>>>>> 5c6cafe MINECRAFT
			}
		}
		if(type.equals("LIGHTGREEN")){
			if(lightGreenRent == 1 || lightGreenRent == 2){
				modRent = rent;
			}else if(lightGreenRent == 3){
<<<<<<< Upstream, based on branch 'master' of https://github.com/EthanCarpenter/Monopoly
				modRent = (rent * 2) + houseRent;
=======
				if(numHouses == -1)
					modRent = rent * 2;
				else
					modRent = rent * 2 + (houses[numHouses].getRent());
>>>>>>> 5c6cafe MINECRAFT
			}
		}
		if(type.equals("VIOLET")){
			if(violetRent == 1 || violetRent == 2){
				modRent = rent;
			}else if(violetRent == 3){
<<<<<<< Upstream, based on branch 'master' of https://github.com/EthanCarpenter/Monopoly
				modRent = (rent * 2) + houseRent;
=======
				if(numHouses == -1)
					modRent = rent * 2;
				else
					modRent = rent * 2 + (houses[numHouses].getRent());
>>>>>>> 5c6cafe MINECRAFT
			}
		}
		if(type.equals("ORANGE")){
			if(orangeRent == 1 || orangeRent == 2){
				modRent = rent;
			}else if(orangeRent == 3){
<<<<<<< Upstream, based on branch 'master' of https://github.com/EthanCarpenter/Monopoly
				modRent = (rent * 2) + houseRent;
=======
				if(numHouses == -1)
					modRent = rent * 2;
				else
					modRent = rent * 2 + (houses[numHouses].getRent());
>>>>>>> 5c6cafe MINECRAFT
			}
		}
		if(type.equals("RED")){
			if(redRent == 1 || redRent == 2){
				modRent = rent;
			}else if(redRent == 3){
<<<<<<< Upstream, based on branch 'master' of https://github.com/EthanCarpenter/Monopoly
				modRent = (rent * 2) + houseRent;
=======
				if(numHouses == -1)
					modRent = rent * 2;
				else
					modRent = rent * 2 + (houses[numHouses].getRent());
>>>>>>> 5c6cafe MINECRAFT
			}
		}
		if(type.equals("YELLOW")){
			if(yellowRent == 1 || yellowRent == 2){
				modRent = rent;
			}else if(yellowRent == 3){
<<<<<<< Upstream, based on branch 'master' of https://github.com/EthanCarpenter/Monopoly
				modRent = (rent * 2) + houseRent;
=======
				if(numHouses == -1)
					modRent = rent * 2;
				else
					modRent = rent * 2 + (houses[numHouses].getRent());
>>>>>>> 5c6cafe MINECRAFT
			}
		}
		if(type.equals("DARKGREEN")){
			if(darkGreenRent == 1 || darkGreenRent == 2){
				modRent = rent;
			}else if(darkGreenRent == 3){
<<<<<<< Upstream, based on branch 'master' of https://github.com/EthanCarpenter/Monopoly
				modRent = (rent * 2) + houseRent;
=======
				if(numHouses == -1)
					modRent = rent * 2;
				else
					modRent = rent * 2 + (houses[numHouses].getRent());
>>>>>>> 5c6cafe MINECRAFT
			}
		}
		if(type.equals("DARKBLUE")){
			if(darkBlueRent == 1){
				modRent = rent;
			}else if(darkBlueRent == 2){
<<<<<<< Upstream, based on branch 'master' of https://github.com/EthanCarpenter/Monopoly
				modRent = (rent * 2) + houseRent;
=======
				if(numHouses == -1)
					modRent = rent * 2;
				else
					modRent = rent * 2 + (houses[numHouses].getRent());
>>>>>>> 5c6cafe MINECRAFT
			}
		}
		if(type.equals("UTILITIES")){
			if(utilitiesRent == 1){
				modRent = 4 * totalDice;
			}else if(utilitiesRent == 2){
				modRent = 10 * totalDice;
			}
		}
		if(type.equals("RAILROAD")){
			if(railRent == 1){
				modRent = rent;
			}else if(railRent == 2){
				modRent = rent * 2;
			}else if(railRent == 3){
				modRent = rent * 4;
			}else if(railRent == 4){
				modRent = rent * 8;
			}
		}
		System.out.println(a.returnName()+" has paid $"+modRent+" to "+owner.returnName());
		a.subtractMoney(modRent);
		owner.addMoney(modRent);
	}
}