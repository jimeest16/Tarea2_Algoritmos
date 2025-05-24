package domain;


import java.util.List;

public interface MapMethods {

    // Devuelve el número de entradas en el mapa
    int size();

    // Retorna true si el mapa está vacío
    boolean isEmpty();

    // Retorna el valor asociado a la clave dada, o null si no existe
    Object get(Object key);

    // Inserta una entrada (clave, valor) o reemplaza si ya existe; retorna el valor anterior si se reemplazó
    Object put(Object key, Object value);

    // Elimina una entrada por clave y retorna su valor, o null si no existía
    Object remove(Object key);

    // Retorna una lista de todas las claves almacenadas
    List<Object> keySet();

    // Retorna una lista de todos los valores almacenados (puede haber repetidos)
    List<Object> values();

    // Retorna una lista con todas las entradas (clave-valor) almacenadas
    List<MapTDA> entrySet();
}

