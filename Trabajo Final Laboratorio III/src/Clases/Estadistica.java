package Clases;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
        return "----------Estadistica----------" +
                "\nFecha=" + fechaFormateada() +
                "\nTotalRecaudacion=" + totalRecaudacion +
                "\nMapaEstadisticas=" + listarTodoEstadistica();
    }


    public String listarTodoEstadistica() {
        String resultado = "";

        Iterator<Map.Entry<String, Integer>> iteratormap= mapaEstadisticas.entrySet().iterator();
        while (iteratormap.hasNext()){
            Map.Entry<String, Integer> entry = iteratormap.next();
            String key = entry.getKey();
            resultado += key+ ": "+ entry.getValue()+"///";
        }
        return resultado;
    }

    public String fechaFormateada() {
        // Crear un formato personalizado (DIA MES AÑO HORA:MINUTOS)
        SimpleDateFormat formato = new SimpleDateFormat("dd MMM yyyy HH:mm");

        // Formatear la fecha
        return formato.format(fecha);
    }



}
