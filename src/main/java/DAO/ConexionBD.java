/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD {
    // Parámetros de conexión a la base de datos
    private static final String URL = "jdbc:mariadb://localhost:3307/restaurante";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "julian";

    // Método para abrir la conexión
    public static Connection abrirConexion() {
        Connection conexion = null;
        try {
            // Registrar el driver de MariaDB
            Class.forName("org.mariadb.jdbc.Driver");

            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("✅ Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Error: No se encontró el driver de MariaDB.");
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar a la base de datos: " + e.getMessage());
        }
        return conexion;
    }

    // Método para cerrar la conexión
    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("🔌 Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.err.println("❌ Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }

}

