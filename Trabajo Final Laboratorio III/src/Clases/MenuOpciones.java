package Clases;

import Archivos.ControladoraArchivoCaja;
import Excepciones.InvalidCardNumberException;
import Excepciones.InvalidDniExcepcion;
import Excepciones.InvalidNameExcepcion;
import FuncionesMapa.GenericidadArray;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class MenuOpciones {
    static Scanner scanner;
    private static ArrayList<Caja> arrayCajas;

    public static void iniciarScanner() {
        scanner = new Scanner(System.in);
    }

    public static void cerrarScanner() {
        scanner.close();
    }

    public static void mensajeInicio(){
        System.out.println(
                         " ____                            _           _     _                     ____                                             \n" +
                        " |  _ \\    ___  __   __   ___   | |  _   _  | |_  (_)   ___    _ __     | __ )   _   _   _ __    __ _    ___   _ __   ___ \n" +
                        " | |_) |  / _ \\ \\ \\ / /  / _ \\  | | | | | | | __| | |  / _ \\  | '_ \\    |  _ \\  | | | | | '__|  / _` |  / _ \\ | '__| / __|\n" +
                        " |  _ <  |  __/  \\ V /  | (_) | | | | |_| | | |_  | | | (_) | | | | |   | |_) | | |_| | | |    | (_| | |  __/ | |    \\__ \\\n" +
                        " |_| \\_\\  \\___|   \\_/    \\___/  |_|  \\__,_|  \\__| |_|  \\___/  |_| |_|   |____/   \\__,_| |_|     \\__, |  \\___| |_|    |___/\n" +
                        "                                                                                                |___/                     "
        );


    }

    public static String listararraycajas() {
        String rta = "";
        for (int i = 0; i < arrayCajas.size(); i++) {
            System.out.println(arrayCajas.get(i));
            rta += arrayCajas.get(i);
        }
        return rta;
    }

    public static void limpiarConsola() { //funcion que imprime varias líneas en blanco en la consola
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void abrirCajaDelDia() {
        System.out.println("Abriendo caja...");
        RevolutionBurgers.abrirCaja();
        System.out.println("Caja abierta exitosamente");
    }

    public static void abrirEstadisticadesdemenus() {
        RevolutionBurgers.abrirarchivoEstadistico();
    }

    public static void cerrarCajadia() {
        System.out.println("Cerrando la caja...");
        RevolutionBurgers.cerrarCaja();
        System.out.println("Caja cerrada exitosamente");
        /*arrayCajas.add(RevolutionBurgers.getCajaDia());
        System.out.println(arrayCajas.toString());
        ControladoraArchivoCaja.grabarArchivoCaja(arrayCajas);*/
    }

    public static void AgregarCajaaEstadistica() {
        arrayCajas.add(RevolutionBurgers.getCajaDia());
    }

    public static void cerrarEstadisticadesdemenu() {
        RevolutionBurgers.cerrarEstadistica();
    }

    public static void opcionesPedido(Menu miMenu) {
        limpiarConsola();
        //if(!ControladoraArchivoCaja.verificarSiEstaVacioArchivoCaja()) {
        System.out.println("Ingrese la opcion que desee: " +
                "\n1- Crear nuevo pedido" +
                "\n2- Ver pedidos existentes");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                crearNuevoPedido(miMenu);
                break;
            case 2:
                opcionesPedidosExistentes(miMenu);
                break;
            default:
                System.out.println("\nOpcion no valida");
                break;
        }
        // }else {
        //     System.out.println("Para acceder a los pedidos, primero debe abrir la caja del dia...");
        //}
    }

    public static void crearNuevoPedido(Menu miMenu) { //se crea un nuevo pedido
        limpiarConsola();
        RevolutionBurgers.crearPedido();
        System.out.println("Pedido creado exitosamente....");
        System.out.println("\nAgregar elementos al pedido: ");
        int idNuevoPedido = RevolutionBurgers.obtenerUltimoIdPedido();
        agregarProductoAPedido(idNuevoPedido, miMenu);
        System.out.println("Pedido: \n" + RevolutionBurgers.listarTodounPedido(idNuevoPedido));
    }

    public static void opcionesPedidosExistentes(Menu miMenu) {
        char continuar = 's';
        limpiarConsola();
        if (RevolutionBurgers.cantPedidosNoPagos() == 0) { //si no hay ningun pedido creado
            System.out.println("No hay ningun pedido creado del dia, primero cree uno");

        } else {
            System.out.println("\n..Pedidos activos..\n");
            System.out.println(RevolutionBurgers.listarTodosLosPedidosNoPagos()); //se muestran todos los pedidos no pagos
            int numOpciones = RevolutionBurgers.cantOpcionesValidasPedido();
            int opcion;

            while (continuar == 's') {
                do {
                    System.out.println("Elija la opcion del pedido que desea: ");
                    opcion = scanner.nextInt();
                } while (opcion < 0 || opcion > numOpciones); //se valida que la opcion elegida este dentro de las opciones validas

                int id = RevolutionBurgers.obtenerIdDeOpcionPedido(opcion);//obtengo el id asociado a la opcion
                System.out.println(id);
                opcionesParaRealizarEnPedidosNoPagos(id, miMenu);

                limpiarConsola();
                System.out.println("Presione 's' para volver a ver el menu de pedidos existentes: ");
                continuar = scanner.next().charAt(0);
            }
        }

    }


    public static void opcionesParaRealizarEnPedidosNoPagos(int id, Menu miMenu) { //se recibe por parametro el id del pedido
        int opcion;
        char seguir = 's';

        do {
            System.out.println("Elija una opcion: \n1- Agregar un producto" +
                    "\n2.Modificar pedido" +
                    "\n3.Mostrar el pedido completo" +
                    "\n4.Eliminar un producto del pedido" +
                    "\n5.Realiza pago" +
                    "\n6.Poner 'c' para volver al menu principal");

            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    agregarProductoAPedido(id, miMenu);
                    break;
                case 2:
                    modificarUnProductoDePedido(id, miMenu);

                    break;
                case 3:
                    mostrarUnPedido(id);
                    break;
                case 4:
                    eliminarProductoDePedido(id);
                    break;
                case 5:
                    realizarPagoPedido(id);
                    break;
                case 6:
                    //seguir= 'c';
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }

            System.out.println("Presione 's' para volver al menu de PEDIDOS ACTIVOS... o 'c' para SALIR");
            seguir = scanner.next().charAt(0);
        } while (seguir == 's');

    } //muestra opciones solo para pedidos no pagos


    public static void realizarPagoPedido(int id) { //se realiza el pago de un pedido seleccionado
        double montoTotal = RevolutionBurgers.obtenerMontoPedido(id);
        System.out.println("\nPAGAR\nIndicar: \n1-Pago en efectivo" +
                "\n2-Pago con tarjeta");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                RevolutionBurgers.cambiarEstadoDePago(id); //se cambia el estado del pago a true, pago realizado
                Pago nuevoPagoE = new PagoEfectivo(montoTotal, 0);
                RevolutionBurgers.agregarPagoAlPedido(nuevoPagoE, id);// se agrega el pago al pedido


                break;
            case 2:
                Pago nuevoPagoT = obtenerPago(montoTotal);
                RevolutionBurgers.agregarPagoAlPedido(nuevoPagoT, id);
                RevolutionBurgers.cambiarEstadoDePago(id);//se cambia el estado del pago a true, pago realizado
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
        System.out.println("..pago exitoso..");
    }

    public static void mostrarUnPedido(int id) {
        System.out.println("\n....PEDIDO....");
        System.out.println(RevolutionBurgers.listarTodounPedido(id));
    } //se muestra un pedido seleccionado, por id

    public static void eliminarProductoDePedido(int id) {
        limpiarConsola();
        System.out.println(RevolutionBurgers.listarTodounPedido(id));
        int opcion;
        System.out.println("Elija que desea eliminar: \n1- Burger" +
                "\n2- Bebida" + "\n3- Postre");
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                eliminarBurgerPedido(id);
                break;
            case 2:
                eliminarBebidaPedido(id);
                break;
            case 3:
                eliminarPostrePedido(id);
                break;
            default:
                System.out.println("Opcion no valida");
                eliminarProductoDePedido(id);
                break;
        }
    } //muestra menu de opciones para eliminar un producto

    public static void eliminarBurgerPedido(int id) {
        limpiarConsola();
        int opcion;
        boolean existeProductoEnPedido = RevolutionBurgers.buscarPorClavePedido("burger", id);

        if (existeProductoEnPedido) {
            ArrayList<ElementoMenu> arregloHamburguesas = RevolutionBurgers.getCajaDia().devolverArregloProductosPorClave("burger", id);
            int tamaño = arregloHamburguesas.size();
            do {
                System.out.println("---Productos burger en pedido---");
                System.out.println(RevolutionBurgers.listarDeCajaPedidoPorDigitoYllave(id, "burger"));
                System.out.println("Indique la opcion de estilo de hamburgesa: ");
                opcion = scanner.nextInt();
            } while (opcion <= 0 || opcion > tamaño);

            ElementoMenu burgerEliminar = arregloHamburguesas.get(opcion - 1);
            System.out.println("Opcion seleccionada: " + burgerEliminar.toString());
            RevolutionBurgers.eliminardelPedido("burger", id, burgerEliminar);
            System.out.println("Producto eliminado exitosamente.....");

        } else {
            System.out.println(mensajeNoExisteBurger());
        }
    } //funcion que elimina un producto burger del pedido

    public static void eliminarPostrePedido(int id) {//funcion que elimina un producto postre del pedido
        limpiarConsola();
        int opcion;
        boolean existeProductoEnPedido = RevolutionBurgers.buscarPorClavePedido("postre", id);

        if (existeProductoEnPedido) {
            ArrayList<ElementoMenu> arregloPostre = RevolutionBurgers.getCajaDia().devolverArregloProductosPorClave("postre", id);
            int tamaño = arregloPostre.size();
            do {
                System.out.println("---Productos postre en pedido---");
                System.out.println(RevolutionBurgers.listarDeCajaPedidoPorDigitoYllave(id, "postre"));
                System.out.println("Indique la opcion del postre: ");
                opcion = scanner.nextInt();
            } while (opcion <= 0 || opcion > tamaño);

            ElementoMenu postreEliminar = arregloPostre.get(opcion - 1);
            System.out.println("Opcion seleccionada: " + postreEliminar.toString());
            RevolutionBurgers.eliminardelPedido("postre", id, postreEliminar);
            System.out.println("Producto eliminado exitosamente.....");

        } else {
            System.out.println(mensajeNoExistePostre());
        }
    }//funcion que elimina un postre  del pedido

    public static void eliminarBebidaPedido(int id) {//funcion que elimina un producto bebida del pedido
        int opcion;

        System.out.println("Elija que desea eliminar: \n1- Cerveza" +
                "\n2- Agua Saborizada" + "\n3- Gaseosa");
        opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                eliminarCerveza(id);
                break;
            case 2:
                eliminarAguaSaborizada(id);
                break;
            case 3:
                eliminarGaseosa(id);
                break;
            default:
                System.out.println("Opcion no valida");
                eliminarPostrePedido(id);
        }

    }//funcion que elimina una bebida del pedido

    public static void eliminarCerveza(int id) {//funcion que elimina un producto postre del pedido
        limpiarConsola();
        int opcion;
        boolean existeProductoEnPedido = RevolutionBurgers.buscarPorClavePedido("cerveza", id);

        if (existeProductoEnPedido) {
            ArrayList<ElementoMenu> arregloCerveza = RevolutionBurgers.getCajaDia().devolverArregloProductosPorClave("cerveza", id);
            int tamaño = arregloCerveza.size();
            do {
                System.out.println("---Productos cerveza en pedido---");
                System.out.println(RevolutionBurgers.listarDeCajaPedidoPorDigitoYllave(id, "cerveza"));
                System.out.println("Indique la opcion de cerveza: ");
                opcion = scanner.nextInt();
            } while (opcion <= 0 || opcion > tamaño);

            ElementoMenu cervezaEliminar = arregloCerveza.get(opcion - 1);
            System.out.println("Opcion seleccionada: " + cervezaEliminar.toString());
            RevolutionBurgers.eliminardelPedido("cerveza", id, cervezaEliminar);
            System.out.println("Producto eliminado exitosamente.....");

        } else {
            System.out.println(mensajeNoExisteCerveza());
        }
    }//funcion que elimina una cerveza del pedido

    public static void eliminarGaseosa(int id) {//funcion que elimina una gaseosa del pedido
        limpiarConsola();
        int opcion;
        boolean existeProductoEnPedido = RevolutionBurgers.buscarPorClavePedido("gaseosa", id);

        if (existeProductoEnPedido) {
            ArrayList<ElementoMenu> arregloGaseosa = RevolutionBurgers.getCajaDia().devolverArregloProductosPorClave("gaseosa", id);
            int tamaño = arregloGaseosa.size();
            do {
                System.out.println("---Productos gaseosa en pedido---");
                System.out.println(RevolutionBurgers.listarDeCajaPedidoPorDigitoYllave(id, "gaseosa"));
                System.out.println("Indique la opcion de gaseosa: ");
                opcion = scanner.nextInt();
            } while (opcion <= 0 || opcion > tamaño);

            ElementoMenu gaseosaEliminar = arregloGaseosa.get(opcion - 1);
            System.out.println("Opcion seleccionada: " + gaseosaEliminar.toString());
            RevolutionBurgers.eliminardelPedido("gaseosa", id, gaseosaEliminar);
            System.out.println("Producto eliminado exitosamente.....");

        } else {
            System.out.println(mensajeNoExisteGaseosa());
        }
    }//funcion que elimina una gaseosa del pedido

    public static void eliminarAguaSaborizada(int id) {
        limpiarConsola();
        int opcion;
        boolean existeProductoEnPedido = RevolutionBurgers.buscarPorClavePedido("aguaSaborizada", id);

        if (existeProductoEnPedido) {
            ArrayList<ElementoMenu> arregloAguaSaborizada = RevolutionBurgers.getCajaDia().devolverArregloProductosPorClave("aguaSaborizada", id);
            int tamaño = arregloAguaSaborizada.size();
            do {
                System.out.println("---Productos tipo agua saborizada en pedido---");
                System.out.println(RevolutionBurgers.listarDeCajaPedidoPorDigitoYllave(id, "aguaSaborizada"));
                System.out.println("Indique la opcion de agua saborizada: ");
                opcion = scanner.nextInt();
            } while (opcion <= 0 || opcion > tamaño);

            ElementoMenu aguaSaborizadaEliminar = arregloAguaSaborizada.get(opcion - 1);
            System.out.println("Opcion seleccionada: " + aguaSaborizadaEliminar.toString());
            RevolutionBurgers.eliminardelPedido("arregloAguaSaborizada", id, aguaSaborizadaEliminar);
            System.out.println("Producto eliminado exitosamente.....");

        } else {
            System.out.println(mensajeNoExisteAguaSaborizada());
        }
    }//funcion que elimina un producto  agua saborizada del pedido

    public static String mensajeNoExisteBurger() {
        return "No existe ningun producto burger en el pedido...";
    }

    public static String mensajeNoExisteCerveza() {
        return "No existe ningun producto de tipo cerveza en el pedido...";
    }

    public static String mensajeNoExistePostre() {
        return "No existe ningun producto postre en el pedido...";
    }

    public static String mensajeNoExisteGaseosa() {
        return "No existe ningun producto tipo gaseosa en el pedido...";
    }

    public static String mensajeNoExisteAguaSaborizada() {
        return "No existe ningun producto tipo agua saborizada en el pedido...";
    }

    public static Cuota obtenerCuotas() { //se le pregunta al usuario en cuantas cuotas desea pagar y se retona la Cuota
        Cuota nuevaC = null;
        int cantCuotas;
        int opcion;
        System.out.println("Elija una opcion: \n1-Pago en UNA CUOTA" +
                "\n2-Pago en TRES CUOTAS" +
                "\n3-Pago en SEIS");
        opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                nuevaC = Cuota.UNPAGO;
                break;
            case 2:
                nuevaC = Cuota.TRESPAGOS;
                break;
            case 3:
                nuevaC = Cuota.SEISPAGOS;
                break;
            default:
                System.out.println("Opcion no valida..");
                obtenerCuotas();
                break;
        }
        return nuevaC;
    }

    //FUNCIONES MODIFICAR---------------------------------------------------

    public static void modificarUnProductoDePedido(int id, Menu miMenu) {
        System.out.println("Indique que producto desea modificar del pedido: \n1- Burger" +
                "\n2- Bebida" + "\n3- Postre");
        int opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                modificarBurger(id, miMenu);
                break;
            case 2:
                modificarBebida(id, miMenu);
                break;
            case 3:
                modificarPostre(id, miMenu);
                break;
            default:
                System.out.println("Opción no valida");
                break;
        }
    }

    public static void modificarBurger(int id, Menu miMenu) {
        limpiarConsola();
        System.out.println("..Modificar producto burger..");
        eliminarBurgerPedido(id);
        agregarBurger(id, miMenu);
    }

    public static void modificarPostre(int id, Menu miMenu) {
        limpiarConsola();
        System.out.println("..Modificar producto postre..");
        eliminarPostrePedido(id);
        agregarPostre(id, miMenu);
    }

    public static void modificarBebida(int id, Menu miMenu) {
        limpiarConsola();
        System.out.println("..Modificar producto bebida..");
        eliminarBebidaPedido(id);
        agregarBebida(id, miMenu);
    }
