package Clases;

public class Postre extends Comida {
    private String nombreDelPostre;
    private String descripcion;  //descripcion de los ingredientes que contiene el postre.

    public Postre(String nombreComida, double precioComida,String nombreDelPostre,String descripcion) {
        super(nombreComida, precioComida);
        this.nombreDelPostre = nombreDelPostre;
        this.descripcion = descripcion;
    }

    public String getNombreDelPostre() {
        return nombreDelPostre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombreDelPostre(String nombreDelPostre) {
        this.nombreDelPostre = nombreDelPostre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

    @Override
    public String toString() {
        return "Postre{" +
                "nombreDelPostre='" + nombreDelPostre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
