import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Serie extends Contenido implements InterfazReproducir, Comparable<Serie> {
    


private int temporadas;
private int capitulos;



private ArrayList<Comentario> comentarios;
ArrayList<Serie> series = new ArrayList<>();


//CONSTRUCTOR SOBRECARGADO

public Serie(String titulo, String descripcion, double duracion, String genero, int temporadas, int capitulos) {
    super(titulo, descripcion, duracion, genero);
    this.temporadas = temporadas;
    this.capitulos = capitulos;
    comentarios = new ArrayList<>(); //arraylist de comentarios el cual se inicializa cada vez que creamos una serie para que esa serie tenga una seccion de comentarios
}



//GETTERS AND SETTERS


public int getTemporadas() {
    return temporadas;
}
public void setTemporadas(int temporadas) {
    this.temporadas = temporadas;
}
public int getCapitulos() {
    return capitulos;
}
public void setCapitulos(int capitulos) {
    this.capitulos = capitulos;
}

//TOSTRING

@Override
public String toString() {
    return "Serie [titulo=" + titulo + ", descripcion=" + descripcion + ", duracion=" + duracion + ", temporadas="
            + temporadas + ", genero=" + genero + ", capitulos=" + capitulos + "Valoracion =" + obtenerMediaValoraciones() + "]";
}







//METODO DE LA INTERFAZ REPRODUCIR



    @Override
public void reproducir(String titulo, Usuario usuario, RegistroReproducciones registro) {
    for (Serie se : series) {
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

public void crearSerie(String titulo, String descripcion, double duracion, String genero, int temporadas, int capitulos) {

    series.add(new Serie( titulo,  descripcion,  duracion,  genero,  temporadas,  capitulos));


}



public void eliminarSerie(String titulo){


Iterator<Serie>iterador = series.iterator();


while(iterador.hasNext()){

Serie seriet = iterador.next();

if (seriet.getTitulo().equals(titulo)) {
    iterador.remove(); 
    break; 

}


}

}

public void verSerie(){

    Collections.sort(series); //aqui uso el collections sort ya que en este bucle vamos a ver todas las series no una en especifico

    for (Serie ser : series) {
        System.out.println("[" + ser.getTitulo() + "]");
    }
}



public void verInfo(String titulo){ // este metodo señala el ejercicio de "Buscar contenidos por palabra clave en título o descripción"

for (Serie ser : series) {
    if(ser.getTitulo().equals(titulo)){
        System.out.println(ser.toString());
    }
}


}


public void agregarComentarioSerie(String titulo, String texto){

    for ( Serie ser : series) {
        if(ser.getTitulo().equals(titulo)){
            ser.comentarios.add(new Comentario(texto));
        }
    }



}


public void verComentariosSerie(String titulo) {
    for (Serie ser : series) {
        if (ser.getTitulo().equals(titulo)) {
            for (Comentario c : ser.comentarios) {
                System.out.println(c.getTexto());
            }
        }
    }
}



@Override
public int compareTo(Serie serie) {
    
    return this.titulo.compareToIgnoreCase(serie.titulo);
}



@Override 
public void valorar(String titulo , double estrellas) {           
    for (Serie ser : series) {
        if (ser.getTitulo().equalsIgnoreCase(titulo)) {
            if (estrellas >= 1 && estrellas <= 5) {
                ser.valoracionesEstrellas.add(estrellas);
                System.out.println(" Valoración añadida al juego: " + titulo);
            } else {
                System.out.println(" Las estrellas deben estar entre 1 y 5.");
            }
            break;
        }
    }
}





}
