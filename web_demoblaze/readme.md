# Proyecto de Automatización con Serenity BDD, Gradle y Java 17

Este proyecto utiliza Serenity BDD junto con Cucumber y Gradle para la automatización de pruebas End-to-End (E2E). Las pruebas están desarrolladas en Java 17 y siguen el patrón de diseño Screenplay.

### Requisitos

- Java 17 
- Gradlew 
- Serenity BDD
- Cucumber

### Estructura del proyecto
El proyecto sigue la estructura de Screenplay.

```
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───consubanco
│   │   │           └───demoblaze
│   │   │               ├───questions
│   │   │               ├───tasks
│   │   │               └───userinterfaces
│   │   └───resources
│   └───test
│       ├───java
│       │   └───com
│       │       └───consubanco
│       │           └───demoblaze
│       │               ├───runners
│       │               └───stepdefinitions
│       └───resources
│           └───features
│           └───serenity.conf
```
src/main/java:
- questions: Aquí se encuentran las clases que representan preguntas o verificaciones realizadas durante la prueba.
- tasks: Contiene las tareas que los actores realizarán, como interactuar con la aplicación.
- userinterfaces: Define los elementos de la interfaz de usuario con los que los actores interactúan.

src/main/test:
- runners: Contiene las clases que configuran y ejecutan las pruebas, usando Cucumber.
- stepdefinitions: Define los pasos que vinculan los escenarios de Cucumber con las acciones del Screenplay.


### Configuración del Proyecto

1. Clona este repositorio:
```
    git clone <url-del-repositorio>
    cd web_demoblaze
```
2. Ejecución de Pruebas

Para ejecutar las pruebas de Cucumber con Serenity, utiliza el siguiente comando:
```
    ./gradlew clean test aggregate
```
Este comando generará un reporte en el directorio target/site/serenity/ una vez finalizadas las pruebas.

Instrucciones Especiales para las Pruebas E2E

En el escenario de Cucumber llamado Agregar productos al carrito con una cuenta nueva, el campo "usuario" debe cambiarse cada vez que se ejecute la prueba para evitar datos repetidos durante la ejecución. Por favor aumenta el contador del usuario cada vez que sea necesario.
```
    Ejemplos:
      | usuario      | clave | categoria | producto          |
      | comprador116 | 123   | Phones    | Samsung galaxy s6 |
```
Por ejemplo, si el escenario utiliza el campo "usuario" en el archivo .feature:

Scenario: Registrar un nuevo usuario
Given el usuario "nuevo_usuario_<timestamp>" intenta registrarse
...


Generación de Reportes

Después de ejecutar las pruebas, puedes visualizar los reportes de Serenity generados en la siguiente ruta:

#### web_demoblaze/target/site/serenity/index.html

Este reporte proporcionará un desglose detallado de los resultados de cada escenario ejecutado.

Comandos Adicionales

- Para limpiar los artefactos generados por Serenity:
  ./gradlew clean

Recursos

- Documentación oficial de Serenity BDD: https://serenity-bdd.github.io/theserenitybook/latest/index.html
- Documentación de Cucumber: https://cucumber.io/docs/guides/10-minute-tutorial/
- Documentación de Gradle: https://docs.gradle.org/
****