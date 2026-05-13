/**
 * This implements the lookup logic that returns the correct data or decision result.
 * This code rbings together the doubly linked list data structure (node.java) and the hashmap data structure (SeparateChainingMap.java)
 * When new cache data is added, the hashmap keeps the location of the data while the doubly linked list stores the data itself. 
 * The hashmap helps find the data when it needs to be retrieved, while the doubly linked lists helps keep track of which ones
 * are the most recently used and which pieces of data are the least recently used. 

 */
public class LRUCache {
    private final int capacity;
    private final SeparateChainingMap map; // the hashmap

    private final Node head;// I'm using dummy head and tail nodes to simplify addition/removal logic for the doubly linked list
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new SeparateChainingMap(capacity); // create a hashmap to store references to cache data
        
        // I'm using dummy head and tail nodes to simplify addition/removal logic for the doubly linked list
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    /**
     * The GET method finds a desired node, returns its value (-1 if not found), and puts it at the front
     * of the cache (to signify that is the most recently used data)
     * 
     * This will be used when a user opens a website that the computer has cache data for. The computer uses
     * get() to quickly load browser data and marks it as the most recently used cache data so that it wouldn't
     * be deleted should new  data be added to the cache. 
     * 
     * The most important part of the GET method is to fulfill the LRU (least recently used) requirement.
     * In an LRU cache, the most recently used data is at the head and the least recently used data is at 
     * the tail. When new data is added and the cache is already using up max capacity, the LRU data at the
     * tail will be ejected. 
     * 
     * This system is utilized because cache should only store data for the websites
     * that the user actually visits more. If the user hasn't visited a website in a long time, there is no
     * need for cache to waste disk space on that wesbite's data. Instead, it should focus its resources on
     * speeding up browser speed for more-frequently visited websites.
     */
    
    public int get(int key) {

        Node node = map.get(key); // use the get() function of the hashmap to find the reference to the node instance. O(1)
        if (node != null) { // if this node actually exists
            remove(node); 
            addToHead(node); // reposition the node to the head of the doubly linked list. This is also O(1)
            return node.value;
        }
        return -1; // no node exists for the given key
    }


    /**
     * The put() method adds new data to the cache. 
     * It creates a node for the given key/value pair and adds it to the doubly linked list. 
     * If the cache is already operating at maximum capacity, the addition of data necessitates
     * the deletion of other data. Hence, the least-recently-used (and consequently, the least
     * important) data at the tail of the linked list is deleted. Since this is a doubly-linked 
     * list, these operations are only O(1) to complete. 

     */
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) { // if this node already exists, we simply need to update its value
            node.value = value;
            remove(node); // Updates occur because a user has re-visited the website, making it the most recent. Hence, an update also positions the node to the front of the list ()
            addToHead(node);
        } else {
            if (map.size() >= capacity) { // if size is already full, the least recently used (lru) data must be deleted to make room. 

                Node lru = tail.prev; // tail of the linkedlist (excluding dummies)
                map.remove(lru.key); // When something is being removed, it has to be removed from both the hashmap and the linked list.
                remove(lru);
            }
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
        }
    }

    // remove() Removes a node in the doubly linked list.
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * Adding to the head is frequently used in put() and get() because anytime a website is visited, its corresponding
     * cache data is moved to the most-frequently-used section of the list, which is the head. Hence, I decided to just make 
     * a separate function for adding to the head.
     */

    private void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
}
