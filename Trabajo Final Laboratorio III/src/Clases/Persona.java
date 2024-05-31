package Clases;

import Excepciones.InvalidCardNumberException;
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


}
