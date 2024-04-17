# Compte Rendu du TP 1 : Patrons de Conceptions

Noms des étudiants du binôme : MINTCHUENG KARELLE

## Exercices 1
 Le modèle reflète le Patron de conception Composite le 'MobileObject' agit en tant que Composant , qui définit une interface pour les objets dans la composition
le 'Vehicle' joue le rôle de composite car elle stocke des composants enfants(instances de 'MobileObject') et implémente l'interface 'MobileObject'.

La méthode 'getVelocity()' n'as plus besion d'être écrire à nouveau car la classe 'Vehicle' fournit déjà une implémentation qui calcule la vitesse comme une moyenne pondérée des vitesses de ses composants, ce qui est le comportement désiré pour 'TagAlongBike'
La methode 'getMasse()' n'a pas non plus besion d'être écrite car l'implémentation heritée de 'Vehicle' calcule déjà la masse en sommant les masses de tous les composants 


## Exercices 2

Le Patron de conception utilisé par  la méthode 'getVelocity()' de la classe 'Vehicle' utilise le patron de conception itérateur pour parcourir les composants d'un véhicule , un itérateur est une interface qui permet de parcourir une collection élement par élement , sans exposer les details de la collection sous-jacente.

Avantage du patron itérateur : Abstraction : l'itérateur cache la complexité de parcours de la structure de données sous-jacente.ce qui permet d'utiliser le même code pour parcourir différents types de collections sans se soucier de leur implémentation interne
Découplage : Il découple les algorithmes des structures de données sur lesquelles ils opèrent ce qui améliore la maintenance et la réutilisation du code.
Contrôle : il fournit un contrôle sur le processus de parcours , ce qui peut être utilise pour les opérations spécifiques comme l'insertion ou la suppression pendant l'itération

La modification de 'Set' à 'List' n'implique pas nécessairement une modification de la méthode 'getVelocity()' car les deux implémentations fournissent un itérateur via la méthode 'iterator()' utilisée dans la méthode actuelle.Cependant il est à noté que 
la 'List' maintient l'ordre des élements , tandis que 'Set' ne le fait pas 
## Exercices 3
Les étapes de la creation du singleton Clock sont les suivantes : 
-Modifier le constructeur de la classe 'Clock' pour le rendre privé ce qui empêche l'instanciation directe de la classe deouis l'extérieur et assure que la classe ne peut être instancié qu'à l'intérieur de celle-ci
-Ajouter une propriété privée dans la classe 'Clock' pour stocker l'inique instance de la classe .Cette instance est généralement initialisée directement lors de la déclaration ou plus tardivement dans la méthode statique 'getInstance()'
-Creer une méthode publique statique 'getInstance' qui retourne l'unique instance de la classe 
-Remplacer toutes les instanciations directes de la classe 'Clock' par des appels à 'Clock.getInstance' ce qui va nous permettre de garantir  que tous les composants utilisent la même instance pour l'horloge ce qui va permettre une synchronisation à travers toute l'application.
## Exercices 4

- Non 'Bike' et 'Wheel' n'appartiennent pas au même paquetages car 'bike' appartient au paquage Cycling et 'Wheel ' appartient au paquage transport
- La classe 'Wheel' depend de la classe 'Bike' pour obtenir la force de poussée via la méthode 'getPush()' il s'agit d'une méthode directe et bidirectionnelle car 'Bike' a des références à ses roues et 'Wheel' à une référence à 'Bike' il s'agit d'une mauvaise pratique car il s'agit d'une dépendance cyclique entre 'Bike' et 'Wheel'
ce qui crée un couplage fort entre les deux classes du fait que un changement dans l'une peut affecter directement l'autre , ce qui rend le système fragile et difficile à évoluer 
- 'Bike' est utilisée par 'Wheel' pour calculer la vitesse de la roue via la méthode 'getPush'
- Oui , il existe déjà une abstraction de la classe 'Bike' qui est la classe 'Vehicle'(puisque 'Bike' etend 'Vehicle').la méthode 'hetPush()' utilisée par 'Wheel' n'est pas astraite dans 'Vehicle', mais pourrait être ajoutée en tant que méthode abstraite à 'Vehicle' ou en tant qu'interface séparée
- L'abstraction 'Vehicle' se trouve dans le paquetage transport 
- Pour casser la dépendance cyclique , on pourrait introduire une interface ,par exemple 'PushProvider', qui aurait une méthode 'getPush()'.'Bike' implémenterait cette interface ensuite , 'Wheel' ne dépendrait plus de 'Bike' directement , mais plutôt de l'interface 'PushProvider'


## Exercices 5


## Exercices 6
La différence entre la méthode de fabrique (Factory method) et le singleton est le suivant :
- Singleton : assurequ'une classe n'a qu'une seule instance et fournit un point d'accès global à cette instance ce qui est utile pour les ressources  qui doivent petre partagées, comme 
une horloge
- La méthode fabriqueb: permet de creer des objets sans spécifier la classe exacte de l'objet qui ser crée ce qui permet de centraliser la logique de création des instances, offrant ainsi plus de flexibilité pour changer le type d'objets
crées sans changer le code qui utilise ces objets.

## Exercices 7

## Exercices 8
-Le Patron de conception de la classe context avec ServiceLoader suit le patron de conception FACADE car en encapsulant la complexité de 'ServiceLoader' derrière une interface simplifiée, 'context' rend l'utilisation des services plus accessible et plus 
simple pour les utilisateurs.Ce qui va permettre de centraliser la création et la gestion des instances , facilitant ainsi la maintenance et l'évolution de l'application.
-Oui nous pouvons avoir plusiers lignes dans le fichier de services "fr.polytech.sim.cycling.Bike".Chaque ligne dans ce fichier va correspondre à une implémentation différente du type de service spécifié.'ServiceLoader' les utilisera pour charger toutes les implémentationsdisponibles du service
l'utilisation de 'injectAll' va permettre d'itéree sur toutes les instances disponibles pour le type de service demandé 
## Exercices 9
-La méthode "injectAll()" de la classe 'context' retourne un 'Iterator', ce qui correspondant  au patron de conception Iterateur.Ce patron permet d'accéder séquentiellement aux élements d'une collection sans exposer ses représentations sous-jacentes.Elle va fournir une façon standard de parcourir des collectionsnet est utilisé dans la bibliothèque standard java pour parcourir tout objet implémentant l'interface 'Iterable'
