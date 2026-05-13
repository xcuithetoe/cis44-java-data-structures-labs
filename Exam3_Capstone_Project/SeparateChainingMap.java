/**
 * hashmap data structure. 
 * 
 * Has a Entry[] table to store entries. Each entry is a key-value pair. The key of the entry is the same 
 * as the key of the node it refers to. The value of each entry is an object reference to the node instance
 * itself.
 * 
 * This hash map uses the separate chaining method to deal with collisions. So, each bucket uses a singly 
 * linked list to store multiple entries, if necessary. As a result, each entry instance will have a 
 * "next" pointer.
 */
public class SeparateChainingMap {


    private static class Entry {

        int key; // The key of the entry is the same as the key of the node it refers to. 
        Node value; // The value of each entry is an object reference to the node instance itself.
        Entry next; // Points to the next entry in the singly linked list bucket. 

        Entry(int key, Node value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Entry[] table; // hashmap

    // in real-world applications, there is a limit to how much disk space can be allocated for cache. 
    // for reference, a typical chrome browser holds around 250MB to 1GB of disk space for cache. 
    // this capacity is usually dyanmic. chrome, for example, will lower or increase its cache size
    // if total disk space changes or if there are differing performance needs.

    // however, for simplicity, this project will keep the cache capacity fixed so that the LRU (least
    // recently used) functionality is most apparent. 
    
    // an important thing to note is that for separate chaining to be effective, the size should be no more than 0.9 of capacity.
    private final int capacity; // N

    private int size; // n

    public SeparateChainingMap(int capacity) {
        this.capacity = capacity;
        this.table = new Entry[this.capacity];
        this.size = 0;
    }

    private int hash(int key) {
        // I'm using a super simple hash function here that also avoids needing a compression function. 
        // In real-world applications, the hash function will be a polynomial hash code, and the compression
        // function would probably use the MAD method. 
        // important that this function stays private.

        return Math.abs(key) % capacity;
    }

    public void put(int key, Node value) {
        int index = hash(key);
        Entry current = table[index];
        
        // Separate chaining: If the bucket already has entries, move to the end of the
        // singly linked list. 

        while (current != null) { // if this bucket already has entries. if it doesn't, it only has null. 
            if (current.key == key) { // if an entry with the key already exists, update it with the new value
                current.value = value;
                return;
            }
            current = current.next; // if the right entry isn't found (or there are more entries), continue along the singly linked list
        }

        Entry newEntry = new Entry(key, value);

        // New entry is added to the FRONT of the singly linked list because it is an O(1) operation, as opposed to the 
        // O(n) time complexity of adding to the end of the list. 
        newEntry.next = table[index]; 
        table[index] = newEntry;
        size++;
    }

    public Node get(int key) {
        int index = hash(key);
        Entry current = table[index];
        
        // cycle through the singly linked list of the bucket to find the key. 
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }
        return null; //  not found!
    }

    public void remove(int key) {
        int index = hash(key);
        Entry current = table[index];
        Entry prev = null;

        while (current != null) {
            if (current.key == key) { // found the right entry to remove
                if (prev == null) { // if this is the head  of the singly linked list bucket
                    table[index] = current.next; // turn the next entry into the head of the singly linked list bucket
                } else {
                    prev.next = current.next; // let the previous entry's next pointer point to the next entry, skipping the current entry (which is to be deleted)
                }
                size--;
                return;
            }
            prev = current;
            current = current.next; // continue along the bucket
        }
    }

    public int size() {
        return size;
    }
}
