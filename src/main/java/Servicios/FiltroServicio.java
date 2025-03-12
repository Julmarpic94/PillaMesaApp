/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import DAO.DAO_Filtros;
import Modelos.Filtro;
import Modelos.Reserva;
import java.util.List;

/**
 *
 * @author User
 */
public class FiltroServicio {
    
    
    
    private DAO_Filtros filtroDAO;

    public FiltroServicio() {
        this.filtroDAO = new DAO_Filtros();
    }

    public List<Reserva> obtenerReservaFiltrada(Filtro filtro) {
        return filtroDAO.obtenerReservasConFiltros(filtro);
    }
    
}
