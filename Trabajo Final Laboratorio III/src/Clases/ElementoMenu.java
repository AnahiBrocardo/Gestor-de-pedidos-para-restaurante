package Clases;

public abstract class ElementoMenu {
    private String nombreElementoMenu; //la categoria
    private double precioElementoMenu;

    public ElementoMenu(){
        nombreElementoMenu="";
        precioElementoMenu=0;
    }

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

    public void setPrecioElementoMenu(double precioElementoMenu) {
        this.precioElementoMenu = precioElementoMenu;
    }

    @Override
    public String toString() {
        return "...................................................................................................................................................................\n "
                +nombreElementoMenu + "\n" +"Precio: $" + precioElementoMenu;

    }
}
