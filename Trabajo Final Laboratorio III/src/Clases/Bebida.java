package Clases;

public class Bebida {
    private float capacidad; //500ml, 1000ml, 1500mlt o 2250ml;

    public Bebida(float capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "capacidad=" + capacidad +
                '}';
    }
}
