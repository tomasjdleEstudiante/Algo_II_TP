
# Trabajo Practico AyP II : Heroes vs Villanos

En este trabajo practico modelamos un juego de Heroes 
contra Villanos en el que los jugadores y ligas de 
jugadores se enfrentan entre si a traves de las 
siguientes caracteristicas: Velocidad, Fuerza, 
Resistencia y Destreza.

## Integrantes del grupo

- [Carlos Fernández](https://github.com/Pizzaconmigo1)
- [Yamil Vernet](https://github.com/yamilvernet)
- [Christian Maldonado](https://github.com/ChristianMaldonado7)
- [Tomás Di Leo](https://github.com/TomasDiLeo)


## Decisiones de diseño

Primero nos decidimos por un patron de diseño de 
Composite por las siguientes razones:

- Los jugadores y las ligas tienen un comportamiento similar
- Las ligas puedes contener tanto jugadores como otras ligas
- Un jugador se puede enfrentar a una liga

Por estas rezones es importante que tanto la liga como el 
personaje cuenten con metodos que cumplen las siguientes 
dos funciones:

- Conseguir el valor de la caracteristica del competidor
- Verificar si es ganador contra otro competidor

Dado el patron composite elegimos una clase abstracta
como base de las clases Player (Jugador) y League (Liga)
porque los jugadores y las ligas tienen atributos en 
comun:

- un nombre
- un booleano que dice si ya pertenece a una liga 
- una alineacion

El atributo booleano es nuestra respuesta a la condicion
de la liga de solo agregar competidores que no esten
en otra liga.

El atributo de alineacion nos permite saber si es un Heroe
o un villano sin tener que hacer clases separadas y
comprobar que intancia es cada una.

Las caracteristicas las decidimos poner en un HashMap
para la clase player, nos facilita buscar el valor de
cada caracteristica (clave) solo basta con llamar al get
y pasarle la caracteristica que queremos obtener. Si
hicieramos un int por cada caracteristica tendriamos
que usar if's y al final no queda tan elegante como 
con un HashMap.

Elegimos un enum para las caracteristicas, es facil 
implementar un metodo para obtener el siguiente enum
y esto nos sirve para recorrer las caracteristicas al
verificar el ganador.

Luego para la clase League decidimos calcular el 
valor de cada caracteristica usando el valor de sus 
integrantes, pareceria que la mejor opcion es guardar
las caracteristicas en un HashMap cada vez que se une
un competidor y luego devolver el promedio, pero si 
hacemos eso es imposible agregar otro competidor a una
liga que ya este adentro de otra porque aunque las 
caracteristicas de la liga contenida cambien no hay 
forma de actualizar el valor de las caracteristicas de
la liga contenedora.






## Explicacion de cada archivo *.java
### Excepciones
- CompetitorInLeagueException
Se usa cuando al intentar meter un competidor en una liga y este
competidor ya esta en una liga
- DifferentAlignmentException
Se usa cuando al intentar meter un competidor en una liga y este
competidor no pertenece al alineamiento de la liga
- NoAlignmentException
Se usa cuando al intentar meter un competidor en una liga y este
competidor no pertenece a ningun alineamiento
- SameAlignmentException
Se usa cuando al intentar hacer competir un competidor con otro y estos
competidores pertenecen a la misma liga
### Funcionamiento interno
- Alignment
Un enum con los alineamientos HERO, VILLAIN
- Trait
Un enum con las caracteristicas SPEED, STRENGTH, STAMINA y DEXTERITY, y
un metodo para obtener su siguiente
- Competitor
Esta clase abstracta modela un objeto que puede competir, tiene su 
alineamiento, su nombre y sabe si esta o no en una liga. Puede competir
con otro competidor y puede decir el valor de sus caracteristicas.
- Player 
Es un competitor que guarda sus caracteristicas y su nombre real. Puede
decir el valor de sus caracteristicas. 
- League
Es un competitor que ademas es un grupo de competitors, tiene una lista
con sus integrantes. Puede agregar un competitor que no este ya en una
liga y que sea del mismo Alignment y puede decir el valor de sus 
caracteristicas calculando el promedio de valores de sus integrantes. 
- TraitComparator
Es un comparator que me permite ordenar los competitors en base a una
lista que dicta el orden de las caracteristicas a comparar. 
Si es ascending ordena de menor a mayor y sino ordena de mayor a menor
