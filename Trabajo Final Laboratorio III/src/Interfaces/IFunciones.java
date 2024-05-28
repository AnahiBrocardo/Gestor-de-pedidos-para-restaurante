package Interfaces;

public interface IFunciones<E>{
public void agregar(E o, String key);

public String modificar(E o, String key, E objetoBuscado);

public boolean buscar(E buscado, String key);

public String listar(String key);

public void eliminar(E o, String key);
}
