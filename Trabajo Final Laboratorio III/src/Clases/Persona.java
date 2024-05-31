package Clases;

import Excepciones.InvalidCardNumberException;
import Excepciones.InvalidDniExcepcion;
import Excepciones.InvalidNameExcepcion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Persona {
    private String nombreYapellido;
    private String dni;
    private String direccion;
    private String telefono;

    public Persona(String nombreYapellido, String dni, String direccion, String telefono) {
        this.nombreYapellido = nombreYapellido;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombreYapellido() {
        return nombreYapellido;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setNombreYapellido(String nombreYapellido) {
        this.nombreYapellido = nombreYapellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombreYapellido='" + nombreYapellido + '\'' +
                ", dni=" + dni +
                ", direccion='" + direccion + '\'' +
                ", telefono=" + telefono +
                '}';
    }

    public static void validarNombrePersona (String nombreApellido) throws InvalidNameExcepcion {

        if(nombreApellido.isEmpty()){
            throw new InvalidNameExcepcion("Nombre Invalido"); //lanza la excepcion
        }
    }

    public static void validarDniPersona (String dniPersona) throws InvalidDniExcepcion {

        if(dniPersona.isEmpty() || dniPersona.length()<6 || dniPersona.length()>8){
            throw new InvalidDniExcepcion("Dni invalido menor a 6 digitos");
        }
    }

    public static void validarTelefonoPersona (String telefonoPersona) throws InvalidCardNumberException {

        if(telefonoPersona.isEmpty() || telefonoPersona.length()<10 || telefonoPersona.length()>10){
            throw new InvalidCardNumberException("Telefono invalido menor a 10 digitos");
        }
    }
}
