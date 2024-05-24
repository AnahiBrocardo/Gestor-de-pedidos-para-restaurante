package Clases;

public class Cerveza extends Bebida{
    private String marca; // artesanal, quilmes, corona
    private double nivelAlcohol; // Nivel de alcohol en porcentaje
    private int amargura; //indice de amargura (por ejemplo, IBU)


    public Cerveza(String nombreElementoMenu, double precioElementoMenu, float capacidad, String marca, double nivelAlcohol, int amargura) {
        super(nombreElementoMenu, precioElementoMenu, capacidad);
        this.marca = marca;
        this.nivelAlcohol = nivelAlcohol;
        this.amargura = amargura;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getNivelAlcohol() {
        return nivelAlcohol;
    }

    public void setNivelAlcohol(double nivelAlcohol) {
        this.nivelAlcohol = nivelAlcohol;
    }

    public int getAmargura() {
        return amargura;
    }

    public void setAmargura(int amargura) {
        this.amargura = amargura;
    }

    @Override
    public String toString() {
        return "Cerveza{" +
                "marca='" + marca + '\'' +
                ", nivelAlcohol=" + nivelAlcohol +
                ", amargura=" + amargura +
                '}';
    }
}
