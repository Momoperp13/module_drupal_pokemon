<?php


class BusinessOffice extends Office 
{
    function __construct($networkSocket_nb, $sectorSocket_nb, $phoneSocket_nb, $chairs_nb, $tables_nb){
        parent:: __construct($networkSocket_nb, $sectorSocket_nb, $phoneSocket_nb, $chairs_nb, $tables_nb);
    }
    // calcul free space in Business office
    public function freeSpace(){
        return  ($this->Person_nb - $this->networkSocket_nb+$this->Person_nb-$this->sectorSocket_nb+$this->Person_nb-2*$this->phoneSocket_nb+$this->Person_nb-2*$this->chairs_nb+$this->Person_nb-$this->tables_nb);
    }
}