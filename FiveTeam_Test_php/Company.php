<?php
require "Office.php";
require "DevelopperOffice.php";
require "BusinessOffice.php";

class Company 
{  
    private $office = array();

    function __construct(){
		$this->init();
    }
    private function init() {
		for($i =0; $i<5; $i++){
            if($i<2){
                $this->office[$i] = new DevelopperOffice(5, 5,
                5, 5, 5);
            }
            $this->office[$i] = new BusinessOffice(3, 3,
            3, 3, 3);
        }
    }
    

    public function getOffices(){
		return $this->office;
	}
  
	public function setOffices($company) {
		$this->office = $company;
	}
}