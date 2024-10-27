package praktikum.OOP.Generics;

public class Pair<K, V>{
    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public void print() {
        System.out.printf("(%s, %s)", key, value);
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
