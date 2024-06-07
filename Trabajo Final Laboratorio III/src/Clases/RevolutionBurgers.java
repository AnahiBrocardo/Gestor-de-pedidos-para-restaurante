package Clases;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//cuando lo queremos usar en el main hacemos: RevolutionBurguer + . y el metodo global
public class RevolutionBurgers {
    private static Caja cajaDia;
    private static boolean valor;
    private static int idpedido= 100;
    private static HashMap<String, Integer> mapaEstadisticas;
    private static Estadistica nuevaEstadistica;

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
        //ingresar a la caja del dia
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

        nuevaEstadistica = new Estadistica(cajaDia.getFecha(), mapaEstadisticas, cajaDia.getTotalRecuadado());
        //System.out.println(nuevaEstadistica.toString());
        //System.out.println(listarEstatidistica());

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
    
    public static String listarEstatidistica(){
        String rta="";
        rta= nuevaEstadistica.toString();
        return rta;
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
}
