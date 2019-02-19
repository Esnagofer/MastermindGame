# Mastermind

Dado el alcance del proyecto se consensúa la no división en subdominios (supporting & generics): se define CORE que se implementará como único Bounded Context.

## Lenguaje ubícuo en CORE BC

**Code peg:**
Piezas de entre 6 colores (red, green, yellow, blue, brown, cyan, black). 

**Secret Pattern:**
Conjunto ordenado de 4 Code pegs que componen el código secreto a acertar.

**Guess Pattern:**
Conjunto ordenado de 4 Code pegs que componen intento de acertar el Pattern.

**Key peg:**
Piezas de entre 2 colores (blanco y negro) para indicar el tipo de resultado: blanco = coincidencia de color y negro = coincidencia de color y posición.

**Feedback:**
Compuesto de KeyPegs (max. 4), log de anteriores intentos, intentos restantes y mensaje explicativo resultado del intento.

**Game board:**
Contiene el código secreto.
Contiene 12 filas de 4 CodePegs para intentar acertar el código secreto y doce filas de 4 KeyPegs. 

**Code maker:**
Usuario que crea el Pattern a descubrir. 

**Code breaker:**
Usuario que intenta descubrir el Pattern.


**Operaciones**

- GameBoard tiene 12 filas para intentos GuessPattern y respectivos resultados 
- GameBoard contiene un SecretCode
- GameBoard se completa cuando se han agotado los 12 GuessPatterns o cuando GuessPattern = SecretCode
- Cuando un GameBoard se completa finaliza el juego
- CodeMaker genera un GameBoard a petición de CodeBreaker
- CodeMaker recibe petición tryToGuessPattern de CodeBreaker -> rellena entradas en GameBoard y devuelve Feedback
- CodeBreaker inicia un GameBoard
- CodeBreaker envía intentos GuessPattern a CodeMaker
