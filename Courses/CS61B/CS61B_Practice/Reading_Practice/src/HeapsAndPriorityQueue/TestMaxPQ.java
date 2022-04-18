package HeapsAndPriorityQueue;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestMaxPQ {
    @Test
    public void insertDelTest() {
        MaxPQ<Integer> maxPQ = new MaxPQ<>(5);
        assertTrue(maxPQ.isEmpty());
        for (int i = 0; i < 5; i++) {
            assertEquals(i, maxPQ.size());
            maxPQ.insert(i);
        }
        for (int i = 4; i >= 0; i--) {
            assertTrue(maxPQ.delMax() == i);
        }
    }
}
