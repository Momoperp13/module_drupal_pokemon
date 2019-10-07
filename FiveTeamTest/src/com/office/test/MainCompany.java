package com.office.test;

public class MainCompany {

	public static void main(String[] args) {
		Company company = new Company();
		Office[] offices = company.getOffices();
		// for example person number to recrut in this company is 30
		int person_numb = 30;
		int numb;
		while(person_numb > 0)
		{	
			//random on 5 because there are 5 office we recrut randomly persons
			numb = (int)(Math.random() * 5);
			if(offices[numb].freeSpace()>0)
				continue;
			if((offices[0].freeSpace()+offices[1].getPerson_nb()+ offices[2].getPerson_nb()+offices[3].getPerson_nb()+offices[4].getPerson_nb())>0)
				break;
			offices[numb].addPerson(1);
			System.out.println("Office free space : "+(offices[numb].freeSpace())*(-1));
			System.out.println("Developper numbers : "+(offices[0].getPerson_nb()+offices[1].getPerson_nb()));
			System.out.println("Commercial numbers : "+(offices[2].getPerson_nb()+offices[3].getPerson_nb()+offices[4].getPerson_nb()));
			System.out.println();
			person_numb--;
			
		}
		System.out.println("Total Office free space : "+(offices[0].freeSpace()+offices[1].getPerson_nb()+ offices[2].getPerson_nb()+offices[3].getPerson_nb()+offices[4].getPerson_nb())*(-1));
	}

}
