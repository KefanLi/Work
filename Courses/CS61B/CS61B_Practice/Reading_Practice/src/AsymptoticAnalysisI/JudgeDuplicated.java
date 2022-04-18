package AsymptoticAnalysisI;

import java.util.HashMap;

import org.junit.Test;

import static org.junit.Assert.*;

public class JudgeDuplicated {
    /**
     * find whether every item in the array
     * has a duplicated value
     *
     * @param array
     * @return
     */
    public static boolean judgeDuplicated(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (map.containsKey(i)) {
                int iterationTimes = map.get(i);
                map.put(i, iterationTimes + 1);
            } else {
                map.put(i, 1);
            }
        }

        if (map.containsValue(1)) {
            return false;
        }
        return true;
    }

    @Test
    public void testJudgeDuplicated(){
        int[] testArray1 = new int[] {1, 2, 3, 4};
        assertFalse(judgeDuplicated(testArray1));
        int[] testArray2 = new int[] {1, 2, 1, 2};
        assertTrue(judgeDuplicated(testArray2));
    }
}
