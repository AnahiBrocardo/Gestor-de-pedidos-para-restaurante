package Clases;

import java.util.*;

public class Menu{
 private HashMap<String, ArrayList<ElementoMenu>> mapaDelMenu;


    public Menu()
    {

        this.mapaDelMenu =ControladoraJson.lecturaArchivoJson();
    }



    public String listarTodoMenu(){ //esta funcion lista todo el menu
        String rta="";
        Iterator<Map.Entry<String, ArrayList<ElementoMenu>>> iteratormap= mapaDelMenu.entrySet().iterator();
        while (iteratormap.hasNext()){
            Map.Entry<String, ArrayList<ElementoMenu>> entry = iteratormap.next();
            String key = entry.getKey();
            rta+= listarMenu(key);
        }

        return rta;
    }

    public String listarMenu(String key) //esta funcion lista solo el menu de determinado elemento del menu
    {
        String rta="";
        ArrayList<ElementoMenu> nuevoArreglo= mapaDelMenu.get(key);
        for(int i=0; i< nuevoArreglo.size(); i++)
        {
            rta += nuevoArreglo.get(i).toString() + "\n";
        }
        return rta;
    }

    public String listarMenuPorDigitos(String key) //esta funcion lista solo el menu de determinado elemento del menu
    {
        String rta="";
        int digito=1;
        ArrayList<ElementoMenu> nuevoArreglo= mapaDelMenu.get(key);
        for(int i=0; i< nuevoArreglo.size(); i++)
        {
            rta += "\n.....Opcion "+digito+ nuevoArreglo.get(i).toString() + "\n";
            digito++;
        }
        return rta;
    }

    public ArrayList<ElementoMenu> devolverArrayListPorClaveDeMenu(String key){ //se devuelve un array de elementos del menu, segun la clave recibida
        ArrayList<ElementoMenu> arregloElementos= mapaDelMenu.get(key);
        return  arregloElementos;
    }


}
