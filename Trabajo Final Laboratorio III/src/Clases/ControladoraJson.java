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

    public static HashMap<String, ArrayList<ElementoMenu>> lecturaArchivo()
    {

        String jsonRespuesta= JsonUtiles.leer("archivoMenu.bin");

        //variables compartidas
        String descripcion, nombreElementoMenu, marca, sabor, amargura;
        Double precioElementoMenu, nivelAlcohol;
        float capacidad;
        boolean tieneEndulzante, tieneGas;

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

            JSONArray arregloCerveza = jsonObject.getJSONArray("cerveza");
            for(int i=0; i<arregloCerveza.length(); i++){
                JSONObject cerveza= arregloCerveza.getJSONObject(i);
                marca= cerveza.getString("marca");
                sabor= cerveza.getString("sabor");
                amargura= cerveza.getString("amargura");
                nombreElementoMenu= cerveza.getString("nombreElementoMenu");
                nivelAlcohol= cerveza.getDouble("nivelAlcohol");
                precioElementoMenu= cerveza.getDouble("precioElementoMenu");
                capacidad=(float) cerveza.getDouble("capacidad");

                ElementoMenu cervezanueva= new Cerveza(nombreElementoMenu,precioElementoMenu, capacidad,marca, sabor,nivelAlcohol, amargura);
                if (mapaMenu.containsKey("cerveza"))
                {
                    datosArreglo = mapaMenu.get("cerveza");
                    datosArreglo.add(cervezanueva);
                }
                else
                {
                    datosArreglo = new ArrayList<>();
                    datosArreglo.add(cervezanueva);
                    mapaMenu.put("cerveza", datosArreglo);
                }
            }

            ///////GASEOSA
            JSONArray arregloGaseosas = jsonObject.getJSONArray("gaseosa");
            for(int i=0; i<arregloGaseosas.length(); i++){
                JSONObject gaseo= arregloGaseosas.getJSONObject(i);
                marca= gaseo.getString("marca");
                sabor= gaseo.getString("sabor");
                tieneEndulzante= gaseo.getBoolean("tieneEndulzante");
                nombreElementoMenu= gaseo.getString("nombreElementoMenu");
                precioElementoMenu= gaseo.getDouble("precioElementoMenu");
                capacidad=(float) gaseo.getDouble("capacidad");

                ElementoMenu gaseoN= new Gaseosa(nombreElementoMenu, precioElementoMenu, capacidad, marca, sabor, tieneEndulzante);
                if (mapaMenu.containsKey("gaseosa"))
                {
                    datosArreglo = mapaMenu.get("gaseosa");
                    datosArreglo.add(gaseoN);
                }
                else
                {
                    datosArreglo = new ArrayList<>();
                    datosArreglo.add(gaseoN);
                    mapaMenu.put("gaseosa", datosArreglo);
                }
            }
            ///////AGUA SABORIZADA
            JSONArray arregloaguaSaborizada = jsonObject.getJSONArray("aguaSaborizada");
            for(int i=0; i<arregloaguaSaborizada.length(); i++){
                JSONObject agua= arregloaguaSaborizada.getJSONObject(i);
                marca= agua.getString("marca");
                sabor= agua.getString("sabor");
                nombreElementoMenu= agua.getString("nombreElementoMenu");
                precioElementoMenu= agua.getDouble("precioElementoMenu");
                tieneGas=agua.getBoolean("tieneGas");
                capacidad=(float) agua.getDouble("capacidad");

                ElementoMenu aguaN= new AguaSaborizada(nombreElementoMenu, precioElementoMenu, capacidad, marca, sabor, tieneGas);
                if (mapaMenu.containsKey("aguaSaborizada"))
                {
                    datosArreglo = mapaMenu.get("aguaSaborizada");
                    datosArreglo.add(aguaN);
                }
                else
                {
                    datosArreglo = new ArrayList<>();
                    datosArreglo.add(aguaN);
                    mapaMenu.put("aguaSaborizada", datosArreglo);
                }
            }



        }
        catch (JSONException exception){
            exception.printStackTrace();
        }

        return mapaMenu;
    }



}



