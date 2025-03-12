package Servicios;

import DAO.DAO_Cliente;
import Modelos.Cliente;
import java.util.List;

public class ClienteServicio {

    private DAO_Cliente clienteDAO;

    public ClienteServicio() {
        this.clienteDAO = new DAO_Cliente();
    }

    // Obtener todos los clientes y devolver en formato Object[][]
    public Object[][] obtenerTodosLosClientes() {
        List<Cliente> listaClientes = clienteDAO.obtenerTodos();
        return convertirListaAArray(listaClientes);
    }

    // Insertar un nuevo cliente
    public void insertar(String nombre, String telefono, String email) {
        Cliente cliente = new Cliente(0, nombre, telefono, email);
        clienteDAO.insertar(cliente);
    }

    // Buscar un cliente por ID
    public Cliente encontrarPorId(int id) {
        return clienteDAO.encontrarPorId(id);
    }

    // Actualizar un cliente
    public void actualizar(int id, String nombre, String telefono, String email) {
        Cliente cliente = new Cliente(id, nombre, telefono, email);
        clienteDAO.actualizar(cliente);
    }

    // Eliminar un cliente por ID
    public void eliminar(int id) {
        clienteDAO.eliminar(id);
    }

    // Método auxiliar para convertir List<Cliente> a Object[][]
    private Object[][] convertirListaAArray(List<Cliente> listaClientes) {
        Object[][] datos = new Object[listaClientes.size()][4]; // 4 columnas: ID, Nombre, Teléfono, Email

        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente cliente = listaClientes.get(i);
            datos[i][0] = cliente.getId();
            datos[i][1] = cliente.getNombre();
            datos[i][2] = cliente.getTelefono();
            datos[i][3] = cliente.getEmail();
        }

        return datos;
    }
}