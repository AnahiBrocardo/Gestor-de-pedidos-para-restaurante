package Clases;

public class AguaSaborizada extends Bebida{
    private String sabor; //naranja, pomelo, otros
    private String linea; //levite, acuarius
    private boolean tieneGas; //0 si no tiene gas, 1 si tiene gas

    public AguaSaborizada(String nombreElementoMenu, double precioElementoMenu, float capacidad, String sabor, String linea, boolean tieneGas) {
        super(nombreElementoMenu, precioElementoMenu, capacidad);
        this.sabor = sabor;
        this.linea = linea;
        this.tieneGas = tieneGas;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public boolean isTieneGas() {
        return tieneGas;
    }

    public void setTieneGas(boolean tieneGas) {
        this.tieneGas = tieneGas;
    }

    @Override
    public String toString() {
        return "AguaSaborizada{" +
                "sabor='" + sabor + '\'' +
                ", linea='" + linea + '\'' +
                ", tieneGas=" + tieneGas +
                '}';
    }
}
