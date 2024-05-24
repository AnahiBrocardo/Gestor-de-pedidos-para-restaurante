package Clases;

public class Gaseosa extends Bebida{
    private boolean tieneEndulzante;

    public Gaseosa(String nombreElementoMenu, double precioElementoMenu, float capacidad, String marca, String sabor, boolean tieneEndulzante) {
        super(nombreElementoMenu, precioElementoMenu, capacidad, marca, sabor);
        this.tieneEndulzante = tieneEndulzante;
    }

    public boolean isTieneEndulzante() {
        return tieneEndulzante;
    }

    @Override
    public String toString() {
        return super.toString()+ " Gaseosa{" +
                "tieneEndulzante=" + tieneEndulzante +
                '}';
    }
}
