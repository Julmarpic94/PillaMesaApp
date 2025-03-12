package DAO;

import Modelos.Reserva;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DAO_Reserva {

    //Obtener todas las reservas con fecha y hora
    public List<Reserva> obtenerReservas() {
        String sql = "SELECT r.id, r.cliente_id, c.nombre AS nombre_cliente, c.telefono AS telefono_cliente, "
                + "r.mesa_id, r.usuario_id, r.fecha, r.hora "
                + "FROM reservas r "
                + "JOIN clientes c ON r.cliente_id = c.id "
                + "ORDER BY r.fecha ASC, r.hora ASC";

        List<Reserva> listaReservas = new ArrayList<>();

        try (Connection conn = ConexionSQLite.abrirConexion(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Reserva reserva = new Reserva(
                        rs.getInt("id"),
                        rs.getInt("cliente_id"),
                        rs.getString("nombre_cliente"),
                        rs.getString("telefono_cliente"),
                        rs.getInt("mesa_id"),
                        rs.getInt("usuario_id"),
                        rs.getDate("fecha").toLocalDate(),
                        rs.getTime("hora").toLocalTime()
                );
                listaReservas.add(reserva);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al obtener reservas: " + e.getMessage());
        }
        return listaReservas;
    }

    // Insertar una nueva reserva con fecha
    public boolean insertar(Reserva reserva) {
        String sql = "INSERT INTO reservas (cliente_id, mesa_id, usuario_id, fecha, hora) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionSQLite.abrirConexion(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            
            pstmt.setInt(1, reserva.getClienteId());
            pstmt.setInt(2, reserva.getMesaId());
            pstmt.setInt(3, reserva.getUsuarioId());
            pstmt.setString(4, reserva.getFecha().toString()); // ✅ Guardar como "YYYY-MM-DD"
            pstmt.setString(5, reserva.getHora().format(DateTimeFormatter.ofPattern("HH:mm:ss"))); // ✅ Guardar como "HH:mm:ss"

            
            int filasAfectadas = pstmt.executeUpdate();

            // Obtener la clave generada automáticamente
            if (filasAfectadas > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        reserva.setId(generatedKeys.getInt(1));
                    }
                }
            }
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al insertar reserva: " + e.getMessage());
            e.printStackTrace(); 
            return false;
        }
    }

    // Buscar una reserva por ID con fecha y hora correctamente
    public Reserva encontrarPorId(int id) {
        String sql = "SELECT r.id, r.cliente_id, c.nombre AS cliente_nombre, c.telefono AS cliente_telefono, "
                + "r.mesa_id, r.usuario_id, r.fecha, r.hora "
                + "FROM reservas r "
                + "JOIN clientes c ON r.cliente_id = c.id "
                + "WHERE r.id = ?";

        Reserva reserva = null;

        try (Connection conn = ConexionSQLite.abrirConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    reserva = new Reserva(
                            rs.getInt("id"),
                            rs.getInt("cliente_id"),
                            rs.getString("cliente_nombre"),
                            rs.getString("cliente_telefono"),
                            rs.getInt("mesa_id"),
                            rs.getInt("usuario_id"),
                            rs.getDate("fecha").toLocalDate(),
                            rs.getTime("hora").toLocalTime() 
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al buscar reserva: " + e.getMessage());
        }
        return reserva;
    }

    // Actualizar una reserva con fecha y hora correctamente
    public boolean actualizar(Reserva reserva) {
        String sql = "UPDATE reservas SET cliente_id = ?, mesa_id = ?, usuario_id = ?, fecha = ?, hora = ? WHERE id = ?";

        try (Connection conn = ConexionSQLite.abrirConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(true);

            pstmt.setInt(1, reserva.getClienteId());
            pstmt.setInt(2, reserva.getMesaId());
            pstmt.setInt(3, reserva.getUsuarioId());
            pstmt.setDate(4, Date.valueOf(reserva.getFecha()));  
            pstmt.setTime(5, Time.valueOf(reserva.getHora()));  
            pstmt.setInt(6, reserva.getId());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar reserva: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM reservas WHERE id = ?";

        try (Connection conn = ConexionSQLite.abrirConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(true);

            pstmt.setInt(1, id);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar reserva: " + e.getMessage());
            return false;
        }
    }
}
