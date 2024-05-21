package Clases;

public abstract class Comida {

    private String nombreComida;
    private double precioComida;

    public Comida(String nombreComida, double precioComida) {  //metodo constructor
        this.nombreComida = nombreComida;
        this.precioComida = precioComida;
    }

    public void setNombreComida(String nombreComida) {
        this.nombreComida = nombreComida;
    }


    public void setPrecioComida(double precioComida) {
        this.precioComida = precioComida;
    }

    public double getPrecioComida() {
        return precioComida;
    }

    public String getNombreComida() {
        return nombreComida;


    }

    @Override
    public String toString() {
        return "Comida{" +
                "nombreComida='" + nombreComida + '\'' +
                ", precioComida=" + precioComida +
                '}';
    }

}
