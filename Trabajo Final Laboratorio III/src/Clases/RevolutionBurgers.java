package Clases;
//cuando lo queremos usar en el main hacemos: RevolutionBurguer + . y el metodo global
public class RevolutionBurgers {
    private static Caja cajaDia;

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
    public static void agregarPedido(){
        cajaDia.
    }
    ///PAGOS
    ///ESTADISTICAS
}
