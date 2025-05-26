## PASOS A SEGUIR  
https://cloud.educa.madrid.org/f/450855496

# DAWFLIX UTL VIDEO:

Este proyecto cumple con todos los requisitos técnicos establecidos para el desarrollo de una aplicación de gestión de contenidos multimedia (películas, series y juegos) bajo el nombre **DAWFLIX**.

## Requisitos Técnicos Obligatorios

- **Herencia y jerarquía de clases**  
- **Composición de clases**  
- **Métodos abstractos y clases abstractas**  
- **Interfaces**  
- **Polimorfismo**  
- **Uso de `ArrayList`**  
- **Comparación y ordenación (Comparable y Comparator)**  
- **Sobrescritura de `equals()` y `toString()`**  
- **Gestión de excepciones (try/catch, excepciones propias)**  

## Descripción del Trabajo

### 1.1 Jerarquía de Clases

He diseñado una jerarquía con una clase padre llamada `Contenido`, que sirve de base para las clases hijas: `Juego`, `Serie` y `Pelicula`. Estas heredan atributos comunes y añaden características específicas a su tipo de contenido.

### 1.2 Clase Usuario

He implementado la clase `Usuario`, que ahora utiliza un `HashSet` para almacenar sus contenidos favoritos, evitando así duplicidades de forma eficiente. La clase también contiene una composición con la clase `Suscripcion`.

### 1.3 Interfaces y Métodos Abstractos

He creado una interfaz `Reproducible`, implementada por `Juego`, `Serie` y `Pelicula`. Cada clase redefine el comportamiento del método `reproducir()` según sus necesidades específicas.

### 1.4 Sistema de Suscripciones

Cada usuario posee una suscripción que se gestiona desde su instancia, permitiendo una arquitectura flexible y modular en la gestión de contenidos.

### 2.1 Comparación y Ordenación

Además de `Comparable` y `Comparator`, he incorporado un `TreeMap` para almacenar los contenidos manteniendo un orden natural (alfabético por título), optimizando búsquedas y listados.

### 2.2 Métodos de Búsqueda

Las subclases de `Contenido` permiten realizar búsquedas por diferentes criterios, incluyendo el título y, en el caso de los usuarios, el correo electrónico.

### 2.3 Valoraciones y Reproducciones

He implementado un sistema de valoración y reproducción. Para llevar un control exhaustivo, se ha añadido un `Map<Usuario, Map<Contenido, Integer>>` que permite registrar de forma precisa las veces que un usuario ha reproducido un contenido específico.

### 2.4 Sobrescritura de `hashCode()` y `equals()`

Los métodos `equals()` y `hashCode()` han sido sobreescritos adecuadamente en la clase `Contenido` para permitir una correcta comparación y gestión en estructuras como `HashSet`.

### 3.1 Excepciones Personalizadas

El sistema incorpora dos excepciones definidas por el usuario: una heredando de `RuntimeException` y otra de `Exception`, integradas con estructuras `try/catch` para una gestión robusta de errores.

### 3.2 Sistema de Recomendaciones

El sistema de recomendaciones propone contenidos basándose en criterios de género y en la media de valoraciones de los usuarios, ofreciendo una experiencia personalizada.

### 3.3 Comentarios de Usuarios

Cada contenido puede recibir comentarios. He implementado una clase específica para gestionar estas opiniones, mejorando la interacción usuario-contenido.

### 3.4 Persistencia de Datos

Se ha añadido soporte para la persistencia mediante ficheros de texto utilizando `java.nio.file.Files`. Esto permite guardar y cargar los favoritos y el historial de reproducciones de cada usuario, facilitando la continuidad entre sesiones.

### 3.5 Reproducción de Contenido Musical

El sistema permite la reproducción de archivos de audio en formato `.wav` mediante la clase `Clip`, lo cual amplía la funcionalidad de la plataforma hacia el contenido musical.

### 4.1 Conexión a Base de Datos

La aplicación ha sido conectada a una base de datos MySQL mediante JDBC. He creado una clase de conexión específica y probado su funcionamiento con éxito.

### 4.2 Operaciones CRUD en MySQL

He implementado operaciones CRUD completas sobre los usuarios y los contenidos desde Java, permitiendo crear, consultar, actualizar y eliminar datos directamente desde la aplicación.

### 4.3 Consultas SQL Personalizadas

Finalmente, he desarrollado una consulta en SQL integrada en el sistema que permite obtener los contenidos más reproducidos por usuario, aportando información estadística valiosa para la experiencia del usuario.

---

## Cómo Ejecutar el Programa

1. Abre la clase `App.java`, que contiene el método que lanza el `Main`.
2. Al ejecutar el programa, se mostrará una interfaz gráfica basada en `JOptionPane`.
3. La aplicación se inicia sin datos, por lo que deberás introducirlos manualmente desde cero.
4. El menú es sencillo e intuitivo: selecciona la opción correspondiente escribiendo su número.
5. Los valores booleanos deben introducirse como `true` o `false`. Por ejemplo, para indicar si un juego es multiplataforma.
6. Todos los métodos y funcionalidades están explicados en el vídeo enlazado al principio. Para cualquier duda, puedes consultarme por correo o directamente en clase.

---

## Notas Adicionales

- Asegúrate de tener Java instalado en tu equipo para ejecutar el programa.
- La interfaz está construida con la clase `JOptionPane`, facilitando la interacción con el sistema.
- La conexión a MySQL requiere tener configurado correctamente el driver JDBC.
- Es recomendable utilizar un entorno de desarrollo como IntelliJ o Eclipse para ejecutar y depurar el código de forma más cómoda.
- Para cualquier cuestión técnica o aclaración adicional, no dudes en contactarme.

