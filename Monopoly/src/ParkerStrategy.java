public class ParkerStrategy extends MonopolyPlayer{
	ParkerStrategy(int id) {
		super(id);
	}
	/**
	 * Determines if the strategy should buy houses,
	 * stay in/escape jail, mortgage
	 */
	public void beforeRoll(int numOwned){
		beforeRollInJail(numOwned);
		determineBuyingHouses();
	}
	private void determineBuyingHouses(){
		for(PropertyCard property : PlayerMonopolyProperties)
			if(property.ableToBuyHouses && new House(property.name(), property.numHouses()+1).getPrice() < money)
				property.buyHouse();
	}
	private void beforeRollInJail(int numOwned){
		//total number of properties: 27
		//could be worth it to mortgage property in order to pay for bail
		if(jail && numOwned < 25){
			if(getOutOfJailFree>0){
				getOutOfJailFree--;
				setJail(false);
			}else if(money > 50){
				money = money - 50;
				setJail(false);
			}
		}
	}
	/**
	 * Determines if the strategy should 
	 * buy properties, mortgage
	 * The boolean returned determines if the player will try to buy the property or not
	 */
	public boolean afterRoll(PropertyCard property){
		determineMortgage(property);
		boolean buy = determineBuyProperty(property);
		determineTrading();
	}
	
	
	private boolean determineBuyProperty(PropertyCard property){
		if(money > property.cost())
			return true;
		else
			return false;
	}
	private int potentialMortgage(){
		int mortgageValue = 0;
		for(PropertyCard property : PlayerMonopolyProperties)
			mortgageValue = mortgageValue + property.getMortgageValue();
		return mortgageValue;
	}
	/**
	 * Mortgage property to buy property
	 */
	private void determineMortgage(PropertyCard property) {
		if(!property.owned() && property.cost() > money && property.cost() > money+potentialMortgage()){
			int counter = 0;
			while(property.cost() > money){
				nthCard(counter).mortgage();;
				counter++;
			}
		}
	}
}