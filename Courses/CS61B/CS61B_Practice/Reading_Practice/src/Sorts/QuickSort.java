package Sorts;

import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);          // Eliminate dependence on input.
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);  // Partition.
        sort(a, lo, j - 1);              // Sort left part a[lo .. j-1].
        sort(a, j + 1, hi);              // Sort right part a[j+1 .. hi].
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo; // left and right scan indices
        int j = hi + 1; // left and right scan indices
        Comparable v = a[lo]; // partitioning item
        while (true) {
            // Scan right, scan left, check for scan complete, and exchange.
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j); // Put v = a[j] into position
        return j; // with a[lo..j-1] <= a[j] <= a[j+1..hi].
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[8];
        for (int i = 0; i < 8; i++) {
            a[i] = 8 - i;
            System.out.print(a[i]);
        }
        QuickSort.sort(a);
        System.out.println();
        for (int i = 0; i < 8; i++) {
            System.out.print(a[i]);
        }
    }
}
