package Servicios;

import DAO.DAO_Reserva;
import Modelos.Reserva;
import java.util.List;

public class ReservaServicio {

    private DAO_Reserva reservaDAO;

    public ReservaServicio() {
        this.reservaDAO = new DAO_Reserva();
    }
    public boolean insertar(Reserva reserva) {
        return reservaDAO.insertar(reserva);
    }
    public List<Reserva> obtenerTodo() {
        return reservaDAO.obtenerReservas();
    }
    public Reserva encontrarPorId(int id) {
        return reservaDAO.encontrarPorId(id);
    }
    public boolean actualizar(Reserva reserva) {
        return reservaDAO.actualizar(reserva);
    }

    public boolean eliminar(int id) {
        return reservaDAO.eliminar(id);
    }
}
