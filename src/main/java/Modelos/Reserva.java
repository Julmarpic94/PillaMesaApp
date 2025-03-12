package Modelos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {

    private int id;
    private Integer clienteId;
    private String clienteNombre;
    private String clienteTelefono;
    private Integer mesaId;
    private Integer usuarioId;
    private LocalDate fecha;
    private LocalTime hora;

    // Constructor vacío (por si necesitamos inicializar sin valores)
    public Reserva() {
    }

    public Reserva(Integer clienteId, Integer mesaId, Integer usuarioId, LocalDate fecha, LocalTime hora) {
        this.clienteId = clienteId;
        this.mesaId = mesaId;
        this.usuarioId = usuarioId;
        this.fecha = fecha;
        this.hora = hora;
    }

    // Constructor sin ID (para cuando creamos una nueva reserva)
    public Reserva(Integer clienteId, String clienteNombre, String clienteTelefono, Integer mesaId, Integer usuarioId, LocalDate fecha, LocalTime hora) {
        this.clienteId = clienteId;
        this.clienteNombre = clienteNombre;
        this.clienteTelefono = clienteTelefono;
        this.mesaId = mesaId;
        this.usuarioId = usuarioId;
        this.fecha = fecha;
        this.hora = hora;
    }

    // ✅ Constructor con ID (para cuando cargamos desde la BD)
    public Reserva(int id, Integer clienteId, String clienteNombre, String clienteTelefono, Integer mesaId, Integer usuarioId, LocalDate fecha, LocalTime hora) {
        this.id = id;
        this.clienteId = clienteId;
        this.clienteNombre = clienteNombre;
        this.clienteTelefono = clienteTelefono;
        this.mesaId = mesaId;
        this.usuarioId = usuarioId;
        this.fecha = fecha;
        this.hora = hora;
    }

    // ✅ GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public String getClienteTelefono() {
        return clienteTelefono;
    }

    public void setClienteTelefono(String clienteTelefono) {
        this.clienteTelefono = clienteTelefono;
    }

    public Integer getMesaId() {
        return mesaId;
    }

    public void setMesaId(Integer mesaId) {
        this.mesaId = mesaId;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Reserva{"
                + "id=" + id
                + ", clienteId=" + clienteId
                + ", clienteNombre='" + clienteNombre + '\''
                + ", clienteTelefono='" + clienteTelefono + '\''
                + ", mesaId=" + mesaId
                + ", usuarioId=" + usuarioId
                + ", fecha=" + fecha
                + ", hora=" + hora
                + '}';
    }
}
