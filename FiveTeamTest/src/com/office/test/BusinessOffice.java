package com.office.test;

public class BusinessOffice extends Office {

	/**
	 * Constructeur de la classe fille bureau commercial
	 * @param networkSocket_nb
	 * @param sectorSocket_nb
	 * @param phoneSocket_nb
	 * @param chairs_nb
	 * @param tables_nb
	 * @param person_nb
	 */
	public BusinessOffice(int networkSocket_nb, int sectorSocket_nb,
			int phoneSocket_nb, int chairs_nb, int tables_nb) {
		super(networkSocket_nb, sectorSocket_nb, phoneSocket_nb, chairs_nb, tables_nb);
		
	}
	public void addPerson(int i) {
		super.addPerson(i);
		
	}
	// calcul free space in Business office
		public int freeSpace(){
	    	 
	    	return  (Person_nb - networkSocket_nb+Person_nb-sectorSocket_nb+Person_nb-2*phoneSocket_nb+Person_nb-2*chairs_nb+Person_nb-tables_nb);
	    }

}
