package Clases;

public  abstract class Bebida extends ElementoMenu {
    private float capacidad; //500ml, 1000ml, 1500mlt o 2250ml;
    private String marca; // antares, corona, quilmes
    private String sabor;// rubia, roja

    public Bebida(){
        capacidad=0;
        marca="";
        sabor="";
    }
    public Bebida(String nombreElementoMenu, double precioElementoMenu, float capacidad, String marca, String sabor) {
        super(nombreElementoMenu, precioElementoMenu);
        this.capacidad = capacidad;
        this.marca = marca;
        this.sabor = sabor;
    }

    public float getCapacidad() {
        return capacidad;
    }

    public String getMarca() {
        return marca;
    }

    public String getSabor() {
        return sabor;
    }

    @Override
    public String toString() {
        return super.toString()+ "Bebida{" +
                "capacidad=" + capacidad +
                ", marca='" + marca + '\'' +
                ", sabor='" + sabor + '\'' +
                '}';
    }
}
