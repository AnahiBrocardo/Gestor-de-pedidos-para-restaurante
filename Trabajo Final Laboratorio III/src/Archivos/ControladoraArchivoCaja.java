package Archivos;


import java.io.*;
import java.util.ArrayList;
import Clases.Caja;
import Clases.Estadistica;

public class ControladoraArchivoCaja {
    public static void grabarArchivoCaja (ArrayList<Caja> cajas){

        FileOutputStream fileOutputStream= null;
        ObjectOutputStream objectOutputStream= null;

        try{
            fileOutputStream= new FileOutputStream("caja.dat");
            objectOutputStream= new ObjectOutputStream(fileOutputStream);

            for(int i=0;i<cajas.size(); i++){ //recorre el arreglo, obtiene el objeto caja por el indice
                Caja elementoCaja= cajas.get(i);
                objectOutputStream.writeObject(elementoCaja);
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

    public static ArrayList<Caja> leerArchivoCaja()
    {
        ArrayList<Caja> cajas= new ArrayList<>();

        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try
        {
            fileInputStream = new FileInputStream("caja.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);


            while (true)
            {
                Caja aux = (Caja) objectInputStream.readObject();
                cajas.add(aux);
            }

                /*El objectInputStream se utiliza para leer objetos serializados y con el metodo readObject me devuelve (retorna) ese objeto leido.
                Se guarda y castea en una variable caja ya que el objeto retornado esta Bytes.*/


        }
        catch (EOFException ex)
        {
        //    ex.printStackTrace();
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }


        return cajas;
    }

    public static boolean verificarSiEstaVacioArchivoCaja ()//true si esta vacia
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
