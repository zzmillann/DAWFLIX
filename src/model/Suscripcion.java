package model;

import java.util.ArrayList;

public class Suscripcion {


 private String tipo;
    private double precio;
    ArrayList<Suscripcion> suscripciones = new ArrayList<>();





    //CONSTRUCTOR DE LA COMPOSICION
    public Suscripcion(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }


    // GETTERS AND SETTERS

    
    public String getTipo() {
        return tipo;
    }



    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    public double getPrecio() {
        return precio;
    }



    public void setPrecio(double precio) {
        this.precio = precio;
    }



  

    //TOSTRING
    
    @Override
    public String toString() {
        return "Suscripcion [tipo=" + tipo + ", precio=" + precio + "]";
    }


    public void crearSuscripcion(String tipo, double precio){

        suscripciones.add(new Suscripcion(tipo, precio) );

    }



    public void crearSuscripciones(String tipo, Double precio){

        suscripciones.add(new Suscripcion(tipo, precio));
    }






}







