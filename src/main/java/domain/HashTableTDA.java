package domain;

import java.util.List;

import static ucr.lab.util.Utility.compare;

public class HashTableTDA implements HashTableMethods {

    private HashTable[] table;
    private int capacity;
    private int size;

    public HashTableTDA(int capacity) {
        this.capacity = capacity;// con la capacidad que quiero que la tabla tenga

    }
    public int hashTest(String key) {
        return hash(key); // solo para la prueba
    }

    @Override
    public void createTable() {
        table = new HashTable[capacity];// como un arreglo convencional
        size = 0;
    }

    // metodo adquirido de la lectura
    // funcion:calcular el indice para una key

    private int hash(String key) {
        int counter = 0;
        for (int i = 0; i < key.length(); i++) {

            counter = (31 * counter + key.charAt(i)) % capacity;
        }
        return counter;
    }

    @Override
    // al igual que la clase map el metodo put inserta o cae sobre un valor
    public void put(String key, String value) {
        int indice = hash(key);
        bucketPut(indice, key, value);// inserta en el bucket, recursividad al 100

    }

    // va a obtener el valor de la key
    @Override
    public String get(String key) {
        int indice = hash(key);// este metodo hash calcula indice para la key
        return bucketGet(indice, key);// busca key en indice y sus duplicados

    }

    //eliminar en el indice de key
    @Override
    public void remove(String key) {
        int indice = hash(key);
        bucketRemove(indice, key);

    }

    @Override
    public void printTable() {
//tambien lo podemos hacer con un string
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null && table[i].getKey() != null) {
                System.out.println("[" + i + "]" + table[i].getKey() + "=>" + table[i].getValue());

            }
        }
    }

    // busca con el indice y la llave
    @Override
    public String bucketGet(int startIndex, String key) {
        int index = startIndex;

        while (table[index] != null) {
            if (compare(table[index].getKey(), key) == 0) {
                return table[index].getValue();
            }
            index = (index + 1) % capacity;
            if (index == startIndex) break; // Si se dio la vuelta completa
        }

        return null; // No encontrado
    }


    // add o update de la clave con el sondeo lineal
    @Override
    public void bucketPut(int startIndex, String key, String value) {
        int index = startIndex;

        while (table[index] != null) {
            // Si la clave ya existe, actualizamos el valor
            if (compare(table[index].getKey(), key) == 0) {
                table[index].setValue(value);
                return;
            }

            index = (index + 1) % capacity;
            if (index == startIndex) return; // Si dimos vuelta completa, tabla llena
        }

        // Espacio vacío encontrado, insertamos nueva entrada
        table[index] = new HashTable(key, value);
        size++;
    }

    @Override
    public void bucketRemove(int startIndice, String key) {
int indice=startIndice;
while(table[indice]!=null){
    if(compare(table[indice].getKey(), key)==0){
        table[indice]=null;// elimina el elemento si es igual
        size--;
        // Reorganizar elementos posteriores (rehashing)
        int next = (indice + 1) % capacity;
        while (table[next] != null) {
            HashTable rehashEntry = table[next];
            table[next] = null;
            size--;
            put(rehashEntry.getKey(), rehashEntry.getValue());
            next = (next + 1) % capacity;
        }

        return;
    }

    indice= (indice+ 1) % capacity;
    if (indice == startIndice) return;
}
    }
    @Override
    public List<String> entrySet() {
        // Devuelve las claves como lista
        java.util.ArrayList<String> keys = new java.util.ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null && table[i].getKey() != null) {
                keys.add(table[i].getKey() + " => " + table[i].getValue());
            }
        }
        return keys;
    }
}