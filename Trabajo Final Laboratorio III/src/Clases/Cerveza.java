package Clases;

public class Cerveza extends Bebida{
    private double nivelAlcohol; // Nivel de alcohol en porcentaje
    private int amargura; //indice de amargura (por ejemplo, IBU)


    public Cerveza(String nombreElementoMenu, double precioElementoMenu, float capacidad, String marca, String sabor, double nivelAlcohol, int amargura) {
        super(nombreElementoMenu, precioElementoMenu, capacidad, marca, sabor);
        this.nivelAlcohol = nivelAlcohol;
        this.amargura = amargura;
    }


    public double getNivelAlcohol() {
        return nivelAlcohol;
    }


    public int getAmargura() {
        return amargura;
    }


    @Override
    public String toString() {
        return super.toString()+" Cerveza{" +
                "nivelAlcohol=" + nivelAlcohol +
                ", amargura=" + amargura +
                '}';
    }
}
