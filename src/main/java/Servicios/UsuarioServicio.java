package Servicios;

import DAO.DAO_Usuario;
import Modelos.Usuario;
import java.util.List;

public class UsuarioServicio {

    private final DAO_Usuario daoUsuario;

    public UsuarioServicio() {
        this.daoUsuario = new DAO_Usuario();
    }

    // ✅ Registrar un nuevo usuario (evita duplicados)
    public boolean registrarUsuario(Usuario usuario) {
        if (daoUsuario.encontrarPorUsuario(usuario.getUsuario()) != null) {
            System.out.println("❌ Error: El usuario ya existe.");
            return false;
        }
        daoUsuario.insertar(usuario);
        return true;
    }

    // ✅ Obtener usuario por ID o nombre de usuario
    public Usuario obtenerUsuarioPorId(int id) {
        return daoUsuario.encontrarPorId(id);
    }

    public Usuario obtenerUsuarioPorNombre(String username) {
        return daoUsuario.encontrarPorUsuario(username);
    }

    // ✅ Obtener todos los usuarios en List o Object[][]
    public List<Usuario> listarUsuarios() {
        return daoUsuario.obtenerTodos();
    }

    public Object[][] obtenerTodosLosUsuarios() {
        return convertirListaAArray(daoUsuario.obtenerTodos());
    }

    // ✅ Insertar o actualizar un usuario
    public void insertar(String nombre, String usuario, String contrasena, String rol) {
        daoUsuario.insertar(new Usuario(0, nombre, usuario, contrasena, rol));
    }

    public void actualizar(int id, String nombre, String usuario, String contrasena, String rol) {
        daoUsuario.actualizar(new Usuario(id, nombre, usuario, contrasena, rol));
    }

    // ✅ Eliminar usuario si existe
    public boolean eliminarUsuario(int id) {
        if (daoUsuario.encontrarPorId(id) == null) {
            System.out.println("❌ Error: No se encontró el usuario.");
            return false;
        }
        daoUsuario.eliminar(id);
        return true;
    }

    // ✅ Convertir List<Usuario> a Object[][] (Para Tablas)
    private Object[][] convertirListaAArray(List<Usuario> listaUsuarios) {
        return listaUsuarios.stream()
                .map(u -> new Object[]{u.getId(), u.getNombre(), u.getUsuario(), u.getContrasena(), u.getRol()})
                .toArray(Object[][]::new);
    }
}
