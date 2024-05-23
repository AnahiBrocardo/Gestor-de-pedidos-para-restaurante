package Clases;

public class Gaseosa extends Bebida{
    private String linea; //7up, CocaCola, otros
    private String sabor; //lima limon, coca, naranja, otros

    public Gaseosa(String nombreElementoMenu, double precioElementoMenu, float capacidad, String linea, String sabor) {
        super(nombreElementoMenu, precioElementoMenu, capacidad);
        this.linea = linea;
        this.sabor = sabor;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    @Override
    public String toString() {
        return "Gaseosa{" +
                "linea='" + linea + '\'' +
                ", sabor='" + sabor + '\'' +
                '}';
    }
}
