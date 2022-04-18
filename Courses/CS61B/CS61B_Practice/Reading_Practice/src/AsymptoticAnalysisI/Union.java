package AsymptoticAnalysisI;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashSet;

public class Union {
    public static int[] union1(int[] A, int[] B) {
        int[] unionArray = new int[A.length + B.length];
        int a = 0;
        int b = 0;
        int u = 0;
        while (a < A.length || b < B.length) {
            if (a < A.length && b < B.length) {
                if (A[a] < B[b]) {
                    unionArray[u] = A[a];
                    a += 1;
                    u += 1;
                } else if (A[a] > B[b]) {
                    unionArray[u] = B[b];
                    b += 1;
                    u += 1;
                } else {
                    unionArray[u] = A[a];
                    a += 1;
                    b += 1;
                    u += 1;
                }
            } else {
                if (a >= A.length) {
                    unionArray[u] = B[b];
                    u += 1;
                    b += 1;
                } else {
                    unionArray[u] = A[a];
                    u += 1;
                    a += 1;
                }
            }
        }
        int[] returnArray = new int[u];
        for (int i = 0; i < u; i++) {
            returnArray[i] = unionArray[i];
        }
        return returnArray;
    }

    public static int[] union2(int[] A, int[] B) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a);
        }

        for (int b : B) {
            set.add(b);
        }

        int[] unionArray = new int[set.size()];
        int index = 0;
        for (int item : set) {
            unionArray[index] = item;
            index += 1;
        }
        return unionArray;
    }

    @Test
    public void testUnion1() {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{2, 3, 4, 5, 6};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6};
        int[] actual = union1(a, b);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testUnion2() {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{3, 4, 5, 6};
        int[] expected = new int[]{1, 2, 3, 4, 5, 6};
        int[] actual = union2(a, b);
        assertArrayEquals(expected, actual);
    }

}
