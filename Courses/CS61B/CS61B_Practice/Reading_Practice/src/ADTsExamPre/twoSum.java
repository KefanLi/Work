package ADTsExamPre;

import java.util.HashSet;

import static org.junit.Assert.*;

import org.junit.Test;

public class twoSum {
    public static boolean twoSum(int[] A, int K) {
        HashSet<Integer> container = new HashSet<>();

        for (int i : A) {
            if (container.contains(K - i)) {
                return true;
            }
            container.add(i);
        }
        return false;
    }

    @Test
    public void testTwoSum() {
        int[] A = {1, 2, 3, 4, 5};
        int a = 7;
        int b = 10;
        assertTrue(twoSum(A, a));
        assertFalse(twoSum(A, b));
    }
}
