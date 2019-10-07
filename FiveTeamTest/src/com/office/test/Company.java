package com.office.test;

public class Company {

	private Office[] offices;

	/**
	 * Initialise a company
	 */
	public Company() {
		offices = new Office[5];
		this.init();
	}

	private void init() {
		for(int i=0; i<5; i++){
			if(i<2){
				offices[i] = new DevelopperOffice(5, 5,
						5, 5, 5);
			}
			else{
				offices[i] = new BusinessOffice(3, 3,
						3, 3, 3);
			}
		}
	}

	public Office[] getOffices() {
		return offices;
	}

	public void setOffices(Office[] company) {
		this.offices = company;
	}
	
}
