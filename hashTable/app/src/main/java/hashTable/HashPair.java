package hashTable;

public class HashPair<K,V> {
    K key;
    V value;
    public HashPair(K key , V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "HashPair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
