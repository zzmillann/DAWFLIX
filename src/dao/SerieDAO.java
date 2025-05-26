package dao;

import db.DBConnection;
import model.Serie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SerieDAO {

    public void insertarSerie(Serie serie) {
        String sql = "INSERT INTO series (titulo, descripcion, duracion, genero, temporadas, capitulos) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, serie.getTitulo());
            stmt.setString(2, serie.getDescripcion());
            stmt.setDouble(3, serie.getDuracion());
            stmt.setString(4, serie.getGenero());
            stmt.setInt(5, serie.getTemporadas());
            stmt.setInt(6, serie.getCapitulos());

            stmt.executeUpdate();
            System.out.println("Serie insertada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Serie> obtenerTodasSeries() {
        List<Serie> series = new ArrayList<>();
        String sql = "SELECT * FROM series";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Serie serie = new Serie(
                        rs.getString("titulo"),
                        rs.getString("descripcion"),
                        rs.getDouble("duracion"),
                        rs.getString("genero"),
                        rs.getInt("temporadas"),
                        rs.getInt("capitulos")
                );
                series.add(serie);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return series;
    }

    public void eliminarSerie(String titulo) {
        String sql = "DELETE FROM series WHERE titulo = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, titulo);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Serie eliminada correctamente.");
            } else {
                System.out.println("No se encontró ninguna serie con ese título.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarSerie(Serie serie) {
        String sql = "UPDATE series SET descripcion = ?, duracion = ?, genero = ?, temporadas = ?, capitulos = ? WHERE titulo = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, serie.getDescripcion());
            stmt.setDouble(2, serie.getDuracion());
            stmt.setString(3, serie.getGenero());
            stmt.setInt(4, serie.getTemporadas());
            stmt.setInt(5, serie.getCapitulos());
            stmt.setString(6, serie.getTitulo());

            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("Serie actualizada correctamente.");
            } else {
                System.out.println("No se encontró ninguna serie con ese título.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
