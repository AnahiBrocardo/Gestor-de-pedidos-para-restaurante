package Clases;

public class PagoTarjeta extends Pago{
    private Persona cliente; //persona que realiza el pago
    private int numeroTarjeta;
    private int cantidadCuotas;
    private String tipoDeTarjeta; //Visa,Mastercard, Favacard, otros.
    private String tipoDeCuenta; //credito o debito

   //Metodo constructor
    public PagoTarjeta(double monto, Persona cliente, int numeroTarjeta, int cantidadCuotas, String tipoDeTarjeta, String tipoDeCuenta) {
        super(monto);
        this.cliente = cliente;
        this.numeroTarjeta = numeroTarjeta;
        this.cantidadCuotas = 0; //inicializamos la cantidad de cuotas en 0, ya que solo se va a poder ingresar la cantidad de cuotas si la tarjeta es credito
        this.tipoDeTarjeta = tipoDeTarjeta;
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public Persona getCliente() {
        return cliente;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public String getTipoDeTarjeta() {
        return tipoDeTarjeta;
    }

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    //ver setters

    //metodo para establecer la cantidad de cuotas si la tarjeta es de credito
    public void establecerCuotas (int cantCuotas){
        if(tipoDeCuenta.equalsIgnoreCase("credito")){
            cantidadCuotas= cantCuotas;
        }
    }


}
