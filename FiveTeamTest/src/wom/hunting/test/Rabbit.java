package wom.hunting.test;

public class Rabbit {

	private int speed;
	private String color;
	private double travaledKilometers_Rabit;
	private Position positionRabit;
	/**
	 * Initialise Rabbit
	 * @param speed
	 * @param travaledKilometers_Rabit
	 * @param positionRabit
	 * @param color
	 */
	public Rabbit(int speed, double travaledKilometers_Rabit, Position positionRabit, String color) {
		this.speed = speed;
		this.travaledKilometers_Rabit = travaledKilometers_Rabit;
		this.positionRabit = positionRabit;
		this.color = color;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getTravaledKilometers_Rabit() {
		return travaledKilometers_Rabit;
	}



	public void setTravaledKilometers_Rabit(double travaledKilometers_Rabit) {
		this.travaledKilometers_Rabit += travaledKilometers_Rabit;
	}

	public Position getPositionRabit() {
		return positionRabit;
	}

	public void setPositionRabit(Position positionRabit) {
		this.positionRabit = positionRabit;
	}

	/**
	 * if Rabbit followed by a hunter then he seach a terrier
	 * @param rabbit
	 * @param forest
	 * @param hunter
	 */
	public void sued(Rabbit rabbit, Forest forest, Hunter hunter){
		int i = 0;
		double val;
		RabbitTerrier[] terriers = forest.getTerriers();
		while(i<terriers.length){
			val = Math.abs((Math.sqrt(Math.pow(rabbit.getPositionRabit().getX(), 2) + Math.pow(rabbit.getPositionRabit().getY(), 2))) - (Math.sqrt(Math.pow(terriers[i].getPositionTerrier().getX(), 2) + Math.pow(terriers[i].getPositionTerrier().getY(), 2))));
			
			if(val>20){
				rabbit.setTravaledKilometers_Rabit(val/1000);
				hunter.setTravaledKilometers_hunter(val/1000);
			}
			if(!terriers[i].isTaken()){
				terriers[i].setTaken(true);
				System.out.println("This rabbit take the terrier");
				System.out.println("This rabbit travelled : "+rabbit.getTravaledKilometers_Rabit()+" Km");
				break;	
			}
			System.out.println("Rabbit : This terrier is taken already");
			i++;	
		}
		
	}
	public String toString(){
		return this.getSpeed()+" "+this.getTravaledKilometers_Rabit()+" "+this.getPositionRabit()+" "+this.getColor();
	}
}
