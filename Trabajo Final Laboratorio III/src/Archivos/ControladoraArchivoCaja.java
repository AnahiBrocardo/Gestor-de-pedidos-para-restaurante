package Archivos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ControladoraArchivoCaja {
    public static void grabarArchivoCaja (ArrayList<Caja> arrayListDeCajas){
        FileOutputStream fileOutputStream= null;
        ObjectOutputStream objectOutputStream= null;

        try{
            fileOutputStream= new FileOutputStream("cajas.dat");
            objectOutputStream= new ObjectOutputStream(fileOutputStream);

            for(int i=0;i<arrayListDeCajas.size(); i++){ //recorre el arreglo, obtiene el objeto estadistica por el indice
                objectOutputStream.writeObject(arrayListDeCajas.get(i));
            }

        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
        finally {
            try {
                if (fileOutputStream != null)
                    fileOutputStream.close();

                if (objectOutputStream != null)
                    objectOutputStream.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static ArrayList<Caja> leerArchivoCaja()
    {
        ArrayList<Caja> cajaArrayList = new ArrayList<>();

        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;

        try
        {
            fileInputStream = new FileInputStream("cajas.dat");
            objectInputStream = new ObjectInputStream(fileInputStream);

            while (true)
            {
                /*El objectInputStream se utiliza para leer objetos serializados y con el metodo readObject me devuelve (retorna) ese objeto leido.
                Se guarda y castea en una variable caja ya que el objeto retornado esta Bytes.*/
                Caja aux = (Caja) objectInputStream.readObject();
                cajaArrayList.add(aux);
            }
        }
        catch (EOFException ex)
        {
            System.out.println("FIN del ARCHIVO");
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());
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
                System.out.println(ex.getMessage());
            }

        }

        return cajaArrayList;
    }
}
