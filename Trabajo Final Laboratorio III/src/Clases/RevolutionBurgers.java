package Clases;

import Archivos.ControladoraArchivosEstadistica;

import javax.swing.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//cuando lo queremos usar en el main hacemos: RevolutionBurguer + . y el metodo global
public class RevolutionBurgers implements Serializable {
    private static Caja cajaDia;
    private static boolean valor;
    private static int idpedido= 100;
    private static HashMap<String, Integer> mapaEstadisticas;
    private static Estadistica nuevaEstadistica;
    private static ArrayList<Estadistica> auxarraylist;
    private static HashMap<String, Integer> acumulador; //poner dentro de una funcion no en los atributos
    //private static ArrayList<Estadistica> archivoEstadisticas = new ArrayList<>();

    ////CAJA DEL DIA
    public static void abrirCaja(){
        cajaDia = new Caja();
    }
    public static void cerrarCaja(){
        cajaDia.setEstado(false);
    }
    public static double totalRecaudacion(){
        double totalRecaudacion= cajaDia.calcularTotalCaja();
        return totalRecaudacion;
    }
    //funcion para ver total recaudado en efectivo
    public static double totalRecaudadoEfectivo(){
        double efectivo= cajaDia.calcularTotalEfectivo();
        return efectivo;
    }
    //funcion para ver total recaudado en tarjeta.
    public static double totalRecaudadoTarjeta(){
        double tarjeta= cajaDia.calcularTotalEfectivo();
        return tarjeta;
    }
    ///PEDIDOS
    private static void incrementador(){
        idpedido = idpedido + 1;
    }
    public static void crearPedido(){
        incrementador();
        cajaDia.crearPedido(idpedido);
    }

    public static boolean agregarPedido(String key, int idPedido, ElementoMenu nuevoElementoMenu){

        return valor= cajaDia.agregarApedido(key, nuevoElementoMenu, idPedido);
    }
    public static boolean modificarPedido(String key, int idPedido, ElementoMenu aCambiar, ElementoMenu aAgregar){
        return valor= cajaDia.modificarPedido(key, idPedido, aCambiar, aAgregar);
    }
    public static boolean buscarPedido(String key, int idPedido, ElementoMenu aBuscado){
        return valor= cajaDia.buscarPedido(key, idPedido, aBuscado);
    }

    public static boolean buscarPorClavePedido(String clave, int id){
        boolean existe= cajaDia.buscarPorClavePedido(clave, id);
        return  existe;
    }

    public static double obtenerMontoPedido(int idPedido){
        double monto;
        return monto= cajaDia.obtenerMontoP(idPedido);
    }

    public static void agregarPagoAlPedido(Pago nuevoPago, int id){
        cajaDia.agregarPago(nuevoPago,id);
    }

    public static boolean eliminardelPedido(String key, int idPedido, ElementoMenu aEliminar){
        return valor= cajaDia.eliminardePedido(key, idPedido, aEliminar);
    }
    public static String listarbuscadoenPedido(String key, int idPedido){
        String pedido= "";
        pedido=cajaDia.listarBuscadoenelPedido(key, idPedido);
        return pedido;
    }
    public static String listarTodounPedido(int idPedido){
        String pedido= "";
        pedido=cajaDia.listarTodounPedido(idPedido);
        return pedido;
    }


    public ArrayList<ElementoMenu> devolverArregloPedidoPorClave(int id, String clave){
        ArrayList<ElementoMenu> arregloPorClave= cajaDia.devolverArregloProductosPorClave(clave,id);
        return arregloPorClave;
    }
    public static String listarDeCajaPedidoPorDigitoYllave(int id, String clave){
        String info="";
        info= cajaDia.listarPedidoPorDigitiYllave(id,clave);
        return info;
    }
    public static String listarTodosLosPedidosNoPagos(){
        String pedido= "";
        pedido=cajaDia.listarPedidosNoPagos();
        return pedido;
    }

    public static int obtenerIdDeOpcionPedido (int opcion){
        HashMap<Integer,Integer>mapaPedidos= cajaDia.mapaPedidosOpcionID();
        int id= mapaPedidos.get(opcion);
        return id;
    }

    public static int cantOpcionesValidasPedido(){
        HashMap<Integer,Integer>mapaPedidos= cajaDia.mapaPedidosOpcionID();
        int numeroEntradas = mapaPedidos.size();
        return numeroEntradas;
    }


