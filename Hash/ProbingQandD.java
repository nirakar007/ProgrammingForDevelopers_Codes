class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    private Entry<K, V>[] table;
    private int size;

    public HashTable() {
        this(DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        table = new Entry[capacity];
        size = 0;
    }

    public void put(K key, V value) {
        if ((double) size / table.length > LOAD_FACTOR_THRESHOLD) {
            resize();
        }

        int hash = hash(key);
        int index = hash % table.length;
        int stepQuadratic = 1;
        int stepDouble = hash2(key);

        // Quadratic probing
        while (table[index] != null && !table[index].getKey().equals(key)) {
            index = (index + stepQuadratic * stepQuadratic) % table.length;
            stepQuadratic++;
        }

        // Double hashing
        if (table[index] == null) {
            table[index] = new Entry<>(key, value);
            size++;
        } else {
            index = doubleHash(index, stepDouble);
            table[index] = new Entry<>(key, value);
            size++;
        }
    }

    public V get(K key) {
        int hash = hash(key);
        int index = hash % table.length;
        int stepQuadratic = 1;
        int stepDouble = hash2(key);

        // Quadratic probing
        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                return table[index].getValue();
            }
            index = (index + stepQuadratic * stepQuadratic) % table.length;
            stepQuadratic++;
        }

        // Double hashing
        index = doubleHash(index, stepDouble);
        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                return table[index].getValue();
            }
            index = (index + stepDouble) % table.length;
        }

        return null; // Key not found
    }

    public void remove(K key) {
        int hash = hash(key);
        int index = hash % table.length;
        int stepQuadratic = 1;
        int stepDouble = hash2(key);

        // Quadratic probing
        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                table[index] = null;
                size--;
                return;
            }
            index = (index + stepQuadratic * stepQuadratic) % table.length;
            stepQuadratic++;
        }

        // Double hashing
        index = doubleHash(index, stepDouble);
        while (table[index] != null) {
            if (table[index].getKey().equals(key)) {
                table[index] = null;
                size--;
                return;
            }
            index = (index + stepDouble) % table.length;
        }
    }

    private int hash(K key) {
        return key.hashCode();
    }

    private int hash2(K key) {
        // Using a simple secondary hash function
        int prime = 31; // You can choose a different prime number
        return prime - (key.hashCode() % prime);
    }

    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[table.length * 2];

        for (Entry<K, V> entry : oldTable) {
            if (entry != null) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    private int doubleHash(int index, int step) {
        return (index + step) % table.length;
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
    }
}

public class ProbingQandD {
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
