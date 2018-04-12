public class House{
	//DifferentValue values for each property and #building
	private String name;
	int houseNum, priceValue, sellValue, rentValue;
	House(String property, int num){
		name=property;
		houseNum = num;
		setHouseStats();
	}
	public void setStats(int price, int rent, int sell){
		priceValue=price;
		rentValue=rent;
		sellValue=sell;
	}
	private void setHouseStats(){
		if(name.equals("Mediterranean Ave.")){
			if(houseNum == 0)
				setStats(50,10,25);
			else if(houseNum == 1)
				setStats(50,30,25);
			else if(houseNum == 2)
				setStats(50,90,25);
			else if(houseNum == 3)
				setStats(50,160,25);
			else if(houseNum == 4)
				setStats(50,250,25);
		}else if(name.equals("Baltic Ave.")){
			if(houseNum == 0)
				setStats(50,20,25);
			else if(houseNum == 1)
				setStats(50,60,25);
			else if(houseNum == 2)
				setStats(50,180,25);
			else if(houseNum == 3)
				setStats(50,320,25);
			else if(houseNum == 4)
				setStats(50,450,25);
		}else if(name.equals("Oriental Ave.")){
			if(houseNum == 0)
				setStats(50,30,25);
			else if(houseNum == 1)
				setStats(50,90,25);
			else if(houseNum == 2)
				setStats(50,270,25);
			else if(houseNum == 3)
				setStats(50,400,25);
			else if(houseNum == 4)
				setStats(50,550,25);
		}else if(name.equals("Vermont Ave.")){
			if(houseNum == 0)
				setStats(50,30,25);
			else if(houseNum == 1)
				setStats(50,90,25);
			else if(houseNum == 2)
				setStats(50,270,25);
			else if(houseNum == 3)
				setStats(50,400,25);
			else if(houseNum == 4)
				setStats(50,550,25);
		}else if(name.equals("Connecticut Ave.")){
			if(houseNum == 0)
				setStats(50,40,25);
			else if(houseNum == 1)
				setStats(50,100,25);
			else if(houseNum == 2)
				setStats(50,300,25);
			else if(houseNum == 3)
				setStats(50,450,25);
			else if(houseNum == 4)
				setStats(50,600,25);
		}else if(name.equals("St. Charles Place")){
			if(houseNum == 0)
				setStats(100,50,50);
			else if(houseNum == 1)
				setStats(100,150,50);
			else if(houseNum == 2)
				setStats(100,450,50);
			else if(houseNum == 3)
				setStats(100,625,50);
			else if(houseNum == 4)
				setStats(50,750,25);
		}else if(name.equals("States Ave.")){
			if(houseNum == 0)
				setStats(100,50,50);
			else if(houseNum == 1)
				setStats(100,150,50);
			else if(houseNum == 2)
				setStats(100,450,50);
			else if(houseNum == 3)
				setStats(100,625,50);
			else if(houseNum == 4)
				setStats(50,750,25);
		}else if(name.equals("Virginia Ave.")){
			if(houseNum == 0)
				setStats(100,60,50);
			else if(houseNum == 1)
				setStats(100,180,50);
			else if(houseNum == 2)
				setStats(100,500,50);
			else if(houseNum == 3)
				setStats(100,700,50);
			else if(houseNum == 4)
				setStats(50,900,25);
		}else if(name.equals("St. James Place")){
			if(houseNum == 0)
				setStats(100,70,50);
			else if(houseNum == 1)
				setStats(100,200,50);
			else if(houseNum == 2)
				setStats(100,550,50);
			else if(houseNum == 3)
				setStats(100,750,50);
			else if(houseNum == 4)
				setStats(50,950,25);
		}else if(name.equals("Tennessee Ave.")){
			if(houseNum == 0)
				setStats(100,70,50);
			else if(houseNum == 1)
				setStats(100,200,50);
			else if(houseNum == 2)
				setStats(100,550,50);
			else if(houseNum == 3)
				setStats(100,750,50);
			else if(houseNum == 4)
				setStats(50,950,25);
		}else if(name.equals("New York Ave.")){
			if(houseNum == 0)
				setStats(100,80,50);
			else if(houseNum == 1)
				setStats(100,220,50);
			else if(houseNum == 2)
				setStats(100,550,50);
			else if(houseNum == 3)
				setStats(100,750,50);
			else if(houseNum == 4)
				setStats(50,1000,25);
		}else if(name.equals("Kentucky Ave.")){
			if(houseNum == 0)
				setStats(150,90,75);
			else if(houseNum == 1)
				setStats(150,250,75);
			else if(houseNum == 2)
				setStats(150,700,75);
			else if(houseNum == 3)
				setStats(150,875,75);
			else if(houseNum == 4)
				setStats(50,1050,25);
		}else if(name.equals("Indiana Ave.")){
			if(houseNum == 0)
				setStats(150,90,75);
			else if(houseNum == 1)
				setStats(150,250,75);
			else if(houseNum == 2)
				setStats(150,700,75);
			else if(houseNum == 3)
				setStats(150,875,75);
			else if(houseNum == 4)
				setStats(50,1050,25);
		}else if(name.equals("Illinois Ave.")){
			if(houseNum == 0)
				setStats(150,100,75);
			else if(houseNum == 1)
				setStats(150,300,75);
			else if(houseNum == 2)
				setStats(150,750,75);
			else if(houseNum == 3)
				setStats(150,925,75);
			else if(houseNum == 4)
				setStats(50,1100,25);
		}else if(name.equals("Atlantic Ave.")){
			if(houseNum == 0)
				setStats(150,110,75);
			else if(houseNum == 1)
				setStats(150,330,75);
			else if(houseNum == 2)
				setStats(150,800,75);
			else if(houseNum == 3)
				setStats(150,975,75);
			else if(houseNum == 4)
				setStats(50,1150,25);
		}else if(name.equals("Ventnor Ave.")){
			if(houseNum == 0)
				setStats(150,110,75);
			else if(houseNum == 1)
				setStats(150,330,75);
			else if(houseNum == 2)
				setStats(150,800,75);
			else if(houseNum == 3)
				setStats(150,975,75);
			else if(houseNum == 4)
				setStats(50,1150,25);
		}else if(name.equals("Marvin Gardens")){
			if(houseNum == 0)
				setStats(150,120,75);
			else if(houseNum == 1)
				setStats(150,360,75);
			else if(houseNum == 2)
				setStats(150,850,75);
			else if(houseNum == 3)
				setStats(150,1025,75);
			else if(houseNum == 4)
				setStats(50,1200,25);
		}else if(name.equals("Pacific Ave.")){
			if(houseNum == 0)
				setStats(200,130,100);
			else if(houseNum == 1)
				setStats(200,390,100);
			else if(houseNum == 2)
				setStats(200,900,100);
			else if(houseNum == 3)
				setStats(200,1100,100);
			else if(houseNum == 4)
				setStats(50,1275,25);
		}else if(name.equals("North Carolina Ave.")){
			if(houseNum == 0)
				setStats(200,130,100);
			else if(houseNum == 1)
				setStats(200,390,100);
			else if(houseNum == 2)
				setStats(200,900,100);
			else if(houseNum == 3)
				setStats(200,1100,100);
			else if(houseNum == 4)
				setStats(50,1275,25);
		}else if(name.equals("Pennsylvania Ave.")){
			if(houseNum == 0)
				setStats(200,150,100);
			else if(houseNum == 1)
				setStats(200,450,100);
			else if(houseNum == 2)
				setStats(200,1000,100);
			else if(houseNum == 3)
				setStats(200,1200,100);
			else if(houseNum == 4)
				setStats(50,1400,25);
		}else if(name.equals("Park Place")){
			if(houseNum == 0)
				setStats(200,175,100);
			else if(houseNum == 1)
				setStats(200,500,100);
			else if(houseNum == 2)
				setStats(200,1100,100);
			else if(houseNum == 3)
				setStats(200,1300,100);
			else if(houseNum == 4)
				setStats(50,1500,25);
		}else if(name.equals("Boardwalk")){
			if(houseNum == 0)
				setStats(200,200,100);
			else if(houseNum == 1)
				setStats(200,600,100);
			else if(houseNum == 2)
				setStats(200,1400,100);
			else if(houseNum == 3)
				setStats(200,1700,100);	
			else if(houseNum == 4)
				setStats(50,2000,25);
		}		
	}
}