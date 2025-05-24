package domain;

import org.junit.jupiter.api.Test;

// codigo para la tarea pagina 411 a 422

class MapTDATest {
    @Test
    public void test(){
        MapTDA map=new MapTDA();
        map.put("Jimena", "Edificio 1");
        map.put("Fabiola", "Edificio 2");
        map.put("Felipe", "Edificio 3");
        map.put("Rodrigo", "Edificio 4");

        System.out.println("Tamaño de la residencia:" + map.size());

        System.out.println("Edificio donde se ubica Jimena->"+ map.get("Jimena"));
        //System.out.println("Habitante del Edificio 2:" + map.get("Edificio 2"));// no funcionarfia
        // debe de ser key primer valor nombre
        System.out.println("Edificio donde se ubica Felipe->" + map.get("Felipe"));

        // put puede sobre poner datos
        map.put("Jimena","Edificio 5");
        System.out.println("Jimena ahora vive en-> " + map.get("Jimena"));

        // remove
        map.remove("Felipe");
        System.out.println("Edificio de felipe->" + map.remove("Felipe"));// si aparece que null todo bien porque se removio

        System.out.println("Tamaño de la residencia:" + map.size());
    }
@Test
    public void test2() {

}
}