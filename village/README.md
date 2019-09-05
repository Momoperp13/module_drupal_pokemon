https://bitbucket.org/HanaZerari18/village

## Fonctionnalités

- site public
    - page d'accueil statique
    - catalogue des hébergements 
    - formulaire de réservation avec paiement (paiement inactif juste pour exemple, mais on pourrait simplement intégrer un paiement PayPal)
    - contact

- administration (simple CRUD)
    - catalogue : gestion du catalogue d'hébergements
    - clients/utilisateurs : gestion des utilisateurs (administrateurs ou clients)
    - réservations : gestion des réservations

## Architecture

- base de données relationnelle "village" (le script de création est dans createdb.sql) - nous avons choisi le SGBDR open source PostgreSQL (sur macos, l'application Postgres.app)
   - table catalogue
   - table reservations
   - table users
   - table password_resets
- application web
    - PHP 5.6, Laravel
    - HTML
    - CSS
    - Bootstrap 3
    - AdminLTE

## Frameworks

### Laravel  (https://laravel.com/)

Le framework PHP Laravel 5.4 a été choisi pour sa simplicité et sa modernité.

### Bootstrap

Fournit un socle et des composants CSS pour une application responsive et ergonomique.

## Configuration

Le fichier .env contient une partie de la configuration de l'application :
En l'occurence, son nom Village, l'environnement sélectionné (local ou production), une clé de sécurité, le niveau de log et l'URL de base

    APP_NAME=Village
    APP_ENV=local
    APP_KEY=base64:A/JMZooPz84Zu+Ts0gCt6mLBMdINaRGdAP8RnTjTRRU=
    APP_DEBUG=true
    APP_LOG_LEVEL=debug
    APP_URL=http://localhost
   
La configuration de l'accès à la base de données :
Ici, on sélectionne le driver "pgsql" pour accéder à PostgreSQL (il faut que l'extension PHP pgsql soit activée), le serveur et le port (localhost:5432), le nom de la base de données, l'utilisateur et le mot de passe.

    DB_CONNECTION=pgsql
    DB_HOST=127.0.0.1
    DB_PORT=5432
    DB_DATABASE=village
    DB_USERNAME=postgres
    DB_PASSWORD=postgres
 
Dans le dossier config/, d'autres fichiers de configuration sont disponibles pour une configuration avancée. 
 
## Routes (https://laravel.com/docs/5.4/routing)

Les routes de l'application web sont définies dans routes/web.php :

    GET /home
    GET /catalogue-public : catalogue public
    GET /reserver : le formulaire de réservation
    POST /reserver : crée la réservation

    GET /admin
    GET+POST /clients
    GET+POST /catalogue
    GET+POST /reservations

## Contrôleurs (https://laravel.com/docs/5.4/controllers)

Les contrôleurs sont des classes définies dans App\Http\Controllers (elles étendent notre classe Controller qui étend BaseController fournie par Laravel)
(Les contrôleurs de l'admin étendent AdminBaseController)

## Vues (https://laravel.com/docs/5.4/views)

Les vues sont écrites avec le moteur de template Blade de Laravel, et sont situées dans resources/views.
Les "layouts" définissent la structure des pages (header, footer, menu, etc.) et des sections nommées (@section)qui seront remplies par les différentes vues.
Chaque vue peut étendre un layout particulier grâce à la directive @extends qui permet de sélectionner le layout.
Dans notre cas, nous avons un layout "public" pour la partie publique du site basée simplement sur Bootstrap 3 et un layout "app" pour l'administration basé sur le template AdminLTE (https://adminlte.io/themes/AdminLTE)

Ex.

    return view('public.reserver')->with('catalogues', $catalogues);

## Models (https://laravel.com/docs/5.4/eloquent)

Nos modèles sont dans App\Models et étendent la classe Model de l'ORM Eloquent.
L'ORM (object-relational mapping) permet de manipuler les tables de la base relationnelle avec des objets PHP (chaque table est un classe Eloquent).

## Sécurité

Le modèle User représente un utilisateur de l'application. Il étend la classe User fournie par Laravel pour une gestion de la sécurité.

App/Providers/AuthServiceProvider.php contient le système d'autorisations.

Laravel fournit aux Controllers une méthode "middleware" qui peut prendre "auth" en argument afin de demander à l'utilisateur de s'authentifier.

Laravel fournit aussi aux Controllers une méthode "authorize" qui permet de restreinte les actions à certains utilisateurs grâce à un système de politiques de sécurité.
Ici, nous avons simplement défini et utilisé une politique "admin" qui autorise l'accès à l'administration seulement aux utilisateurs qui ont le booléen admin == true.

*** 

<p align="center"><img src="https://laravel.com/assets/img/components/logo-laravel.svg"></p>

<p align="center">
<a href="https://travis-ci.org/laravel/framework"><img src="https://travis-ci.org/laravel/framework.svg" alt="Build Status"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://poser.pugx.org/laravel/framework/d/total.svg" alt="Total Downloads"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://poser.pugx.org/laravel/framework/v/stable.svg" alt="Latest Stable Version"></a>
<a href="https://packagist.org/packages/laravel/framework"><img src="https://poser.pugx.org/laravel/framework/license.svg" alt="License"></a>
</p>

## About Laravel

Laravel is a web application framework with expressive, elegant syntax. We believe development must be an enjoyable and creative experience to be truly fulfilling. Laravel attempts to take the pain out of development by easing common tasks used in the majority of web projects, such as:

- [Simple, fast routing engine](https://laravel.com/docs/routing).
- [Powerful dependency injection container](https://laravel.com/docs/container).
- Multiple back-ends for [session](https://laravel.com/docs/session) and [cache](https://laravel.com/docs/cache) storage.
- Expressive, intuitive [database ORM](https://laravel.com/docs/eloquent).
- Database agnostic [schema migrations](https://laravel.com/docs/migrations).
- [Robust background job processing](https://laravel.com/docs/queues).
- [Real-time event broadcasting](https://laravel.com/docs/broadcasting).

Laravel is accessible, yet powerful, providing tools needed for large, robust applications. A superb combination of simplicity, elegance, and innovation give you tools you need to build any application with which you are tasked.

## Learning Laravel

Laravel has the most extensive and thorough documentation and video tutorial library of any modern web application framework. The [Laravel documentation](https://laravel.com/docs) is thorough, complete, and makes it a breeze to get started learning the framework.

If you're not in the mood to read, [Laracasts](https://laracasts.com) contains over 900 video tutorials on a range of topics including Laravel, modern PHP, unit testing, JavaScript, and more. Boost the skill level of yourself and your entire team by digging into our comprehensive video library.

## Laravel Sponsors

We would like to extend our thanks to the following sponsors for helping fund on-going Laravel development. If you are interested in becoming a sponsor, please visit the Laravel [Patreon page](http://patreon.com/taylorotwell):

- **[Vehikl](http://vehikl.com)**
- **[Tighten Co.](https://tighten.co)**
- **[British Software Development](https://www.britishsoftware.co)**
- **[Styde](https://styde.net)**
- [Fragrantica](https://www.fragrantica.com)
- [SOFTonSOFA](https://softonsofa.com/)

## Contributing

Thank you for considering contributing to the Laravel framework! The contribution guide can be found in the [Laravel documentation](http://laravel.com/docs/contributions).

## Security Vulnerabilities

If you discover a security vulnerability within Laravel, please send an e-mail to Taylor Otwell at taylor@laravel.com. All security vulnerabilities will be promptly addressed.

## License

The Laravel framework is open-sourced software licensed under the [MIT license](http://opensource.org/licenses/MIT).
