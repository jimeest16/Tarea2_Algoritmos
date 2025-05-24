package domain;

public class Map {

    private Object key;// la clave del map
    private Object value;

    public Map(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Map{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
