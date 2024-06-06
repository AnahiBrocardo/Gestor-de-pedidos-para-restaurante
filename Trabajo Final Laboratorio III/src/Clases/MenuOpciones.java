package Clases;

import Excepciones.InvalidCardNumberException;
import Excepciones.InvalidDniExcepcion;
import Excepciones.InvalidNameExcepcion;

import java.util.Scanner;

public class MenuOpciones {
    Scanner scanner = new Scanner(System.in);

    public static void limpiarConsola() { //funcion que imprime varias líneas en blanco en la consola
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void abrirCajaDelDia(){
        System.out.println("Abriendo caja...");
        RevolutionBurgers.abrirCaja();
        System.out.println("Caja abierta exitosamente");
    }

    /*    System.out.println("3. Agregar pedido");
            System.out.println("4. Modificar pedido");*/
    public static void opcionesPedido(Menu miMenu){
        char continuar='s';
        limpiarConsola();
        System.out.println(RevolutionBurgers.listarTodosLosPedidosNoPagos());
        int numOpciones= RevolutionBurgers.cantOpcionesValidasPedido();
        int opcion;

        while (continuar=='s') {
            do{
                System.out.println("Elija la opcion del pedido que desea: ");
                opcion = scanner.nextInt();
            }while (opcion<0 || opcion>numOpciones);

            int id= RevolutionBurgers.obtenerIdDeOpcionPedido(opcion);//obtengo el id asociado a la opcion
            opcionesParaRealizarEnPedidosNoPagos(id, miMenu);

            limpiarConsola();
            //
        }
    }


    public static void opcionesParaRealizarEnPedidosNoPagos(int id, Menu miMenu){ //se recibe por parametro el id del pedido
        int opcion;

        System.out.println("Elija una opcion: \n1- Agregar un producto" +
                "\n2.Modificar pedido\n" +
                "\n3- Mostrar el pedido completo" +
                "\n4- -Eliminar un producto del pedido" +
                "\n5. Realiza pago");

        opcion = scanner.nextInt();
        switch (opcion) {
            case 1:
                agregarProductoAPedido(id, miMenu);
                break;
            case 2:
                //hacer

                break;
            case 3:
                mostrarUnPedido(id);
                break;
            case 4:

                break;
            case 5:
                limpiarConsola();
                realizarPagoPedido(id);
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        }
    }

    public static void realizarPagoPedido(int id){
        System.out.println("Indicar: \n1-Pago en efectivo" +
                "\nPago con tarjeta");
        int opcion= scanner.nextInt();
        switch (opcion){
            case 1:
                RevolutionBurgers.cambiarEstadoDePago(id);
                break;
            case 2:
                double montoTotal= RevolutionBurgers.obtenerMontoPedido(id);
                //Pago nuevoPago= obtenerPago();
                //RevolutionBurgers.agregarPagoAlPedido(nuevoPago, id);
                break;
        }
    }


    public static void agregarProductoAPedido(int id, Menu miMenu){
        System.out.println("Indique que producto desea agregar al pedido: \n1- Burger" +
                "\n2- Bebida"+ "\n 3- Postre");
        int opcion= scanner.nextInt();
        switch (opcion){
            case 1:
                agregarBurger(id, miMenu);
                break;
            case 2:
                //agregarBebida(id, miMenu);
                break;
            case 3:
                //agregarPostre(id, miMenu);
                break;

        }

    }



    public static void mostrarUnPedido(int id){
        System.out.println("\n....PEDIDO....");
        RevolutionBurgers.listarTodounPedido(id);
    }


    public static void agregarBurger(int id, Menu miMenu){
        int opcion;
        System.out.println("Indique el estilo de hamburgesa: \n1. Veggie" +
                "\nAmericana" +
                "\nMexicana" +
                "\nIconic");
        //ver si en vez de trabajar con el menu puedo mediante una funcion acceder al json para traerme cada atributo y pasarlo a constructor o necesiro hacerlo en el  menu4
        // en la clase menu que me liste los elementos del array con la clave-> y me lo devuelva , asociar con opciones y cuando selecciona una opcion y con esa posicion que devuelva un elemento burger
    }

    public static Persona cargarDatosPersona () {
        String nombre, telefono, dni, direccion;
        nombre = cargarDatoNombre();
        dni = cargarDatosDni();
        telefono = cargarDatosTelefono();
        direccion = cargarDatoDireccion();

        Persona cliente = new Persona(nombre, dni, direccion, telefono);

        return cliente;
    }

    public static String cargarDatoNombre(){
        String nombre;

        System.out.println("\nPresione enter....");
        scanner.nextLine();
        System.out.println("Ingrese su nombre y apellido completo");
        nombre = scanner.nextLine();

        try  {
            Persona.validarNombrePersona(nombre);
        }
        catch (InvalidNameExcepcion ex){
            System.out.println(ex.getMessage());
            nombre= cargarDatoNombre();

        }
        return nombre;
    }

    public static String cargarDatosDni(){
        String dni;

        System.out.println("\nPresione enter....");
        scanner.nextLine();
        System.out.println("Ingrese DNI:");
        dni = scanner.nextLine();

        try  {
            Persona.validarDniPersona(dni);
        }
        catch (InvalidDniExcepcion ex){
            System.out.println(ex.getMessage());
            dni= cargarDatosDni();

        }
        return dni;
    }

    public static String cargarDatosTelefono(){
        String telefono;
        System.out.println("\nPresione enter....");
        scanner.nextLine();
        System.out.println("Ingrese numero de telefono incluyendo la caracteristica (Ej: 223)");
        telefono = scanner.nextLine();

        try  {
            Persona.validarTelefonoPersona(telefono);
        }
        catch (InvalidCardNumberException ex){
            System.out.println(ex.getMessage());
            telefono= cargarDatosTelefono();

        }
        return telefono;
    }

    public static String cargarDatoDireccion ()
    {
        String direccion;
        scanner.nextLine();
        System.out.println("Ingrese direccion");
        direccion = scanner.nextLine();

        return direccion;
    }

    public static Pago obtenerPago() { //ACHICAR
        double monto = 0;
        int opcion;
        Tarjeta tipo= null;
        TipoCuenta tipoC= null;
        String numTarjeta;
        Persona cliente= cargarDatosPersona();

        System.out.println("Tipo de tarjeta: 1.VISA | 2.MASTERCARD | 3.NARANJA | 4.FAVACARD | 5.CABAL");
        opcion = scanner.nextInt();
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
                break;
        }

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
                break;
        }

        numTarjeta= ingresarTarjeta();
        Pago tarjeta= new PagoTarjeta(monto,cliente, numTarjeta,tipo,tipoC);
        return tarjeta;
    }

    public static String ingresarTarjeta(){
        String numTarjeta;

        System.out.println("\nPresione enter....");
        scanner.nextLine();
        System.out.println("Ingrese el numero de tarjeta (XXXX XXXX XXXX XXXX)");
        numTarjeta = scanner.nextLine();

        try  {
            PagoTarjeta.validarDigitosNumeroTarjeta(numTarjeta);

        }
        catch (InvalidCardNumberException ex){
            System.out.println(ex.getMessage());
            numTarjeta= ingresarTarjeta();

        }
        return numTarjeta;
    }


}
