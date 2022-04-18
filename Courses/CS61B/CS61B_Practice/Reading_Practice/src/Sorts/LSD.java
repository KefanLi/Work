package Sorts;

public class LSD {

    /**
     * Sort a[] on leading W characters.
     *
     * @param a
     * @param w
     */
    public static void sort(String[] a, int w) {
        int N = a.length;
        int R = 256;

        String[] aux = new String[N];
        // Sort by key-indexed counting on dth char.
        for (int d = w -1; d >= 0; d--) {
            // Compute frequency counts.
            int[] count = new int[R+1];
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }
            // Transform counts to indices.
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }
            // Distribute.
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            // Copy back
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }
}
