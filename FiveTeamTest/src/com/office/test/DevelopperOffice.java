package com.office.test;
//Classe de bureau de développeur

public class DevelopperOffice extends Office {

	/**
	 * Initialise Developpeur office
	 * @param networkSocket_nb
	 * @param sectorSocket_nb
	 * @param phoneSocket_nb
	 * @param chairs_nb
	 * @param tables_nb
	 * @param person_nb
	 */
	public DevelopperOffice(int networkSocket_nb, int sectorSocket_nb,
			int phoneSocket_nb, int chairs_nb, int tables_nb) {
		super(networkSocket_nb, sectorSocket_nb, phoneSocket_nb, chairs_nb, tables_nb);
		
	}
	public void addPerson(int i) {
		super.addPerson(i);
		
	}
	// calcul free space in developper office
	public int freeSpace(){ 
    	return (int) (Person_nb - 3*networkSocket_nb+Person_nb-3*sectorSocket_nb+Person_nb-phoneSocket_nb+Person_nb-1.5*chairs_nb+Person_nb-tables_nb);
    }
	
}
