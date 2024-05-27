
import Clases.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Pedido nuevoP= new Pedido(1254, new Date());
        ElementoMenu nuevaC= new Burger("Burger",1500,"jkfef","Mexicana");
        ElementoMenu nuevaC2= new Burger("Burger",2000,"jkfef","Americana");
        ElementoMenu nuevaC3= new Postre("Postre",1449,"jkfef","Brownie con helado");

        nuevoP.getConjuntoDeElementos().agregar(nuevaC, "Mexicana");
        nuevoP.getConjuntoDeElementos().agregar(nuevaC2, "Americana");
        nuevoP.getConjuntoDeElementos().agregar(nuevaC3, "Brownie con helado");
        System.out.println("El total del pedidod es: "+nuevoP.calcularTotaldelPedido());

    }
}