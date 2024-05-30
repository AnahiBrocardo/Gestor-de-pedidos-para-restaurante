package Clases;

import FuncionesMapa.GenericidadArray;

import java.util.ArrayList;
import java.util.Date;

public class Caja extends GenericidadArray {
    private double totalRecuadado;
    private Date fecha;
    private GenericidadArray<Pedido> pedidosDia;

    public Caja() {
        totalRecuadado=0;
        fecha= new Date();
        pedidosDia= new GenericidadArray<>();
    }

    public double getTotalRecuadado() {
        return totalRecuadado;
    }

    public Date getFecha() {
        return fecha;
    }

    public GenericidadArray<Pedido> getPedidosDia() {
        return pedidosDia;
    }

    public Double calcularTotalCaja(){

        for (int i=0; i<pedidosDia.getNuevoArreglo().size(); i++) {
           Pedido pedido= (Pedido)     pedidosDia.getPos(i) ;
           totalRecuadado += pedido.calcularTotaldelPedido();
        }
        return getTotalRecuadado();
    }

    


}
