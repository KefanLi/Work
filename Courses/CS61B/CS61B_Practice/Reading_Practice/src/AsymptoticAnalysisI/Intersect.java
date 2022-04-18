package AsymptoticAnalysisI;

import java.util.HashSet;

import org.junit.Test;

import static org.junit.Assert.*;

public class Intersect {
    public static int[] intersect(int[] A, int[] B) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a);
        }

        int index = 0;
        int[] arrayIntersect = new int[B.length];
        for (int b : B) {
            if (set.add(b)) {
                continue;
            } else {
                arrayIntersect[index] = b;
                index += 1;
            }
        }
        int[] arrayReturned = new int[index];
        for (int i = 0; i < index; i++) {
            arrayReturned[i] = arrayIntersect[i];
        }

        return arrayReturned;
    }

    public static int[] intersectionOfficial(int[] A, int[] B) {
        HashSet<Integer> setOfA = new HashSet<Integer>();
        HashSet<Integer> intersectionSet = new HashSet<Integer>();
        for (int num : A) {
            setOfA.add(num);
        }
        for (int num : B) {
            if (setOfA.contains(num)) {
                intersectionSet.add(num);
            }
        }
        int[] intersectionArray = new int[intersectionSet.size()];
        int index = 0;
        for (int num : intersectionSet) {
            intersectionArray[index] = num;
            index += 1;
        }
        return intersectionArray;
    }

    @Test
    public void testIntersect() {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{2, 3, 4, 5, 6};
        int[] expected = new int[]{2, 3, 4};
        int[] actual = intersect(a, b);
        assertArrayEquals(expected, actual);
    }

}
