
package Controlador;

import Modelos.Cliente;
import Servicios.ClienteServicio;

public class ControladorClientes {

    private ClienteServicio clienteServicio;

    public ControladorClientes() {
        this.clienteServicio = new ClienteServicio();
    }

    // Obtener todos los clientes en formato Object[][] para la tabla
    public Object[][] obtenerDatosClientes() {
        return clienteServicio.obtenerTodosLosClientes();
    }

    // Insertar un nuevo cliente
    public void insertarCliente(String nombre, String telefono, String email) {
        clienteServicio.insertar(nombre, telefono, email);
    }

    // Actualizar un cliente existente
    public void actualizarCliente(int id, String nombre, String telefono, String email) {
        clienteServicio.actualizar(id, nombre, telefono, email);
    }

    // Eliminar un cliente por ID
    public void eliminarCliente(int id) {
        clienteServicio.eliminar(id);
    }
}
