package Clases;

import com.sun.jdi.ArrayReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ControladoraJson {
    /*Este metodo leer el archivo archivoMenu.bin  y lo codifica a la clase Menu
     * @return el mapa de elementosMenu (comida) del archivo*/

    public HashMap<String, ArrayList<ElementoMenu>> lecturaArchivo()
    {

        String jsonRespuesta= JsonUtiles.leer("archivoMenu.bin");
        HashMap<String, ArrayList<ElementoMenu>> mapaMenu= new HashMap<>();

        try{
            JSONObject jsonObject= new JSONObject(jsonRespuesta);

            JSONArray arregloPostres= jsonObject.getJSONArray("postre");

            for (int i=0; i<arregloPostres.length(); i++){
                ArrayList<ElementoMenu> datos;
                JSONObject jsonObjetArregloPostre= arregloPostres.getJSONObject(i);

                String nombreElementoMenu=jsonObjetArregloPostre.getString("nombreElementoMenu");
                Double precioElementoMenu= jsonObjetArregloPostre.getDouble("precioElementoMenu");
                String nombrePostre= jsonObjetArregloPostre.getString("nombreDelPostre");
                String descripcion=  jsonObjetArregloPostre.getString("descripcion");
                ElementoMenu nuevoE= new Postre(nombreElementoMenu, precioElementoMenu,nombrePostre,descripcion);

                ArrayList<ElementoMenu> datosArreglo;
                if(mapaMenu.containsKey("postre")){
                    datosArreglo= mapaMenu.get("postre");
                    datosArreglo.add(nuevoE);
                }else{
                    datosArreglo= new ArrayList<>();
                    datosArreglo.add(nuevoE);
                    mapaMenu.put("postre", datosArreglo);
                }
            }


            
        }
        catch (JSONException exception){
            exception.printStackTrace();
        }

        return mapaMenu;
    }



}