//FIN DE FUNCIONES MODIFICAR...


    //FUNCIONES DE AGREGAR--------------------------------------------------
    public static void agregarProductoAPedido(int id, Menu miMenu) {
        char seguir = 's';
        int opcion;

        do {
            limpiarConsola();
            System.out.println("Indique que producto desea agregar al pedido: \n1- Burger" +
                    "\n2- Bebida" + "\n3- Postre");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarBurger(id, miMenu);
                    break;
                case 2:
                    agregarBebida(id, miMenu);
                    break;
                case 3:
                    agregarPostre(id, miMenu);
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
            System.out.println("Para agregar otro producto al pedido presione s: ");
            seguir = scanner.next().charAt(0);
        } while (seguir == 's');

    }//se le da un menu al usuario para que elija que producto agregar


    public static void agregarBebida(int id, Menu miMenu) //se agrega una bebida al pedido indicado
    {
        limpiarConsola();

        System.out.println("Que tipo de bebida desea agregar \n1- Cerveza" +
                "\n2- Gaseosa" + "\n3- Agua saborizada");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                agregarBedidaCerveza(id, miMenu);
                break;
            case 2:
                agregarBebidaGaseosa(id, miMenu);
                break;
            case 3:
                agregarBebidaAguaSaborizada(id, miMenu);
                break;

        }
    }

    public static void agregarBebidaAguaSaborizada(int id, Menu miMenu) //se agrega una  BebidaAguaSaborizada al pedido indicado
    {
        ArrayList<ElementoMenu> arregloDeAguasSab = miMenu.devolverArrayListPorClaveDeMenu("aguaSaborizada");
        int tamaño = arregloDeAguasSab.size();
        char repetir = 's';
        int opcion;

        do {
            limpiarConsola();
            System.out.println(miMenu.listarMenuPorDigitos("aguaSaborizada"));
            do {
                System.out.println("Ingrese una de las opciones disponibles: ");
                opcion = scanner.nextInt();
            } while (opcion <= 0 || opcion > tamaño);

            ElementoMenu nuevaAgua = arregloDeAguasSab.get(opcion - 1);
            System.out.println(nuevaAgua.toString());
            RevolutionBurgers.agregarPedido("aguaSaborizada", id, nuevaAgua);
            System.out.println("Presione 's' para agregar otra agua saborizada o 'n' para salir...");
            repetir = scanner.next().charAt(0);
        } while (repetir == 's');
    }

    public static void agregarBebidaGaseosa(int id, Menu miMenu) //se agrega una  Bebida gaseosa al pedido indicado
    {
        ArrayList<ElementoMenu> arregloDeGaseosas = miMenu.devolverArrayListPorClaveDeMenu("gaseosa");
        int tamaño = arregloDeGaseosas.size();
        char repetir = 's';
        int opcion;

        do {
            limpiarConsola();
            System.out.println(miMenu.listarMenuPorDigitos("gaseosa"));
            do {
                System.out.println("Ingrese una de las opciones disponibles: ");
                opcion = scanner.nextInt();
            } while (opcion <= 0 || opcion > tamaño);

            ElementoMenu nuevaGaseosa = arregloDeGaseosas.get(opcion - 1);
            System.out.println(nuevaGaseosa.toString());
            RevolutionBurgers.agregarPedido("gaseosa", id, nuevaGaseosa);
            System.out.println("Presione 's' para agregar otra gaseosa o 'n' para salir...");
            repetir = scanner.next().charAt(0);
        } while (repetir == 's');
    }

    public static void agregarBedidaCerveza(int id, Menu miMenu) {

        ArrayList<ElementoMenu> arregloDeCervezas = miMenu.devolverArrayListPorClaveDeMenu("cerveza");
        int tamaño = arregloDeCervezas.size();
        char repetir = 's';
        int opcion;

        do {
            limpiarConsola();
            System.out.println(miMenu.listarMenuPorDigitos("cerveza"));
            do {
                System.out.println("Indique una opcion: ");
                opcion = scanner.nextInt();
            } while (opcion <= 0 || opcion > tamaño);

            ElementoMenu nuevaC = arregloDeCervezas.get(opcion - 1);
            System.out.println(nuevaC.toString());
            RevolutionBurgers.agregarPedido("cerveza", id, nuevaC);
            System.out.println("Para agregar otra cerveza presione 's' o 'n' para salir");
            repetir = scanner.next().charAt(0);
        } while (repetir == 's');

    }//se agrega una  Bebida cerveza al pedido indicado

    public static void agregarBurger(int id, Menu miMenu) {
        limpiarConsola();
        int opcion;
        ArrayList<ElementoMenu> arregloHamburguesas = miMenu.devolverArrayListPorClaveDeMenu("burger");
        int tamaño = arregloHamburguesas.size();
        char repetir = 's';
        System.out.println("..Agregar un nuevo pedido...");

        do {
            limpiarConsola();
            System.out.println(miMenu.listarMenuPorDigitos("burger"));
            do {
                System.out.println("Indique la opcion que desee: ");
                opcion = scanner.nextInt();//faltaria validar que la opcion ente dento de las validas, leght del arreglo burger
            } while (opcion <= 0 || opcion > tamaño);

            //preguntar de tal estilo cuantas desea agregar, hacer un while agregando la cant de burgers indicada, validar que el num sea si o si mayor a 0
            ElementoMenu nuevaBurger = arregloHamburguesas.get(opcion - 1);
            System.out.println(nuevaBurger.toString());
            Burger nuevaB = (Burger) nuevaBurger;
            String estilo = nuevaB.getTipoHamburguesa();
            RevolutionBurgers.agregarPedido("burger", id, nuevaBurger);
            System.out.println("Para agregar otra hamburgesa presione 's' o 'n' para salir");
            repetir = scanner.next().charAt(0);
        } while (repetir == 's');

    }//se agrega una  burger al pedido indicado


    public static void agregarPostre(int id, Menu miMenu) {
        limpiarConsola();
        int opcion;
        ArrayList<ElementoMenu> arregloPostres = miMenu.devolverArrayListPorClaveDeMenu("postre");
        int tamaño = arregloPostres.size();
        char repetir = 's';

        do {
            limpiarConsola();
            System.out.println(miMenu.listarMenuPorDigitos("postre"));
            do {
                System.out.println("Indique el postre que desea: ");
                opcion = scanner.nextInt();
            } while (opcion <= 0 || opcion > tamaño);

            //preguntar de tal estilo cuantas desea agregar, hacer un while agregando la cant de burgers indicada, validar que el num sea si o si mayor a 0
            ElementoMenu postreN = arregloPostres.get(opcion - 1);
            Postre nuevoP = (Postre) postreN;
            String nombreP = nuevoP.getNombreDelPostre();
            RevolutionBurgers.agregarPedido("postre", id, postreN);
            System.out.println(RevolutionBurgers.buscarPedido("postre", id, postreN));
            System.out.println("Pedido: " + RevolutionBurgers.listarTodounPedido(id));
            System.out.println("Para agregar otro postre presione 's'");
            repetir = scanner.next().charAt(0);
        } while (repetir == 's');

    }//se agrega un postre al pedido indicado
