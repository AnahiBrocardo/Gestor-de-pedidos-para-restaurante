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

        //variables compartidas
        String descripcion, nombreElementoMenu;
        Double precioElementoMenu;

        HashMap<String, ArrayList<ElementoMenu>> mapaMenu= new HashMap<>();

        try{
            JSONObject jsonObject= new JSONObject(jsonRespuesta);

            //CLAVE POSTRE
            JSONArray arregloPostres= jsonObject.getJSONArray("postre");
            ArrayList<ElementoMenu> datosArreglo;

            for (int i=0; i<arregloPostres.length(); i++){

                JSONObject jsonObjetArregloPostre= arregloPostres.getJSONObject(i);

                 nombreElementoMenu=jsonObjetArregloPostre.getString("nombreElementoMenu");
                 precioElementoMenu= jsonObjetArregloPostre.getDouble("precioElementoMenu");
                String nombrePostre= jsonObjetArregloPostre.getString("nombreDelPostre");
                 descripcion=  jsonObjetArregloPostre.getString("descripcion");
                ElementoMenu nuevoE= new Postre(nombreElementoMenu, precioElementoMenu,nombrePostre,descripcion);


                if(mapaMenu.containsKey("postre")){
                    datosArreglo= mapaMenu.get("postre");
                    datosArreglo.add(nuevoE);
                }else{
                    datosArreglo= new ArrayList<>();
                    datosArreglo.add(nuevoE);
                    mapaMenu.put("postre", datosArreglo);
                }
            }

            JSONArray arregloDeBurges = jsonObject.getJSONArray("burger");
            String tipoHamburguesa;
            for(int i=0; i<arregloDeBurges.length(); i++)
            {
                JSONObject jsonObjetArregloBurger = arregloDeBurges.getJSONObject(i);
                descripcion = jsonObjetArregloBurger.getString("descripcion");
                tipoHamburguesa = jsonObjetArregloBurger.getString("tipoHamburguesa");
                nombreElementoMenu = jsonObjetArregloBurger.getString("nombreElementoMenu");
                precioElementoMenu = jsonObjetArregloBurger.getDouble("precioElementoMenu");
                ElementoMenu nuevoElementoBurger = new Burger(nombreElementoMenu, precioElementoMenu, descripcion, tipoHamburguesa);

                if (mapaMenu.containsKey("burger"))
                {
                    datosArreglo = mapaMenu.get("burger");
                    datosArreglo.add(nuevoElementoBurger);
                }
                else
                {
                    datosArreglo = new ArrayList<>();
                    datosArreglo.add(nuevoElementoBurger);
                    mapaMenu.put("burger", datosArreglo);
                }
            }




        }
        catch (JSONException exception){
            exception.printStackTrace();
        }

        return mapaMenu;
    }



}



