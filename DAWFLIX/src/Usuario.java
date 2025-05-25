import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Usuario {
    
private String nombre;
private String email;
Suscripcion suscripcion;
private Set<String> favoritos ;
private Set<String> estoyViendo ;
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
    this.favoritos = new HashSet<>();
    this.estoyViendo = new HashSet<>();
    this.usuarios = new ArrayList<>();
}


//GETTERS AND SETTERS


public String getNombre() {
    return nombre;
}

public void setUsuarios(ArrayList<Usuario> usuarios) {
    this.usuarios = usuarios;
}


public void setNombre(String nombre) {
    this.nombre = nombre;
}

public Set<String> getFavoritos() {
    return favoritos;
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







public void setFavoritos(Set<String> favoritos) {
    this.favoritos = favoritos;
}




public Set<String> getEstoyViendo() {
    return estoyViendo;
}




public void setEstoyViendo(Set<String> estoyViendo) {
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







public void agreagarFavorito(String nombre) throws ContenidoNoDisponibleException{

    if(favoritos.contains(nombre)){
        throw new ContenidoNoDisponibleException("El contenido ya esta añadido a favoritos"); // Si se intenta insertyar una pelicula que ya estaba anteriormente añadida a favoritos lanzará la excepcion
    }else{
    favoritos.add(nombre);
    }
}

public void eliminarFavorito(String c) {
    favoritos.remove(c);
}


public void agregarEstoyViendo(String c){

    estoyViendo.add(c);
}




public void elimianrEstoyViendo(String c){

    estoyViendo.remove(c);
}



public void cambiarSuscripcion(String tipo){
    
    this.getSuscripcion().setTipo(tipo);

}



 public void guardarUsuariosEnArchivo(List<Usuario> usuarios, String rutaArchivo) throws IOException {
    List<String> lineas = usuarios.stream()
        .map(u -> {
            String favoritos = String.join(",", u.getFavoritos());
            String viendo = String.join(",", u.getEstoyViendo());
            return u.getEmail() + "|" + favoritos + "|" + viendo;
        })
        .collect(Collectors.toList());

    Path path = Paths.get(rutaArchivo);
    Files.write(path, lineas);
}






public void cargarUsuariosDesdeArchivo(List<Usuario> usuarios, String rutaArchivo) throws IOException {
    Path path = Paths.get(rutaArchivo);
    if (!Files.exists(path)) return; // Si no existe el archivo, no hacer nada

    List<String> lineas = Files.readAllLines(path);

    for (String linea : lineas) {
        String[] partes = linea.split("\\|");
        if (partes.length >= 3) {
            String email = partes[0];
            String[] favoritosArray = partes[1].isEmpty() ? new String[0] : partes[1].split(",");
            String[] viendoArray = partes[2].isEmpty() ? new String[0] : partes[2].split(",");

            Usuario usuario = buscarUsuarioPorEmail(usuarios, email);
            if (usuario != null) {
                usuario.setFavoritos(new HashSet<>(List.of(favoritosArray)));
                usuario.setEstoyViendo(new HashSet<>(List.of(viendoArray)));
            }
        }
    }
}

// Método para buscar usuario en la lista por email
public Usuario buscarUsuarioPorEmail(List<Usuario> usuarios, String email) {
    for (Usuario u : usuarios) {
        if (u.getEmail().equals(email)) return u;
    }
    return null;
}


}
