public class BestStrategy extends MonopolyPlayer{
	BestStrategy(int id) {
		super(id);
	}
	/**
	 * Determines if the strategy should buy houses,
	 * stay in/escape jail, mortgage
	 */
	public void beforeRoll(){
		beforeRollInJail();
		determineBuyingHouses();
	}
	private void determineBuyingHouses(){
		for(PropertyCard property : PlayerMonopolyProperties)
		if(property.ableToBuyHouses && new House(property.name(), property.numHouses()+1).getPrice() < money){
			property.buyHouse();
		}
	}
	private void beforeRollInJail(){
		//total number of properties: 27
		//could be worth it to mortgage property in order to pay for bail
		if(jail && /*number of owned properties < 25*/){
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
	 */
	public void afterRoll(){
		
	}
}