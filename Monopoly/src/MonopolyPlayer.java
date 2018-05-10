/*
 * Chance Xie and Will Cox
 * Monopoly
 * Independent Project
 */
import java.util.ArrayList;
import javax.swing.*;
import java.lang.Math;
import java.util.Random;
import java.util.Scanner;
public class MonopolyPlayer {
	protected boolean chance;
	protected boolean communitychest;
	protected int money=1500;
	protected boolean bankruptcy=false;
	protected String name;
	protected boolean jail=false;
	protected int dice1, dice2;
	protected int dicetotal;
	protected int playerPosition=0;
	protected int totalMoves = 0;
	protected int revolutions;
	protected int playerID;
	protected boolean playerDoubleRoll;
	protected int getOutOfJailFree=0;
	protected ArrayList<PropertyCard> PlayerMonopolyProperties;
	protected int numPurple = 0;
	protected int numLightGreen = 0;
	protected int numViolet = 0;
	protected int numOrange = 0;
	protected int numRed = 0;
	protected int numYellow = 0;
	protected int numDarkGreen = 0;
	protected int numDarkBlue = 0;
	protected int numUtilities = 0;
	protected int numRailroads = 0;
	protected int pieceID;
	protected int doubleRolls;
	protected int numTurnsInJail = 0;
	public ArrayList<PropertyCard> playerProperties(){
		return PlayerMonopolyProperties;
	}
	MonopolyPlayer(int id){
		playerID=id;
		PlayerMonopolyProperties=new ArrayList();
		revolutions = 40;
	}
	/**
	 * @return the number of monopolies a player has
	 */
	protected int numMonopolies(){
		int monopolies = 0;

		return monopolies;
	}
<<<<<<< Upstream, based on branch 'master' of https://github.com/EthanCarpenter/Monopoly
	public int numTurnsInJail(){
		return numTurnsInJail;
	}
	public void addJailTurn(){
		numTurnsInJail++;
=======
	public int propertiesNeededForMonopoly(String color){
		int properties = 0;
		for(PropertyCard property : PlayerMonopolyProperties)
			if()
		return properties;
>>>>>>> 85be4be mineaesd
	}
	public void beforeRoll(){
		
	}
	public boolean afterRoll(PropertyCard card){
		/*boolean check=true;
		boolean returnBool=true;
		
		do{
<<<<<<< Upstream, based on branch 'master' of https://github.com/EthanCarpenter/Monopoly
			if(check==false)
				System.out.print("Input not valid. ");
			String playerResponse;
			playerResponse=JOptionPane.showInputDialog(name+". "+question+" yes/no");
			System.out.println(name+"'s response: "+playerResponse);
			if(playerResponse.equals("yes")){
				returnBool=true;
				check=true;
			}else if(playerResponse.equals("no")){
				returnBool=false;
				check=true;
			}else
				check=false;
		}while(check==false);
		//return true;
		return returnBool;*/
		return true;
	}
	public void setPieceID(int x){
		pieceID = x;
	}
	public int returnPieceID(){
		return pieceID;
	}
	public void setPlayerID(int newID){
		playerID=newID;
	}
	public int playerID(){
		return playerID;
	}
	public boolean setPlayerDoubleRoll(boolean x){
		playerDoubleRoll = x;
		return playerDoubleRoll;
	}
	public void setDoubleRoll(int set){
		doubleRolls=set;
	}
	public boolean playerDoubleRoll(){
		if(dice1==dice2){
			doubleRolls++;
			playerDoubleRoll=true;
			if(jail){
				System.out.print("You got out of jail due to a double roll!");
				jail=false;
			}
		}else{
			playerDoubleRoll=false;
		}

		return playerDoubleRoll;
	}
	public void setPlayerPosition(int pos){
		truePosition();
		playerPosition=pos;
	}
	public int playerPosition(){
		truePosition();
		return playerPosition;
	}
	public void truePosition(){
		playerPosition=playerPosition%40;
	}
	//Use this method to automate dice
	public int rollDice(){
		String playerResponse;
		playerResponse=JOptionPane.showInputDialog(name+". "+"Type anything to roll");
		System.out.println(name+"'s response: "+playerResponse);
		dice1=(int)(Math.random() * ((6 - 1) + 1)) + 1;
		dice2=(int)(Math.random() * ((6 - 1) + 1)) + 1;
		dicetotal=dice1+dice2;
		return dicetotal;
	}
	public int getDice1(){
		return dice1;
	}
	public int getDice2(){
		return dice2;
	}
	public int numberOfCards(){
		return PlayerMonopolyProperties.size();
	}
	public PropertyCard nthCard(int i){
		return (PropertyCard) PlayerMonopolyProperties.get(i);
	}
	public boolean playerConfirm(String question){
		boolean check=true;
		boolean returnBool=true;
		do{
			if(check==false)
				System.out.print("Input not valid. ");
			String playerResponse;
			playerResponse=JOptionPane.showInputDialog(name+". "+question+" yes/no");
			System.out.println(name+"'s response: "+playerResponse);
			if(playerResponse.equals("yes")){
				returnBool=true;
				check=true;
			}else if(playerResponse.equals("no")){
				returnBool=false;
				check=true;
			}else
				check=false;
		}while(check==false);
		return returnBool;
	}
	public void print(){
		for(Object PlayingCard: PlayerMonopolyProperties){
			String s=PlayingCard.toString();
			System.out.println(s);
		}
	}
	public void setName(String n){
		name=n;
	}
	public void addCard(PropertyCard a){
		PlayerMonopolyProperties.add(a);
		a.setOwned(true);
	}
	public int playerMoney(){
		return money;
	}
	public boolean chanceBool(){
		return chance;
	}
	public boolean communitychestBool(){
		return communitychest;
	}
	public int addMoney(int add){
		money+=add;
		return money;
	}
	public int subtractMoney(int subtract){
		money-=subtract;
		return money;
	}
	public boolean bankruptcy(){
		if(money<0){
			bankruptcy=true;
			for(int i = 0; i < PlayerMonopolyProperties.size(); i++) {
				PlayerMonopolyProperties.get(i).setOwned(false);
				//PlayerMonopolyProperties.get(i).setOwner(null);
			}
		}
		return bankruptcy;
	}
	public void jail(){
		if(jail == true){
			System.out.print(name+" is in jail!");
			if(getOutOfJailFree>0){
				boolean bool=playerConfirm(name+", would you like to use your Get out of Jail Free Card?");
				if(bool){
					jail=false;
					getOutOfJailFree--;
				}
			}
		}
	}
	public boolean isInJail(){
		return jail;
	}
	public int getOutOfJailFree(){
		return getOutOfJailFree;
	}
	public void addGetOutOfJailFree(){
		getOutOfJailFree+=1;
	}
	public void setJail(boolean j){
		jail=j;
	}
	public String returnName(){
		return name;
	}
	public int getRevolutions(){
		return revolutions;
	}
	public void addRevolutions(){
		revolutions+=40;
	}
	public void totalMoves(int dice1, int dice2){
		int movement = dice1 + dice2;
		totalMoves += movement;
	}
	public int returnMoves(){
		return totalMoves;
	}
	public void addTotalMoves(int addTotal){
		totalMoves += addTotal;
	}
	public void setTotalMoves(int moves){
		totalMoves = moves;
	}
	public void setRevolutions(int setRev){
		revolutions = setRev;
	}
	public void passGo(){
		System.out.println("You have passed go. Collected $200.");
		addMoney(200);
	}
	public int numPurple(){
		return numPurple;
	}
	public void addPurple(){
		numPurple++;
	}
	public int numLightGreen(){
		return numLightGreen;
	}
	public void addLightGreen(){
		numLightGreen++;
	}
	public int numViolet(){
		return numViolet;
	}
	public void addViolet(){
		numViolet++;
	}
	public int numOrange(){
		return numOrange;
	}
	public void addOrange(){
		numOrange++;
	}
	public int numRed(){
		return numRed;
	}
	public void addRed(){
		numRed++;
	}
	public int numYellow(){
		return numYellow;
	}
	public void addYellow(){
		numYellow++;
	}
	public int numDarkGreen(){
		return numDarkGreen;
	}
	public void addDarkGreen(){
		numDarkGreen++;
	}
	public int numDarkBlue(){
		return numDarkBlue;
	}
	public void addDarkBlue(){
		numDarkBlue++;
	}
	public int numUtilities(){
		return numUtilities;
	}
	public void addUtilities(){
		numUtilities++;
	}
	public int numRails(){
		return numRailroads;
	}
	public void addRails(){
		numRailroads++;
	}
}