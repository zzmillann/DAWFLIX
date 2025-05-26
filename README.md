## PASOS A SEGUIR https://cloud.educa.madrid.org/f/450855496


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

He diseñado una jerarquía con una clase padre llamada `Contenido`, que es la clase base para las clases hijas: `Juego`, `Serie` y `Pelicula`. Estas clases heredan atributos específicos de `Contenido` y, además, poseen atributos adicionales propios de cada tipo de contenido.

### 1.2 Clase Usuario

He creado una clase `Usuario` con dos `ArrayList` de contenidos favoritos y he implementado la clase `Suscripcion` como una composición en la clase `Usuario`.

### 1.3 Interfaces y Métodos Abstractos

He creado una interfaz llamada `Reproducible`, implementada por tres clases hijas: `Juego`, `Serie` y `Pelicula`. Cada una de estas clases sobrescribe el método de la interfaz con su comportamiento específico.

### 1.4 Sistema de Suscripciones

He añadido un sistema de suscripciones que se inicializa al crear un usuario. Cada usuario puede gestionar su suscripción a distintos contenidos.

### 2.1 Comparación y Ordenación

He implementado `Comparable` y `Comparator` para ordenar los contenidos por título y duración.

### 2.2 Métodos de Búsqueda

Cada subclase tiene un método para buscar contenido por diferentes parámetros, como el título o el correo electrónico del usuario.

### 2.3 Métodos de Valoración y Reproducción

He añadido dos métodos para valorar y reproducir contenidos, basado en la valoración media de cada clase específica.

### 2.4 Sobrescritura de `hashCode()` y `equals()`

He sobreescrito los métodos `hashCode()` y `equals()` en las clases base (`Contenido`) para asegurar una correcta comparación de objetos.

### 3.1 Excepciones Personalizadas

He creado y utilizado una excepción personalizada que hereda de `RuntimeException` y otra que hereda de `Exception`, las cuales son utilizadas con un bloque `try/catch` en el `main` para manejar errores de manera adecuada.

### 3.2 Sistema de Recomendaciones

He implementado un sistema de recomendaciones que sugiere contenidos basados en el género y la valoración media de los usuarios.

### 3.3 Funcionalidad Adicional

He añadido una funcionalidad adicional, que consiste en una clase de comentarios para cada contenido específico, permitiendo a los usuarios dejar opiniones sobre películas, series y juegos.

## Cómo Ejecutar el Programa

1. Abre la clase `App.java`, que contiene el método que llama al `Main`.
2. Al ejecutar el programa, te aparecerá una interfaz gráfica proporcionada por la librería `JOptionPane`.
3. La aplicación estará vacía inicialmente, como si fuera una nueva instalación, y serás tú quien ingrese los datos desde el principio.
4. La interfaz es muy intuitiva, y puedes realizar las acciones seleccionando el número correspondiente a la opción en el menú.
5. Para evitar errores, todos los valores relacionados con cantidades son booleanos, lo que significa que puedes ingresar decimales cuando sea necesario. Por ejemplo, en los juegos, cuando se pregunta si es multiplataforma, se responde con `true` o `false`.
6. Puedes ver todos los métodos y funcionalidades del programa siguiendo las instrucciones proporcionadas en el video explicativo. Si tienes alguna duda, no dudes en contactarme por correo electrónico o pedir ayuda en clase.

## Notas Adicionales

- Asegúrate de tener instalado Java en tu máquina para poder ejecutar el proyecto.
- La interfaz gráfica utiliza la librería `JOptionPane` para facilitar la interacción del usuario con el sistema.
- Si tienes alguna duda o necesitas más información, no dudes en ponerte en contacto conmigo por correo electrónico o en clase.