    public static int cantPedidosNoPagos(){
        int cant= cajaDia.cantPedidosNoPagos();
        return cant;
    }
    ///ESTADISTICAS

    public static void deCajaaEstadistica() {
        mapaEstadisticas = new HashMap<>();
        for (int i = 0; i < cajaDia.getNuevoArreglo().size(); i++) {
            //Antes de castear if(instanceof Pedido)ap
            Pedido pedido = (Pedido) cajaDia.getPos(i);
            //acceder a map
            Iterator<Map.Entry<String, ArrayList<ElementoMenu>>> entryIterator = pedido.getMapa().getEntrySet().iterator();
            //recorrer map
            //instanciamos el mapa de estadisticas porque esta funcion se llama una sola vez al final del dia
            //mapaEstadisticas = new HashMap<>();
            while (entryIterator.hasNext()) {
                Map.Entry<String, ArrayList<ElementoMenu>> entry = entryIterator.next();
                ArrayList<ElementoMenu> menuItems = entry.getValue();
                //recorrer arreglo de productos
                for (int b = 0; b < menuItems.size(); b++) {
                    ElementoMenu item = menuItems.get(b);
                    //agregar elementos al mapa de estadisticas
                    if (item instanceof Postre) {
                        agregarElementos(((Postre) item).getNombreDelPostre());
                    } else if (item instanceof Burger) {
                        agregarElementos(((Burger) item).getTipoHamburguesa());
                    } else if (item instanceof Bebida) {
                        agregarElementos(((Bebida) item).getTipoBebida());
                    }
                }
            }
        }

        nuevaEstadistica = new Estadistica(cajaDia.getFecha(), mapaEstadisticas, cajaDia.calcularTotalCaja());
        agregarDatoalaEstadistica();
    }



/*
    public static void guardarArchivoEstadistico(){
        ControladoraArchivosEstadistica.grabarArchivo(archivoEstadisticas);
    }
    /// agregar la estadistica del dia al arreglo de estadistica
    public static void agregarEstadisticadelDiaAlArchivo(){
        archivoEstadisticas.add(nuevaEstadistica);
    }

    public static void leerArchi(){
        archivoEstadisticas= ControladoraArchivosEstadistica.leerArchivo();
    }
    */;
    public static String listarEstatidistica(){
        String rta="";
        rta= nuevaEstadistica.toString();
        return rta;
    }



    private static void agregarElementos(String key){
        if (mapaEstadisticas.containsKey(key)) {
            // Si la llave ya existe, incrementar su valor en 1
            int valorActual = mapaEstadisticas.get(key);
            mapaEstadisticas.put(key, valorActual + 1);
        } else {
            // Si la llave no existe, crearla con un valor inicial de 1
            mapaEstadisticas.put(key, 1);
        }

    }
    


    public static int obtenerUltimoIdPedido() {
        return idpedido;
    }

    public static void cambiarEstadoDePago(int id){
        cajaDia.cambiarEstadoDePago(id);
    }

    public static Caja getCajaDia() {
        return cajaDia;
    }

    public static double obtenerMontoTotalCajaDia(){
        double recaudacionT= cajaDia.calcularTotalCaja();
        return recaudacionT;
    }

    public static double obtenerRecudacionPagoEfectivo(){
        double recaudacion= cajaDia.calcularTotalEfectivo();
        return recaudacion;
    }

    public static double obtenerRecudacionPagoTarjeta(){
        double recaudacion= cajaDia.calcularTotalTarjeta();
        return recaudacion;
    }

    public static boolean validarFecha(int dia, int mes, int anio) {
        // Validación del día y mes
        boolean rta= true;
        if (dia < 1 || dia > 31 || mes < 1 || mes > 12) {
            rta= false;
        }
        // Validación específica para febrero (considerando años bisiestos)
        if (mes == 2 && dia > 29) {
            rta=  false;
        }
        // Validación del año (puedes ajustar el rango según tus necesidades)
        if (anio < 1900 || anio > 2100) {
            rta= false;
        }

        return rta;
    }


    public static void agregaralacumulador(String key, int valor) {
        //crearAcumulador();
        if(acumulador.containsKey(key)){
            int aux=acumulador.get(key);
            aux +=valor;
            acumulador.put(key, aux);
        } else {
            acumulador.put(key,valor);
        }

    }

