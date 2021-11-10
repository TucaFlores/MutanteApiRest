# MutanteApiRest
Este es un Proyecto realizado por los alumnos Flores Sebastián y Pepi Martín para la materia Taller de Programación Avanzada. 4to Año de la carrera Ingeniería de Sistema de Información.

Este proyecto consta de un desafío, que había que determinar con un vector con caracteres especiales, si la persona era mutante o no. Este desafío lo podemos encontrar como el "Desafío del Mercado Libre". Hay varias personas que lo han realizado, de distintas formas y hay foros y blog que explican brevemente algunos detalles que tuvieron en cuenta a la hora de realizar el desafío.

# Tecnologías
- XAMPP 
- Java 11
- Maven
- Intellig IDE
- MySQLYog Community
- Postman (para poder probar el proyecto)

# Cómo probarlo con Postman
Para ellos necesitamos iniciar el XAMPP e iniciar un servidor MySQL. Luego con MySQLYog, crea una base de datos. Puede cologarle el nombre de `db_mutante` o si le coloca otro nombre tendrá que cambiar en el `application.properties` el nombre de la base de datos. 
Una vez iniciado ambas cosas, procede a clonar el repositorio y ha abrirlo con Intellig IDE. Dentro del programa lo hace correr, con el XAMPP andando. Cuando los 3 programas estén funcionando, abrimos el Postman. Dentro de él crearemos una Request, una nueva tarea `Post` y en el URL colocaremos `http://localhost:9000/api/v1/personas/mutant`. Dentro del body colocamos, en lenguaje JSON, {"dna":[]} el vector con el ADN. Luego el programa les mostrará si hubo un error o si se guardo exitosamente. Además, mostrará si es mutante o no.

# Post en Heroku
Este proyecto esta deployado en Heroku con el siguiente URL: https://mutanteapirest.herokuapp.com/. Estuvo testeado con JMeter para poder medir las peticiones que el programa puede soportar. 
