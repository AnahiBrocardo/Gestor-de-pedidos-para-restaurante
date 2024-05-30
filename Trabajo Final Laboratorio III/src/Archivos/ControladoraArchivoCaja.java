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
}
