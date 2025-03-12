package Controlador;

import Modelos.Usuario;
import Servicios.UsuarioServicio;

public class ControladorUsuario {

    private final UsuarioServicio usuarioServicio;

    public ControladorUsuario() {
        this.usuarioServicio = new UsuarioServicio();
    }

    // ✅ Iniciar sesión y devolver el rol del usuario
    public String iniciarSesion(String username, String contrasena) {
        if (!validarCampos(username, contrasena)) {
            return null;
        }

        Usuario usuario = usuarioServicio.obtenerUsuarioPorNombre(username);
        if (usuario == null || !usuario.getContrasena().equals(contrasena)) {
            System.out.println("❌ Error: Usuario o contraseña incorrectos.");
            return null;
        }

        System.out.println("✅ Usuario autenticado correctamente. Rol: " + usuario.getRol());
        return usuario.getRol();
    }

    // ✅ Validar que los campos no estén vacíos
    private boolean validarCampos(String username, String contrasena) {
        return username != null && !username.trim().isEmpty()
                && contrasena != null && !contrasena.trim().isEmpty();
    }

    // ✅ Registrar un usuario
    public boolean registrarUsuario(Usuario usuario) {
        return usuarioServicio.registrarUsuario(usuario);
    }

    // ✅ Obtener usuario por ID
    public Usuario obtenerUsuarioPorId(int id) {
        return usuarioServicio.obtenerUsuarioPorId(id);
    }

    // ✅ Eliminar usuario por ID
    public boolean eliminarUsuario(int id) {
        return usuarioServicio.eliminarUsuario(id);
    }

    // ✅ Obtener lista de usuarios en formato Object[][] para tablas
    public Object[][] obtenerDatosUsuarios() {
        return usuarioServicio.obtenerTodosLosUsuarios();
    }

    public void actualizarUsuario(int id, String nombre, String usuario, String contrasena, String rol) {
        usuarioServicio.actualizar(id, nombre, usuario, contrasena, rol);

    }

}
