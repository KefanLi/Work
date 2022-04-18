package Hashing;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestSeparateChainingHashST {
    @Test
    public void testPut() {
        SeparateChainHashST<String, Integer> hashST =
                new SeparateChainHashST<>(16);
        hashST.put("Dog", 1);
        hashST.put("Cat", 2);
        hashST.put("Fish", 3);
    }

    @Test
    public void testSeparateChainHashST() {
        SeparateChainHashST<String, Integer> hashST =
                new SeparateChainHashST<>(16);
        hashST.put("Dog", 1);
        hashST.put("Cat", 2);
        hashST.put("Fish", 3);
        assertEquals((Integer) 2, hashST.get("Cat"));
        assertEquals(3, hashST.size());
        hashST.delete("Cat");
        assertEquals((Integer) 3, hashST.get("Fish"));
    }
}
