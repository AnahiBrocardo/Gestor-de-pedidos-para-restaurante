package Clases;

public class Cerveza extends Bebida{
    private double nivelAlcohol; // Nivel de alcohol en porcentaje
    private String amargura; //bajo, alto, modererado, medio

    public Cerveza()
    {
        nivelAlcohol = 0;
        amargura = "";
    }

    public Cerveza(String nombreElementoMenu, double precioElementoMenu, float capacidad, String marca, String sabor, double nivelAlcohol, String amargura) {
        super(nombreElementoMenu, precioElementoMenu, capacidad, marca, sabor);
        this.nivelAlcohol = nivelAlcohol;
        this.amargura = amargura;
    }


    public double getNivelAlcohol() {
        return nivelAlcohol;
    }

    public String getAmargura() {
        return amargura;
    }

    public void setNivelAlcohol(double nivelAlcohol) {
        this.nivelAlcohol = nivelAlcohol;
    }

    public void setAmargura(String amargura) {
        this.amargura = amargura;
    }

    @Override
    public String toString() {
        return super.toString()+"\nNivel de alcohol: " + nivelAlcohol +
                "\nAmargura: " + amargura;
    }

    public String getTipoBebida(){
        return "Cerveza";
    }
}
