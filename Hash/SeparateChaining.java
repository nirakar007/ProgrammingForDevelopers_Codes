import java.util.LinkedList;

class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 10;

    private LinkedList<Entry<K, V>>[] table;
    private int size;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }

    public void put(K key, V value) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Check if the key already exists in the list, update the value if so
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        // Add a new entry to the list
        bucket.add(new Entry<>(key, value));
        size++;

        // Resize the table if necessary (optional)
        if (size > table.length * 0.75) {
            resize();
        }
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Search for the key in the list
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        return null; // Key not found
    }

    public void remove(K key) {
        int index = hash(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Find and remove the entry with the given key
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                bucket.remove(entry);
                size--;
                return;
            }
        }
    }

    private int hash(K key) {
        return key.hashCode() % table.length;
    }

    private void resize() {
        // Double the table size and rehash all entries
        LinkedList<Entry<K, V>>[] newTable = new LinkedList[table.length * 2];
        for (int i = 0; i < newTable.length; i++) {
            newTable[i] = new LinkedList<>();
        }

        for (LinkedList<Entry<K, V>> bucket : table) {
            for (Entry<K, V> entry : bucket) {
                int index = entry.getKey().hashCode() % newTable.length;
                newTable[index].add(entry);
            }
        }

        table = newTable;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}

public class SeparateChaining {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);

        System.out.println("Value for key 'two': " + hashTable.get("two"));

        hashTable.remove("two");

        System.out.println("Value for key 'two' after removal: " + hashTable.get("two"));
    }
}
