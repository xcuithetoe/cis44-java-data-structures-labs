/**
 * This is the second part of phase 4, which is to write a 
 * JUnit Test Class using assertions to validate my methods. 
 * 
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LRUCacheTest {

    @Test
    public void testBasicOperations() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1)); // see if basic put and get operations work
        cache.put(3, 3); // see if the buckets work (key 3 and 1 go to the same bucket). also see if the full-capacity removals work. key 1 should be removed. 
        assertEquals(-1, cache.get(2)); // check that key 2 is actually removed
        assertEquals(3, cache.get(3));
    }

    @Test
    public void testEvictionOrder() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);    // 1 is now most recent
        cache.put(3, 3); // evicts key 2
        assertEquals(-1, cache.get(2)); // key 2 should no longer exist
        assertEquals(1, cache.get(1));
    }

    @Test
    public void testUpdateKey() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(1, 10);
        assertEquals(10, cache.get(1)); // key 1 should have an updated value 
    }

    @Test
    public void testCapacityOne() {
        LRUCache cache = new LRUCache(1);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(-1, cache.get(1));// key 1 should be evicted
        assertEquals(2, cache.get(2)); // key 2 should still exist
    }
}
