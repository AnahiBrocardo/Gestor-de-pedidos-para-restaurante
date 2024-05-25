package Clases;

import FuncionesMapa.GenericidadMapa;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Pedido extends GenericidadMapa {
    private int id; //
    private Date fecha;
    private Pago tipoDePago;
    private boolean pagado;
    private Double totalCompra;
    private String sugerencia;
    private GenericidadMapa conjuntoDeElementos;

    public Pedido(int id, Date fecha) {
        this.id = id; // buscar funcion que autoincremente
        this.fecha = fecha;
        this.tipoDePago = null;
        this.pagado = false;
        this.totalCompra = (double) 0;
        this.sugerencia = " ";
        conjuntoDeElementos = new GenericidadMapa();
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public Pago getTipoDePago() {
        return tipoDePago;
    }

    public boolean isPagado() {
        return pagado;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public String getSugerencia() {
        return sugerencia;
    }

    public GenericidadMapa getConjuntoDeElementos() {
        return conjuntoDeElementos;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTipoDePago(Pago tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public void setPagado() {
        this.pagado = true;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public void setSugerencia(String sugerencia) {
        this.sugerencia = sugerencia;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", tipoDePago=" + tipoDePago +
                ", pagado=" + pagado +
                ", totalCompra=" + totalCompra +
                ", sugerencia='" + sugerencia + '\'' +
                ", conjuntoDeElementos=" + conjuntoDeElementos +
                '}' +" \n";
    }
    ///Metodo para calcular el total de la compra
}
