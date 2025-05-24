package domain;

import java.util.List;

public interface HashTableMethods {
    void createTable();
    // Crea la tabla hash vacía
    void put(String key, String value);
    // Inserta o actualiza una clave
    String get(String key);
    // Obtiene el valor de una clave
    void remove(String key);
    // Elimina una clave
    void printTable();
    // Imprime el contenido de la tabla

    String bucketGet(int indice, String key);
    // Obtiene el valor en el bucket h
    void bucketPut(int indice, String key, String value);
    // Inserta o actualiza en el bucket h
    void bucketRemove(int indice, String key);
    // Elimina desde el bucket h

    List<String> entrySet();
    // Lista de todas las entradas válidas
}

