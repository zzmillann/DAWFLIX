package dao;

import db.DBConnection;
import model.Suscripcion;
import model.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UsuarioDAO {

    // Insertar usuario
    public void insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, email, tipo_suscripcion, precio_suscripcion) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSuscripcion().getTipo());
            stmt.setDouble(4, usuario.getSuscripcion().getPrecio());
           

            stmt.executeUpdate();
            System.out.println("Usuario insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Obtener todos los usuarios
    public List<Usuario> obtenerTodosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String email = rs.getString("email");
                String tipoSuscripcion = rs.getString("tipo_suscripcion");
                double precioSuscripcion = rs.getDouble("precio_suscripcion");
                String favoritosStr = rs.getString("favoritos");
                String estoyViendoStr = rs.getString("estoy_viendo");

                Suscripcion suscripcion = new Suscripcion(tipoSuscripcion, precioSuscripcion);

                Set<String> favoritos = new HashSet<>();
                if (favoritosStr != null && !favoritosStr.isEmpty()) {
                    String[] favArray = favoritosStr.split(",");
                    for (String f : favArray) favoritos.add(f.trim());
                }

                Set<String> estoyViendo = new HashSet<>();
                if (estoyViendoStr != null && !estoyViendoStr.isEmpty()) {
                    String[] viendoArray = estoyViendoStr.split(",");
                    for (String v : viendoArray) estoyViendo.add(v.trim());
                }

                Usuario usuario = new Usuario(nombre, email, suscripcion);
                usuario.setFavoritos(favoritos);
                usuario.setEstoyViendo(estoyViendo);

                usuarios.add(usuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

    // Eliminar usuario por email
    public void eliminarUsuario(String email) {
        String sql = "DELETE FROM usuarios WHERE email = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Usuario eliminado correctamente.");
            } else {
                System.out.println("No se encontró usuario con ese email.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Actualizar usuario (nombre, suscripción, favoritos, estoyViendo) según email
    public void actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, tipo_suscripcion = ?, precio_suscripcion = ?, favoritos = ?, estoy_viendo = ? WHERE email = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNombre());
            stmt.setString(2, usuario.getSuscripcion().getTipo());
            stmt.setDouble(3, usuario.getSuscripcion().getPrecio());
            stmt.setString(4, String.join(",", usuario.getFavoritos()));
            stmt.setString(5, String.join(",", usuario.getEstoyViendo()));
            stmt.setString(6, usuario.getEmail());

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Usuario actualizado correctamente.");
            } else {
                System.out.println("No se encontró usuario con ese email.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Buscar usuario por email
    public Usuario buscarUsuarioPorEmail(String email) {
        String sql = "SELECT * FROM usuarios WHERE email = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String tipoSuscripcion = rs.getString("tipo_suscripcion");
                    double precioSuscripcion = rs.getDouble("precio_suscripcion");
                    String favoritosStr = rs.getString("favoritos");
                    String estoyViendoStr = rs.getString("estoy_viendo");

                    Suscripcion suscripcion = new Suscripcion(tipoSuscripcion, precioSuscripcion);

                    Set<String> favoritos = new HashSet<>();
                    if (favoritosStr != null && !favoritosStr.isEmpty()) {
                        String[] favArray = favoritosStr.split(",");
                        for (String f : favArray) favoritos.add(f.trim());
                    }

                    Set<String> estoyViendo = new HashSet<>();
                    if (estoyViendoStr != null && !estoyViendoStr.isEmpty()) {
                        String[] viendoArray = estoyViendoStr.split(",");
                        for (String v : viendoArray) estoyViendo.add(v.trim());
                    }

                    Usuario usuario = new Usuario(nombre, email, suscripcion);
                    usuario.setFavoritos(favoritos);
                    usuario.setEstoyViendo(estoyViendo);
                    return usuario;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



public void registrarReproduccion(String emailUsuario, String tituloContenido) {
    String sql = "INSERT INTO reproducciones (email_usuario, titulo_contenido) VALUES (?, ?)";
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, emailUsuario);
        stmt.setString(2, tituloContenido);
        stmt.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}





 public void mostrarContenidosMasReproducidosPorUsuario() {
        String sql = "SELECT email_usuario, titulo_contenido, COUNT(*) AS total_reproducciones " +
                     "FROM reproducciones " +
                     "GROUP BY email_usuario, titulo_contenido " +
                     "ORDER BY email_usuario, total_reproducciones DESC";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String emailUsuario = rs.getString("email_usuario");
                String tituloContenido = rs.getString("titulo_contenido");
                int totalReproducciones = rs.getInt("total_reproducciones");

                System.out.println("Usuario: " + emailUsuario + ", Contenido: " + tituloContenido + ", Reproducciones: " + totalReproducciones);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
