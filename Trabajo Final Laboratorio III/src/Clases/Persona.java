package Clases;

public class Persona {
    private String nombreYapellido;
    private int dni;
    private String direccion;
    private String telefono;

    public Persona(String nombreYapellido, int dni, String direccion, String telefono) {
        this.nombreYapellido = nombreYapellido;
        this.dni = dni;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombreYapellido() {
        return nombreYapellido;
    }

    public int getDni() {
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
}
