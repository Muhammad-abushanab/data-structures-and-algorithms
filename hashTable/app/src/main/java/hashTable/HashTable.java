package hashTable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class HashTable<K, V> {
    private final int size;
    private final ArrayList<LinkedList<HashPair<K, V>>> table;


    // by default the size will be 10
    public HashTable() {
        this.size = 10;
        table = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            table.add(new LinkedList<>());
        }
    }

    // constructor to change size of the table
    public HashTable(int size) {
        this.size = size;
        table = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            table.add(new LinkedList<>());
        }
    }

    public void set(K key, V value) {
        int index = hash(key);
        LinkedList<HashPair<K, V>> bucket = table.get(index);
        for (HashPair<K, V> hashPair : bucket) {
            if (hashPair.key.equals(key)) {
                hashPair.value = value;
                return;
            }
        }
        bucket.add(new HashPair<>(key, value));
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<HashPair<K, V>> bucket = table.get(index);
        for (HashPair<K, V> hashPair : bucket) {
            if (hashPair.key.equals(key)) {
                return hashPair.value;
            }
        }
        return null;
    }

    public boolean has(K key) {
        int index = hash(key);
        LinkedList<HashPair<K, V>> bucket = table.get(index);
        for (HashPair<K, V> hashPair : bucket
        ) {
            if (hashPair.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public List<K> keys() {
        List<K> keys = new ArrayList<>();
        for (LinkedList<HashPair<K, V>> bucket : table
        ) {
            for (HashPair<K, V> hashPair : bucket
            ) {
                keys.add(hashPair.key);
            }
        }
        return keys;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % size);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("size: ").append(size).append("\n");

        for (LinkedList<HashPair<K, V>> bucket : table) {
            for (HashPair<K, V> hashPair : bucket) {
                str.append("Key: ").append(hashPair.key).append(", Value: ").append(hashPair.value).append("\n");
            }
        }
        return str.toString();
    }
}
