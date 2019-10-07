<?php


class Office
{
    protected $networkSocket_nb;
    protected $sectorSocket_nb;
    protected $phoneSocket_nb;
    protected $chairs_nb;
    protected $tables_nb;
    protected $Person_nb;
    /**
     * Initialise Office
     */
    function __construct($networkSocket_nb, $sectorSocket_nb, $phoneSocket_nb, $chairs_nb, $tables_nb){
        $this->networkSocket_nb = $networkSocket_nb;
        $this->sectorSocket_nb = $sectorSocket_nb;
        $this->phoneSocket_nb = $phoneSocket_nb;
        $this->chairs_nb= $chairs_nb;
        $this->tables_nb = $tables_nb;
    }
    
    public function getPerson_nb() {
		return $this->Person_nb;
	}

	public function setPerson_nb($person_nb) {
		$$this->Person_nb = $person_nb;
	}
	

	public function getNetworkSocket_nb() {
		return $networkSocket_nb;
	}

	public function setNetworkSocket_nb($networkSocket_nb) {
		$$this->networkSocket_nb = $networkSocket_nb;
	}

	public function getSectorSocket_nb() {
		return $sectorSocket_nb;
	}

	public function setSectorSocket_nb($sectorSocket_nb) {
		$$this->sectorSocket_nb = $sectorSocket_nb;
	}

	public function getPhoneSocket_nb() {
		return $phoneSocket_nb;
	}

	public function setPhoneSocket_nb($phoneSocket_nb) {
		$this->$phoneSocket_nb = $phoneSocket_nb;
	}

	public function getChairs_nb() {
		return $chairs_nb;
	}

	public function setChairs_nb($chairs_nb) {
		$this->chairs_nb = $chairs_nb;
	}

	public function getTables_nb() {
		return $tables_nb;
	}

	public function setTables_nb($tables_nb) {
		$this->tables_nb = $tables_nb;
	}
    // calcul free space in office
    public function freeSpace(){
        return ($this->Person_nb - $this->networkSocket_nb+$this->Person_nb-$this->sectorSocket_nb+$this->Person_nb-$this->phoneSocket_nb+$this->Person_nb-$this->chairs_nb+$this->Person_nb-$this->tables_nb);
    }
    public function addPerson($i) {
		$this->Person_nb+=$i;
		
	}
}