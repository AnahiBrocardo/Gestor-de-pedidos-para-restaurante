
import Archivos.ControladoraArchivoCaja;
import Clases.*;

import java.util.Scanner;

public class Main {
    static Scanner scanner;
    public static void main(String[] args) {
     scanner = new Scanner(System.in);
     Menu miMenu=  new Menu();
     //MenuOpciones.abrirEstadisticadesdemenus();
     MenuOpciones.abrirLaCajaDelDia(miMenu);
     int opcion;
        char seguir = 's';



        while (seguir=='s') {
            System.out.println("...Menú de opciones...");
            System.out.println("1. Ver menú");
            System.out.println("2. Pedidos");
            System.out.println("3. Ver estadisticas");
            //falta opcion cerrar caja
            //ver monto recaudado del dia, funcion de caja ver total recaudado, ver pago tarjeta y efectivo
            System.out.println("4. Ver recaudacion");

            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

             opcion = scanner.nextInt();
             MenuOpciones.iniciarScanner();

            switch (opcion) {
                case 1:
                    System.out.println("MENU");
                    System.out.println(miMenu.listarTodoMenu());
                    break;

                case 2:
                    MenuOpciones.opcionesPedido(miMenu);

                    break;
                case 3:
                    MenuOpciones.opcionesEstadistica();
                    break;
                case 4:
                    MenuOpciones.verRecaudacionCajaDelDia();
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    seguir = 'c';
                    MenuOpciones.cerrarCajadia();
                    MenuOpciones.cerrarEstadisticadesdemenu();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida...2");
            }
            System.out.println("Para volver al menu de opciones presione 's' o para salir: 'c'");
            seguir= scanner.next().charAt(0);
            MenuOpciones.limpiarConsola();

        }

       MenuOpciones.cerrarScanner();
        scanner.close();
    }



}

