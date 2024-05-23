package Clases;

public class Burguer extends ElementoMenu{
    private String descripcion;
    private String tipoHamburguesa; //puede ser Mexicana, americana, argenta o liviana

    public Burguer(String nombreElementoMenu, double precioElementoMenu, String descripcion, String tipoHamburguesa) {
        super(nombreElementoMenu, precioElementoMenu);
        this.descripcion = descripcion;
        this.tipoHamburguesa = tipoHamburguesa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoHamburguesa() {
        return tipoHamburguesa;
    }

    public void setTipoHamburguesa(String tipoHamburguesa) {
        this.tipoHamburguesa = tipoHamburguesa;
    }

    @Override
    public String toString() {
        return "Burguer{" +
                "descripcion='" + descripcion + '\'' +
                ", tipoHamburguesa='" + tipoHamburguesa + '\'' +
                '}';
    }
}
