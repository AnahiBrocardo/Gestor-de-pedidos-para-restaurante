package Clases;

public class Burger extends ElementoMenu {
        private String descripcion;
        private String tipoHamburguesa; //puede ser Mexicana, americana, argenta o liviana

    public Burger ()
    {
        descripcion = "";
        tipoHamburguesa= "";
    }

    public Burger (String nombreElementoMenu, double precioElementoMenu, String descripcion, String tipoHamburguesa) {
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
            return super.toString()+
                    "\nDescripcion: " + descripcion +
                    "\nEstilo: " + tipoHamburguesa;
        }
    }


