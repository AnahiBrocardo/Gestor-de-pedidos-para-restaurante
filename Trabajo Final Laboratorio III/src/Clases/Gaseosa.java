package Clases;

public class Gaseosa extends Bebida{
    private boolean tieneEndulzante;
    

    public Gaseosa(String nombreElementoMenu, double precioElementoMenu, float capacidad, String marca, String sabor, boolean tieneEndulzante) {
        super(nombreElementoMenu, precioElementoMenu, capacidad, marca, sabor);
        this.tieneEndulzante = tieneEndulzante;
    }

    public boolean isTieneEndulzante() {
        return tieneEndulzante;
    }

    public String infoTieneEndulzante(){
        String info="";
        if(tieneEndulzante){
            info="Con azucar";
        }else{
            info="Sin azucar";
        }
        return info;
    }

    public void setTieneEndulzante(boolean tieneEndulzante) {
        this.tieneEndulzante = tieneEndulzante;
    }

    @Override
    public String toString() {
        return super.toString()+
               "\n"+ infoTieneEndulzante();
    }

    public String getTipoBebida(){
        return "Gaseosa";
    }
}
