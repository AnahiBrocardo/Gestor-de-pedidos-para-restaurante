package Clases;

import FuncionesMapa.GenericidadArray;

import javax.swing.*;
import java.io.Serializable;
import java.sql.Struct;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Caja extends GenericidadArray implements Serializable {
    private double totalRecuadado;
    private Date fecha;
    private Boolean estado; //Esto nos permite ver si la caja esta activa o ya la cerramos

    public Caja() {
        totalRecuadado=0;
        fecha= new Date();
        estado= true;
    }

    public double getTotalRecuadado() {
        return totalRecuadado;
    }

    public Date getFecha() {
        return fecha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public void crearPedido(int id) {
        Pedido nuevoPedido = new Pedido(id);
        agregar(nuevoPedido);

    }

    public Double calcularTotalCaja(){

        for (int i=0; i<getNuevoArreglo().size(); i++) {
           Pedido pedido= (Pedido) getPos(i) ;
           totalRecuadado += pedido.calcularTotaldelPedido();
        }
        return getTotalRecuadado();
    }

    public double calcularTotalEfectivo(){
        double efectivo=0;
        for (int i=0; i< getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) getPos(i) ;
            if(pedido.getTipoDePago() instanceof PagoEfectivo){
                efectivo += pedido.getTotalCompra();
            }

        }
        return efectivo;
    }
    public double calcularTotalTarjeta(){
        double tarjeta= 0;
        for (int i=0; i<getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) getPos(i) ;
            if(pedido.getTipoDePago() instanceof PagoTarjeta){
                tarjeta += pedido.getTotalCompra();
            }

        }
        return tarjeta;
    }

    public boolean agregarApedido(String key, ElementoMenu nuevoElementoMenu, int idBuscado) {
        boolean agregado= false;
        for (int i=0; i<getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) getPos(i) ;
            if(pedido.getId() == idBuscado ){
                if(!pedido.isPagado()){//Quiero lograr que si el estado del pedido es sin pagar puedo agregar productos
                    pedido.agregarApedido(nuevoElementoMenu, key);
                    agregado= true;
                }
            }

        }
        return agregado;
    }

    public void agregarPago(Pago nuevoPago,int id) {
        for (int i = 0; i < getNuevoArreglo().size(); i++) {
            Pedido pedido = (Pedido) getPos(i);
            if (pedido.getId() == id) {
                pedido.setTipoDePago(nuevoPago);
            }
        }
    }

    public boolean modificarPedido(String key, int idbuscado, ElementoMenu aCambiar, ElementoMenu aAgregar) {
        boolean agregado = false;
        for (int i = 0; i < getNuevoArreglo().size(); i++) {
            Pedido pedido = (Pedido) getPos(i);
            if ((pedido.getId() == idbuscado) && (!pedido.isPagado())) {
                pedido.modificarPedido(aCambiar, aAgregar, key);
                agregado = true;
            }
        }
        return agregado;
    }

    public boolean buscarPedido(String key, int idbuscado, ElementoMenu aBuscado){
        boolean buscado= false;
        for (int i=0; i<getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) getPos(i) ;
            if((pedido.getId() == idbuscado) && (!pedido.isPagado()) ){
                buscado=pedido.buscar(aBuscado, key);
            }
        }
        return buscado;
    }
    public boolean buscarPorClavePedido(String clave, int id){
        boolean buscado= false;
        for (int i=0; i<getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) getPos(i) ;
            if((pedido.getId() == id)){
                buscado=pedido.buscarClavePedido(clave);
            }
        }
        return buscado;
    }


    public double obtenerMontoP(int id){ //se obtiene el monto total del pedido
        double monto=0;
        for (int i=0; i<getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) getPos(i) ;
            if(pedido.getId() == id){
               monto= pedido.calcularTotaldelPedido();
            }
        }
        return monto;
    }


    public String listarBuscadoenelPedido(String key, int idbuscado){
        String rta="";
        for (int i=0; i<getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) getPos(i) ;
            if((pedido.getId() == idbuscado) ){
                rta=pedido.listar(key);
            }
        }
        return rta;
    }

    public String listarTodounPedido(int idbuscado){ //se lista todo UN pedido
        String rta="";
        for (int i=0; i<getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) getPos(i) ;
            if((pedido.getId() == idbuscado) ){
                rta=pedido.listarTodoelPedido();
            }
        }
        return rta;
    }

    public String listarPedidoPorDigitiYllave (int idbuscado, String key){ //se listan los pedidos por digito y clave
        String rta="";
        for (int i=0; i<getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) getPos(i) ;
            if((pedido.getId() == idbuscado) ){
                rta=pedido.listarPorDigitoYllave(key);
            }
        }
        return rta;
    }

    public int cantPedidosNoPagos (){ //se devuelve la cantidad de pedidos no pagos
        ArrayList<Pedido> arrayPedidos= getNuevoArreglo();
        int cant=0;

        for (int i=0; i<arrayPedidos.size(); i++){
            if(!arrayPedidos.get(i).isPagado()){
                cant++;
            }
        }
        return cant;
    }
    public void cambiarEstadoDePago (int id){ //se cambia el estado del pago
        for (int i=0; i<getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) getPos(i) ;
            if((pedido.getId() == id) ){
               pedido.setPagado();
            }
        }

    }

    public String listarPedidosNoPagos(){ //funcion para listar todos los pedidos no pagos
        String rta="";
        int opcion=1;
        for (int i=0; i<getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) getPos(i) ;
            if(!pedido.isPagado()){
                rta+="Opcion "+ opcion +pedido.listarTodoelPedido();//ver
                opcion++;
            }
        }
        return rta;
    }




     public HashMap<Integer,Integer> mapaPedidosOpcionID() {
        HashMap<Integer,Integer> mapPedidos= new HashMap<>();
        int opcion = 1;
        int id;
        for (int i=0; i<getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) getPos(i) ;
            if(!pedido.isPagado()) {
                mapPedidos.put(opcion, pedido.getId());
                opcion++;
            }
        }
        return mapPedidos;
    }

    public boolean eliminardePedido(String key, int idbuscado, ElementoMenu aEliminar){
        boolean eliminado= false;
        for (int i=0; i<getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) getPos(i) ;
            if((pedido.getId() == idbuscado) && (!pedido.isPagado()) ){
                pedido.eliminar(aEliminar, key);
                eliminado= true;
            }
        }
        return eliminado;
    }


    public ArrayList<ElementoMenu> devolverArregloProductosPorClave(String clave, int id){
        ArrayList<ElementoMenu> arrayProductosClave= new ArrayList<>();
        for (int i=0; i<getNuevoArreglo().size(); i++) {
            Pedido pedido = (Pedido) getPos(i);
            if ((pedido.getId() == id)) {
                arrayProductosClave = pedido.devolverArrayProductosPorClave(clave);
            }
        }
        return arrayProductosClave;
    }

    @Override
    public String toString() {
        return "Caja:{" +
                "\ntotalRecuadado=" + totalRecuadado +
                "\nfecha=" + fecha +
                "\nestado=" + estado +
                '}';
    }
}
