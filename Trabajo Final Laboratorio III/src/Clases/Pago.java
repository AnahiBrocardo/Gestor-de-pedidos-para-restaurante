package Clases;

public abstract class Pago {
   private double monto;

    public Pago(double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "monto=" + monto +
                '}';
    }

    public abstract double calcularMontoTotalAPagar();
}
