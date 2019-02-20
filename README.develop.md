#MASTERMIND


## DISCLAIMER

No dispongo del tiempo personal suficiente para implementar la práctica tal como me gustaría.
Hay varios aspectos implementados que deberían estar sujetos a refactor/mejora.


## KNOUNW ISSUES

1.  Noy hay logs: se debe implementar un INTERCEPTOR/AOP (en infrastructure) para logar a SYS lo relevante.
2.  Se debe mejorar la cobertura de TESTS (estamos en un 79%).
3.  El espacio actual para COMMENTS debe redactarse acorde a lo implementado (ahora hay comments automáticos generados por el IDE).
4.  Hay algunos aspectos del MODELO (CodeMakerFeedbackData vs GameBoardGuessLogItem por ejemplo) a refactorizar.
5.  La implementación del fuente debería segmentarse en diferentes proyectos indempendientes para asegurar la consistencia en las dependencias de los mismos:

Domain --> NO debe tener dependencias
Application --> Depende de DOMAIN
Infrastructure --> Depende de DOMAIN & APPLICATION

Esto aplica a los 3 proyectos LIB (Application, Model, Infrastructure)

Esto significa que tendríamos 1 repositorio de fuente con los 3 proyectos maven de MASTERMIND (Application, Domain, Infrastructure).

Los 3 quedarían coregidos bajo un POM padre multimódulo con el que compilar todo el proyecto.

Los repositorios para LIB se puede valorar si deben tener un repo independiente o uno para los 3.

6.  Generar una imagen DOCKER para correr el servicio.
