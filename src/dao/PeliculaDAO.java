package dao;

import db.DBConnection;
import model.Pelicula;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {

    public void insertarPelicula(Pelicula pelicula) {
        String sql = "INSERT INTO peliculas (titulo, descripcion, duracion, genero, director, año) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pelicula.getTitulo());
            stmt.setString(2, pelicula.getDescripcion());
            stmt.setDouble(3, pelicula.getDuracion());
            stmt.setString(4, pelicula.getGenero());
            stmt.setString(5, pelicula.getDirector());
            stmt.setInt(6, pelicula.getAño());

            stmt.executeUpdate();
            System.out.println("Pelicula insertada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pelicula> obtenerTodasPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        String sql = "SELECT * FROM peliculas";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pelicula pelicula = new Pelicula(
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getDouble("duracion"),
                        rs.getString("genero"),
                        rs.getString("director"),
                        rs.getInt("año")
                );
                peliculas.add(pelicula);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return peliculas;
    }

    public void eliminarPelicula(String titulo) {
        String sql = "DELETE FROM peliculas WHERE titulo = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, titulo);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Pelicula eliminada correctamente.");
            } else {
                System.out.println("No se encontró ninguna película con ese título.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarPelicula(Pelicula pelicula) {
        String sql = "UPDATE peliculas SET descripcion = ?, duracion = ?, genero = ?, director = ?, año = ? WHERE titulo = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pelicula.getDescripcion());
            stmt.setDouble(2, pelicula.getDuracion());
            stmt.setString(3, pelicula.getGenero());
            stmt.setString(4, pelicula.getDirector());
            stmt.setInt(5, pelicula.getAño());
            stmt.setString(6, pelicula.getTitulo());

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Pelicula actualizada correctamente.");
            } else {
                System.out.println("No se encontró ninguna película con ese título.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
