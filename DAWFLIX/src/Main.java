import javax.swing.JOptionPane;


public class Main {

    public void main() {

        Usuario gestorusuario = new Usuario("aaaaaaaaa", "aaaaaaaa", null );
        Juego gestorjuego = new Juego(null, null, 0, null, null, false);
        Serie gestorserie = new Serie(null, null, 0, null, 0, 0);
        Pelicula gestorpelicula = new Pelicula(null, null, 0, null, null, 0);



        int opcionPrincipal;

        do {
            String dialogo1 = JOptionPane.showInputDialog(
                    "¿QUÉ DESEA HACER?" +
                    "\n1) Gestionar Usuarios" +
                    "\n2) Gestionar Juegos" +
                    "\n3) Gestionar Series" +
                    "\n4) Gestionar Peliculas" +
                    "\n5) SALIR");

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
                                "\n5) Volver");

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
                            gestorusuario.crearUsuario(nombreusu , emailusu , suscripcionNueva );
                                break;
                            case 2:
                            String emailusu2 = JOptionPane.showInputDialog("Email usuario:");
                            gestorusuario.eliminarUsuario(emailusu2);
                                break;
                            case 3:
                            gestorusuario.verUsuarios();
                                break;
                            case 4:
                            String emailusu3 = JOptionPane.showInputDialog("Email usuario:");
                            gestorusuario.verInfo(emailusu3);
                                break;
                            case 5:
                            break;
                            
                        }
                    } while (opcionUsuarios != 5);
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


                                gestorjuego.crearJuego(titulo, descripcion, numero, genero, plataforma, valor);
                                break;
                            case 2:
                                String titulo2 = JOptionPane.showInputDialog("Título del juego");
                                gestorjuego.eliminarJuego(titulo2);
                                break;
                            case 3:
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
                                         gestorjuego.reproducir(titulo7);                  // puede lanzar ContenidoNoDisponibleException
                                    } catch (ContenidoNoDisponibleException e) {
                                         System.out.println("No se puede reproducir: " + e.getMessage());
                                    }
                                break;
                            case 9:
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

                                gestorserie.crearSerie(titulo, descripcion, numero, genero, temporadas, capitulos);
                                break;
                            case 2:
                                String titulo2 = JOptionPane.showInputDialog("Título de la Serie");
                                gestorserie.eliminarSerie(titulo2);
                                break;
                            case 3:
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
                                        gestorserie.reproducir(titulo7);                 // puede lanzar ContenidoNoDisponibleException
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

                               gestorpelicula.crearPelicula(titulo, descripcion, numero, genero, director, año);
                                break;
                            case 2:
                                String titulo2 = JOptionPane.showInputDialog("Título del juego");
                                gestorpelicula.eliminarPelicula(titulo2);
                                break;
                            case 3:
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
                                         gestorpelicula.reproducir(titulo7);                  // puede lanzar ContenidoNoDisponibleException
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
                    JOptionPane.showMessageDialog(null, "Saliendo del programa...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.");
            }

        } while (opcionPrincipal != 5);
    }
}
