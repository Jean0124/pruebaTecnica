## Prueba Técnica 2

Proyecto de springboot que integra 2 microservicios: 

El primero consume una api de JSONPlaceHolder de la cual obtiene una lista de usuarios y la expone en su endpoint
se manejaron algunos errores y uno global también tiene sistema de cache y sus pruebas unitarias.

El segundo recibe un JSON con un parámetro palíndromo y muestra el tamaño de la cadena, si es palíndromo o no y el numero
de caracteres especiales si los tiene.

Estos dos microservicios tienen su documentación en swagger la cual se explicara mas adelante como acceder a ella.



## Requisitos

Antes de comenzar, asegúrate de tener lo siguiente en tu maquina:

- [Java 17 o superior](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Maven](https://maven.apache.org/install.html) ya que en el proyecto se eligió maven y no gradle
- [Git](https://git-scm.com/downloads)



## Instalación 

1. Se debe clonar el repositorio en la maquina local usando:

git clone https://github.com/Jean0124/pruebaTecnica.git

2. Ve a la ruta del proyecto y abres el cmd y ejecuta este comando para construir el proyecto:

mvn clean install

3. Ejecuta el proyecto con el siguiente comando:

mvn spring-boot:run



## Uso

Una ves que el proyecto este corriendo necesitas los respectivos endpoints para probar los servicios en el navegador:

-Endpoint del microservicio de usuarios donde muestra la lista:

http://localhost:8080/api/usuarios

-Endpoint del microservicio de palíndromo, este se debe probar en postman ya que como es un método post y no get se le debe mandar un parámetro:

http://localhost:8080/api/palindromo

-Pasos para probar este endpoint en postman:
 
1. pones el endpoint en el campo para ello y el pones el método POST

2. vas a la pestaña body y elijes de tipo rawr

3. le envías el parámetro ejemplo:
{
    "palindromo": "radar"
}

4. le das en send y te devuelve la respuesta

Nota: al correr el proyecto funcionan los dos microservicios.



## Swagger

Para entrar en la documentación de swagger se tienen las siguientes rutas:

http://localhost:8080/swagger-ui/index.html#/

Al poner esta ruta en tu navegador te aparecerá la interfaz de swagger donde podrás ver todos los endpoints del proyecto y probarlos.


Muchas gracias por probar mi proyecto :)

