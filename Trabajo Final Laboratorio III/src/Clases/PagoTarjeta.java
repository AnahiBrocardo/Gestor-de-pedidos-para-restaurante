package Clases;

public class PagoTarjeta extends Pago{
    private Persona cliente;
    private int numeroTarjeta;
    private int cantidadCuotas;
    private String tipoDeTarjeta; //Visa,Mastercard
    private String tipoDeCuenta; //credito o debito

    public PagoTarjeta(double monto, Persona cliente, int numeroTarjeta, int cantidadCuotas, String tipoDeTarjeta, String tipoDeCuenta) {
        super(monto);
        this.cliente = cliente;
        this.numeroTarjeta = numeroTarjeta;
        this.cantidadCuotas = 0; //inicializamos la cantidad de cuotas en 0, ya que solo se va a poder ingresar la cantidad de cuotas si la tarjeta es credito
        this.tipoDeTarjeta = tipoDeTarjeta;
        this.tipoDeCuenta = tipoDeCuenta;
    }


}
