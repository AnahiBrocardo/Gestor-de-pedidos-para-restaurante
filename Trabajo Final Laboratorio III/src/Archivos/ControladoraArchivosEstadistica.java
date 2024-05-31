package Archivos;
import Clases.Estadistica;

import java.io.*;
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
            exception.printStackTrace();
        }
        finally {
            try {
                if (fileOutputStream != null)
                    fileOutputStream.close();

                if (objectOutputStream != null)
                    objectOutputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static ArrayList<Estadistica> leerArchivo()
    {
        ArrayList<Estadistica> estadisticasArrayList = new ArrayList<>();

        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try
        {
            fileInputStream = new FileInputStream("estadisticas.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);

            while (true)
            {
                /*El objectInputStream se utiliza para leer objetos serializados y con el metodo readObject me devuelve (retorna) ese objeto leido.
                Se guarda y castea en una variable estadistica ya que el objeto retornado esta Bytes.*/
                Estadistica aux = (Estadistica) objectInputStream.readObject();
                estadisticasArrayList.add(aux);
            }
        }
        catch (EOFException ex)
        {
            ex.printStackTrace();
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            try
            {
                if (fileInputStream!=null)
                    fileInputStream.close();

                if (objectInputStream!=null)
                    objectInputStream.close();
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }

        }

        return estadisticasArrayList;
    }
}
