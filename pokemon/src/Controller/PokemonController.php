<?php
/**
* @file
* Contains \Drupal\pokemon\Controller\PokemonController.
*/
namespace Drupal\pokemon\Controller;
use Drupal\Core\Controller\ControllerBase;
use Drupal\pokemon\Model\PokemonModel;

/**
 * Controller du module pokemon
 */
class PokemonController extends ControllerBase{

    private $pokemon_model;
    
    /**
     * page home
     */
    public function pokemon_list($page = 1){
      $pokemons_by_type = [];
      if(!(empty($_COOKIE['pokemons_by_type']))){
        $pokemons_by_type = $_COOKIE['pokemons_by_type_searched'];
      }
      //verification de l'id
      /*$idver = (int)($id);
      if($idver <1 || $idver > 97)
          return 'entrer la valeur exacte de la page';*/
      $pokemon_model = new PokemonModel();   
      //$pokemons_name = $pokemon_model->get_pokemon_list_by_name();
      $pokemons_type = $pokemon_model->get_type();
      if(isset($_POST['recherPokemon'])){
        $type_id = $_POST['typePokemon'];
        $name_id = $post['nomPokemon'];
        if ($type_id == NULL){
          $pok = $pokemon_model->get_pokemon_list_by_name();
          
        }
        else{
          $pok = $pokemon_model->get_pokemon_list_by_type($type_id+1);
          
        }
        foreach($pok as $p){
          if(strpos($p['name'], $name_id)){
            $pokemons_by_type[] = $p;
          }
        }  
        setcookie("pokemons_by_type_searched", $pokemons_by_type);
      }
      $nbr_pokemon = count($pokemons_by_type);
        for($i =1; $i<=$nbr_pokemon; $i++)
          $pages[] = $i;
        
        //pagination
        $k = (int)($page)-1;
            $j = ((String)($k).'0');
            $debut = (int)($j);
        $pokemons_by_type_by_page = array_slice($pokemons_by_type, $debut, 10);
      //$pokemons_name_by_page = $pokemon_model->get_pokemon_list_by_name_by_page($id);
      $output = array();
      $output= [
          '#pokemons_type'=> $pokemons_type, 
          '#pokemons_by_type_by_page' => $pokemons_by_type_by_page,
          '#theme' => 'pokemon_list', 
          '#pages'=> $pages,
      ];
      return  $output;
      }
      /**
       * page caractéristique d'un pokemon
       */
    public function pokemon_show($name = 'bulbasor'){
      $pokemon_model = new PokemonModel();
      $pokemons_name = $pokemon_model->get_pokemon_list_by_name();
      $value = array();
      foreach($pokemons_name as $pokemon_name)
        $value[] = $pokemon_name['name'];
      
      $key = array_search($name, $value)+1;
      $caracteristique = $pokemon_model->get_character_pokemon($key);
      $output = array();
      $output= [
          '#key' => $key,
          '#caracteristique' => $caracteristique,
          '#theme' => 'pokemon_show', 
      ];
      return  $output;
      }
}
?>