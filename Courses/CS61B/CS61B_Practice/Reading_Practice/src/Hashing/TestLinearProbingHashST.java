package Hashing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLinearProbingHashST {
    @Test
    public void testLinearProbingHashST() {
        LinearProbingHashST<String, Integer> hashST
                = new LinearProbingHashST<>(16);
        hashST.put("Dog", 1);
        hashST.put("Cat", 2);
        hashST.put("Fish", 3);
        assertEquals((Integer) 2, hashST.get("Cat"));
        hashST.delete("Cat");
        assertEquals((Integer) 3, hashST.get("Fish"));
    }
}
