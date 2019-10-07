package wom.hunting.test;

import java.util.Random;

public class Forest {

	private RabbitTerrier[] terriers;
	private Rabbit[] rabbits;
	private int surface;
	private int treesNumber;
	private int rabbitsNumber;
	private int terriersNumber;
	/**
	 * Intialise the forest
	 * @param surface
	 * @param treesNumber
	 * @param rabbitsNumber
	 * @param terriersNumber
	 */
	public Forest( int surface, int treesNumber, int rabbitsNumber, int terriersNumber) {
		this.surface = surface;
		this.treesNumber = treesNumber;
		this.rabbitsNumber = rabbitsNumber;
		this.terriersNumber = terriersNumber;
		terriers = new RabbitTerrier[terriersNumber];
		rabbits = new Rabbit[rabbitsNumber];
		initialise();
	}

	/**
	 * initialise terriers and rabbits
	 */
	private void initialise() {
		Random numb = new Random();
		boolean taken;
		int speed;
		int x;
		int y;
		String [] colors = {"White", "Brown"};
		String color;
		//Initialise terriers
		for(int i=0;i<terriersNumber;i++){
			taken = numb.nextBoolean();
			x = (int) (Math.random() * (Math.sqrt(this.surface)+1)*100);
			y = (int) (Math.random() * (Math.sqrt(this.surface)+1)*100);
			terriers[i]= new RabbitTerrier(taken, new Position(x, y));
			
		}
		//Initialise rabbit
		for(int i=0;i<rabbitsNumber;i++){
			speed = (int)(Math.random() * 11);
			color = colors[(int) Math.random()];
			x = (int) (Math.random() * (Math.sqrt(this.surface)+1)*100);
			y = (int) (Math.random() * (Math.sqrt(this.surface)+1)*100);
			rabbits[i] = new Rabbit(speed, 0, new Position(x, y), color);
			
		}
		
	}

	public RabbitTerrier[] getTerriers() {
		return terriers;
	}

	public void setTerriers(RabbitTerrier[] terriers) {
		this.terriers = terriers;
	}

	public Rabbit[] getRabbits() {
		return rabbits;
	}

	public void setRabbits(Rabbit[] rabbits) {
		this.rabbits = rabbits;
	}

	public int getSurface() {
		return surface;
	}

	public void setSurface(int surface) {
		this.surface = surface;
	}

	public int getTreesNumber() {
		return treesNumber;
	}

	public void setTreesNumber(int treesNumber) {
		this.treesNumber = treesNumber;
	}

	public int getRabbitsNumber() {
		return rabbitsNumber;
	}

	public void setRabbitsNumber(int rabbitsNumber) {
		this.rabbitsNumber = rabbitsNumber;
	}

	public int getTerriersNumber() {
		return terriersNumber;
	}

	public void setTerriersNumber(int terriersNumber) {
		this.terriersNumber = terriersNumber;
	}
	public void calculatSpace(){
		
	}
	

	
	
	
}
