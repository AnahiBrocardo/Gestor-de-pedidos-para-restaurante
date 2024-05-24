package Clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public abstract class Pedido {
    private int id;
    private Date fecha;
    private Pago tipoDePago;
    private boolean pagado;
    private Double totalCompra;
    private String sugerencia;
    private HashMap <String, ArrayList<ElementoMenu>> conjuntoDeElementos;

    public Pedido(int id, Date fecha, Pago tipoDePago, boolean pagado, Double totalCompra, String sugerencia, HashMap<String, ArrayList<ElementoMenu>> conjuntoDeElementos) {
        this.id = id;
        this.fecha = fecha;
        this.tipoDePago = tipoDePago;
        this.pagado = pagado;
        this.totalCompra = totalCompra;
        this.sugerencia = sugerencia;
        conjuntoDeElementos = new HashMap<>();
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

    public HashMap<String, ArrayList<ElementoMenu>> getConjuntoDeElementos() {
        return conjuntoDeElementos;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTipoDePago(Pago tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
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
                '}';
    }
}