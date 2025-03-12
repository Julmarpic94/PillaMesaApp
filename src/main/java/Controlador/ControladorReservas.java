package Controlador;

import Modelos.Filtro;
import Modelos.Reserva;
import Servicios.FiltroServicio;
import Servicios.ReservaServicio;
import java.util.List;

public class ControladorReservas {

    private ReservaServicio reservaServicio;
    private FiltroServicio filtroServicio;

    public ControladorReservas() {
        this.reservaServicio = new ReservaServicio();
        this.filtroServicio = new FiltroServicio();
    }

    // Obtener todas las reservas con detalles
    public Object[][] obtenerDatosParaTabla() {
        List<Reserva> reservas = reservaServicio.obtenerTodo();
        Object[][] datos = new Object[reservas.size()][7];

        for (int i = 0; i < reservas.size(); i++) {
            Reserva r = reservas.get(i);
            datos[i][0] = r.getId();
            datos[i][1] = r.getFecha().toString();
            datos[i][2] = r.getHora().toString();
            datos[i][3] = r.getClienteNombre();  // 🔹 Ahora obtenemos el nombre del cliente
            datos[i][4] = r.getClienteTelefono(); // 🔹 Ahora obtenemos el teléfono del cliente
            datos[i][5] = r.getMesaId(); 
            datos[i][6] = r.getUsuarioId();  // 🔹 Mostramos el ID del usuario en lugar del nombre (opcional)
        }
        return datos;
    }

    // Obtener reservas con filtros aplicados
    public Object[][] obtenerDatosConFiltro(Filtro filtro) {
        List<Reserva> reservas = filtroServicio.obtenerReservaFiltrada(filtro);
        Object[][] datos = new Object[reservas.size()][7];

        for (int i = 0; i < reservas.size(); i++) {
            Reserva r = reservas.get(i);
            datos[i][0] = r.getId();
            datos[i][1] = r.getFecha().toString();
            datos[i][2] = r.getHora().toString();
            datos[i][3] = r.getClienteNombre();  // 🔹 Usamos el nuevo método del POJO
            datos[i][4] = r.getClienteTelefono(); // 🔹 Obtenemos el teléfono del cliente
            datos[i][5] = r.getMesaId();
            datos[i][6] = r.getUsuarioId();  // 🔹 Mostramos solo el ID del usuario (podría ajustarse)
        }
        return datos;
    }
}
