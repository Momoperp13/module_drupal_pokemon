<?php

namespace Drupal\pokemon\Routing;

use Symfony\Component\Routing\Route;

/**
 * Définir les routes dynamiques.
 */
class PokemonRoutes {

  /**
   * {@inheritdoc}
   */
  public function routes() {
    $routes = [];
    $routes = [
            'pokemon.list' => new Route(
            '/pokemon-list',
            [
              '_controller' => '\Drupal\pokemon\Controller\PokemonController::pokemon_list',
              '_title' => 'Pokemon list'
            ],
            [
              '_permission'  => 'access content',
            ]
            ),
            'pokemon.home' => new Route(
              '/pokemon-list/{page}',
              [
                '_controller' => '\Drupal\pokemon\Controller\PokemonController::pokemon_list',
                '_title' => 'Pokemon list'
              ],
              [
                '_permission'  => 'access content',
              ]
              ),
            
            'pokemon.show' => new Route(
            '/pokemon-list/pokemon-show/{name}',
            [
              '_controller' => '\Drupal\pokemon\Controller\PokemonController::pokemon_show',
              '_title' => 'Pokemon show'
            ],
            [
              '_permission'  => 'access content',
            ]
            ),
    ];
  return $routes;
  }

}