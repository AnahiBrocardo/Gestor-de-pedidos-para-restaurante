package Clases;

public  abstract class Bebida extends ElementoMenu {
    private float capacidad; //500ml, 1000ml, 1500mlt o 2250ml;

    public Bebida(String nombreElementoMenu, double precioElementoMenu, float capacidad) {
        super(nombreElementoMenu, precioElementoMenu);
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return super.toString()+ " Bebida{" +
                "capacidad=" + capacidad +
                '}';
    }
}
