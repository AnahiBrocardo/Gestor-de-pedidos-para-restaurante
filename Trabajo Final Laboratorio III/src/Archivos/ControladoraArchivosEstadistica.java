package Archivos;
import Clases.Estadistica;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ControladoraArchivosEstadistica {
    public static void grabarArchivo (ArrayList<Estadistica> arrayListEstadistica){
        FileOutputStream fileOutputStream= null;
        ObjectOutputStream objectOutputStream= null;
        //se iniciliza en null para asegurar un valor predeterminado si no se puede abrir el archivo

        try{
            fileOutputStream= new FileOutputStream("estadisticas.dat");
            objectOutputStream= new ObjectOutputStream(fileOutputStream);

            for(int i=0;i<arrayListEstadistica.size(); i++){ //recorre el arreglo, obtiene el objeto estadistica por el indice
                Estadistica elementoEstadistica= arrayListEstadistica.get(i);
                objectOutputStream.writeObject(elementoEstadistica); //
            }

        }catch (IOException exception){

        }
    }
}
