<?php
namespace Drupal\pokemon\Model;
/**
 * Model pokemon
 */
class PokemonModel{

    //private $url;
    private $pokemon_list_name;
    private $pokemon_list_type;
    private $url_pokemons;
    private $url_type;
    private $pokemon_by_page;

    public function __construct(){
        $this->url_pokemons = "https://pokeapi.co/api/v2/pokemon/?offset=0&limit=964";
        $this->url_type = "https://pokeapi.co/api/v2/type";
        $this->pokemon_list_name = $this->connect_poke_api($this->url_pokemons);
        $this->pokemon_list_type = $this->connect_poke_api($this->url_type);
        
    }
    /**
     * Consomation de l'api
     */
    private function connect_poke_api($url){
        
        $curl = curl_init();
        curl_setopt_array($curl, array(
        CURLOPT_URL => $url,
        CURLOPT_RETURNTRANSFER => true,
        CURLOPT_ENCODING => "",
        CURLOPT_MAXREDIRS => 10,
        CURLOPT_TIMEOUT => 30,
        CURLOPT_HTTP_VERSION => CURL_HTTP_VERSION_1_1,
        CURLOPT_CUSTOMREQUEST => "GET",
        CURLOPT_POSTFIELDS => "",
        CURLOPT_SSL_VERIFYPEER => false,
        ));

        $response = curl_exec($curl);
        $err = curl_error($curl);

        curl_close($curl);

        if ($err) {
            echo "cURL Error #:" . $err;
        } else {
            $pokemons = json_decode($response, true);
        }
        if($url == $this->url_type ||$url == $this->url_pokemons)
            return $pokemons['results'];
        return $pokemons;
    }
    /**
     * Retourner la liste des noms des pokemones
     */
    public function get_pokemon_list_by_name(){
        return $this->pokemon_list_name;
    }
    public function get_type(){
        return $this->pokemon_list_type;
    }
    public function get_pokemon_list_by_type($type_id){
        $type = $this->connect_poke_api("https://pokeapi.co/api/v2/type/$type_id");
        $value = array_values($type);
        return $value[8];
    }
    public function get_pokemon_list_by_name_by_page($id){
            $k = (int)$id-1;
            $j = ((String)($k).'0');
            $debut = (int)($j);
            $this->$pokemon_by_page = array_slice($this->pokemon_list_name, $debut, 10);
        return $this->pokemon_by_page;
    }
    public function get_character_pokemon($key){
        $character = $this->connect_poke_api("https://pokeapi.co/api/v2/pokemon/$key");
        return $character;
    }
}