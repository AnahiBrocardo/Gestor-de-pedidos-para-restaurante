package Clases;

import java.io.Serializable;
import java.util.*;

public class Estadistica implements Serializable {
    private Date fecha; //fecha de la caja del dia
    private double totalRecaudacion; //total de la recaudacion de la caja del dia
    private HashMap <String, Integer> mapaEstadisticas;// clave-> tipo de producto y el valor cant de ese producto
    /* cuando se cierra caja se crea un new de estadistica y se guarda en el archivo*/

    public Estadistica(Date fecha, HashMap<String, Integer> mapaEstadisticas, double totalRecaudacion) {
        this.fecha = fecha;
        this.totalRecaudacion = totalRecaudacion;
        this.mapaEstadisticas = mapaEstadisticas;
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

    @Override
    public String toString() {
        return "Estadistica{" +
                "fecha=" + fecha +
                ", totalRecaudacion=" + totalRecaudacion + "\n"+
                " MapaEstadisticas=" + listarTodoEstadistica() +
                '}';
    }
    public String listarTodoEstadistica() {
        String resultado = "";

        /*for (Map.Entry<String, Integer> entrada : mapaEstadisticas.entrySet()) {
            String clave = entrada.getKey();
            Integer cantidad = entrada.getValue();
            resultado += clave + ": " + cantidad + "\n";
        }*/
        Iterator<Map.Entry<String, Integer>> iteratormap= mapaEstadisticas.entrySet().iterator();
        while (iteratormap.hasNext()){
            Map.Entry<String, Integer> entry = iteratormap.next();
            String key = entry.getKey();
            resultado += key+ entry.getValue();
        }
        return resultado;
    }


}