//FIN DE FUNCIONES AGREGAR


    public static Persona cargarDatosPersona() {
        String nombre, telefono, dni, direccion;
        nombre = cargarDatoNombre();
        dni = cargarDatosDni();
        telefono = cargarDatosTelefono();
        direccion = cargarDatoDireccion();

        Persona cliente = new Persona(nombre, dni, direccion, telefono);

        return cliente;
    } //se cargan los datos de el cliente que va a pagar el pedido

    public static String cargarDatoNombre() {
        String nombreYapellido;

        System.out.println("\nPresione enter....");
        scanner.nextLine();
        System.out.println("Ingrese nombre y apellido completo: ");
        nombreYapellido = scanner.nextLine();

        try {
            Persona.validarNombrePersona(nombreYapellido); //intenta validar el nombre de la persona
        } catch (InvalidNameExcepcion ex) { //si el nombre no es valido se lanza la excepcion
            System.out.println(ex.getMessage());
            nombreYapellido = cargarDatoNombre();

        }
        return nombreYapellido;
    }

    public static String cargarDatosDni() {
        String dni;

        System.out.println("\nPresione enter....");
        scanner.nextLine();
        System.out.println("Ingrese DNI:");
        dni = scanner.nextLine();

        try {
            Persona.validarDniPersona(dni); //se valida el dni de la persona
        } catch (InvalidDniExcepcion ex) { //si no es valido se lanza la excepcion
            System.out.println(ex.getMessage());
            dni = cargarDatosDni();

        }
        return dni;
    }

    public static String cargarDatosTelefono() {
        String telefono;
        System.out.println("Ingrese numero de telefono incluyendo la caracteristica (Ej: 223)");
        telefono = scanner.nextLine();

        try {
            Persona.validarTelefonoPersona(telefono); //se valida el num telefono
        } catch (InvalidCardNumberException ex) { // si  no es valido se lanza la excepcion
            System.out.println(ex.getMessage());
            telefono = cargarDatosTelefono();

        }
        return telefono;
    }

    public static String cargarDatoDireccion() {
        String direccion;
        scanner.nextLine();
        System.out.println("Ingrese direccion");
        direccion = scanner.nextLine();

        return direccion;
    }

    public static Pago obtenerPago(double montoTotal) { //se piden los datos de pago
        int opcion;
        Tarjeta tipoTarjeta = null;
        TipoCuenta tipoCuenta = null;
        String numTarjeta;
        Persona cliente = cargarDatosPersona();

        numTarjeta = ingresarTarjeta();
        tipoCuenta = ingresarTipoCuenta();
        tipoTarjeta = ingresarTipoTarjeta();
        Pago tarjeta = new PagoTarjeta(montoTotal, cliente, numTarjeta, tipoTarjeta, tipoCuenta);

        if (tipoCuenta.equals(TipoCuenta.CREDITO)) {
            if (tarjeta instanceof PagoTarjeta) {
                PagoTarjeta tarjetaP = (PagoTarjeta) tarjeta;
                Cuota cuota = obtenerCuotas();
                tarjetaP.establecerCuotas(cuota);
                double montoCuota = tarjetaP.calcularMontoCuotasAPagar();
                System.out.println("Monto total: $" + montoTotal);
                System.out.println("Monto de cuotas: $" + montoCuota);
            }
        }

        return tarjeta;
    }

    public static Tarjeta ingresarTipoTarjeta() {
        int opcion;
        System.out.println("Tipo de tarjeta: 1.VISA | 2.MASTERCARD | 3.NARANJA | 4.FAVACARD | 5.CABAL");
        opcion = scanner.nextInt();
        Tarjeta tipo = null;
        switch (opcion) {
            case 1:
                tipo = Tarjeta.VISA;
                break;

            case 2:
                tipo = Tarjeta.MASTERCARD;
                break;

            case 3:
                tipo = Tarjeta.NARANJA;
                break;

            case 4:
                tipo = Tarjeta.FAVACARD;
                break;

            case 5:
                tipo = Tarjeta.CABAL;
                break;

            default:
                System.out.println("Opcion invalida");
                ingresarTipoTarjeta();
                break;
        }
        return tipo;
    }

    public static TipoCuenta ingresarTipoCuenta() {
        int opcion;
        TipoCuenta tipoC = null;
        System.out.println("Tipo de cuenta: 1.CREDITO | 2.DEBITO");
        opcion = scanner.nextInt();


        switch (opcion) {
            case 1:
                tipoC = TipoCuenta.CREDITO;
                break;

            case 2:
                tipoC = TipoCuenta.DEBITO;
                break;

            default:
                System.out.println("Opcion invalida");
                ingresarTipoCuenta();
                break;
        }
        return tipoC;
    }

    public static String ingresarTarjeta() {
        String numTarjeta;

        System.out.println("\nPresione enter....");
        scanner.nextLine();
        System.out.println("Ingrese el numero de tarjeta (XXXX XXXX XXXX XXXX)");
        numTarjeta = scanner.nextLine();

        try {
            PagoTarjeta.validarDigitosNumeroTarjeta(numTarjeta);

        } catch (InvalidCardNumberException ex) {
            System.out.println(ex.getMessage());
            numTarjeta = ingresarTarjeta();

        }
        return numTarjeta;
    }

    //VER RECAUDACION DEL DIA
    public static void verRecaudacionCajaDelDia() {
        limpiarConsola();
        int opcion;
        System.out.println("Indique que tipo de recaudacion del dia quiere ver: \n1- Recaudacion total del dia" +
                "\n2- Recaudación total de pagos en efectivo" + "\n3- Recaudación total de pagos con tarjeta");
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                mostrarRecaudacionTotal();
                break;
            case 2:
                mostrarRecaudacionEfectivo();
                break;
            case 3:
                mostrarRecaudacionTarjeta();
                break;
            default:
                System.out.println("Opcion no valida......");
                verRecaudacionCajaDelDia();
                break;
        }
    }

    public static void mostrarRecaudacionTotal() { //se muestra la recaudacion total del dia
        double recaudacionTotal = RevolutionBurgers.obtenerMontoTotalCajaDia();
        System.out.println("Recaudacion total del dia..........$" + recaudacionTotal);
    }

    public static void mostrarRecaudacionEfectivo() {
        double recaudacionE = RevolutionBurgers.obtenerRecudacionPagoEfectivo();
        System.out.println("Recaudacion total del dia..........$" + recaudacionE);
    }//se muestra la recaudacion del dia pero solo de pagos en efectivo

    public static void mostrarRecaudacionTarjeta() {
        double recaudacionT = RevolutionBurgers.obtenerRecudacionPagoTarjeta();
        System.out.println("Recaudacion total del dia..........$" + recaudacionT);
    }//se muestra la recaudacion del dia pero solo de pagos con tarjeta

    public static Date devolverDate(int dia, int mes, int anio) {
        Date fecha = null;
        if (RevolutionBurgers.validarFecha(dia, mes, anio)) {
            String fechaString = dia + "/" + mes + "/" + anio;
            try {
                fecha = RevolutionBurgers.convertirFecha(fechaString);
            } catch (ParseException e) {
                System.out.println("Error al convertir la fecha.");
            }
        } else {
            System.out.println("Fecha inválida.");
        }
        return fecha;
    }

    SimpleDateFormat formatoSalida = new SimpleDateFormat("dd/MM/yyyy");


    public static void opcionesEstadistica() {

        limpiarConsola();
        //RevolutionBurgers.deCajaaEstadistica(); //funciona
        //System.out.println(RevolutionBurgers.listarTodaslasestadisticas());//funciona
        int opcion;
        System.out.println("Indique que opcion desea realizar \n1- Ver la estadistica por fecha" +
                "\n2- Ranking de productos");
        opcion= scanner.nextInt();
        //RevolutionBurgers.crearArregloEstadistica(); funciones
        switch (opcion){
            case 1:

                break;
            case 2:
                RevolutionBurgers.generarEstadisticas();
                System.out.println(RevolutionBurgers.listarTodoelAcumulador());
                break;
            default:
                System.out.println("Opcion no valida......");
                break;
        }
    }


}
