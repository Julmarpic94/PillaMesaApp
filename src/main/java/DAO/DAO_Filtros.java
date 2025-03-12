package DAO;

import Modelos.Filtro;
import Modelos.Reserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DAO_Filtros {

    // ✅ Método para obtener reservas con filtros aplicados, incluyendo detalles del cliente
    public List<Reserva> obtenerReservasConFiltros(Filtro filtro) {
        String sql = "SELECT r.id, r.cliente_id, c.nombre AS cliente_nombre, c.telefono AS cliente_telefono, "
                + "r.mesa_id, r.usuario_id, r.fecha, r.hora "
                + "FROM reservas r "
                + "JOIN clientes c ON r.cliente_id = c.id "
                + "WHERE 1=1 "; // Se usa WHERE 1=1 para concatenar filtros dinámicamente

        List<Object> params = new ArrayList<>();

        if (filtro.getNombre() != null && !filtro.getNombre().isEmpty()) {
            sql += " AND c.nombre LIKE ? ";
            params.add("%" + filtro.getNombre() + "%");
        }
        if (filtro.getMesa() != null) {
            sql += " AND r.mesa_id = ? ";
            params.add(filtro.getMesa());
        }
        if (filtro.getFecha() != null) {
            sql += " AND r.fecha = ? ";
            params.add(filtro.getFecha().toString()); // Guardar como String en formato "YYYY-MM-DD"
        }
        if (filtro.getHora() != null) {
            sql += " AND r.hora = ? ";
            params.add(filtro.getHora().format(DateTimeFormatter.ofPattern("HH:mm:ss"))); // Formato compatible con SQLite
        }

        sql += " ORDER BY r.fecha ASC, r.hora ASC"; // Ordenar por fecha y hora

        List<Reserva> listaReservas = new ArrayList<>();

        try (Connection conn = ConexionSQLite.abrirConexion(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Asignar valores a los parámetros dinámicos
            for (int i = 0; i < params.size(); i++) {
                pstmt.setObject(i + 1, params.get(i));
            }

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    LocalDate fecha = null;
                    String fechaStr = rs.getString("fecha"); // SQLite almacena fechas como TEXT "YYYY-MM-DD"
                    if (fechaStr != null && !fechaStr.isEmpty()) {
                        fecha = LocalDate.parse(fechaStr);
                    }

                    LocalTime hora = null;
                    String horaStr = rs.getString("hora"); // SQLite almacena horas como TEXT "HH:mm:ss"
                    if (horaStr != null && !horaStr.isEmpty()) {
                        hora = LocalTime.parse(horaStr, DateTimeFormatter.ofPattern("HH:mm:ss"));
                    }

                    Reserva reserva = new Reserva(
                            rs.getInt("id"),
                            rs.getInt("cliente_id"),
                            rs.getString("cliente_nombre"),
                            rs.getString("cliente_telefono"),
                            rs.getInt("mesa_id"),
                            rs.getInt("usuario_id"),
                            fecha, // Fecha convertida manualmente
                            hora // Hora convertida manualmente
                    );
                    listaReservas.add(reserva);
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al obtener reservas con filtros: " + e.getMessage());
            e.printStackTrace();
        }
        return listaReservas;
    }

}
