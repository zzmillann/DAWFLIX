import java.util.ArrayList;
import java.util.Iterator;

public class Usuario {
    
private String nombre;
private String email;
Suscripcion suscripcion;
private ArrayList<Contenido> favoritos;
private ArrayList<Contenido> estoyViendo;
ArrayList<Usuario> usuarios;





//EQUALS Y HASHCODE



@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((suscripcion == null) ? 0 : suscripcion.hashCode());
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
    Usuario other = (Usuario) obj;
    if (nombre == null) {
        if (other.nombre != null)
            return false;
    } else if (!nombre.equals(other.nombre))
        return false;
    if (email == null) {
        if (other.email != null)
            return false;
    } else if (!email.equals(other.email))
        return false;
    if (suscripcion == null) {
        if (other.suscripcion != null)
            return false;
    } else if (!suscripcion.equals(other.suscripcion))
        return false;
    return true;
}







//CONSTRUCTOR



public Usuario(String nombre, String email, Suscripcion suscripcion) {
    this.nombre = nombre;
    this.email = email;
    this.suscripcion = suscripcion;
    this.favoritos = new ArrayList<>();
    this.estoyViendo = new ArrayList<>();
    this.usuarios = new ArrayList<>();
}


//GETTERS AND SETTERS


public String getNombre() {
    return nombre;
}




public void setNombre(String nombre) {
    this.nombre = nombre;
}




public String getEmail() {
    return email;
}




public void setEmail(String email) {
    this.email = email;
}




public Suscripcion getSuscripcion() {
    return suscripcion;
}




public void setSuscripcion(Suscripcion suscripcion) {
    this.suscripcion = suscripcion;
}




public ArrayList<Contenido> getFavoritos() {
    return favoritos;
}




public void setFavoritos(ArrayList<Contenido> favoritos) {
    this.favoritos = favoritos;
}




public ArrayList<Contenido> getEstoyViendo() {
    return estoyViendo;
}




public void setEstoyViendo(ArrayList<Contenido> estoyViendo) {
    this.estoyViendo = estoyViendo;
}



//TOSTRING

@Override
public String toString() {
    return "Usuario [nombre=" + nombre + ", email=" + email + ", suscripcion=" + suscripcion + "]";
}




//METODOS

public void crearUsuario(String nombre, String email, Suscripcion suscripcion){
    usuarios.add(new Usuario(nombre, email, suscripcion));
}

public void eliminarUsuario(String email){


    Iterator<Usuario>iterador = usuarios.iterator();
    
    
    while(iterador.hasNext()){
    
    Usuario usu = iterador.next();
    
    if (usu.getEmail().equals(email)) {
        iterador.remove(); 
        break; 
    
    }
    
    
    }
    
    }


public void verUsuarios(){

    for (Usuario usu : usuarios) {
        System.out.println("Nombre : ["+usu.getNombre()+"]" + "Correo electrónico : ["+usu.getEmail()+"]");
    }


}

public void verInfo(String email){ // este metodo señala el ejercicio de "Buscar contenidos por palabra clave en título o descripción"

for (Usuario usu : usuarios) {
    if(usu.getEmail().equals(email)){
        System.out.println(usu.toString());
    }
}


}







public void agreagarFavorito(Contenido c) throws ContenidoNoDisponibleException{

    if(favoritos.contains(c)){
        throw new ContenidoNoDisponibleException("El contenido ya esta añadido a favoritos"); // Si se intenta insertyar una pelicula que ya estaba anteriormente añadida a favoritos lanzará la excepcion
    }else{
    favoritos.add(c);
    }
}

public void eliminarFavorito(Contenido c) {
    favoritos.remove(c);
}


public void agregarEstoyViendo(Contenido c){

    estoyViendo.add(c);
}




public void elimianrEstoyViendo(Contenido c){

    estoyViendo.remove(c);
}



public void cambiarSuscripcion(String tipo){
    
    this.getSuscripcion().setTipo(tipo);

}



 



}
