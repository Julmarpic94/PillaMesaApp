package DAO;

import Modelos.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Cliente {

    // Método para insertar un cliente en la base de datos
    public void insertar(Cliente cliente) {
        String sql = "INSERT INTO clientes (nombre, telefono, email) VALUES (?, ?, ?)";
        try (Connection conn = ConexionSQLite.abrirConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(true); // Asegurar que se confirmen los cambios

            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getTelefono());
            pstmt.setString(3, cliente.getEmail());

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("✅ Cliente insertado correctamente.");
            } else {
                System.out.println("❌ No se pudo insertar el cliente.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al insertar cliente: " + e.getMessage());
        }
    }

    // Método para buscar un cliente por ID
    public Cliente encontrarPorId(int id) {
        String sql = "SELECT id, nombre, telefono, email FROM clientes WHERE id = ?";
        Cliente cliente = null;

        try (Connection conn = ConexionSQLite.abrirConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("telefono"),
                            rs.getString("email")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al buscar cliente: " + e.getMessage());
        }
        return cliente;
    }

    // Método para obtener todos los clientes
    public List<Cliente> obtenerTodos() {
        String sql = "SELECT id, nombre, telefono, email FROM clientes";
        List<Cliente> listaClientes = new ArrayList<>();

        try (Connection conn = ConexionSQLite.abrirConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("email")
                );
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al obtener clientes: " + e.getMessage());
        }
        return listaClientes;
    }

    // Método para actualizar un cliente
    public void actualizar(Cliente cliente) {
        String sql = "UPDATE clientes SET nombre = ?, telefono = ?, email = ? WHERE id = ?";
        try (Connection conn = ConexionSQLite.abrirConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(true);

            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getTelefono());
            pstmt.setString(3, cliente.getEmail());
            pstmt.setInt(4, cliente.getId());

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("✅ Cliente actualizado correctamente.");
            } else {
                System.out.println("❌ No se encontró el cliente para actualizar.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar cliente: " + e.getMessage());
        }
    }

    // Método para eliminar un cliente
    public void eliminar(int id) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (Connection conn = ConexionSQLite.abrirConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(true);

            pstmt.setInt(1, id);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("✅ Cliente eliminado correctamente.");
            } else {
                System.out.println("❌ No se encontró el cliente para eliminar.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar cliente: " + e.getMessage());
        }
    }
}
