
import Clases.*;

import java.util.Date;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
// PRUEBA MENU
        ElementoMenu n1 = new Burger("Burger", 2340, "guacamole", "Mexicana");
        ElementoMenu n4 = new Burger("Burger", 4000, "chees and bacom", "Americana");
        ElementoMenu n2 = new Postre("Postre", 2370, "brownie con helado", "chocolatosoo");
        ElementoMenu n3= new Cerveza("Cerveza", 1000, 850, "Quilmes", "honey",3,"baja");

        /*
        Pedido c2 = new Pedido(123, new Date());

        c2.agregarApedido(n1, "Mexicana");
        c2.agregarApedido(n2, "brownie con helado");

        System.out.println(c2.calcularTotaldelPedido());
        System.out.println(c2.toString());

        Menu nuevoMenu= new Menu();
        System.out.println(nuevoMenu.listarTodoMenu());*/
        RevolutionBurgers.abrirCaja();
        RevolutionBurgers.crearPedido();

        System.out.println(RevolutionBurgers.agregarPedido("Burger", 101, n1));
        System.out.println(RevolutionBurgers.agregarPedido("Postre", 101, n2));
        System.out.println(RevolutionBurgers.agregarPedido("Burger", 101, n4));
        System.out.println(RevolutionBurgers.agregarPedido("Burger", 101, n1));
        System.out.println(RevolutionBurgers.listarTodounPedido(101));
        System.out.println(RevolutionBurgers.totalRecaudacion());
        RevolutionBurgers.deCajaaEstadistica();
        System.out.println("-----------------");
        System.out.println(RevolutionBurgers.listarEstatidistica());






        /*HashMap<String, Integer> nuevomapa= new HashMap<>();
        nuevomapa.put("Postre", 4);
        nuevomapa.put("Burguer", 5);
        Estadistica estadistica= new Estadistica(new Date(), nuevomapa, 10000);
        System.out.println(estadistica.listarTodoEstadistica());  Esta funcion anda bien*/
    }
}

