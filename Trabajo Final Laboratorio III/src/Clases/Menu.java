package Clases;

import java.util.*;

public class Menu{
 private HashMap<String, ArrayList<ElementoMenu>> mapaDelMenu;


    public Menu()
    {

        this.mapaDelMenu =ControladoraJson.lecturaArchivoJson();
    }



    public String listarTodoMenu(){
        String rta="";
        Iterator<Map.Entry<String, ArrayList<ElementoMenu>>> iteratormap= mapaDelMenu.entrySet().iterator();
        while (iteratormap.hasNext()){
            Map.Entry<String, ArrayList<ElementoMenu>> entry = iteratormap.next();
            String key = entry.getKey();
            rta += listarMenu(key);
        }

        return rta;
    }

    public String listarMenu(String key)
    {
        String rta="";
        ArrayList<ElementoMenu> nuevoArreglo= mapaDelMenu.get(key);
        for(int i=0; i< nuevoArreglo.size(); i++)
        {
            rta += nuevoArreglo.get(i).toString() + "\n";
        }
        return rta;
    }
}
