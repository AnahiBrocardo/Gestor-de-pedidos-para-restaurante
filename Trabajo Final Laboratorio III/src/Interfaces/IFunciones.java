package Interfaces;

public interface IFunciones{
public void agregar(Object o, String key);

public String modificar(Object o, String key, Object objetoBuscado);

public boolean buscar(Object buscado, String key);

public String listar(String key);

public void eliminar(Object o, String key);
}
