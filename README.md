# Sistema Educativo

Este es un proyecto de un sistema educativo construido con Spring Boot y Maven.

## Requisitos

- Java 17
- Maven
- PostgreSQL

## Instalación

Primero, clona el repositorio a tu máquina local:

```sh
git clone https://github.com/gjcardonam/sistemaeducativo.git
```

Luego, navega al directorio del proyecto:

```sh
cd sistemaeducativo
```

Finalmente, construye y ejecuta el proyecto con Maven:

```sh
./mvnw spring-boot:run
```

## Configuración

La configuración de la base de datos se encuentra en el archivo `src/main/resources/application.properties`. Asegúrate de actualizar las credenciales de la base de datos según tu configuración local.

## Estructura del Proyecto

El proyecto sigue la estructura estándar de Maven:

- `src/main/java`: Contiene el código fuente del proyecto.
- `src/main/resources`: Contiene los recursos del proyecto, como la configuración de la base de datos.
- `src/test/java`: Contiene las pruebas del proyecto.

## Entidades

El proyecto tiene las siguientes entidades:

- `Asignatura`: Representa una asignatura en el sistema educativo.
- `Estudiante`: Representa un estudiante en el sistema educativo.

## Repositorios

El proyecto tiene los siguientes repositorios:

- `AsignaturaRepository`: Proporciona operaciones de base de datos para la entidad `Asignatura`.
- `EstudianteRepository`: Proporciona operaciones de base de datos para la entidad `Estudiante`.

## Uso

Para iniciar la aplicación, ejecuta el siguiente comando en la raíz del proyecto:

```sh
./mvnw spring-boot:run
```

La aplicación se iniciará en el puerto 3000.