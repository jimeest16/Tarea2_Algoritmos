package domain;

import java.util.ArrayList;
import java.util.List;

import static ucr.lab.util.Utility.compare;

public class MapTDA implements MapMethods {
    private Map[] mapInsertion;
    // arreglo
    private int size;
    // cantidad actual

    private static final int INITIAL_CAPACITY = 10;

    public MapTDA() {
        this.mapInsertion = new Map[INITIAL_CAPACITY];
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object get(Object key) {
        if (key == null) {
            throw new MapException("The key is invalid");
        }
        for (int i = 0; i < size; i++) {
            if (compare(mapInsertion[i].getKey(), key) == 0) {
                return mapInsertion[i].getValue();
            }
        }
        throw new MapException("The key is invalid");
    }

    @Override
    public Object put(Object key, Object value) {
        if (key == null) {
            throw new MapException("La clave no puede ser null");
        }
        // Verificar si la clave existe y reemplazar valor
        for (int i = 0; i < size; i++) {
            if (compare(mapInsertion[i].getKey(), key) == 0) {
                Object oldValue = mapInsertion[i].getValue();
                mapInsertion[i].setValue(value);
                return oldValue;
            }
        }
        // Si no existe, agregar nuevo par
        if (size == mapInsertion.length) {
            // Redimensionar arreglo manualmente
            Map[] newArray = new Map[mapInsertion.length * 2];
            for (int j = 0; j < size; j++) {
                newArray[j] = mapInsertion[j];
            }
            mapInsertion = newArray;
        }
        mapInsertion[size] = new Map(key, value);
        size++;
        return null;
    }

    @Override
    public Object remove(Object key) {
        if (key == null) {
            throw new MapException("La clave no puede ser null");
        }
        for (int i = 0; i < size; i++) {
            if (compare(mapInsertion[i].getKey(), key) == 0) {
                Object removedValue = mapInsertion[i].getValue();
                // Desplazar elementos a la izquierda para "eliminar" el elemento i
                for (int j = i; j < size - 1; j++) {
                    mapInsertion[j] = mapInsertion[j + 1];
                }
                mapInsertion[size - 1] = null; // limpiar referencia
                size--;
                return removedValue;
            }
        }
        return null; // No se encontró la clave
    }

    @Override
    public List<Object> keySet() {
        List<Object> keys = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            keys.add(mapInsertion[i].getKey());
        }
        return keys;
    }

    @Override
    public List<Object> values() {
        List<Object> values = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            values.add(mapInsertion[i].getValue());
        }
        return values;
    }

    @Override
    public List<MapTDA> entrySet() {

        return List.of();
    }
}
//basicamente
//Insertar o actualizar (put):
//Añades un nuevo par (clave, valor).
//Si la clave ya existe, reemplazas el valor viejo por el nuevo.
//
//Obtener (get):
//Dado un clave, te devuelve el valor asociado.
//
//Eliminar (remove):
//Quitas la entrada que tiene cierta clave.
//
//        Saber tamaño (size):
//Cuántos pares clave-valor hay en total.
//
//Saber si está vacío (isEmpty):
//Verifica si no hay elementos.
//
//        Listar claves (keySet):
//Devuelve todas las claves existentes.
//
//        Listar valores (values):
//Devuelve todos los valores almacenados.