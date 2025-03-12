package DAO;

import Modelos.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO_Usuario {

    // ✅ Insertar un usuario en la base de datos
    public void insertar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, usuario, contrasena, rol) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionSQLite.abrirConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(true); // Confirmar cambios en SQLite

            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getUsuario());
            pstmt.setString(3, usuario.getContrasena()); // Se recomienda encriptar en producción
            pstmt.setString(4, usuario.getRol());

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("✅ Usuario insertado correctamente.");
            } else {
                System.out.println("❌ No se pudo insertar el usuario.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al insertar usuario: " + e.getMessage());
        }
    }

    // ✅ Buscar un usuario por ID
    public Usuario encontrarPorId(int id) {
        String sql = "SELECT id, nombre, usuario, contrasena, rol FROM usuarios WHERE id = ?";
        Usuario usuario = null;

        try (Connection conn = ConexionSQLite.abrirConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("usuario"),
                            rs.getString("contrasena"),
                            rs.getString("rol")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al buscar usuario: " + e.getMessage());
        }
        return usuario;
    }

    // ✅ Obtener todos los usuarios
    public List<Usuario> obtenerTodos() {
        String sql = "SELECT id, nombre, usuario, contrasena, rol FROM usuarios";
        List<Usuario> listaUsuarios = new ArrayList<>();

        try (Connection conn = ConexionSQLite.abrirConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Usuario usuario = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("usuario"),
                        rs.getString("contrasena"),
                        rs.getString("rol")
                );
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al obtener usuarios: " + e.getMessage());
        }
        return listaUsuarios;
    }

    // ✅ Actualizar un usuario
    public void actualizar(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, usuario = ?, contrasena = ?, rol = ? WHERE id = ?";

        try (Connection conn = ConexionSQLite.abrirConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(true);

            pstmt.setString(1, usuario.getNombre());
            pstmt.setString(2, usuario.getUsuario());
            pstmt.setString(3, usuario.getContrasena()); // Se recomienda encriptar en producción
            pstmt.setString(4, usuario.getRol());
            pstmt.setInt(5, usuario.getId());

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("✅ Usuario actualizado correctamente.");
            } else {
                System.out.println("❌ No se encontró el usuario para actualizar.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al actualizar usuario: " + e.getMessage());
        }
    }

    // ✅ Eliminar un usuario por ID
    public void eliminar(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";

        try (Connection conn = ConexionSQLite.abrirConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(true);

            pstmt.setInt(1, id);
            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("✅ Usuario eliminado correctamente.");
            } else {
                System.out.println("❌ No se encontró el usuario para eliminar.");
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al eliminar usuario: " + e.getMessage());
        }
    }

    // ✅ Buscar un usuario por nombre de usuario (para autenticación)
    public Usuario encontrarPorUsuario(String username) {
        String sql = "SELECT id, nombre, usuario, contrasena, rol FROM usuarios WHERE usuario = ?";
        Usuario usuario = null;

        try (Connection conn = ConexionSQLite.abrirConexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario(
                            rs.getInt("id"),
                            rs.getString("nombre"),
                            rs.getString("usuario"),
                            rs.getString("contrasena"),
                            rs.getString("rol")
                    );
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al buscar usuario por nombre: " + e.getMessage());
        }
        return usuario;
    }
}
