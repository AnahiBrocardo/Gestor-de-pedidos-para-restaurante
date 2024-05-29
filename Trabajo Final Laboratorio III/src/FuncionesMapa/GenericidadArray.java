package FuncionesMapa;

import Interfaces.IFuncionesArreglos;

import java.util.ArrayList;

public class GenericidadArray <E> implements IFuncionesArreglos<E> {
    private ArrayList<E> nuevoArreglo;
    public GenericidadArray() {
        this.nuevoArreglo = new ArrayList<>();
    }

    @Override
    public void agregar(E o) {
        nuevoArreglo.add(o);
    }

    @Override
    public void sobreescribir(E nuevo, E aCambiar) {
        for (int i=0; i< nuevoArreglo.size(); i++){
            if (nuevoArreglo.get(i).equals(aCambiar)){
                nuevoArreglo.set(i, nuevo);
            }
        }
    }

    @Override
    public boolean buscar(E buscado) {
        boolean rta= false;
        if(nuevoArreglo.contains(buscado))
            rta=true;
        return rta;
    }

    @Override
    public String listar() {
        String rta= "";
        for(int i=0; i< nuevoArreglo.size(); i++)
        {
            rta += nuevoArreglo.get(i).toString();
        }
        return rta;
    }

    @Override
    public void eliminarElemento(E o) {
        nuevoArreglo.remove(o);
    }
}
