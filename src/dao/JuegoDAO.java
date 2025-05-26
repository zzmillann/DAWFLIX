package dao;

import db.DBConnection;
import model.Juego;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JuegoDAO {

    public void insertarJuego(Juego juego) {
        String sql = "INSERT INTO juegos (titulo, descripcion, duracion, genero, plataforma, multijugador) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, juego.getTitulo());
            stmt.setString(2, juego.getDescripcion());
            stmt.setDouble(3, juego.getDuracion());
            stmt.setString(4, juego.getGenero());
            stmt.setString(5, juego.getPlataforma());
            stmt.setBoolean(6, juego.isMultijugador());

            stmt.executeUpdate();
            System.out.println("Juego insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Juego> obtenerTodosJuegos() {
        List<Juego> juegos = new ArrayList<>();
        String sql = "SELECT * FROM juegos";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Juego juego = new Juego(
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getDouble("duracion"),
                        rs.getString("genero"),
                        rs.getString("plataforma"),
                        rs.getBoolean("multijugador")
                );
                juegos.add(juego);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return juegos;
    }

    public void eliminarJuego(String titulo) {
        String sql = "DELETE FROM juegos WHERE titulo = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, titulo);
            stmt.executeUpdate();
            System.out.println("Juego eliminado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public void actualizarJuego(Juego juego) {
    String sql = "UPDATE juegos SET descripcion = ?, duracion = ?, genero = ?, plataforma = ?, multijugador = ? WHERE titulo = ?";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, juego.getDescripcion());
        stmt.setDouble(2, juego.getDuracion());
        stmt.setString(3, juego.getGenero());
        stmt.setString(4, juego.getPlataforma());
        stmt.setBoolean(5, juego.isMultijugador());
        stmt.setString(6, juego.getTitulo()); // WHERE título = ?

        int filas = stmt.executeUpdate();

        if (filas > 0) {
            System.out.println("Juego actualizado correctamente.");
        } else {
            System.out.println("No se encontró ningún juego con ese título.");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
