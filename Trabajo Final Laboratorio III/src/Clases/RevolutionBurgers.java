package Clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//cuando lo queremos usar en el main hacemos: RevolutionBurguer + . y el metodo global
public class RevolutionBurgers {
    private static Caja cajaDia;
    private static boolean valor;
    private static int idpedido= 100;
    private static HashMap<String, Integer> mapaEstadisticas = null;
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

    ///PAGOS

    ///ESTADISTICAS

    /*public static void deCajaaEstadistica(){


        for (int i=0; i<cajaDia.getPedidosDia().getNuevoArreglo().size(); i++) {   ///Esto recorre los elementos de la caja
            Pedido pedido= (Pedido)  cajaDia.getPedidosDia().getPos(i) ;  ///me genera el dato tipo pedido
            //recorro el pedido con el iterador
            Iterator<Map.Entry<String, ArrayList<ElementoMenu>>> entryIterator = cajaDia.getPedidosDia().getPos(i).getNuevomapa().entrySet().iterator();
            while (entryIterator.hasNext()) {
                Map.Entry<String, ArrayList<ElementoMenu>> entry = entryIterator.next();
                ArrayList<ElementoMenu> menuItems = entry.getValue();
                for (int b = 0; b < menuItems.size(); b++) {
                    ElementoMenu item = (ElementoMenu) menuItems.get(b);
                    if(item instanceof Postre){
                        agregarElementos(((Postre) item).getNombreDelPostre(), mapaEstadisticas);
                    } else if (item instanceof Burger) {
                        agregarElementos(((Burger) item).getTipoHamburguesa(), mapaEstadisticas);
                    } else if (item instanceof Cerveza) {
                        agregarElementos("Cerveza", mapaEstadisticas);
                    } else if (item instanceof Gaseosa) {
                        agregarElementos("Gaseosa", mapaEstadisticas);
                    }else if (item instanceof AguaSaborizada){
                        agregarElementos("Agua Saborizada", mapaEstadisticas);
                    }

                }

            }
        }

        nuevaEstadistica= new Estadistica(cajaDia.getFecha(), mapaEstadisticas, cajaDia.getTotalRecuadado());

    }*/

    public static void deCajaaEstadistica() {
        for (int i = 0; i < cajaDia.getPedidosDia().getNuevoArreglo().size(); i++) {
            Pedido pedido = (Pedido) cajaDia.getPedidosDia().getPos(i);
            Iterator<Map.Entry<String, ArrayList<ElementoMenu>>> entryIterator = pedido.getNuevomapa().entrySet().iterator();
            while (entryIterator.hasNext()) {
                Map.Entry<String, ArrayList<ElementoMenu>> entry = entryIterator.next();
                ArrayList<ElementoMenu> menuItems = entry.getValue();
                for (int b = 0; b < menuItems.size(); b++) {
                    ElementoMenu item = menuItems.get(b);
                    if (item instanceof Postre) {
                        agregarElementos(((Postre) item).getNombreDelPostre(), mapaEstadisticas);
                    } else if (item instanceof Burger) {
                        agregarElementos(((Burger) item).getTipoHamburguesa(), mapaEstadisticas);
                    } else if (item instanceof Cerveza) {
                        agregarElementos("Cerveza", mapaEstadisticas);
                    } else if (item instanceof Gaseosa) {
                        agregarElementos("Gaseosa", mapaEstadisticas);
                    } else if (item instanceof AguaSaborizada) {
                        agregarElementos("Agua Saborizada", mapaEstadisticas);
                    }
                }
            }
        }

        nuevaEstadistica = new Estadistica(cajaDia.getFecha(), mapaEstadisticas, cajaDia.getTotalRecuadado());
    }


    private static void agregarElementos(String key, HashMap<String, Integer> estadistica){
        if (estadistica.containsKey(key)) {
            // Si la llave ya existe, incrementar su valor en 1
            int valorActual = estadistica.get(key);
            estadistica.put(key, valorActual + 1);
        } else {
            // Si la llave no existe, crearla con un valor inicial de 1
            estadistica.put(key, 1);
        }

    }
    
    public static String listarEstatidistica(){
        String rta="";
        rta= nuevaEstadistica.toString();
        return rta;
    }


}
