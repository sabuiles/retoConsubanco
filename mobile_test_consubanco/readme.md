# Proyecto de Automatización con Serenity BDD, Gradle y Java 17

Este proyecto utiliza Serenity BDD junto con Cucumber y Gradle para la automatización de pruebas End-to-End (E2E). Las pruebas están desarrolladas en Java 17 y siguen el patrón de diseño Screenplay.

### Requisitos

- Java 17
- Gradlew
- Serenity BDD
- Cucumber
- Appium 2
- Android Studio

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
│   │   │               ├───userinterfaces
│   │   │               └───interactions
│   │   └───resources
│   └───test
│       ├───java
│       │   └───com
│       │       └───consubanco
│       │           └───demoblaze
│       │               ├───runners
│       │               └───stepdefinitions
│       └───resources
│           ├───features
│           └───apk
├───serenity.properties
```
src/main/java:
- questions: Aquí se encuentran las clases que representan preguntas o verificaciones realizadas durante la prueba.
- tasks: Contiene las tareas que los actores realizarán, como interactuar con la aplicación.
- userinterfaces: Define los elementos de la interfaz de usuario con los que los actores interactúan.
- interactions: Contiene las interacciones que son reutilizables a nivel de acciones.
src/main/test:
- runners: Contiene las clases que configuran y ejecutan las pruebas, usando Cucumber.
- stepdefinitions: Define los pasos que vinculan los escenarios de Cucumber con las acciones del Screenplay.


### Configuración del Proyecto
1. Configura un emulador con Android Studio
2. Ejecuta el servicio de appium
1. Clona este repositorio:
```
    git clone <url-del-repositorio>
    cd web_demoblaze
```
4. En el archivo serenity.properties reemplaza los valores del dispositivo emulado y appium
```
appium.hub = http://localhost:4723/
appium.platformVersion = "14"
appium.deviceName  = "Pixel 8 Pro"
appium.app = ${user.dir}\\src\\test\\resources\\promotor_consubanco.apk
```

#### Nota: La apk debe ser agregada en la carpeta de src/test/resources y renombrada en el properties en caso de ser necesario.
5. Ejecución de Pruebas

Para ejecutar las pruebas de Cucumber con Serenity, utiliza el siguiente comando:
```
    ./gradlew clean test aggregate
```
Este comando generará un reporte en el directorio target/site/serenity/ una vez finalizadas las pruebas.

Generación de Reportes

Después de ejecutar las pruebas, puedes visualizar los reportes de Serenity generados en la siguiente ruta:

#### mobile_test_consubanco/target/site/serenity/index.html

Este reporte proporcionará un desglose detallado de los resultados de cada escenario ejecutado.

Comandos Adicionales

- Para limpiar los artefactos generados por Serenity:
  ./gradlew clean

Recursos

- Documentación oficial de Serenity BDD: https://serenity-bdd.github.io/theserenitybook/latest/index.html
- Documentación de Cucumber: https://cucumber.io/docs/guides/10-minute-tutorial/
- Documentación de Gradle: https://docs.gradle.org/
- Documentación de Appium: https://appium.io/docs/en/latest/
- Documentación de Android Studio: https://developer.android.com/?hl=es-419
****