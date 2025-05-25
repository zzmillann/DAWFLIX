import java.util.ArrayList;
import java.util.Iterator;

public class Pelicula extends Contenido implements InterfazReproducir {
    


private String director;
private int año;




ArrayList<Pelicula> peliculas = new ArrayList<>();



//CONSTRUCTOR SOBRECARGADO


public Pelicula(String titulo, String descripcion, double duracion, String genero, String director, int año) {
    super(titulo, descripcion, duracion, genero);
    this.director = director;
    this.año = año;
}



//GETTERS AND SETTERS

public String getDirector() {
    return director;
}

public void setDirector(String director) {
    this.director = director;
}

public int getAño() {
    return año;
}

public void setAño(int año) {
    this.año = año;
}


//TOSTRING

@Override
public String toString() {
    return "Pelicula [titulo=" + titulo + ", descripcion=" + descripcion + ", duracion=" + duracion + ", director="
            + director + ", genero=" + genero + ", año=" + año + "Valoracion = " + obtenerMediaValoraciones() + "]";
}



//METODO DE LA INTERFAZ REPRODUCIR


    @Override
public void reproducir(String titulo, Usuario usuario, RegistroReproducciones registro) {
    for (Pelicula se : peliculas) {
        if (se.getTitulo().equals(titulo)) {
            if (se.getDuracion() <= 0) {
                throw new ContenidoNoDisponibleException("El juego no está disponible");
            } else {
                System.out.println("Reproduciendo: " + titulo);
                registro.registrarReproduccion(usuario, se);
            }
        }
    }
}

    




//METODOS PROPIOS

public void crearPelicula(String titulo, String descripcion, double duracion, String genero, String director, int año) {

    peliculas.add(new Pelicula(titulo, descripcion, duracion, genero, director, año));


}



public void eliminarPelicula(String titulo){


Iterator<Pelicula>iterador = peliculas.iterator();


while(iterador.hasNext()){

Pelicula peli = iterador.next();

if (peli.getTitulo().equals(titulo)) {
    iterador.remove(); 
    break; 

}


}

}

public void verPeliculas(){



    for (Pelicula pelicula : peliculas) {
        System.out.println("[" + pelicula.titulo + "]");
    }
}



public void verInfo(String titulo) throws ContenidoNoDisponibleException{  // este metodo señala el ejercicio de "Buscar contenidos por palabra clave en título o descripción"

for (Pelicula pelicula : peliculas) {
    if(pelicula.getTitulo().equals(titulo)){
        System.out.println(pelicula.toString());
    }else{
        throw new ContenidoNoDisponibleException("No se encuentra la pelicula buscada");  //si no encuentra una pelicula con el titulo indicado lanzara la excepcion
    }
}



}


@Override 
public void valorar(String titulo , double estrellas) {           
    for (Pelicula pel : peliculas) {
        if (pel.getTitulo().equalsIgnoreCase(titulo)) {
            if (estrellas >= 1 && estrellas <= 5) {
                pel.valoracionesEstrellas.add(estrellas);
                System.out.println(" Valoración añadida al juego: " + titulo);
            } else {
                System.out.println(" Las estrellas deben estar entre 1 y 5.");
            }
            break;
        }
    }
}





}
