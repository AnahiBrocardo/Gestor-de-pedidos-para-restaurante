package Clases;

public class PagoEfectivo extends Pago{
    float descuento;

    public PagoEfectivo(double monto, float descuento) {
        super(monto);
        this.descuento = descuento;
    }
    
}
