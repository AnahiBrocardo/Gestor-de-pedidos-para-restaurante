package Interfaces;

public interface IFuncionesArreglos <E>{
    public void agregar(E o);

    public void sobreescribir(E o, E objetoBuscado);

    public boolean buscar(E buscado);

    public String listar();

    public void eliminarElemento(E o);
}