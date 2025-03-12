/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author User
 */
public class Mesa {
    private int id;
    private int capacidad;
    private boolean disponible;

    public Mesa() {
    }

    public Mesa(int id, int capacidad, boolean disponible) {
        this.id = id;
        this.capacidad = capacidad;
        this.disponible = disponible;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Mesa{" + "id=" + id + ", capacidad=" + capacidad + ", disponible=" + disponible + '}';
    }
    
    
    
    
    
}
