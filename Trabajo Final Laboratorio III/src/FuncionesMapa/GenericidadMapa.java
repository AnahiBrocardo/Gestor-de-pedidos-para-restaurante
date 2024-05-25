package FuncionesMapa;


import Interfaces.IFunciones;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GenericidadMapa <E> implements IFunciones {
    private HashMap <String, ArrayList<Object>> nuevomapa;

    public GenericidadMapa() {
        nuevomapa = new HashMap<>();
    }

    @Override
    public void agregar(Object o, String key) {
        ArrayList<Object> datosArreglo;
        if(nuevomapa.containsKey(key)){
            datosArreglo= nuevomapa.get(key);
            datosArreglo.add(o);
        } else {
            datosArreglo= new ArrayList<>();
            datosArreglo.add(o);
            nuevomapa.put(key,datosArreglo);
        }

    }

    @Override
    public String modificar(Object o, String key, Object objetoBuscado) {
        String rta="";
        if (nuevomapa.containsKey(key)){
            ArrayList<Object> datosArreglo = nuevomapa.get(key);
            if (datosArreglo.contains(objetoBuscado)) {
                int indice = datosArreglo.indexOf(objetoBuscado);
                datosArreglo.set(indice, o);
                rta="Objeto modificado con exito";
            } else {
                rta="El objeto no se encuentra en el arreglo.";
            }
        } else {
            rta="La clave no existe en el mapa";
        }
        return rta;
    }

}
