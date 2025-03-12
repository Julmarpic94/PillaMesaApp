
package Servicios;

import DAO.DAO_Mesa;
import Modelos.Mesa;
import java.util.List;

public class MesasServicio {
    
    private final DAO_Mesa daoMesa;

    public MesasServicio() {
        this.daoMesa = new DAO_Mesa();
    }

    // Insertar nueva mesa
    public boolean agregarMesa(int capacidad, boolean disponible) {
        if (capacidad <= 0) {
            System.out.println("❌ La capacidad debe ser mayor a 0.");
            return false;
        }

        Mesa nuevaMesa = new Mesa(0, capacidad, disponible);
        daoMesa.insertar(nuevaMesa);
        return true;
    }

    // Obtener todas las mesas
    public List<Mesa> listarMesas() {
        return daoMesa.obtenerTodas();
    }

    // Buscar una mesa por ID
    public Mesa obtenerMesaPorId(int id) {
        if (id <= 0) {
            System.out.println("❌ El ID debe ser mayor a 0.");
            return null;
        }
        return daoMesa.encontrarPorId(id);
    }

    // Actualizar una mesa
    public boolean actualizarMesa(int id, int capacidad, boolean disponible) {
        if (id <= 0 || capacidad <= 0) {
            System.out.println("❌ Datos inválidos para actualizar.");
            return false;
        }

        Mesa mesaActualizada = new Mesa(id, capacidad, disponible);
        daoMesa.actualizar(mesaActualizada);
        return true;
    }

    // Eliminar una mesa por ID
    public boolean eliminarMesa(int id) {
        if (id <= 0) {
            System.out.println("❌ ID inválido.");
            return false;
        }

        daoMesa.eliminar(id);
        return true;
    }
    
    
}