    public static void generarEstadisticas(){
        crearAcumulador();
        for(Estadistica estadistica : auxarraylist){
            Iterator<Map.Entry<String, Integer>> iterator = estadistica.getMapaEstadisticas().entrySet().iterator();
            //System.out.println("probando");
            while (iterator.hasNext())
            {
                Map.Entry<String, Integer> entry = iterator.next();
                String clave= entry.getKey();
                int valor= entry.getValue();
                // Agrega al valor acumulado existente o crea uno nuevo
                agregaralacumulador(clave, valor);
            }
        }
    }

    public static String listarTodoelAcumulador(){
        String resultado = "";
        Iterator<Map.Entry<String, Integer>> iteratormap= acumulador.entrySet().iterator();
        while (iteratormap.hasNext()){
            Map.Entry<String, Integer> entry = iteratormap.next();
            String key = entry.getKey();
            resultado += key+ ": "+ entry.getValue()+"///";
        }
        return resultado;
    }
    public static String mostrarRanking() {
        // Crear una lista de entradas ordenadas por valor (acumulado)
        // Map.Entry.<String, Integer>comparingByValue() -->comparador que compara las entradas (pares clave-valor) del mapa por su valor
        //.reversed(): Agrega la reversión al comparador. Esto significa que las entradas se ordenarán de mayor a menor (de forma descendente).
        //listaOrdenada.sort(...): Finalmente, se utiliza el método sort() para ordenar la lista de entradas (listaOrdenada) según el comparador creado.
        // Como resultado, las entradas se organizan en orden descendente según su valor.

        List<Map.Entry<String, Integer>> listaOrdenada = new ArrayList<>(acumulador.entrySet());
        listaOrdenada.sort(Map.Entry.<String, Integer>comparingByValue().reversed());
        // Construir la cadena de texto del ranking
        String resultado = "";
        int posicion = 1;
        for (Map.Entry<String, Integer> entry : listaOrdenada) {
            resultado += "|"+posicion + "| " + entry.getKey() + ": " + entry.getValue() + "\n ";
            posicion++;
        }

        return resultado;
    }

    public static void abrirarchivoEstadistico(){
        if (ControladoraArchivosEstadistica.verificarSiEstaVacioArchivoEstadistica()) {
            crearArregloEstadistica();
        }else{
            auxarraylist= ControladoraArchivosEstadistica.leerArchivo();
        }
    }

    public static void cerrarEstadistica(){
        deCajaaEstadistica();
        //System.out.println(auxarraylist.toString());
        ControladoraArchivosEstadistica.grabarArchivo(auxarraylist);
    }

    /*public static String listarTodaslasestadisticas(){
        StringBuilder rta= new StringBuilder();

            for (Estadistica estadistica : auxarraylist) {

                System.out.println(estadistica.getTotalRecaudacion());
                    rta.append(estadistica.toString());

            }


        return rta.toString();
    }*/
    public static void crearArregloEstadistica(){
        auxarraylist= new ArrayList<>();
    }

    public static void agregarDatoalaEstadistica(){
        if(auxarraylist ==null){
            crearArregloEstadistica();
        }
        auxarraylist.add(nuevaEstadistica);

    }

    private static void crearAcumulador(){
        acumulador= new HashMap<>();
    }





    public static void procesarEstadisticasporfecha( Date fechaInicio, Date fechaFin) {
        int acumuladorTotal = 0;
        crearAcumulador();
        
        for (Estadistica estadistica : auxarraylist) {
            Date fechaActual = estadistica.getFecha();
            System.out.println(estadistica.getFecha());
            if (fechaActual != null && fechaActual.compareTo(fechaInicio) >= 0 && fechaActual.compareTo(fechaFin) <= 0) {
                // Realiza las operaciones necesarias con los atributos de la estadística
                Iterator<Map.Entry<String, Integer>> iterator = estadistica.getMapaEstadisticas().entrySet().iterator();
                //System.out.println("probando");
                while (iterator.hasNext())
                {
                    Map.Entry<String, Integer> entry = iterator.next();
                    String clave= entry.getKey();
                    int valor= entry.getValue();
                    // Agrega al valor acumulado existente o crea uno nuevo
                    agregaralacumulador(clave, valor);
                }

            }
        }
    }
    public static String mostarEstadisticasporfechas(){
        return "-----------FECHAS DISPONIBLES-----------\n" +
                listarFechadeEstadisticas();

    }
    public static String listarFechadeEstadisticas() {
        String rta= "";
        for(int i=0; i<  auxarraylist.size(); i++)
        {
            rta += auxarraylist.get(i).getFecha() + "\n";
        }
        return rta;
    }

}
