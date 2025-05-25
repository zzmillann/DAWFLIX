import java.util.ArrayList;

public abstract class Contenido   {
    
    protected String titulo;
    protected String descripcion;
    protected double duracion;
    protected String genero;
    protected ArrayList<Double> valoracionesEstrellas = new ArrayList<>(); //arraylist ejercicio de valoraciones y hacer la media



    // EQUALS Y HASHCODE

@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        long temp;
        temp = Double.doubleToLongBits(duracion);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((genero == null) ? 0 : genero.hashCode());
        return result;
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contenido other = (Contenido) obj;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (Double.doubleToLongBits(duracion) != Double.doubleToLongBits(other.duracion))
            return false;
        if (genero == null) {
            if (other.genero != null)
                return false;
        } else if (!genero.equals(other.genero))
            return false;
        return true;
    }



    //COSNTRUCTOR

    public Contenido() {
    }



    public Contenido(String titulo, String descripcion, double duracion, String genero) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.genero = genero;
    }



    //GETTER Y SETTER
    
    public String getTitulo() {
        return titulo;
    }



    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



    public String getDescripcion() {
        return descripcion;
    }



    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public double getDuracion() {
        return duracion;
    }



    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }



    public String getGenero() {
        return genero;
    }



    public void setGenero(String genero) {
        this.genero = genero;
    }



  
// METODO EJERCICIO DAR VALORACIONES Y HACER LA MEDIA , DESPUES POLIMORFISMO EN LAS CLASES HIJAS


public void valorar(String titulo ,double estrellas) {
    if (estrellas >= 1 && estrellas <= 5) {  // ve que si el valor esta entre 1 y 5 estrelals que es lo logico mete ese valor en un array
        valoracionesEstrellas.add(estrellas);
    }
}

public double obtenerMediaValoraciones() {
    if (valoracionesEstrellas.isEmpty()){
        return 0.0;
    }                                                   // explico este metodo ,  va recorriendo el array de estreallas y creo una variable vacia la cual suma todas las estrellas y lueg0
    double suma = 0.0;                                  //  retorna la suma entre el numero de datos que ha nsido insertados en el array 
 
    for (double v : valoracionesEstrellas) {
        suma += v;
    }

    return  suma / valoracionesEstrellas.size();

}



public ArrayList<Contenido> recomendarPorGeneroYValoracion(Contenido referencia, ArrayList<Contenido> contenidos) {
    String generoObjetivo = referencia.getGenero();
    
    ArrayList<Contenido> mismosGenero = new ArrayList<>();
    for (Contenido c : contenidos) {

        if (!c.equals(referencia) && c.getGenero().equalsIgnoreCase(generoObjetivo)) {
            mismosGenero.add(c);
        }
    }

    // Ordenar por valoración media descendente
    mismosGenero.sort((c1, c2) -> Double.compare(c2.obtenerMediaValoraciones(), c1.obtenerMediaValoraciones()));

    return mismosGenero;
}








}
