
    <?php
        require "Company.php";
        $company = new Company;
        $offices = $company->getOffices();
        $person_numb = 30;
        while($person_numb > 0)
		{	
			//random on 5 because there are 5 office we recrut randomly persons
            $numb = (int)(rand(0,4));
			if($offices[$numb]->freeSpace()>0)
				continue;
			if(($offices[0]->freeSpace()+$offices[1]->getPerson_nb()+ $offices[2]->getPerson_nb()+$offices[3]->getPerson_nb()+$offices[4]->getPerson_nb())>0)
                break;
            $offices[$numb]->addPerson(1);
            echo "<h1>This company  : </h1>
                   <ul>
                        <li>Office free space : ".($offices[$numb]->freeSpace()*(-1))."</li>
                        <li>Developper numbers : ".($offices[0]->getPerson_nb()+$offices[1]->getPerson_nb())."</li>
                        <li>Commercial numbers : ".($offices[2]->getPerson_nb()+$offices[3]->getPerson_nb()+$offices[4]->getPerson_nb())."</li>
                    </ul></br>"; 
        }
        echo "<h1>Total Office free space :".($offices[0]->freeSpace()*(-1)+$offices[1]->freeSpace()*(-1)+$offices[2]->freeSpace()*(-1)+$offices[3]->freeSpace()*(-1)+$offices[4]->freeSpace()*(-1))." </h1>";
    ?>
