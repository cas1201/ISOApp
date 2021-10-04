# ISOApp: Easy Hodling
Este repositorio está pensado para realizar un control de versiones para la aplicación móvil *Easy Hodling* desarrollada en la asignatura de Ingeniería del Software por el **Grupo 2**.

1.	Capaz de poder ejecutarse en un dispositivo Android.
La aplicación se programará en el entorno de desarrollo de Android Studio. 
2.	Capaz de conectarse mediante API Rest con un exchange mediante unas credenciales.
La aplicación ejecutará un script de Python para conectarse a la API.
3.	Capaz de permitir la conexión con la aplicación Binance mediante la API Key y el API Secret proporcionado por Binance(aplicación con la cual se llevará a cabo la compra y venta de criptomonedas).
El script de Python utilizará las claves aportadas para poder realizar la conexión con la API.
4.	Capaz de poder operar con distintas criptomonedas (comprar/vender).
El cliente creado mediante la conexión a la API permitirá la creación de órdenes de compra y de venta. 
5.	Capaz de poder establecer las características preferidas de la aplicación y su apariencia.
El usuario podrá establecer las preferencias de la aplicación en el apartado “Configuración”.
6.	Capaz de vender instantáneamente en cualquier momento.
En el apartado de “Trading”  el usuario podrá realizar una venta instantánea pulsando un botón.
7.	Capaz de consultar los resultados de la última operación realizada.
El usuario podrá consultar el resultado de la última operación realizada pulsando un botón en el apartado de “Trading”.
8.	Capaz de consultar el estado de la wallet.
El usuario podrá consultar el estado de su wallet en cualquier momento en el apartado de “Wallet”.
9.	Capacidad para añadir diferentes métodos de pago y retirada: 
1.Tarjeta de crédito/débito 
2.Paypal 
3.Skrill
La aplicación se conectará con servicios de pago externos mediante API.
10.	Capaz de mostrar los posibles errores que ocurran en la ejecución de la aplicación.
Cuando un usuario haga una acción no permitida o surja un error en la ejecución de la aplicación saltará un cuadro de diálogo con un texto explicativo.
11.	Posibilidad de añadir un gráfico a tiempo real del par de moneda seleccionado.
Al momento de comprar una moneda el usuario podrá ver el estado y la evolución de la misma.
12.	Capaz de ser una aplicación abierta a todos los usuarios.
Cualquier usuario podrá descargarse la aplicación.
13.	Cada usuario deberá hacer login para entrar en su cuenta. En caso de no tenerla, se deberá crear una.
Se solicitará el ingreso de los datos de inicio de sesión al abrir la aplicación por primera vez o la posibilidad de acceder a un apartado para la creación de una cuenta.
14.	El proceso de login consistirá en introducir el correo electrónico o nombre de usuario y la contraseña.
Los datos de inicio de sesión deben coincidir con los introducidos en el proceso de registro.
15.	En caso de pérdida de contraseña se deberá resetear mediante correo electrónico, mensaje de texto o llamada.
El usuario deberá de introducir el correo electrónico o el número de teléfono requerido para poder restablecer la contraseña.
16.	Tendrá la opción MFA de autentificación en dos pasos para mayor seguridad
El usuario tendrá la posibilidad de activar una autentificación MFA para mejorar la integridad de sus cuentas 
17.	Permite buscar todas las criptomonedas que están listadas en la plataforma Binance para operar con ellas.
	Los usuarios podrán buscar todas las criptomonedas guardadas en la base de datos de la aplicación
18.	Si no encontramos la criptomoneda o token que estamos buscando, no estaría soportada por la exchange.
Los usuarios no podrán hacer uso de las criptomonedas que no estén presentes en la base de datos
19.	La aplicación ofrecerá la posibilidad de elegir el par de moneda con el que quiera operar cada usuario.
Todo usuario tendrá la libertad de elegir si la compra se lleva a cabo con divisas o con criptomonedas y la criptomoneda que desea comprar.
20.	La aplicación dispondrá de la posibilidad de poner un límite de pérdidas y de ganancias.
	Se permitirá que el usuario elija qué porcentaje de dinero está dispuesto a perder o ganar 
