package Clases;
//cuando lo queremos usar en el main hacemos: RevolutionBurguer + . y el metodo global
public class RevolutionBurgers {
    private static Caja cajaDia;
    private static boolean valor;

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

}
