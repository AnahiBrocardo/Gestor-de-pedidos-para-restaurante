package FuncionesMapa;


import Interfaces.IFunciones;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GenericidadMapa  <E> implements IFunciones {
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




}
