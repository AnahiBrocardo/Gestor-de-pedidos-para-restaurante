package FuncionesMapa;


import Interfaces.IFunciones;

import java.util.*;
import java.util.Map.Entry;
public class GenericidadMapa <E> implements IFunciones<E> {
    private HashMap <String, ArrayList<E>> nuevomapa;

    public GenericidadMapa() {
        nuevomapa = new HashMap<>();
    }

    @Override
    public void agregar(E o, String key) {
        ArrayList<E> datosArreglo;
        if(nuevomapa.containsKey(key)){
            datosArreglo= nuevomapa.get(key);
            datosArreglo.add(o);
        } else {
            datosArreglo= new ArrayList<>();
            datosArreglo.add(o);
            nuevomapa.put(key,datosArreglo);
        }

    }

    public Set<Entry<String, ArrayList<E>>> getEntrySet(){
        return nuevomapa.entrySet();
    }

    @Override
    public String modificar(E o, String key, E objetoBuscado) {
        String rta="";
        if (nuevomapa.containsKey(key)){
            ArrayList<E> datosArreglo = nuevomapa.get(key);
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
    @Override
    public boolean buscar(E buscado, String key) {
        boolean existencia= false;
        if(nuevomapa.containsKey(key)){
            ArrayList<E> datosArreglo = nuevomapa.get(key);
            if (buscado != null){
                if (datosArreglo.contains(buscado)) {
                    existencia= true;
                }
            }
        }
        return existencia;
    }


    public boolean buscarPorClave(String key) {
        boolean existe= false;
        if(nuevomapa.containsKey(key)){
            existe= true;
        }
        return existe;
    }


    @Override
    public String listar(String key)
    {
        String rta="";
        ArrayList<E> nuevoArreglo= nuevomapa.get(key);
        //Iterator<Object> iterator= nuevoArreglo.iterator();
        for(int i=0; i< nuevoArreglo.size(); i++)
        {
            rta += nuevoArreglo.get(i).toString() + "\n";
        }
        return rta;
    }


    public String listarPorDigitoYllave(String key)
    {
        String rta="";
        int opcion=1;
        ArrayList<E> nuevoArreglo= nuevomapa.get(key);
        //Iterator<Object> iterator= nuevoArreglo.iterator();
        for(int i=0; i< nuevoArreglo.size(); i++)
        {
            rta += "  Opcion"+opcion+nuevoArreglo.get(i).toString() + "\n";
            opcion++;
        }
        return rta;
    }

    public ArrayList<E>  devolverArregloPorClave (String key)
    {
        ArrayList<E> nuevoArreglo= nuevomapa.get(key);

        return nuevoArreglo;
    }
    @Override
    public void eliminar(E o, String key) {
        ArrayList<E> datosArreglo;
        if(nuevomapa.containsKey(key)){
            datosArreglo= nuevomapa.get(key);
            datosArreglo.remove(o);
        }
    }

    public String listarTodo(){
        String rta="";
        Iterator<Map.Entry<String, ArrayList<E>>> iteratormap= nuevomapa.entrySet().iterator();
        while (iteratormap.hasNext()){
            Map.Entry<String, ArrayList<E>> entry = iteratormap.next();
            String key = entry.getKey();

            rta += listar(key);
        }

        return rta;
    }

    public String listarTodoPorDigito(){
        String rta="";
        Iterator<Map.Entry<String, ArrayList<E>>> iteratormap= nuevomapa.entrySet().iterator();
        while (iteratormap.hasNext()){
            Map.Entry<String, ArrayList<E>> entry = iteratormap.next();
            String key = entry.getKey();

            rta += listar(key);
        }

        return rta;
    }


    public HashMap<String, ArrayList<E>> getNuevomapa() {
        return nuevomapa;
    }
}
