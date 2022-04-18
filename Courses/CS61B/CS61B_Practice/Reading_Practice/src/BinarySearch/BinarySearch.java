package BinarySearch;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearch {

    public static int f1(int i, int[] numList) {
        for (int j = 0; j < numList.length; j++) {
            if (numList[j] == i) {
                return j;
            }
        }
        return -1;
    }

    public static int binarySearch(int i, int[] numList) {
        int lo = 0;
        int hi = numList.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (numList[mid] > i) {
                hi = mid - 1;
            } else if (numList[mid] < i) {
                lo = mid + 1;
            } else {
                return numList[mid];
            }
        }
        System.out.println("i is not found");
        return -1;
    }

    @Test
    public void testBinarySearch() {
        int[] numList1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] numList2 = new int[]{1, 2, 3, 4, 5, 6, 7};
        binarySearch(6, numList1);
        assertEquals(6, binarySearch(6, numList1));
        assertEquals(1, binarySearch(1, numList1));
        assertEquals(-1, binarySearch(8, numList1));
        assertEquals(7, binarySearch(7, numList2));
        assertEquals(1, binarySearch(1, numList2));
        assertEquals(-1, binarySearch(8, numList2));
    }
}
