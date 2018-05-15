/*
 * Parker Tewell and William Cox
 * Period 1
 */
public class goodStrategy extends MonopolyPlayer{
	goodStrategy(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public boolean afterRoll(PropertyCard propertyCard) {
		int propertyCost = propertyCard.cost();
		String propertyColor = propertyCard.getColor();
		int numPropertyColor = 0;
		if(propertyColor.equals("PURPLE")) {
			numPropertyColor = numLightGreen;
		}else if(propertyColor.equals("LIGHTGREEN")) {
			numPropertyColor = numLightGreen;
		}else if(propertyColor.equals("VIOLET")) {
			numPropertyColor = numViolet;
		}else if(propertyColor.equals("ORANGE")) {
			numPropertyColor = numOrange;
		}else if(propertyColor.equals("RED")) {
			numPropertyColor = numRed;
		}else if(propertyColor.equals("YELLOW")) {
			numPropertyColor = numYellow;
		}else if(propertyColor.equals("DARKGREEN")) {
			numPropertyColor = numDarkGreen;
		}else if(propertyColor.equals("DARKBLUE")) {
			numPropertyColor = numDarkBlue;
		}else if(propertyColor.equals("UTILITIES")) {
			numPropertyColor = numUtilities;
		}else if(propertyColor.equals("RAILROAD")) {
			numPropertyColor = numRailroads;
		}
		if(numPropertyColor > ) {
			
		}
	}
}
