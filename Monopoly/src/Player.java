/*
 * Chance Xie and Will Cox
 * Monopoly
 * Independent Project
 */
import java.util.ArrayList;
import javax.swing.*;

import java.awt.Color;
import java.lang.Math;
public class Player {
	//protected boolean chance;
	//protected boolean communitychest;
	//protected boolean bankruptcy = false;
	protected String name;
	protected Color color;
	//protected boolean jail = false;
	protected int money = 1500, getOutOfJailFree = 0;
	//int dice1, dice2, dicetotal, doubleRolls,
	protected int playerPosition=0;
	protected int totalMoves = 0;
	protected int revolutions;
	protected int playerID;
	protected boolean playerDoubleRoll;
	protected ArrayList<PropertyCard> playerMonopolyProperties = new ArrayList<PropertyCard>();
	protected int pieceID; 
	protected ArrayList playerBoard;
	protected int numTurns = 0;
	Player(Color newColor, String newName, String type){
		color = newColor;
		name = newName;
		
	}
	/**
	 * @param otherProperties properties the player that wants to trade has
	 * @return the property that can be a mutually beneficial trade
	 */
	public PropertyCard tradeableProperty(ArrayList<PropertyCard> otherProperties){
		for(PropertyCard property : playerMonopolyProperties)
			if(propertiesNeededForMonopoly(property.getColor()) == 1)
				for(PropertyCard otherProperty : otherProperties)
					if(property.getColor().equals(otherProperty.getColor()))
						return otherProperty;
		return null;
	}
	public void setBoard(ArrayList board){
		playerBoard = board;
	}
	public ArrayList<PropertyCard> playerProperties(){
		return playerMonopolyProperties;
	}
	/**
	 * @return the number of monopolies a player has
	 */
	protected int numMonopolies(){
		int monopolies = 0;

		return monopolies;
	}
	private int numType(String color){
		int num;
		if(color.equals("PURPLE") || color.equals("DARKBLUE"))
			num=2;
		else
			num=3;
		return num;
	}
	public int propertiesNeededForMonopoly(String color){
		int propertiesOwned = 0, total = numType(color);
		for(PropertyCard property : playerMonopolyProperties) {
			if(color.equals(property.getColor()))
				propertiesOwned++;
			System.out.println(color+ (total - propertiesOwned));
		}
		return total - propertiesOwned;
	}
	public void beforeRoll(){

	}
	public boolean afterRoll(Slot slot){
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
	public int numberOfCards(){
		return playerMonopolyProperties.size();
	}
	public PropertyCard nthCard(int i){
		return (PropertyCard) playerMonopolyProperties.get(i);
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
		for(Object PlayingCard: playerMonopolyProperties){
			String s=PlayingCard.toString();
			//System.out.println(s);
		}
	}
	public void setName(String n){
		name=n;
	}
	public void addCard(PropertyCard a){
		playerMonopolyProperties.add(a);
		a.setOwned(true);
	}
	public int playerMoney(){
		return money;
	}
	public int addMoney(int add){
		money+=add;
		return money;
	}
	public int subtractMoney(int subtract){
		money-=subtract;
		return money;
	}
//	public boolean bankruptcy(){
//		if(money<0){
//			bankruptcy=true;
//			for(int i = 0; i < playerMonopolyProperties.size(); i++) {
//				playerMonopolyProperties.get(i).setOwned(false);
//				//playerMonopolyProperties.get(i).setOwner(null);
//			}
//		}
//		return bankruptcy;
//	}
	public int getOutOfJailFree(){
		return getOutOfJailFree;
	}
	public void addGetOutOfJailFree(){
		getOutOfJailFree+=1;
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
		addMoney(200);
	}
	public void removeCard(PropertyCard card) {
		playerMonopolyProperties.remove(card);
	}
	public int numTurns() {
		return numTurns;
	}
}