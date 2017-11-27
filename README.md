# FinalArcquitecturaSw
Repositorio para el proyecto final de la materia de arquitectura de software

Materia: Diseño y Arquitectura de SoftWare TC-3049

Mto. Juan Velez Ballesteros

Equipo:
   Diego Miguel Granados A01337287
   Itzel Daniela Reyes   A01337712
   Yukio José Tsuru      A01337580


Descripcion del proyecto

El equipo decidió implementar una aplicación de mensajería instantánea corriendo en Spring. La aplicación hace el uso de la tecnología de WebSocket para generar un canal de  comunicación bidireccional entre el servidor y  cliente, esto con el objetivo de tener un canal de comunicación que permanezca abierto y que sea más veloz que las peticiones HTTP.

Nuestro proyecto se inspiró en la idea de páginas como Omegle y ChatRoulette, en las cuales la gente puede hablar con cualquier persona solo habiendo ingresado un nombre, en ellas no hay persistencia de los mensajes enviados. Decidimos no implementar esta parte por razones de tiempo, tratando de enfocarnos en el uso de WebSockets y el uso de Spring, así como presentar una aplicación visualmente atractiva, nostálgica a las páginas de los años 90.

Para correr el proyecto, es necesario utilizar el siguiente comando en la carpeta del proyecto:

./gradlew bootrun

En caso de haber algun problema al correr el proyecto, tal vez sea necesario ahcer el build, el  comando es el siguiente:

gradle build

Para poder hacer uso de la aplicación, solo es necesario abrir cualquier navegador de internet y entrar al localhost:8080

El reporte de los tests se encuentra en la siguiente dirección:
  ./build/reports/tests/test/index.html
