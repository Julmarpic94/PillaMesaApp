package DAO;

import Modelos.Mesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Mesa {

    // Método para insertar una nueva mesa en la base de datos
    public void insertar(Mesa mesa) {
        String sql = "INSERT INTO mesas (capacidad, disponible) VALUES (?, ?)";

        try (Connection conn = ConexionSQLite.abrirConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(true); // Asegurar que se confirmen los cambios

            pstmt.setInt(1, mesa.getCapacidad());
            pstmt.setInt(2, mesa.isDisponible() ? 1 : 0); // SQLite usa 1 y 0 en lugar de boolean

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("✅ Mesa insertada correctamente.");
            } else {
                System.out.println("❌ No se pudo insertar la mesa.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al insertar mesa: " + e.getMessage());
        }
    }

    // Método para buscar una mesa por ID
    public Mesa encontrarPorId(int id) {
        String sql = "SELECT id, capacidad, disponible FROM mesas";
        Mesa mesa = null;

        try (Connection conn = ConexionSQLite.abrirConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    mesa = new Mesa(
                            rs.getInt("id"),
                            rs.getInt("capacidad"),
                            rs.getInt("disponible") == 1 // Convertir INTEGER a boolean
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al buscar mesa: " + e.getMessage());
        }
        return mesa;
    }

    // Método para obtener todas las mesas
    public List<Mesa> obtenerTodas() {
        String sql = "SELECT id, capacidad, disponible FROM mesas";
        List<Mesa> listaMesas = new ArrayList<>();

        try (Connection conn = ConexionSQLite.abrirConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Mesa mesa = new Mesa(
                        rs.getInt("id"),
                        rs.getInt("capacidad"),
                        rs.getInt("disponible") == 1 // Convertir INTEGER a boolean
                );
                listaMesas.add(mesa);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al obtener mesas: " + e.getMessage());
        }
        return listaMesas;
    }

    // Método para actualizar una mesa
    public void actualizar(Mesa mesa) {
        String sql = "UPDATE mesas SET capacidad = ?, disponible = ? WHERE id = ?";

        try (Connection conn = ConexionSQLite.abrirConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(true);

            pstmt.setInt(1, mesa.getCapacidad());
            pstmt.setInt(2, mesa.isDisponible() ? 1 : 0); // SQLite usa 1 y 0 para booleanos
            pstmt.setInt(3, mesa.getId());

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("✅ Mesa actualizada correctamente.");
            } else {
                System.out.println("❌ No se encontró la mesa para actualizar.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar mesa: " + e.getMessage());
        }
    }

    // Método para eliminar una mesa
    public void eliminar(int id) {
        String sql = "DELETE FROM mesas WHERE id = ?";

        try (Connection conn = ConexionSQLite.abrirConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(true);

            pstmt.setInt(1, id);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("✅ Mesa eliminada correctamente.");
            } else {
                System.out.println("❌ No se encontró la mesa para eliminar.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar mesa: " + e.getMessage());
        }
    }
}
