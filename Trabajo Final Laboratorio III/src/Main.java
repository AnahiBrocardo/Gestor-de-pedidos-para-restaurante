
import Clases.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        ElementoMenu n1 = new Burger("Burger", 2340, "chees and bacom", "Mexicana");
        ElementoMenu n2 = new Postre("Postre", 2370, "brownie con helado", "brofje");
        Pedido c2 = new Pedido(123, new Date());

        c2.getConjuntoDeElementos().agregar(n1, "Mexicana");
        c2.getConjuntoDeElementos().agregar(n2, "brownie con helado");

        System.out.println(c2.calcularTotaldelPedido());
        System.out.println(c2.toString());





    }
}