package wom.hunting.test;

public class RabbitTerrier {

	private boolean taken;
	private Position positionTerrier;
	
	public RabbitTerrier(boolean taken, Position position) {
		this.taken = taken;
		this.positionTerrier = position;
	}

	public boolean isTaken() {
		return taken;
	}

	public void setTaken(boolean taken) {
		this.taken = taken;
	}

	public Position getPositionTerrier() {
		return positionTerrier;
	}

	public void setPositionTerrier(Position positionTerrier) {
		this.positionTerrier = positionTerrier;
	}
	public String toString(){
		return this.isTaken()+" "+this.getPositionTerrier();
	}
	
}
