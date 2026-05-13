/**
 * I first create a node class for my Doubly Linked List.
 * 
 * Unlike a typical linked list, these nodes also have a key in addition to their values. The key is 
 * important because if a node is deleted in within the linked list, the correspoinding entry in the 
 * hash table with the same key must be removed too.  
 * 
 * Since this is a doubly linked list, each node also has a refernce to prev/next nodes.
 * 
 * A doubly-linked list alone is not enough to be used as cache because of its O(n) retrieval time.
 * However, the advantage of a doubly linked list is that it is O(1) in adding new data and removing 
 * older data - this is very important in a LRU (least recently used) cache. 
 */

public class Node {

    int key;
    int value;
    
    Node prev; // next "recent"node
    Node next; // next "older" node. will be deleted first in LRU

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
