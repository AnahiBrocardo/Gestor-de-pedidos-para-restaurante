package Archivos;


import java.io.*;
import java.util.ArrayList;
import Clases.Caja;

public class ControladoraArchivoCaja {
    public static void grabarArchivoCaja (Caja caja){

        FileOutputStream fileOutputStream= null;
        ObjectOutputStream objectOutputStream= null;

        try{
            fileOutputStream= new FileOutputStream("caja.dat");
            objectOutputStream= new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(caja);


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

    public static Caja leerArchivoCaja()
    {
        Caja caja= new Caja();

        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try
        {
            fileInputStream = new FileInputStream("caja.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);

          //  while (true)
            //{
                /*El objectInputStream se utiliza para leer objetos serializados y con el metodo readObject me devuelve (retorna) ese objeto leido.
                Se guarda y castea en una variable caja ya que el objeto retornado esta Bytes.*/
                Caja aux = (Caja) objectInputStream.readObject();

            //}
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

        return caja;
    }

    public static boolean verificarSiEstaVacioArchivoCaja ()
    {
        boolean rta = false;
        File archivo = new File("caja.dat");
        if (archivo.length()==0)
        {
            rta= true;
        }
        return rta;
    }

    public static void vaciarArchivoCaja () {

        File archivo = new File("caja.dat");
        try {
            if (archivo.exists()) {
                archivo.delete(); // Elimina el archivo si ya existe
            }
            archivo.createNewFile(); // Crea un nuevo archivo vacío con el mismo nombre.
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