21.	La aplicación contará con una base de datos con la información de los usuarios desde el momento del lanzamiento.
Todos los datos de los usuarios quedarán grabados en la aplicación desde su registro.
22.	La aplicación permitirá customizar la apariencia de la aplicación.
Todo usuario podrá personalizar la aplicación a su gusto para facilitar el uso de esta.
23.	Se podrá compartir los resultados de una operación.
Todo usuario tendrá la posibilidad de compartir en cualquier momento los resultados de sus operaciones.
24.	Se podrá compartir el estado de la wallet.
Todo usuario tendrá la posibilidad de compartir en cualquier momento el estado de la wallet.
25.	La operación de compra de una moneda deberá de tardar menos de 2 segundos.
El tiempo máximo que debe tardar la aplicación en ejecutar una compra es de 2 segundos.
26.	La operación de venta de una moneda deberá de tardar menos de 1 segundos.
El tiempo máximo que debe tardar la aplicación en ejecutar una compra es de 1 segundo.
27.	Al iniciar sesión se deberá ejecutar el código para crear cliente de la API en segundo plano.
El usuario recibe un mensaje toast comunicando que se ha iniciado correctamente. 
28.	La aplicación deberá de mostrar mensajes “Toast” cuando realice operaciones para informar al usuario.
Se le mostrará al usuario mensajes informativos relacionados con las operaciones que realice en cada momento.
29.	Se podrá conectar a una cuenta de Google para guardar los datos de inicio de sesión y preferencias de la aplicación.
En el momento de inicio de sesión la app te pedirá si deseas guardar los datos de inicio, solo pulsando guardar conseguirás guardarlos para cada vez que inicies sesión.
30.	El par de moneda seleccionado se puede cambiar en cualquier momento por el usuario en el apartado de configuración.
Una vez dentro de configuración al hacer clic en moneda, saldrá una pestaña con los diferentes pares que hay
31.	La aplicación mostrará predicciones sobre la evolución del valor de la moneda.
El usuario podrá ver la evolución del par de moneda que ha seleccionado para así poder realizar las operaciones que considere oportunas.
32.	La aplicación permitirá a los usuarios poder establecer el porcentaje del dinero de su wallet que se va a emplear en la compra de una criptomoneda.
El usuario podrá manejar la cantidad de dinero que considere oportuna para operar. 
33.	Capaz de incorporar nuevas criptomonedas con las que operar una vez sean lanzadas al mercado de Binace.
El usuario es capaz de elegir y operar con las nuevas moendas incorporadas. 
34.	Se informará a los usuarios de las salidas de nuevas criptomonedas para que puedan operar con ellas.
Se establecerán actualizaciones con las nuevas criptomonedas.
35.	La aplicación estará disponible en castellano.
Se podrá cambiar el idioma en el momento que se desee
36.	La aplicación estará disponible en inglés.
Se podrá cambiar el idioma en el momento que se desee.
37.	La aplicación mostrará opciones sobre compra/venta más convenientes para el usuario según la evolución del par de moneda seleccionado por el mismo.
El usuario será capaz de ver recomendaciones según su moneda elegida.
38.	El usuario podrá recibir notificaciones sobre la evolución del valor de la moneda y/o sobre consejos a la hora de operar.
El usuario será capaz de activar notificaciones si desea recibirlas y las recibirá correctamente. 
39.	El usuario podrá establecer la recepción de notificaciones en caso de que la criptomoneda alcance el valor predefinido por el usuario.
El usuario será capaz de activar la notificación si lo desea y recibirla correctamente.
40.	Los usuarios tendrán habilitado un foro donde podrán crear una comunidad compartiendo sus experiencias y conocimientos.
Se podrán enviar y recibir mensajes por el chat habilitado 24h 
41.	Los foros estarán filtrados según el par de moneda elegido con el que se opera.
Cada par de monedas tendrá su foro particular para garantizar la efectividad de las búsquedas
42.	Los foros serán simplemente a través de texto, sin la posibilidad de poder enviar imágenes o videos.
Se podrán enviar y recibir mensajes por el chat habilitado 24h 
43.	La aplicación contará con vídeos explicativos para nuevos usuarios para aprender a operar
Éstos aparecerán al iniciar sesión abajo del todo y serán una serie de tutoriales divididos en secciones para conocer más acerca de tanto lo básico como alguna opción más específica
44.	La aplicación contará con una opción de usar créditos no reales en vez de dinero real para experimentar en los inicios
El usuario tendrá la libertad de cambiar a la opción de operar con dinero ficticio, situada en la pantalla principal para así aprender el funcionamiento adecuado antes de utilizar la app
45.	La aplicación contará con una opción de autoexclusión por si padece de problemas de ludopatía
Con el botón de autoexclusión situado en el apartado de configuración, podrá autoexcluirse temporal o definitivamente 
46.	La aplicación obligará a los usuarios a validar un test semanal para validar el uso correcto de la aplicación
Aparecerá un test al iniciar sesión cada domingo que se deberá rellenar si se quiere continuar con el uso de la app.
