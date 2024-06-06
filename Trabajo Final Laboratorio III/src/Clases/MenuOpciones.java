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
                "\n2- Ver pedidos existentes");
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
        char seguir = 's';

        do {
            System.out.println("Elija una opcion: \n1- Agregar un producto" +
                    "\n2.Modificar pedido" +
                    "\n3.Mostrar el pedido completo" +
                    "\n4.Eliminar un producto del pedido" +
                    "\n5.Realiza pago");

            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    agregarProductoAPedido(id, miMenu);
                    break;
                case 2:
                    modificarUnProductoDePedido (id, miMenu);

                    break;
                case 3:
                    mostrarUnPedido(id);
                    break;
                case 4:

                    break;
                case 5:
                    realizarPagoPedido(id);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }

            System.out.println("Presione 's' para volver al menu de PEDIDOS ACTIVOS...");
            seguir = scanner.next().charAt(0);
        }while (seguir=='s');

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

    public static void mostrarUnPedido(int id){
        System.out.println("\n....PEDIDO....");
        RevolutionBurgers.listarTodounPedido(id);
    }

    //FUNCIONES MODIFICAR---------------------------------------------------

    public static void modificarUnProductoDePedido(int id, Menu miMenu)
    {
       //falta mostrar lista de existentes y en base a la opcion valida modificar. 
        System.out.println("Indique que producto desea modificar del pedido: \n1- Burger" +
                "\n2- Bebida"+ "\n3- Postre");
        int opcion= scanner.nextInt();
        switch (opcion){
            case 1:
                modificarBurger(id, miMenu);
                break;
            case 2:

                break;
            case 3:

                break;
            default:
                System.out.println("Opción no valida");
                break;
        }
    }

    public static void modificarBurger (int id, Menu miMenu)
    {
        limpiarConsola();


    }
//FIN DE FUNCIONES MODIFICAR...


//FUNCIONES DE AGREGAR--------------------------------------------------
    public static void agregarProductoAPedido(int id, Menu miMenu){
        System.out.println("Indique que producto desea agregar al pedido: \n1- Burger" +
                "\n2- Bebida"+ "\n3- Postre");
        int opcion= scanner.nextInt();
        switch (opcion){
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
    }


    public static void agregarBebida(int id, Menu miMenu)
    {
        limpiarConsola();

        System.out.println("Que tipo de bebida desea agregar \n1- Cerveza" +
                "\n2- Gaseosa"+ "\n3- Agua saborizada");
         int opcion= scanner.nextInt();

        switch (opcion){
            case 1:
                agregarBedidaCerveza (id, miMenu);
                break;
            case 2:
                agregarBebidaGaseosa(id, miMenu);
                break;
            case 3:
                agregarBebidaAguaSaborizada(id, miMenu);
                break;

        }
    }

    public static void agregarBebidaAguaSaborizada (int id, Menu miMenu)
    {
        ArrayList<ElementoMenu> arregloDeAguasSab= miMenu.devolverArrayListPorClaveDeMenu("aguaSaborizada");
        int tamaño= arregloDeAguasSab.size();
        char repetir='s';
        int opcion;

        do{
            limpiarConsola();
            System.out.println(miMenu.listarMenuPorDigitos("aguaSaborizada"));
            do{
                System.out.println("Ingrese una de las opciones disponibles: ");
                opcion= scanner.nextInt();
            }while (opcion<=0 || opcion>tamaño);

            ElementoMenu nuevaAgua= arregloDeAguasSab.get(opcion-1);
            System.out.println(nuevaAgua.toString());
            AguaSaborizada aguaSab= (AguaSaborizada) nuevaAgua;
            String tipo= aguaSab.getTipoBebida();
            RevolutionBurgers.agregarPedido(tipo, id,nuevaAgua);
            System.out.println("Presione 's' para agregar una gaseosa...");
            repetir= scanner.next().charAt(0);
        }while (repetir=='s');
    }

    public static void agregarBebidaGaseosa (int id, Menu miMenu)
    {
        ArrayList<ElementoMenu> arregloDeGaseosas= miMenu.devolverArrayListPorClaveDeMenu("gaseosa");
        int tamaño= arregloDeGaseosas.size();
        char repetir='s';
        int opcion;

        do{
            limpiarConsola();
            System.out.println(miMenu.listarMenuPorDigitos("gaseosa"));
            do{
                System.out.println("Ingrese una de las opciones disponibles: ");
                opcion= scanner.nextInt();
            }while (opcion<=0 || opcion>tamaño);

            ElementoMenu nuevaGaseosa= arregloDeGaseosas.get(opcion-1);
            System.out.println(nuevaGaseosa.toString());
            Gaseosa gaseosa= (Gaseosa) nuevaGaseosa;
            String tipo= gaseosa.getTipoBebida();
            RevolutionBurgers.agregarPedido(tipo, id,nuevaGaseosa);
            System.out.println("Presione 's' para agregar una gaseosa...");
            repetir= scanner.next().charAt(0);
        }while (repetir=='s');
    }

    public static void agregarBedidaCerveza (int id, Menu miMenu) {

        ArrayList<ElementoMenu> arregloDeCervezas= miMenu.devolverArrayListPorClaveDeMenu("cerveza");
        int tamaño= arregloDeCervezas.size();
        char repetir='s';
        int opcion;

        do{
            limpiarConsola();
            System.out.println(miMenu.listarMenuPorDigitos("cerveza"));
            do{
                System.out.println("Indique una opcion: ");
                opcion= scanner.nextInt();
            }while (opcion<=0 || opcion>tamaño);

            ElementoMenu nuevaC= arregloDeCervezas.get(opcion-1);
            System.out.println(nuevaC.toString());
            Cerveza nuevaCerveza= (Cerveza) nuevaC;
            String tipo= nuevaCerveza.getTipoBebida();
            RevolutionBurgers.agregarPedido(tipo, id,nuevaCerveza);
            System.out.println("Para agregar otra cerveza presione 's'");
            repetir= scanner.next().charAt(0);
        }while (repetir=='s');

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
//FIN DE FUNCIONES AGREGAR


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
