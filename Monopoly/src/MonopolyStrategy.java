/*
 * William Cox
 * Parker Tewell
 * Period 1
 */
public class MonopolyStrategy extends MonopolyPlayer{
	MonopolyStrategy(int id) {
		super(id);
	}
	public int rollDice(){
		dice1=(int)(Math.random() * ((6 - 1) + 1)) + 1;
		dice2=(int)(Math.random() * ((6 - 1) + 1)) + 1;
		dicetotal=dice1+dice2;
		return dicetotal;
	}
	//what is used to determine strategy
	public boolean playerConfirm(String question){
		boolean check=true;
		boolean returnBool=true;
		
		return returnBool;
	}
	/**
	 * Determines if the strategy should buy houses,
	 * stay in/escape jail, mortgage
	 * @return 
	 */
	public void beforeRoll(){
		if(money > 600 && numMonopolies()>0){
			
		}
	}
	/**
	 * Determines if the strategy should 
	 * buy properties, mortgage
	 */
	public boolean afterRoll(PropertyCard card){
		
	}
}