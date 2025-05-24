package domain;

import org.junit.jupiter.api.Test;

class HashTableTDATest {
    @Test
    public void test() {

        System.out.println("____HASH TABLES_____________");

        HashTableTDA hashTable = new HashTableTDA(20);
        hashTable.createTable();
        System.out.println("___________________________________________________");
        // 1. agregar los objects
        System.out.println("Inserting hotels:");

        hashTable.put("ED1-Name", "Torre Central");
        hashTable.put("ED1-Level", "15");
        hashTable.put("ED1-Adress", "San José");

        hashTable.put("ED2-Name", "Plaza Norte");
        hashTable.put("ED2-Level", "10");
        hashTable.put("ED2-Adress", "Heredia");

        System.out.println("___________________________________________________");
        System.out.println();

        // mostrar table
        System.out.println("Content of the Hash Table:");
        hashTable.printTable();
        System.out.println("___________________________________________________");
        System.out.println();

        // get test
        System.out.println("Searching hotel info....");
        searchKey(hashTable, "ED1-Name");
        searchKey(hashTable, "ED2-Adress");
        System.out.println("___________________________________________________");
        System.out.println();

        // remove
        System.out.println("Deleting hotel info..." + "ED2-Adress");
        hashTable.remove("ED2-Adress");
        searchKey(hashTable, "ED2-Adress");
        System.out.println("___________________________________________________");
        System.out.println();

        System.out.println("Hash Table modified:");
        hashTable.printTable();
        System.out.println("___________________________________________________");
        System.out.println();

        // entradas hechas
        System.out.println("All the entries");
        for (String entry : hashTable.entrySet()) {
            System.out.println("*" + entry);

        }

    }

    // metodo aparte para buscar key en la tabla
    private static void searchKey(HashTableTDA tableTDA, String key) {
        String value = tableTDA.get(key);
        if (value != null) {
            System.out.println("Founded[ " + key + " ] ==>" + value);

        } else {
            System.out.println("Not founded[ " + key + "]");

        }
    }


    @Test
    public void testBuckets() {
        System.out.println("HASH TABLE CON BUCKETS");

        HashTableTDA table = new HashTableTDA(10);
        table.createTable();

        // EmpireState debería colisionar con StateEmpire porque tienen letras similares
        String key1 = "Cartago";
        String key2 = "Cartago";
        String key3 = "San Jose";
        String key4 = "Limon";

        // Verificar índices hash
        int index1 = table.hashTest(key1);
        int index2 = table.hashTest(key2);
        int index3 = table.hashTest(key3);
        int index4 = table.hashTest(key4);

        System.out.println("\n Índices generados:");
        System.out.println("" + key1 + "' → índice " + index1);
        System.out.println("" + key2 + "' → índice " + index2);// en el test son indice iguakes x la similitud
        System.out.println("" + key3 + "' → índice " + index3);
        System.out.println("" + key4 + "' → índice " + index4);

        // Añadiendo info...
        // al final no importa el value si son identicos pero las llaves no pueden ser iguales
        // porque modifican en los buckets
        table.bucketPut(index1, key1, "Costa Rica");
        table.bucketPut(index2, key2, "Colombia");
        table.bucketPut(index3, key3, "Costa Rica");
        table.bucketPut(index4, key4, "Costa Rica");

        // uso de get para encontrar los valores
        System.out.println("\n Encontrando los valores...");
        System.out.println("*" + key1 + "' → " + table.bucketGet(index1, key1));
        System.out.println("*" + key2 + "' → " + table.bucketGet(index2, key2));
        System.out.println("*" + key3 + "' → " + table.bucketGet(index3, key3));
        System.out.println("*" + key4 + "' → " + table.bucketGet(index4, key4));

        // Eliminar algunas claves
        System.out.println("\n Eliminando claves...");
        table.bucketRemove(index1, key1); // porque son las similares
        table.bucketRemove(index2, key2);

        // volvemos a llamarlas
        System.out.println("\n Valores encontrados...");
        System.out.println("*" + key1 + "' → " + table.bucketGet(index1, key1));
        System.out.println("*" + key2 + "' → " + table.bucketGet(index2, key2));

        // Mostrar tabla final
        System.out.println("\nTabla final:");
        table.printTable();
    }
}
