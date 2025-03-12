package DAO;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQLite {

    // Nombre del archivo de la base de datos
    private static final String DB_NAME = "restaurante"; 

    // Obtiene la ruta absoluta de la base de datos en la misma carpeta que el ejecutable
    private static final String DB_PATH = new File(DB_NAME).getAbsolutePath();

    // URL de conexión a SQLite
    private static final String URL = "jdbc:sqlite:" + DB_PATH;

    // Método para abrir la conexión a la base de datos
    public static Connection abrirConexion() {
        Connection conexion = null;
        try {
            // Registrar el driver de SQLite
            Class.forName("org.sqlite.JDBC");

            // Establecer la conexión
            conexion = DriverManager.getConnection(URL);
            System.out.println("✅ Conexión establecida con SQLite en: " + DB_PATH);

        } catch (ClassNotFoundException e) {
            System.err.println("❌ Error: No se encontró el driver de SQLite.");
        } catch (SQLException e) {
            System.err.println("❌ Error al conectar a SQLite: " + e.getMessage());
        }
        return conexion;
    }

    // Método para cerrar la conexión
    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("✅ Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.err.println("❌ Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}
