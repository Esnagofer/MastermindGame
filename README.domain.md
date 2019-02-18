# Mastermind

Dado el alcance del proyecto se consensúa la no división en subdominios (supporting & generics): se define CORE que se implementará como único Bounded Context.

## Lenguaje ubícuo en CORE

**Code peg**

Piezas de entre 6 colores (red, green, yellow, blue, brown, cyan, black). 

**Secret Pattern**

Conjunto ordenado de 4 Code pegs que componen el código secreto a acertar.

**Guess**

Conjunto ordenado de 4 Code pegs que componen intento de acertar el Pattern.

**Key peg**

Piezas de entre 2 colores (blanco y negro) para indicar el tipo de resultado: blanco = coincidencia de color y negro = coincidencia de color y posición.

**Feedback**

Conjunto de Key pegs indicando el resultado completo de un Guess.

**Game board**

Contiene el código secreto.
Contiene 12 files (de 4 colores) para intentar acertar el código secreto.

**Code maker**

Usuario que crea el Pattern a descubrir. 

**Code breaker**

Usuario que intenta descubrir el Pattern.


 - The Code Maker creates a Game and assign it to a Code Breaker user
 - The Code Maker returns Feedback to a Guess sent by Code Breaker that tries to guess the Pattern.
 - The Game shows his state to Code Breaker.
