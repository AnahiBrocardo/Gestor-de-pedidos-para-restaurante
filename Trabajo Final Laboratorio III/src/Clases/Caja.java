package Clases;

import FuncionesMapa.GenericidadArray;

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


    


}
