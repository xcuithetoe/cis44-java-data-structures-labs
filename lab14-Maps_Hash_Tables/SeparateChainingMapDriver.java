import java.util.ArrayList;
import java.util.LinkedList;

// Use the same Entry<K, V> and MapADT<K, V> as in Project 1

// --- 4. Implementation: Separate Chaining Hash Map ---
// Time Complexity: get/put/remove are O(1) expected (Amortized)
class SeparateChainingMap<K, V> implements MapADT<K, V> {
    private ArrayList<LinkedList<Entry<K, V>>> table;
    private int size = 0;
    private final int N = 11; // Use a prime number for table capacity

    public SeparateChainingMap() {
        table = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            table.add(new LinkedList<Entry<K, V>>());
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % N);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    // TODO: Complete this method (O(1) expected time)
    public V get(K key) {
        // 1. Calculate the hash index (bucket).
        int h = hash(key);

        // 2. Search linearly within the bucket's linked list for the key.
        LinkedList<Entry<K, V>> bucket = table.get(h);
        for (Entry<K,V> entry : bucket) {
            if (entry.getKey().equals(key)) { // found key
                return entry.getValue(); // return the found value
            }
        }  
        

        // 3. If key is not found in the bucket, return null.
        return null;
        
    }

    public V put(K key, V value) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        // Check if key already exists in the bucket
        for (Entry<K,V> entry : bucket) {
            if (entry.getKey().equals(key)) { // key already exists
                return entry.setValue(value); // set entry to new value and return old value
            }
        }
        // Key is new: add to the front of the list
        bucket.add(new Entry<>(key, value));
        return null;
        
      }

    public V remove(K key) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                toRemove = entry;
                break;
            }
        }

        if (toRemove != null) {
            V oldValue = toRemove.getValue();
            bucket.remove(toRemove);
            size--;
            return oldValue;
        }
        return null;
    }
}

// verify output with main() and get console screenshots.

/*
    The output should include insertions that demonstrate collision handling by inserting at least three 
    String keys that are expected to hash to the same bucket (or near the same bucket) in a small table 
    (like N=11). 

*/

// Given N=11, to all hash to the same bucket, the string keys should all be 
// multiples of 11. Hence, I choose to insert "B", "M", and "X" because they are
// ASCI 66, 77, and 88 respectively. Since they are all multiples of 11, they will 
// hash to the same bucket.

public class SeparateChainingMapDriver {
    public static void main(String[] args) {
        SeparateChainingMap<String, Integer> map = new SeparateChainingMap<>();
        System.out.println(map.put("B", 100)); // I chose an abritrary value (it doesn't actually matter). should be NULL
        System.out.println(map.put("M", 10)); // should be NULL
        System.out.println(map.put("X", 1));// should be NULL

        System.out.println(map.get("B")); // should be 100
        System.out.println(map.get("M")); // should be 10
        System.out.println(map.get("X")); // should be 1
        System.out.println(map.get("Z")); // Z is not in the map so it should be NULL.
        System.out.println(map.remove("M")); // Should be 10
        System.out.println(map.get("M")); // should be NULL
    }
}