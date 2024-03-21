# automationTest-api-requres

## Descripción general

`automationTest-api-requres` es un proyecto de pruebas de desarrollo dirigido por comportamiento (BDD) diseñado para automatizar y validar interacciones con la API de Reqres. Este proyecto aprovecha Serenity BDD para proporcionar informes narrativos claros de los escenarios de prueba de API, incluyendo la creación, actualización, eliminación y listado de usuarios.

## Empezando

### Prerrequisitos

- Java 11 o superior
- Gradle 8.0.2 preferiblemente o superior
- Un IDE de tu elección (por ejemplo, IntelliJ IDEA, Eclipse, Visual Studio Code)

### Configuración

1. Clona el repositorio en tu máquina local.
2. Asegúrate de que `JAVA_HOME` esté configurado con la ruta de instalación de tu JDK.
3. Abre el proyecto en tu IDE e impórtalo como un proyecto Gradle.

### Ejecutando pruebas

Para ejecutar todas las pruebas, utiliza el siguiente comando de Gradle:
```sh
./gradlew clean test aggregate
