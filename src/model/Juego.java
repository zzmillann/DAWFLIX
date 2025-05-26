package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Juego extends Contenido implements InterfazReproducir, Comparable<Juego>{

    private String plataforma;
    private boolean multijugador;
  

    ArrayList<Juego> juegos = new ArrayList<>();

    private ArrayList<Comentario> comentarios;
   






    //CONSTRUCTOR

    public Juego(String titulo, String descripcion, double duracion, String genero, String plataforma,
            boolean multijugador) {
        super(titulo, descripcion, duracion, genero);
        this.plataforma = plataforma;
        this.multijugador = multijugador;
        comentarios = new ArrayList<>(); //arraylist de comentarios el cual se inicializa cada vez que creamos una serie para que esa serie tenga una seccion de comentarios
    }
    



//GETTER AND SETTER


    public String getPlataforma() {
        return plataforma;
    }


    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }


    public boolean isMultijugador() {
        return multijugador;
    }



    public void setMultijugador(boolean multijugador) {
        this.multijugador = multijugador;
    }


 public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }




    public void setComentarios(ArrayList<Comentario> comentarios) {
        this.comentarios = comentarios;
    }





    //TOSTRING


    @Override
    public String toString() {
        return "Juego [titulo= " + titulo + ", descripcion= " + descripcion + ", duracion= " + duracion + ", plataforma= "
                + plataforma + ", genero= " + genero + ", multijugador= " + multijugador + "Valoracion : " + obtenerMediaValoraciones()+ "]";
    }


























    // METODO DE LA INTERFAZ REPRODUCIR


    @Override
public void reproducir(String titulo, Usuario usuario, RegistroReproducciones registro) {
    for (Juego jue : juegos) {
        if (jue.getTitulo().equals(titulo)) {
            if (jue.getDuracion() <= 0) {
                throw new ContenidoNoDisponibleException("El juego no está disponible");
            } else {
                System.out.println("Reproduciendo: " + titulo);
                registro.registrarReproduccion(usuario, jue);
            }
        }
    }
}

    
  
//METODOS PROPIOS

public void crearJuego(String titulo, String descripcion, double duracion, String genero, String plataforma,
boolean multijugador) {

    juegos.add(new Juego( titulo,  descripcion,  duracion,  genero,  plataforma,  multijugador));


}



public void eliminarJuego(String titulo){


Iterator<Juego>iterador = juegos.iterator();


while(iterador.hasNext()){

    Juego jueg = iterador.next();

if (jueg.getTitulo().equals(titulo)) {
    iterador.remove(); 
    break; 

}


}

}

public void verJuego(){


    Collections.sort(juegos); //aqui uso el collections sort ya que en este bucle vamos a ver todos los juegos no uno en especifico
    for (Juego jueg : juegos) {
        System.out.println("[" + jueg.getTitulo() + "]");
    }
}



public void verInfo(String titulo){  // este metodo señala el ejercicio de "Buscar contenidos por palabra clave en título o descripción"

for (Juego jueg : juegos) {
    if(jueg.getTitulo().equals(titulo)){
        System.out.println(jueg.toString());

    }
}


}

    public void agregarComentario(String texto) {
        comentarios.add(new Comentario(texto));
    }

public void agregarComentarioJuego(String titulo, String texto) {
    for (Juego jueg : juegos) {
        if (jueg.getTitulo().equals(titulo)) {
            jueg.agregarComentario(texto); 
            break;
        }
    }
}

public void verComentariosJuego(String titulo) {
    for (Juego jueg : juegos) {
        if (jueg.getTitulo().equals(titulo)) {
            for (Comentario c : jueg.getComentarios()) {
                System.out.println(c.getTexto());
            }
            break;
        }
    }
}

@Override 
public void valorar(String titulo , double estrellas) {           
    for (Juego jug : juegos) {
        if (jug.getTitulo().equalsIgnoreCase(titulo)) {
            if (estrellas >= 1 && estrellas <= 5) {
                jug.valoracionesEstrellas.add(estrellas);
                System.out.println(" Valoración añadida al juego: " + titulo);
            } else {
                System.out.println(" Las estrellas deben estar entre 1 y 5.");
            }
            break;
        }
    }
}

@Override
public int compareTo(Juego jueg) {

    return this.titulo.compareToIgnoreCase(jueg.titulo);
}



}

