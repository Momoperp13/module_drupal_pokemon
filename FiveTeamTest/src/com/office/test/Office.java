package com.office.test;

public class Office {

	protected int networkSocket_nb;
    protected int sectorSocket_nb;
    protected int phoneSocket_nb;
    protected int chairs_nb;
    protected int tables_nb;
    protected int Person_nb = 0;
    /**
     * Initialise office 
     * @param networkSocket_nb: nombre de prises de réseau
     * @param sectorSocket_nb : nombre de prise de secteur
     * @param phoneSocket_nb : nombre de prises de téléphone
     * @param chairs_nb : nombre de chaises
     * @param tables_nb : nombre de tables
     */
    public Office(int networkSocket_nb, int sectorSocket_nb,
			int phoneSocket_nb, int chairs_nb, int tables_nb) {
		this.networkSocket_nb = networkSocket_nb;
		this.sectorSocket_nb = sectorSocket_nb;
		this.phoneSocket_nb = phoneSocket_nb;
		this.chairs_nb = chairs_nb;
		this.tables_nb = tables_nb;
		
	}
    
    public int getPerson_nb() {
		return Person_nb;
	}

	public void setPerson_nb(int person_nb) {
		this.Person_nb = person_nb;
	}
	

	public int getNetworkSocket_nb() {
		return networkSocket_nb;
	}

	public void setNetworkSocket_nb(int networkSocket_nb) {
		this.networkSocket_nb = networkSocket_nb;
	}

	public int getSectorSocket_nb() {
		return sectorSocket_nb;
	}

	public void setSectorSocket_nb(int sectorSocket_nb) {
		this.sectorSocket_nb = sectorSocket_nb;
	}

	public int getPhoneSocket_nb() {
		return phoneSocket_nb;
	}

	public void setPhoneSocket_nb(int phoneSocket_nb) {
		this.phoneSocket_nb = phoneSocket_nb;
	}

	public int getChairs_nb() {
		return chairs_nb;
	}

	public void setChairs_nb(int chairs_nb) {
		this.chairs_nb = chairs_nb;
	}

	public int getTables_nb() {
		return tables_nb;
	}

	public void setTables_nb(int tables_nb) {
		this.tables_nb = tables_nb;
	}

	// calcul free space in office
    public int freeSpace(){
    	return (Person_nb - networkSocket_nb+Person_nb-sectorSocket_nb+Person_nb-phoneSocket_nb+Person_nb-chairs_nb+Person_nb-tables_nb);
    }

	public void addPerson(int i) {
		this.Person_nb+=i;
		
	}
}
