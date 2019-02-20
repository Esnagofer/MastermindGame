# Mastermind

## Git repo
https://github.com/Esnagofer/esnagofer-mastermind-game.git

## API Spec
Swagger SPEC: https://app.swaggerhub.com/apis/axiomadeeleccion/MasterMindCodeMaker/1.0.0-oas3

## Build & RUN
git clone https://github.com/Esnagofer/esnagofer-mastermind-game.git
cd esnagofer-mastermind-game
git checkout master
git pull
mvn install
java -jar target/esnagofer-mastermind-game-1.0.2.jar

## Try

### Create GameBoard

curl --request GET \
  --url http://localhost:8080/mastermind/api/codemaker/v1/gameboard \
  --header 'cache-control: no-cache'
  
Resultado:

{
    "value": "b8523cf8-28b2-4fd8-a124-86950c6870ac"
}

### TryToGuessSecretPattern

curl --request POST \
  --url http://localhost:8080/mastermind/api/codemaker/v1/gameboard/b8523cf8-28b2-4fd8-a124-86950c6870ac/try/guess/secret/pattern \
  --header 'Content-Type: application/json' \
  --header 'cache-control: no-cache' \
  --data '{\n	"codePegColor1": "RED",\n	"codePegColor2": "BLUE",\n	"codePegColor3": "BLACK",\n	"codePegColor4": "BROWN"\n}'

Resultado:

{
    "turnsLeft": 11,
    "guessLog": [
        "[[RED,BLUE,BLACK,BROWN] - [WHITE,WHITE,WHITE]]"
    ],
    "message": "Try again!",
    "keyPegs": [
        "WHITE",
        "WHITE",
        "WHITE"
    ]
}
  
  