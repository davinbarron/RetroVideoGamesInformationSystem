package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void testHashTable() {
        HashTable<String> hashTable = new HashTable<>(10);
        assertNotNull(hashTable);
    }

    @Test
    void testHashFunction() {
        HashTable<String> hashTable = new HashTable<>(10);
        int index = hashTable.hashFunction(15);
        assertEquals(5, index);
    }

    @Test
    void testPutAndGet() {
        HashTable<String> hashTable = new HashTable<>(10);
        hashTable.put(1, "value1");
        hashTable.put(11, "value11");
        assertEquals("value1", hashTable.get(1));
        assertEquals("value11", hashTable.get(11));
    }

    @Test
    void testGetWithNoValue() {
        HashTable<String> hashTable = new HashTable<>(10);
        assertNull(hashTable.get(1));
    }

    @Test
    void testSize() {
        HashTable<String> hashTable = new HashTable<>(10);
        hashTable.put(1, "value1");
        hashTable.put(11, "value11");
        assertEquals(2, hashTable.size());
    }

    @Test
    void testResize() {
        HashTable<String> hashTable = new HashTable<>(2);
        hashTable.put(1, "value1");
        hashTable.put(2, "value2");
        hashTable.put(3, "value3");  // This should trigger a resize
        assertEquals(3, hashTable.size());
        assertEquals("value1", hashTable.get(1));
        assertEquals("value2", hashTable.get(2));
        assertEquals("value3", hashTable.get(3));
    }
}
