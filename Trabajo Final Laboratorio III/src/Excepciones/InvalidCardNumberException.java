package Excepciones;

public class InvalidCardNumberException extends Exception{
    public InvalidCardNumberException(String mensaje){
       super(mensaje);
    }
}
