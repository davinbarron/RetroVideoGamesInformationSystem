package Model;

import java.io.Serializable;

public class HashTable<V> implements Serializable {
    private Node<V>[] hashTable;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private static final float LOAD_FACTOR = 0.75f;

    public HashTable(int capacity) {
        hashTable = new Node[capacity];
    }

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public int hashFunction(int key) {
        return Math.abs(key) % hashTable.length;
    }

    public void put(int key, V value) {
        if (size >= LOAD_FACTOR * hashTable.length) {
            resize();
        }
        int index = hashFunction(key);
        hashTable[index] = new Node<>(key, value, hashTable[index]);
        size++;
    }

    public V get(int key) {
        int index = hashFunction(key);
        for (Node<V> node = hashTable[index]; node != null; node = node.next) {
            if (node.key == key) {
                return node.value;
            }
        }
        return null;
    }

    public int size() {
        return size;
    }

    private void resize() {
        Node<V>[] oldTable = hashTable;
        hashTable = new Node[oldTable.length * 2];
        size = 0;
        for (Node<V> node : oldTable) {
            if (node != null) {
                put(node.key, node.value);
            }
        }
    }

    public Object[] values() {
        Object[] values = new Object[size];
        int index = 0;
        for (Node<V> node : hashTable) {
            for (Node<V> x = node; x != null; x = x.next) {
                values[index++] = x.value;
            }
        }
        return values;
    }

    private static class Node<V> implements Serializable {
        private int key;
        private V value;
        private Node<V> next;

        public Node(int key, V value, Node<V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
