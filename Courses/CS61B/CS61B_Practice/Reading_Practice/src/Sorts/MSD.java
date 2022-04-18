package Sorts;

public class MSD {
    // radix
    /* Alphabet.LOWERCASE's R = 26, Alphabet.EXTENDED.ASCII's R = 256, and
       Alphabet.UNICODE, with R = 65536 */

    private static final int R = 256;

    // auxiliary array for distribution
    private static String[] aux;

    private static int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        } else {
            return -1;
        }
    }

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        sort(a, 0, N - 1, 0);
    }

    // Sort from a[lo] to a[hi], starting at the dth character.
    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo) {
            return;
        }
        // Compute frequency counts.
        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++) {
            count[charAt(a[i], d) + 2]++;
        }

        // Transform counts to indices.
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }

        // Distribute.
        for (int i = lo; i <= hi; i++) {
            aux[count[charAt(a[i], d) + 1]++] = a[i];
        }

        // Copy back.
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }

        // Recursively sort for each character value.
        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }
    }

    public static void main(String[] args) {
        String[] a = new String[]{"she", "sells", "seashells", "by", "the", "sea", "shore",
                "the", "shells", "she", "sells", "are", "surely", "seashells"};
        for (String s : a) {
            System.out.print(s + " ");
        }
        sort(a);
        System.out.println();
        for (String s : a) {
            System.out.print(s + " ");
        }
    }
}
