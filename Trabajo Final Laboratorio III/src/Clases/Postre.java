package Clases;

public class Postre extends ElementoMenu{
    private String nombreDelPostre; //Brownie con helado,  Volcan de chocolate, CheeseCake de  frutos rojos
    private String descripcion;  //descripcion de los ingredientes que contiene el postre.


    //Metodo constructor

    public Postre(){
        super();
        nombreDelPostre="";
        descripcion= "";
    }

    public Postre(String nombreElementoMenu, double precioElementoMenu, String nombreDelPostre, String descripcion) {
        super(nombreElementoMenu, precioElementoMenu);
        this.nombreDelPostre = nombreDelPostre;
        this.descripcion = descripcion;
    }

    public String getNombreDelPostre() {
        return nombreDelPostre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNombreDelPostre(String nombreDelPostre) {
        this.nombreDelPostre = nombreDelPostre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public String toString() {
        return super.toString()+ "\n"+nombreDelPostre+
                "\nDescripcion: " + descripcion;
    }
}
