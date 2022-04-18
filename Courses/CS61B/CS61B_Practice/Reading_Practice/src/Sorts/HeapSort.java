package Sorts;

public class HeapSort {

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(a[j], a[j + 1])) {
                j += 1;
            }
            if (!less(a[k], a[j])) {
                break;
            }
            exch(a, k, j);
            k = j;
        }
    }

    private static void printArray(Comparable[] a) {
        for (Comparable e : a) {
            System.out.print(e);
        }
        System.out.println();
    }

    public static void sort(Comparable[] a) {
        int N = a.length - 1;
        for (int k = N / 2 - 1; k >= 0; k--) {
            sink(a, k, N);
        }
        while (N >= 0) {
            exch(a, 0, N--);
            sink(a, 0, N);
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[5];
        a[0] = 0;
        a[1] = 6;
        a[2] = 2;
        a[3] = 7;
        a[4] = 4;
        printArray(a);
        HeapSort.sort(a);
        printArray(a);
    }
}
