package Clases;

public abstract class ElementoMenu {
    private String nombreElementoMenu;
    private double precioElementoMenu;

    public ElementoMenu(String nombreElementoMenu, double precioElementoMenu) {
        this.nombreElementoMenu = nombreElementoMenu;
        this.precioElementoMenu = precioElementoMenu;
    }

    public String getNombreElementoMenu() {
        return nombreElementoMenu;
    }
    public double getPrecioElementoMenu() {
        return precioElementoMenu;
    }

    public void setNombreElementoMenu(String nombreElementoMenu) {
        this.nombreElementoMenu = nombreElementoMenu;
    }

    @Override
    public String toString() {
        return "\n ElementoMenu{" +
                "nombreElementoMenu='" + nombreElementoMenu + '\'' +
                ", precioElementoMenu=" + precioElementoMenu +
                '}';
    }
}
