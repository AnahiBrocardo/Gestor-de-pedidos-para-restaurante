package Clases;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class Estadistica implements Serializable {
    private Date fecha; //fecha de la caja del dia
    private double totalRecaudacion; //total de la recaudacion de la caja del dia
    private HashMap <String, Integer> mapaEstadisticas;// clave-> tipo de producto y el valor cant de ese producto
    /* cuando se cierra caja se crea un new de estadistica y se guarda en el archivo*/

    public Estadistica(Date fecha, double totalRecaudacion) {
        this.fecha = fecha;
        this.totalRecaudacion = totalRecaudacion;
        this.mapaEstadisticas = new HashMap<>();
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotalRecaudacion() {
        return totalRecaudacion;
    }

    public void setTotalRecaudacion(double totalRecaudacion) {
        this.totalRecaudacion = totalRecaudacion;
    }

    public HashMap<String, Integer> getMapaEstadisticas() {
        return mapaEstadisticas;
    }

    public void setMapaEstadisticas(HashMap<String, Integer> mapaEstadisticas) {
        this.mapaEstadisticas = mapaEstadisticas;
    }


}
