import java.util.ArrayList;

// --- 1. Entry ADT ---
class Entry<K, V> {
    private final K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() { return key; }
    public V getValue() { return value; }
    public V setValue(V value) { 
        V old = this.value;
        this.value = value;
        return old;
    }
}

// --- 2. Common Map Interface ---
interface MapADT<K, V> {
    V get(K key);
    V put(K key, V value);
    V remove(K key);
    int size();
    boolean isEmpty();
}

// --- 3. Implementation: Unsorted List Map ---
class UnsortedListMap<K, V> implements MapADT<K, V> {
    private ArrayList<Entry<K, V>> list = new ArrayList<>();
    private int findEntryIndex(K key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    public int size() { return list.size(); }
    public boolean isEmpty() { return list.isEmpty(); }
    
    public V get(K key) {
        int i = findEntryIndex(key);
        return (i != -1) ? list.get(i).getValue() : null;
    }
    
    public V remove(K key) {
        int i = findEntryIndex(key);
        if (i != -1) {
            V oldValue = list.get(i).getValue();
            list.remove(i); 
            return oldValue;
        }
        return null;
    }
    
    // TODO: Complete this method (O(n))
    public V put(K key, V value) {
        // 1. Search for existing key.

        int location = findEntryIndex(key);
        
        // 2. If found, update the value and return the old value.
        
        if (location >= 0) {
            return list.get(location).setValue(value);
        }
        
        // 3. If not found, add a new entry and return null.

        else {
            Entry<K, V> entry = new Entry<>(key, value);
            list.add(entry);
            return null;
        }
        
    }
}

// main() function to verify core operations and get the console output screenshots.

public class UnsortedListMapDriver {
    public static void main(String[] args) {
        UnsortedListMap<Integer, String> map = new UnsortedListMap<>();

        System.out.println(map.put(5, "A"));  // output should be NULL
        System.out.println(map.put(7, "B"));  // output should still be NULL
        System.out.println(map.put(2, "C"));  // output should still be NULL
        System.out.println(map.put(2, "E"));  // output should be "C"
        System.out.println(map.get(7)); // output should be "B"
        System.out.println(map.remove(5)); // output should be "A"


    }
}