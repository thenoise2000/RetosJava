############################# Proyecto java #############################

1 - Reto 1

Contar la Frecuencia de Caracteres en la Revista:

Usamos un HashMap para almacenar la frecuencia de cada carácter en la cadena de la revista. Recorremos cada carácter de la revista y aumentamos su contador en el mapa.

# Verificamos la Nota:

Recorremos cada carácter de la nota que queremos escribir. Para cada carácter, verificamos si existe en el mapa de la revista y si su frecuencia es mayor que cero.
Si el carácter no está presente o su frecuencia es cero, significa que no podemos escribir la nota, por lo que la función retorna false.
Si el carácter está presente, decrementamos su contador en el mapa, ya que hemos "usado" ese carácter.

# Resultado Final:

Si logramos recorrer toda la nota sin encontrar caracteres que no se puedan cubrir, retornamos true, indicando que es posible escribir la nota con recortes de la revista.

# Analisis de la respuesta 

Complejidad Temporal: O(n + m), donde n es la longitud de la nota y m es la longitud de la revista. Esto se debe a que recorremos ambas cadenas una vez.
Complejidad Espacial: O(k), donde k es el número de caracteres únicos en la revista, ya que almacenamos la frecuencia de cada carácter en un HashMap.
Este enfoque es eficiente y permite determinar si la nota puede ser escrita utilizando los recortes de la revista de manera clara y directa.

2 - Reto 2

Deseamos notificar a los estudiantes sobre una incidencia por la cual no se celebrarán las clases 
programadas para el siguiente día en el instituto. Esta incidencia afecta a dos asignaturas y sólo 
afecta a los alumnos que asisten a la sede ubicada en Málaga. La información de la que 
disponemos son tres listas de los estudiantes que están matriculados en cada asignatura:

 ● Lista A: Nombres de estudiantes matriculados en Matemáticas. (De todas las sedes)
 ● Lista B: Nombres de estudiantes matriculados en Francés. (De todas las sedes)
 ● Lista C: Nombres de estudiantes matriculados en Matemáticas y Francés. (De todas las 
sedes)

 Escriba una función en Java para que sean notificados los estudiantes de cada asignatura de 
manera que cada uno de los estudiantes sólo reciba un email y los emails a enviar a cada una de 
las tres listas son diferentes.
 De cada estudiante sabemos su nombre y la sede donde está matriculado.
 
# Definimos la clase Estudiante: 

Se define una clase Estudiante que contiene el nombre y la sede del estudiante. También se implementan los métodos equals y hashCode para que los estudiantes puedan ser comparados correctamente en un conjunto.

# Creamos el método notificarSuspensionMalaga:

Este método recibe tres listas de estudiantes (Matemáticas, Francés y ambas).
Se utiliza un HashSet para llevar un registro de los estudiantes que ya han sido notificados, evitando así que reciban múltiples correos.

El método notificarSuspensionMalaga es responsable de enviar correos electrónicos a los estudiantes.
Se utiliza un Set llamado notificados para asegurarse de que cada estudiante solo reciba un correo una vez.
Se configura una sesión de correo utilizando las propiedades definidas y se autentica con el correo y la contraseña del remitente.

Configuración de Correo Electrónico:

Se definen constantes para el correo del remitente (EMAIL_REMITENTE), la contraseña del remitente (PASSWORD_REMITENTE), el servidor SMTP (SMTP_HOST), el puerto (SMTP_PORT), y propiedades de autenticación y seguridad.

# Método enviarEmail:

Se recorren las listas de estudiantes para identificar a aquellos que están matriculados en Matemáticas y Francés en la sede de Málaga.
Para cada grupo de estudiantes (Matemáticas, Francés, y ambos), se envía un correo electrónico informando sobre la suspensión de clases, siempre que no hayan sido notificados previamente.

Este método envia un correo electrónico en un escenario real, aquí se implementaría la lógica para enviar un correo electrónico (utilizando la biblioteca de envío de correos JavaMail).

![notificaciones4](https://github.com/user-attachments/assets/5d889aab-f80f-4815-813c-3e94ca0dbb78)

Debemos incluir ambas librerias en nuestro proyecto java

# Metodo estaEnLista:
Verifica si un estudiante está en una lista dada.

# Metodo enviarCorreo:
Crea y envía el correo electrónico utilizando la sesión de correo configurada.

Método main:
Se crean listas de objetos Estudiantes que representan a los estudiantes matriculados en Matemáticas, Francés y ambos cursos. Y Se llama al método notificarSuspensionMalaga, pasándole las listas de estudiantes.

Correo remitente y destanatario

![Notificaciones](https://github.com/user-attachments/assets/f5b8ca40-83a4-43d0-8f8e-1be640fd8900)


Correo destinatario 2

![notificaciones2](https://github.com/user-attachments/assets/f8529b9f-dd4f-4fba-b5fe-458cf004b44c)


![Notificaciones3](https://github.com/user-attachments/assets/23f1c5db-17e5-4bbe-82be-6294f1d5aaea)

