package Clases;

import Excepciones.InvalidCardNumberException;
import Excepciones.InvalidDniExcepcion;
import Excepciones.InvalidNameExcepcion;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuOpciones {
    static Scanner scanner;

    public static void iniciarScanner(){
        scanner = new Scanner(System.in);
    }

    public static void cerrarScanner(){
        scanner.close();
    }



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

    public static void opcionesPedido(Menu miMenu){
        limpiarConsola();
        System.out.println("Ingrese la opcion que desee: " +
                "\n1- Crear nuevo pedido" +
                "\n2-Ver pedidos existentes");
        int opcion= scanner.nextInt();
        switch (opcion){
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
    }

    public static void crearNuevoPedido(Menu miMenu){
        limpiarConsola();
        RevolutionBurgers.crearPedido();
        System.out.println("Pedido creado exitosamente....");
        System.out.println("\nAgregar elementos al pedido: ");
        int idNuevoPedido= RevolutionBurgers.obtenerUltimoIdPedido();
        agregarProductoAPedido(idNuevoPedido,miMenu);
        System.out.println("Pedido: \n"+RevolutionBurgers.listarTodounPedido(idNuevoPedido));
    }

    public static void opcionesPedidosExistentes(Menu miMenu){
        char continuar='s';
        limpiarConsola();
        if(RevolutionBurgers.cantPedidosNoPagos()==0){ //si no hay ningun pedido creado
            System.out.println("No hay ningun pedido creado del dia, primero cree uno");

        }else {
            System.out.println("\n..Pedidos activos..\n");
            System.out.println(RevolutionBurgers.listarTodosLosPedidosNoPagos()); //se muestran todos los pedidos no pagos
            int numOpciones= RevolutionBurgers.cantOpcionesValidasPedido();
            int opcion;

            while (continuar=='s') {
                do{
                    System.out.println("Elija la opcion del pedido que desea: ");
                    opcion = scanner.nextInt();
                }while (opcion<0 || opcion>numOpciones); //se valida que la opcion elegida este dentro de las opciones validas

                int id= RevolutionBurgers.obtenerIdDeOpcionPedido(opcion);//obtengo el id asociado a la opcion
                opcionesParaRealizarEnPedidosNoPagos(id, miMenu);

                limpiarConsola();
                System.out.println("Presione 's' para volver a ver el menu de pedidos existentes: ");
                continuar=scanner.next().charAt(0);
            }
        }

    }


    public static void opcionesParaRealizarEnPedidosNoPagos(int id, Menu miMenu){ //se recibe por parametro el id del pedido
        int opcion;

        System.out.println("Elija una opcion: \n1- Agregar un producto" +
                "\n2.Modificar pedido\n" +
                "\n3. Mostrar el pedido completo" +
                "\n4.Eliminar un producto del pedido" +
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
        System.out.println("\nPAGAR\nIndicar: \n1-Pago en efectivo" +
                "\n2-Pago con tarjeta");
        int opcion= scanner.nextInt();
        switch (opcion){
            case 1:
                RevolutionBurgers.cambiarEstadoDePago(id);
                System.out.println("..pago exitoso..");
                break;
            case 2:
                double montoTotal= RevolutionBurgers.obtenerMontoPedido(id);
                Pago nuevoPago= obtenerPago();
                RevolutionBurgers.agregarPagoAlPedido(nuevoPago, id);
                System.out.println("..pago exitoso..");
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }


    public static void agregarProductoAPedido(int id, Menu miMenu){
        System.out.println("Indique que producto desea agregar al pedido: \n1- Burger" +
                "\n2- Bebida"+ "\n 3-Postre");
        int opcion= scanner.nextInt();
        switch (opcion){
            case 1:
                agregarBurger(id, miMenu);
                break;
            case 2:
                //agregarBebida(id, miMenu);
                System.out.println("Aca iria la funcion para agregar bebida");
                break;
            case 3:
                agregarPostre(id, miMenu);
                break;

        }

    }


    public static void mostrarUnPedido(int id){
        System.out.println("\n....PEDIDO....");
        RevolutionBurgers.listarTodounPedido(id);
    }


    public static void agregarBurger(int id, Menu miMenu){
        limpiarConsola();
        int opcion;
        ArrayList<ElementoMenu> arregloHamburguesas= miMenu.devolverArrayListPorClaveDeMenu("burger");
        int tamaño= arregloHamburguesas.size();
        char repetir='s';

        do{
            limpiarConsola();
            System.out.println(miMenu.listarMenuPorDigitos("burger"));
            do{
                System.out.println("Indique el estilo de hamburgesa: ");
                opcion= scanner.nextInt();//faltaria validar que la opcion ente dento de las validas, leght del arreglo burger
            }while (opcion<=0 || opcion>tamaño);

            //preguntar de tal estilo cuantas desea agregar, hacer un while agregando la cant de burgers indicada, validar que el num sea si o si mayor a 0
            ElementoMenu nuevaBurger= arregloHamburguesas.get(opcion-1);
            System.out.println(nuevaBurger.toString());
            Burger nuevaB= (Burger) nuevaBurger;
            String estilo= nuevaB.getTipoHamburguesa();
            RevolutionBurgers.agregarPedido(estilo, id,nuevaBurger);
            System.out.println("Para agregar otra hamburgesa presione 's'");
            repetir= scanner.next().charAt(0);
        }while (repetir=='s');

    }




    public static void agregarPostre(int id, Menu miMenu){
        limpiarConsola();
        int opcion;
        ArrayList<ElementoMenu> arregloPostres= miMenu.devolverArrayListPorClaveDeMenu("postre");
        int tamaño= arregloPostres.size();
        char repetir='s';

        do{
            limpiarConsola();
            System.out.println(miMenu.listarMenuPorDigitos("postre"));
            do{
                System.out.println("Indique el postre que desea: ");
                opcion= scanner.nextInt();
            }while (opcion<=0 || opcion>tamaño);

            //preguntar de tal estilo cuantas desea agregar, hacer un while agregando la cant de burgers indicada, validar que el num sea si o si mayor a 0
            ElementoMenu postreN= arregloPostres.get(opcion-1);
            Postre nuevoP= (Postre) postreN;
            String nombreP= nuevoP.getNombreDelPostre();
            RevolutionBurgers.agregarPedido(nombreP, id,postreN);
            System.out.println(RevolutionBurgers.buscarPedido("postre", id,postreN));
            System.out.println("Pedido: "+RevolutionBurgers.listarTodounPedido(id));
            System.out.println("Para agregar otro postre presione 's'");
            repetir= scanner.next().charAt(0);
        }while (repetir=='s');

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



         tipoC= ingresarTipoCuenta();

        numTarjeta= ingresarTarjeta();
        Pago tarjeta= new PagoTarjeta(monto,cliente, numTarjeta,tipo,tipoC);
        return tarjeta;
    }

    public static Tarjeta ingresarTipoTarjeta(){
        int opcion;
        System.out.println("Tipo de tarjeta: 1.VISA | 2.MASTERCARD | 3.NARANJA | 4.FAVACARD | 5.CABAL");
        opcion = scanner.nextInt();
        Tarjeta tipo=null;
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
                ingresarTarjeta();
                break;
        }
        return tipo;
    }

    public static TipoCuenta ingresarTipoCuenta(){
        int opcion;
        System.out.println("Tipo de cuenta: 1.CREDITO | 2.DEBITO");
        opcion = scanner.nextInt();
        TipoCuenta tipoC= null;
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
