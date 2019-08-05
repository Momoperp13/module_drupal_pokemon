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
      
      //verification de l'id
      $idver = (int)($page);
      if($idver <1 || $idver > 97){
          return [
            '#markup'=> $this->t('Veuillez entrer un chiffre entre 1 et 97 svp ')
          ];
        }
      $pokemon_model = new PokemonModel();   
      $pokemons_type = $pokemon_model->get_type();
      if(isset($_POST['recherPokemon'])){
        $type_id = $_POST['typePokemon'];
        $name_id = $_POST['nomPokemon'];
        setcookie('type_id', $type_id, time()+1800);
        setcookie('name_id', $name_id,  time()+1800);

      }else{
        $type_id = $_COOKIE['type_id'];
         $name_id = $_COOKIE['name_id'];
      }
      if ($type_id == '' && $name_id != ''){
        $pok = $pokemon_model->get_pokemon_list_by_name();
        foreach($pok as $p){
          $pos = strpos($p['name'], $name_id);
          if($pos !== false){
            $pokemons_by_type[] = array($key=>$p);
          }
        }  
      }
      elseif($type_id !=''  && $name_id == ''){
        $pokemons_by_type = $pokemon_model->get_pokemon_list_by_type($type_id+1);
        
      }
      
      elseif($type_id != '' && $name_id != ''){
        $pok = $pokemon_model->get_pokemon_list_by_type($type_id+1);
        foreach($pok as $p){
          foreach($p as $pp){
            $pos2 = strpos($pp['name'], $name_id);
            if($pos2 !== false){
              $pokemons_by_type[] = $p;
            }
         }
        }  
      }
      $nbr_pokemon = count($pokemons_by_type);
        for($i = 1; $i<=$nbr_pokemon; $i++)
          $pages[] = $i;
        
        //pagination
        $k = (int)($page)-1;
            $j = ((String)($k).'0');
            $debut = (int)($j);
        $pokemons_by_type_by_page = array_slice($pokemons_by_type, $debut, 10);
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