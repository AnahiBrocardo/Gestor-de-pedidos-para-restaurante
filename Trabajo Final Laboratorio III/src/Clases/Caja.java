package Clases;

import FuncionesMapa.GenericidadArray;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Date;

public class Caja extends GenericidadArray {
    private double totalRecuadado;
    private Date fecha;
    private Boolean estado; //Esto nos permite ver si la caja esta activa o ya la cerramos
    private GenericidadArray<Pedido> pedidosDia;

    public Caja() {
        totalRecuadado=0;
        fecha= new Date();
        estado= true;
        pedidosDia= new GenericidadArray<>();
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

    public GenericidadArray<Pedido> getPedidosDia() {
        return pedidosDia;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public void crearPedido(int id) {
        Pedido nuevoPedido = new Pedido(id);
        pedidosDia.agregar(nuevoPedido);
    }

    public Double calcularTotalCaja(){

        for (int i=0; i<pedidosDia.getNuevoArreglo().size(); i++) {
           Pedido pedido= (Pedido)     pedidosDia.getPos(i) ;
           totalRecuadado += pedido.calcularTotaldelPedido();
        }
        return getTotalRecuadado();
    }

    public double calcularTotalEfectivo(){
        double efectivo=0;
        for (int i=0; i<pedidosDia.getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) pedidosDia.getPos(i) ;
            if(pedido.getTipoDePago() instanceof PagoEfectivo){
                efectivo += pedido.getTotalCompra();
            }

        }
        return efectivo;
    }
    public double calcularTotalTarjeta(){
        double tarjeta= 0;
        for (int i=0; i<pedidosDia.getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) pedidosDia.getPos(i) ;
            if(pedido.getTipoDePago() instanceof PagoTarjeta){
                tarjeta += pedido.getTotalCompra();
            }

        }
        return tarjeta;
    }

    public boolean agregarApedido(String key, ElementoMenu nuevoElementoMenu, int idBuscado) {
        boolean agregado= false;
        for (int i=0; i<pedidosDia.getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) pedidosDia.getPos(i) ;
            if(pedido.getId() == idBuscado ){
                if(!pedido.isPagado()){//Quiero lograr que si el estado del pedido es sin pagar puedo agregar productos
                    pedido.agregarApedido(nuevoElementoMenu, key);
                    agregado= true;
                }
            }

        }
        return agregado;
    }

    public boolean modificarPedido(String key, int idbuscado, ElementoMenu aCambiar, ElementoMenu aAgregar) {
        boolean agregado = false;
        for (int i = 0; i < pedidosDia.getNuevoArreglo().size(); i++) {
            Pedido pedido = (Pedido) pedidosDia.getPos(i);
            if ((pedido.getId() == idbuscado) && (!pedido.isPagado())) {
                pedido.modificarPedido(aCambiar, aAgregar, key);
                agregado = true;
            }
        }
        return agregado;
    }

    public boolean buscarPedido(String key, int idbuscado, ElementoMenu aBuscado){
        boolean buscado= false;
        for (int i=0; i<pedidosDia.getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) pedidosDia.getPos(i) ;
            if((pedido.getId() == idbuscado) && (!pedido.isPagado()) ){
                buscado=pedido.buscar(aBuscado, key);
            }
        }
        return buscado;
    }


    public String listarBuscadoenelPedido(String key, int idbuscado){
        String rta="";
        for (int i=0; i<pedidosDia.getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) pedidosDia.getPos(i) ;
            if((pedido.getId() == idbuscado) ){
                rta=pedido.listar(key);
            }
        }
        return rta;
    }

    public String listarTodounPedido(int idbuscado){
        String rta="";
        for (int i=0; i<pedidosDia.getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) pedidosDia.getPos(i) ;
            if((pedido.getId() == idbuscado) ){
                rta=pedido.listarTodoelPedido();
            }
        }
        return rta;
    }

    public boolean eliminardePedido(String key, int idbuscado, ElementoMenu aEliminar){
        boolean eliminado= false;
        for (int i=0; i<pedidosDia.getNuevoArreglo().size(); i++) {
            Pedido pedido= (Pedido) pedidosDia.getPos(i) ;
            if((pedido.getId() == idbuscado) && (!pedido.isPagado()) ){
                pedido.eliminar(aEliminar, key);
                eliminado= true;
            }
        }
        return eliminado;
    }



    


}
