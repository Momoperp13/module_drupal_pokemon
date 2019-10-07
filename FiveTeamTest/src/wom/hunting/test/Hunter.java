package wom.hunting.test;

public class Hunter {
	private int bulletsNumber;
	private int hungerLevel;
	private double travaledKilometers_hunter;
	private Position positionHunter;
	
	/**
	 * Initialise Hunter
	 * @param bulletsNumber
	 * @param hungerLevel
	 * @param travaledKilometers_hunter
	 * @param positionHunter
	 */
	public Hunter(int bulletsNumber, int hungerLevel,
			double travaledKilometers_hunter, Position positionHunter) {
		this.bulletsNumber = bulletsNumber;
		this.hungerLevel = hungerLevel;
		this.travaledKilometers_hunter = travaledKilometers_hunter;
		this.positionHunter = positionHunter;
	}


	public int getBulletsNumber() {
		return bulletsNumber;
	}


	public void setBulletsNumber(int bulletsNumber) {
		this.bulletsNumber -= bulletsNumber;
	}


	public int getHungerLevel() {
		return hungerLevel;
	}


	public void setHungerLevel(int hungerLevel) {
		this.hungerLevel = hungerLevel;
	}


	public double getTravaledKilometers_hunter() {
		return travaledKilometers_hunter;
	}


	public void setTravaledKilometers_hunter(double travaledKilometers_hunter) {
		this.travaledKilometers_hunter += travaledKilometers_hunter;
	}


	public Position getPositionHunter() {
		return positionHunter;
	}


	public void setPositionHunter(Position positionHunter) {
		this.positionHunter = positionHunter;
	}


	/**
	 * Hunter search and follow a rabbit if it's close to 50m
	 * @param forest
	 */
	public void hunting(Forest forest){
		int i = 0;
		double val;
		Rabbit[] rabbits = forest.getRabbits();
		while(i<rabbits.length){
			//calcul the distance
			val = Math.abs((Math.sqrt(Math.pow(rabbits[i].getPositionRabit().getX(), 2) + Math.pow(rabbits[i].getPositionRabit().getY(), 2))) - (Math.sqrt(Math.pow(this.getPositionHunter().getX(), 2) + Math.pow(this.getPositionHunter().getY(), 2))));
			if(val<50){
				this.setBulletsNumber(1);
				rabbits[i].sued(rabbits[i], forest, this);
				this.setTravaledKilometers_hunter(val/1000);
			}
			i++;
		}
	}
}
