package Controlador;

import Modelos.Mesa;
import Servicios.MesasServicio;
import java.util.List;

public class ControladorMesas {

    private final MesasServicio servicio;

    public ControladorMesas() {
        this.servicio = new MesasServicio();
    }

    // Método para insertar una nueva mesa
    public void insertarMesa(int capacidad, boolean disponible) {
        boolean resultado = servicio.agregarMesa(capacidad, disponible);
        if (resultado) {
            System.out.println("✅ Mesa agregada exitosamente.");
        } else {
            System.out.println("❌ No se pudo agregar la mesa.");
        }
    }

    // Método para obtener todas las mesas (se usará en la vista)
    public Object[][] obtenerDatosMesas() {
        List<Mesa> mesas = servicio.listarMesas();
        Object[][] datos = new Object[mesas.size()][3];

        for (int i = 0; i < mesas.size(); i++) {
            Mesa mesa = mesas.get(i);
            datos[i][0] = mesa.getId();
            datos[i][1] = mesa.getCapacidad();
            datos[i][2] = mesa.isDisponible() ? "Sí" : "No";
        }

        return datos;
    }

    // Método para buscar una mesa por ID
    public Mesa obtenerMesaPorId(int id) {
        return servicio.obtenerMesaPorId(id);
    }

    // Método para actualizar una mesa
    public void actualizarMesa(int id, int capacidad, boolean disponible) {
        boolean resultado = servicio.actualizarMesa(id, capacidad, disponible);
        if (resultado) {
            System.out.println("✅ Mesa actualizada correctamente.");
        } else {
            System.out.println("❌ No se pudo actualizar la mesa.");
        }
    }

    // Método para eliminar una mesa
    public void eliminarMesa(int id) {
        boolean resultado = servicio.eliminarMesa(id);
        if (resultado) {
            System.out.println("✅ Mesa eliminada correctamente.");
        } else {
            System.out.println("❌ No se pudo eliminar la mesa.");
        }
    }
}

