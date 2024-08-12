# EvaNisumDiegoMunoz

## Descripción
Este proyecto es una aplicación de ejemplo desarrollada con Spring Boot, que incluye pruebas unitarias utilizando JUnit y Mockito. La aplicación gestiona usuarios y valida correos electrónicos y contraseñas.

## Requisitos Previos
- Java 17 o superior
- Maven 3.8.1 o superior

## Tecnologías Utilizadas
- Spring Boot 3.0.0
- JUnit 5.9.2
- Mockito 4.6.1
- H2 Database (para pruebas en memoria)
- Swagger (para documentación de la API)

## Instrucciones para Ejecutar el Proyecto
1. Clona el repositorio en tu máquina local:
   git clone https://github.com/geodiego02/Nisum
2. Navega al directorio del proyecto:
   cd EvaNisumDiegoMunoz
3. Compila y empaqueta el proyecto utilizando Maven:
   mvn clean package
4. Ejecuta la aplicación:
   java -jar target/EvaNisumDiegoMunoz-0.0.1-SNAPSHOT.jar
5. Para prues unitarias ejecuta:
   mvn test
6. Para visualizar la base de datos H2:
   http://localhost:8080/h2-console
   Como usuario se usa: user
   Como clave se usa: admin
7. Para ver la documentación Swagger:
   ejecutar la aplicación y luego usar la url http://localhost:8080/swagger-ui/index.html
   

