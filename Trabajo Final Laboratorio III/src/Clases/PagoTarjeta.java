package Clases;

import Excepciones.InvalidCardNumberException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PagoTarjeta extends Pago{
    private Persona cliente; //persona que realiza el pago
    private String numeroTarjeta; //tiene que tener  16 digitos en este formato
    private Cuota cantidadCuotas;//UNPAGO, TRESPAGOS, SEISPAGOS
    private Tarjeta tipoDeTarjeta; //Visa,Mastercard, Favacard, otros.
    private TipoCuenta tipoDeCuenta; //credito o debito

   //Metodo constructor
    public PagoTarjeta(double monto, Persona cliente, String numeroTarjeta, Tarjeta tipoDeTarjeta, TipoCuenta tipoDeCuenta){
        super(monto);
        this.cliente = cliente;
        this.numeroTarjeta = numeroTarjeta;
        this.cantidadCuotas= Cuota.UNPAGO; //inicializamos la cantidad de cuotas en 1, ya que solo se va a poder ingresar la cantidad de cuotas si la tarjeta es credito
        this.tipoDeTarjeta = tipoDeTarjeta;
        this.tipoDeCuenta = tipoDeCuenta;
    }

    public Persona getCliente() {
        return cliente;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public Cuota getCantidadCuotas() {
        return cantidadCuotas;
    }


    public Tarjeta getTipoDeTarjeta() {
        return tipoDeTarjeta;
    }

    public TipoCuenta getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    //ver setters

    //metodo para establecer la cantidad de cuotas si la tarjeta es de credito
    public void establecerCuotas (Cuota cantCuotas){ //verificar que pueda establecer cuotas(credito) no depende de PagoTarjeta
            this.cantidadCuotas = cantCuotas;
    }

    @Override
    public String toString() {
        return "PagoTarjeta{" +
                "cliente=" + cliente +
                ", numeroTarjeta=" + numeroTarjeta +
                ", cantidadCuotas=" + cantidadCuotas +
                ", tipoDeTarjeta='" + tipoDeTarjeta + '\'' +
                ", tipoDeCuenta='" + tipoDeCuenta + '\'' +
                '}';
    }

    @Override
    public double calcularMontoTotalAPagar() {
        double montoTotal= getMonto();
        return montoTotal;
    }

    public double calcularMontoCuotasAPagar() {
        double montoCuota=0;
        int tresPagos= 3;
        int seisPagos=6;

        if(cantidadCuotas.equals(Cuota.TRESPAGOS)){
            montoCuota=getMonto()/tresPagos;
        }
        else if(cantidadCuotas.equals(Cuota.SEISPAGOS)){
            montoCuota=getMonto()/seisPagos;
        }
        return montoCuota;
    }

    public static void validarDigitosNumeroTarjeta (String numeroDeTarjeta) throws InvalidCardNumberException {

        String regular = "\\d{4} \\d{4} \\d{4} \\d{4}"; // expresión regular para validar el formato de la tarjeta

        Pattern pattern = Pattern.compile(regular);// compila la expresión regular

        // Crear un matcher para la cadena de entrada
        Matcher matcher = pattern.matcher(numeroDeTarjeta);

        if(!matcher.matches() || numeroDeTarjeta.isEmpty()){ //si el numero de tarjeta esta vacio o no cumple con el formato de la expresion regular
          throw new InvalidCardNumberException("Numero de tarjeta invalido seguir el formato XXXX XXXX XXXX XXXX"); //lanza la excepcion

        }
    }

    public boolean esCredito (){
        boolean esCredito= false;

        if(tipoDeCuenta.equals(TipoCuenta.CREDITO)){
            esCredito= true;
        }
        return esCredito;
    }

}
