<?php


class DevelopperOffice extends Office 
{
    function __construct($networkSocket_nb, $sectorSocket_nb, $phoneSocket_nb, $chairs_nb, $tables_nb){
        parent:: __construct($networkSocket_nb, $sectorSocket_nb, $phoneSocket_nb, $chairs_nb, $tables_nb);
    }
    // calcul free space in Developer office
    public function freeSpace(){
        return (int) ($this->Person_nb - 3*$this->networkSocket_nb+$this->Person_nb-3*$this->sectorSocket_nb+$this->Person_nb-$this->phoneSocket_nb+$this->Person_nb-1.5*$this->chairs_nb+$this->Person_nb-$this->tables_nb);
    }
}