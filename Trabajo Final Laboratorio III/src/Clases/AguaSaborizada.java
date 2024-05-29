package Clases;

public class AguaSaborizada extends Bebida{
    private boolean tieneGas;

    public AguaSaborizada()
    {
        tieneGas = false;
    }

    public AguaSaborizada(String nombreElementoMenu, double precioElementoMenu, float capacidad, String marca, String sabor, boolean tieneGas) {
        super(nombreElementoMenu, precioElementoMenu, capacidad, marca, sabor);
        this.tieneGas = tieneGas;
    }

    public boolean isTieneGas() {
        return tieneGas;
    }

    public void setTieneGas(boolean tieneGas) {
        this.tieneGas = tieneGas;
    }

    @Override
    public String toString() {
        return super.toString()+ " AguaSaborizada{" +
                "tieneGas=" + tieneGas +
                '}';
    }

}
