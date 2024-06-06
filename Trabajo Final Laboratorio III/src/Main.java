
import Clases.*;
import Excepciones.InvalidCardNumberException;
import Excepciones.InvalidDniExcepcion;
import Excepciones.InvalidNameExcepcion;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    public static void main(String[] args) {
     scanner = new Scanner(System.in);
     Menu miMenu=  new Menu();
        int opcion;
        char seguir = 's';


        while (seguir=='s') {
            System.out.println("...Menú de opciones...");
            System.out.println("1. Ver menú");
            System.out.println("2. Abrir caja");
            System.out.println("3. Pedidos");
            System.out.println("3. Ver estadisticas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

             opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("MENU");
                    System.out.println(miMenu.listarTodoMenu());
                    break;
                case 2:
                    MenuOpciones.abrirCajaDelDia();
                    //codigo para avisar que hay una caja del dia abierta
                    break;
                case 3:
                    MenuOpciones.opcionesPedido(miMenu);
                    //funcion pedidos
                    break;
                case 4:
                   //logica estadisticas
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    seguir = 'c';
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
            System.out.println("Para volver al menu de opciones presione 's': ");
            seguir= scanner.next().charAt(0);
            MenuOpciones.limpiarConsola();

        }


        scanner.close();
    }



}

