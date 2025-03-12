
package Modelos;

import java.time.LocalDate;
import java.time.LocalTime;


public class Filtro {
    private String nombre;
    private Integer mesa;
    private LocalDate fecha;
    private LocalTime hora;

    public Filtro() {
    }

    public Filtro(String nombre, Integer mesa, LocalDate fecha, LocalTime hora) {
        this.nombre = nombre;
        this.mesa = mesa;
        this.fecha = fecha;
        this.hora = hora;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
}

