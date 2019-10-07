package wom.hunting.test;


public class Hunting {

	public static void main(String[] args) {
		//Initialiser le chasseur
		int bull = (int)(Math.random() * 11);
		int hung = (int)(Math.random() * 11);
		//surface en kilometres
		int surf = (int)(1 + (Math.random() * 11));
		//positions en mettres
		int x = (int) (Math.random() * (Math.sqrt(surf)+1)*100);
		int y = (int) (Math.random() * (Math.sqrt(surf)+1)*100);
		Hunter hunter = new Hunter(bull, hung, 0, new Position(x,y));
		
		//Initialiser la foret
		int rabitNumb = (int)(1 + (Math.random() * 11));
		int treesNum = (int) (Math.random() * 1001);
		int ter = (int)(1 + (Math.random() * 11));
		Forest forest = new Forest(surf, treesNum, rabitNumb, ter);
		// Tourner le jeux
		hunter.hunting(forest);
		System.out.println("This hunter lose : "+(bull-hunter.getBulletsNumber())+" bullets \t and travelled :"+hunter.getTravaledKilometers_hunter()+" Km");

		
	}

	

}
