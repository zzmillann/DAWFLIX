package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import dao.JuegoDAO;
import dao.PeliculaDAO;
import dao.SerieDAO;
import dao.UsuarioDAO;


public class Main {

    public void main() {


        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario gestorusuario = new Usuario("aaaaaaaaa", "aaaaaaaa", null );
         gestorusuario.setUsuarios(usuarios);
        Juego gestorjuego = new Juego(null, null, 0, null, null, false);
        Serie gestorserie = new Serie(null, null, 0, null, 0, 0);
        Pelicula gestorpelicula = new Pelicula(null, null, 0, null, null, 0);
        RegistroReproducciones registro = new RegistroReproducciones();
        Map<Usuario, Map<Contenido, Integer>> reproducciones;
       try {
            gestorusuario.cargarUsuariosDesdeArchivo(usuarios, "usuarios.txt");
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }
        JuegoDAO daojuego = new dao.JuegoDAO();
        PeliculaDAO daopeli = new dao.PeliculaDAO();
        SerieDAO daoserie = new dao.SerieDAO();
        UsuarioDAO daousuario = new UsuarioDAO();

        gestorusuario.crearUsuario("Alejandro", "alex@email.com" , null);
gestorusuario.crearUsuario("Lucía", "lucia@example.com", new Suscripcion("Premium", 9.99));
gestorusuario.crearUsuario("Carlos", "carlos23@gmail.com", new Suscripcion("Básica", 4.99));
gestorusuario.crearUsuario("Marta", "marta.1990@hotmail.com", new Suscripcion("Estudiante", 2.99));
gestorusuario.crearUsuario("Javier", "javi.dev@outlook.com", new Suscripcion("Familiar", 12.99));
gestorusuario.crearUsuario("Sofía", "sofia_love@correo.com", new Suscripcion("Premium", 9.99));


gestorjuego.crearJuego("gta 5", "es violento", 120, "accion", "play 4 y pc", true);
gestorjuego.crearJuego("The Witcher 3", "RPG de mundo abierto con historia profunda", 150, "RPG", "PC, PS4, Xbox One", false);
gestorjuego.crearJuego("FIFA 23", "Simulador de fútbol con multijugador", 90, "Deportes", "PC, PS5, Xbox Series", true);
gestorjuego.crearJuego("Minecraft", "Juego de construcción y exploración", 200, "Sandbox", "PC, Consolas, Móvil", true);
gestorjuego.crearJuego("Celeste", "Plataformas con gran dificultad y buena narrativa", 8, "Plataformas", "PC, Switch, PS4", false);
gestorjuego.crearJuego("Call of Duty: Modern Warfare", "Shooter en primera persona con multijugador", 100, "Shooter", "PC, PS4, Xbox One", true);





        int opcionPrincipal;

        do {
            String dialogo1 = JOptionPane.showInputDialog(
                    "¿QUÉ DESEA HACER?" +
                    "\n1) Gestionar Usuarios" +
                    "\n2) Gestionar Juegos" +
                    "\n3) Gestionar Series" +
                    "\n4) Gestionar Peliculas" +
                    "\n5) SALIR" +
                    "\n6) Reproducir música");
;

            if (dialogo1 == null) break;
            opcionPrincipal = Integer.parseInt(dialogo1);

            switch (opcionPrincipal) {
                case 1: 
                    int opcionUsuarios;
                    do {
                        String dialogo2 = JOptionPane.showInputDialog(
                                "GESTIÓN DE USUARIOS" +
                                "\n1) Crear Usuario" +
                                "\n2) Eliminar Usuario" +
                                "\n3) Ver todos los usuarios" +
                                "\n4) Ver Info de usuario especifico" +
                                "\n5) Añadir a favoritos" +
                                "\n6) Eliminar de favoritos" +
                                "\n7) Añadir a estoy viendo" +
                                "\n8) Eliminar de estoy viendo" +
                                "\n9) Volver");

                        if (dialogo2 == null) break;
                        

                        opcionUsuarios = Integer.parseInt(dialogo2);

                        switch (opcionUsuarios) {
                            case 1:
                       
                            String nombreusu = JOptionPane.showInputDialog("Nombre usuario:");
                            String emailusu = JOptionPane.showInputDialog("Email usuario:");
                            String tiposus = JOptionPane.showInputDialog("Tipo suscripcion:");
                            String preciosus = JOptionPane.showInputDialog("Precio suscripcion:");
                            double numero = Double.parseDouble(preciosus);
                            Suscripcion suscripcionNueva = new Suscripcion(tiposus, numero);
                            Usuario usuarioNuevo = gestorusuario.crearUsuario(nombreusu, emailusu, suscripcionNueva);
                            daousuario.insertarUsuario(usuarioNuevo);
                                break;
                            case 2:
                            String emailusu2 = JOptionPane.showInputDialog("Email usuario:");
                            daousuario.eliminarUsuario(emailusu2);
                                break;
                            case 3:
                                    List<Usuario> se = daousuario.obtenerTodosUsuarios();
                                    for (Usuario u : se) {
                                    System.out.println(u);
                                         }
                            gestorusuario.verUsuarios();
                                break;
                            case 4:
                            String emailusu3 = JOptionPane.showInputDialog("Email usuario:");
                            Usuario usuarioEncontrado = daousuario.buscarUsuarioPorEmail(emailusu3);
                            System.out.println(usuarioEncontrado);
                                break;
                            case 5:
                            String emailFavorito = JOptionPane.showInputDialog("Email del usuario:");
                             Usuario usuarioActual = gestorusuario.buscarUsuarioPorEmail(usuarios, emailFavorito);

                             if (usuarioActual != null) {
                                String contenidos1 = JOptionPane.showInputDialog("Nombre de película, serie o juego que quieras añadir a tu lista de favoritos");

                             if (contenidos1 == null || contenidos1.trim().isEmpty()) {
                                      JOptionPane.showMessageDialog(null, "El contenido no puede estar vacío.");
                              } else {
                            try {
                              usuarioActual.agreagarFavorito(contenidos1);
                               JOptionPane.showMessageDialog(null, "Contenido añadido a favoritos.");

                                    // Guardar cambios en archivo
                            gestorusuario.guardarUsuariosEnArchivo(usuarios, "usuarios.txt");

                              } catch (ContenidoNoDisponibleException e) {
                                   JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                               } catch (IOException ioEx) {
                                   JOptionPane.showMessageDialog(null, "Error al guardar en archivo: " + ioEx.getMessage());
                                    }
                             }  
                              } else {
                                  JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                             }
                              break;
                            case 6:
                            String contenidos2 = JOptionPane.showInputDialog("Nombre de pelicula, serie o juego que quieras eliminar a tu lista de favoritos");
                            gestorusuario.eliminarFavorito(contenidos2);
                            break;   
                            case 7:
                            String contenidos3 = JOptionPane.showInputDialog("Nombre de pelicula, serie o juego que quieras agregar a tu lista de estoy viendo");
                            gestorusuario.agregarEstoyViendo(contenidos3);
                            break;
                            case 8:
                            String contenidos4 = JOptionPane.showInputDialog("Nombre de pelicula, serie o juego que quieras eliminar de tu lista de estoy viendo");
                            gestorusuario.elimianrEstoyViendo(contenidos4);
                            break; 
                            case 9:
                                break;
                        }
                    } while (opcionUsuarios != 9);
                    break;

                case 2: // Contenidos
                    int opcionContenido;
                    do {
                        String dialogo3 = JOptionPane.showInputDialog(
                                "GESTIÓN DE CONTENIDOS" +
                                "\n1) Crear Juego" +
                                "\n2) Eliminar Juego" +
                                "\n3) Ver Juego" +
                                "\n4) Ver Info de juego" +
                                "\n5) Agregar comentario" +
                                "\n6) Ver comentarios" +
                                "\n7) Valorar" +
                                "\n8) Reproducir" +
                                "\n9) Salir");

                        if (dialogo3 == null) break;
                        opcionContenido = Integer.parseInt(dialogo3);

                        switch (opcionContenido) {
                            case 1:
                                String titulo = JOptionPane.showInputDialog("Título del juego");
                                String descripcion = JOptionPane.showInputDialog("Descripcion del juego");
                                String duracion = JOptionPane.showInputDialog("Duracion del juego");
                                double numero = Double.parseDouble(duracion);
                                String genero = JOptionPane.showInputDialog("Genero del juego");
                                String plataforma = JOptionPane.showInputDialog("Plataforma del juego");
                                String multijugador = JOptionPane.showInputDialog("¿ Es Multijugador ? ");
                                boolean valor = Boolean.parseBoolean(multijugador);
                                Juego juego = new Juego(titulo, descripcion, numero, genero, plataforma, valor);
                                daojuego.insertarJuego(juego);
                                gestorjuego.crearJuego(titulo, descripcion, numero, genero, plataforma, valor);
                                break;
                            case 2:
                                String titulo2 = JOptionPane.showInputDialog("Título del juego");
                                gestorjuego.eliminarJuego(titulo2);
                                break;
                            case 3:
                                           List<Juego> juegos = daojuego.obtenerTodosJuegos(); // ← método que saca todos los juegos de la BD
                                           StringBuilder sb = new StringBuilder();
                                           for (Juego j : juegos) {
                                          sb.append(j.toString()).append("\n\n");
                                       }
                                     gestorjuego.verJuego();
                                break;
                            case 4:
                                String titulo3 = JOptionPane.showInputDialog("Título del juego");
                                gestorjuego.verInfo(titulo3);
                                break;
                            case 5:
                             String titulo4 = JOptionPane.showInputDialog("Título del juego");
                            String comentario = JOptionPane.showInputDialog("Introduzca su comentario...");
                                gestorjuego.agregarComentarioJuego(titulo4,comentario);
                                break;
                            case 6:
                            String titulo5 = JOptionPane.showInputDialog("Título del juego");
                            gestorjuego.verComentariosJuego(titulo5);
                            break;
                            case 7:
                            String titulo6 = JOptionPane.showInputDialog("Título del juego");
                            String estrellas = JOptionPane.showInputDialog("Estrellas para este juego 1-5");
                            double contadorestrellas = Double.parseDouble(estrellas);
                            gestorjuego.valorar(titulo6,contadorestrellas);
                                break;
                            case 8:
                                try {    
                                        String titulo7 = JOptionPane.showInputDialog("Título del juego");
                                        String emailLogin = JOptionPane.showInputDialog("Introduce tu email:");
                                        Usuario usuarioActual = daousuario.buscarUsuarioPorEmail(emailLogin);
                                        gestorjuego.reproducir(titulo7, usuarioActual, registro); 
                                        daousuario.registrarReproduccion(usuarioActual.getEmail(), titulo7);          // puede lanzar ContenidoNoDisponibleException
                                    } catch (ContenidoNoDisponibleException e) {
                                         System.out.println("No se puede reproducir: " + e.getMessage());
                                    }
                                break;
                            case 9:
                                break;
                            case 10:
                            daousuario.mostrarContenidosMasReproducidosPorUsuario();
                            break;

                        }
                    } while (opcionContenido != 9);
                    break;

                case 3: // Contenidos
                    int opcionseries;
                    do {
                        String dialogo3 = JOptionPane.showInputDialog(
                                "GESTIÓN DE CONTENIDOS" +
                                "\n1) Crear Serie" +
                                "\n2) Eliminar Serie" +
                                "\n3) Ver Serie" +
                                "\n4) Ver Info de la serie" +
                                "\n5) Valorar" +
                                "\n6) Reproducir" +
                                "\n7) Salir");

                        if (dialogo3 == null) break;
                        opcionseries = Integer.parseInt(dialogo3);

                        switch (opcionseries) {
                            case 1:
                                String titulo = JOptionPane.showInputDialog("Título de la Serie");
                                String descripcion = JOptionPane.showInputDialog("Descripcion de la Serie");
                                String duracion = JOptionPane.showInputDialog("Duracion de la Serie");
                                double numero = Double.parseDouble(duracion);
                                String genero = JOptionPane.showInputDialog("Duracion de la Serie");
                                String tempo = JOptionPane.showInputDialog("Temporadas");
                                int temporadas = Integer.parseInt(tempo);                               
                                String caps = JOptionPane.showInputDialog("Capitulos ");
                                int capitulos = Integer.parseInt(caps);
                                Serie serie = new Serie(titulo, descripcion, numero, genero, temporadas, capitulos);
                                daoserie.insertarSerie(serie);
                                gestorserie.crearSerie(titulo, descripcion, numero, genero, temporadas, capitulos);
                                break;
                            case 2:
                                String titulo2 = JOptionPane.showInputDialog("Título de la Serie");
                                gestorserie.eliminarSerie(titulo2);
                                break;
                            case 3:
                                List<Serie> series = daoserie.obtenerTodasSeries(); // ← método que saca todos los juegos de la BD
                                           StringBuilder sb = new StringBuilder();
                                           for (Serie j : series) {
                                          sb.append(j.toString()).append("\n\n");
                                       }
                               gestorserie.verSerie();
                                break;
                            case 4:
                                String titulo3 = JOptionPane.showInputDialog("Título de la Serie");
                                gestorserie.verInfo(titulo3);
                                break;
                            case 5:
                            String titulo6 = JOptionPane.showInputDialog("Título de la Serie");
                            String estrellas = JOptionPane.showInputDialog("Estrellas para esta Serie 1-5");
                            double contadorestrellas = Double.parseDouble(estrellas);
                            gestorserie.valorar(titulo6, contadorestrellas);
                                break;
                            case 6:
                                try {    
                                        String titulo7 = JOptionPane.showInputDialog("Título de la Serie");
                                        gestorserie.reproducir(titulo7, gestorusuario, registro);                   // puede lanzar ContenidoNoDisponibleException
                                    } catch (ContenidoNoDisponibleException e) {
                                         System.out.println("No se puede reproducir: " + e.getMessage());
                                    }
                                break;
                            case 7:
                                break;

                        }
                    } while (opcionseries != 7);
                    break;
                  
                 case 4: // Contenidos
                    int opcionpeliculas;
                    do {
                        String dialogo3 = JOptionPane.showInputDialog(
                                "GESTIÓN DE CONTENIDOS" +
                                "\n1) Crear Pelicula" +
                                "\n2) Eliminar Pelicula" +
                                "\n3) Ver Pelicula" +
                                "\n4) Ver Info de la Pelicula" +
                                "\n5) Valorar" +
                                "\n6) Reproducir" +
                                "\n7) Salir");

                        if (dialogo3 == null) break;
                        opcionpeliculas = Integer.parseInt(dialogo3);

                        switch (opcionpeliculas) {
                            case 1:
                                String titulo = JOptionPane.showInputDialog("Título de la Pelicula");
                                String descripcion = JOptionPane.showInputDialog("Descripcion de la Pelicula");
                                String duracion = JOptionPane.showInputDialog("Duracion de la Pelicula");
                                double numero = Double.parseDouble(duracion);
                                String genero = JOptionPane.showInputDialog("Genero de la Pelicula");
                                String director = JOptionPane.showInputDialog("Director de la pelicula");
                                String años = JOptionPane.showInputDialog("¿ Año de la grabación ? ");
                               int año = Integer.parseInt(años);
                                Pelicula peli = new Pelicula(titulo, descripcion, numero, genero, director, año);
                                daopeli.insertarPelicula(peli);
                               gestorpelicula.crearPelicula(titulo, descripcion, numero, genero, director, año);
                                break;
                            case 2:
                                String titulo2 = JOptionPane.showInputDialog("Título del juego");
                                gestorpelicula.eliminarPelicula(titulo2);
                                break;
                            case 3:
                                List<Pelicula> pelis = daopeli.obtenerTodasPeliculas(); // ← método que saca todos los juegos de la BD
                                StringBuilder sb = new StringBuilder();
                                for (Pelicula j : pelis) {
                                sb.append(j.toString()).append("\n\n");
                                }
                               gestorpelicula.verPeliculas();
                                break;
                            case 4:
                                String titulo3 = JOptionPane.showInputDialog("Título del juego");
                                gestorpelicula.verInfo(titulo3);
                                break;
                           
                            case 5:
                            String titulo6 = JOptionPane.showInputDialog("Título del juego");
                            String estrellas = JOptionPane.showInputDialog("Estrellas para este juego 1-5");
                            double contadorestrellas = Double.parseDouble(estrellas);
                            gestorpelicula.valorar(titulo6,contadorestrellas);
                                break;
                            case 6:
                                try {    
                                        String titulo7 = JOptionPane.showInputDialog("Título del juego");
                                         gestorpelicula.reproducir(titulo7, gestorusuario, registro);      
                                    } catch (ContenidoNoDisponibleException e) {
                                         System.out.println("No se puede reproducir: " + e.getMessage());
                                    }
                                break;
                            case 7:
                                break;

                        }
                    } while (opcionpeliculas != 7);
                    break;

                    case 5:
                         try {
                             gestorusuario.guardarUsuariosEnArchivo(usuarios, "usuarios.txt");
                              JOptionPane.showMessageDialog(null, "Usuarios guardados en 'usuarios.txt'");
                             } catch (IOException e) {
                               JOptionPane.showMessageDialog(null, "Error al guardar usuarios: " + e.getMessage());
                            }

                                JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                             break;
                    case 6:

                       // Copiamos el .wav a un .bin (simula binario)
                                try {
                                   Files.copy(Paths.get("C:\\Users\\Alejandro\\Desktop\\DAW\\DAWFLIX\\src\\model\\cancion1.wav"), Paths.get("audio.bin"));
                                     } catch (IOException e) {
                                            System.out.println("No se pudo copiar el archivo WAV: " + e.getMessage());
                                      return;
                                   }       

                              ReproductorMusica rep = new ReproductorMusica();
                              rep.reproducirWav("audio.bin");
                               break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
            }

        } while (opcionPrincipal != 5);
    }
}
