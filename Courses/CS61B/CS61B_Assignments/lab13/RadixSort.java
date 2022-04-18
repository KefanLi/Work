/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        // TODO: Implement LSD Sort
        int R = 256;
        int N = asciis.length;

        String[] arrange = new String[N];
        String[] sorted = new String[N];

        int length = findLongestLength(asciis);
        for (int i = 0; i < N; i++) {
            if (asciis[i].length() < length) {
                int j = asciis[i].length();
                while (j < length) {
                    asciis[i] += "0";
                    j += 1;
                }
            }
            arrange[i] = asciis[i];
        }


        for (int d = length - 1; d >= 0; d--) {
            int[] counts = new int[R + 1];

            for (int i = 0; i < N; i++) {
                counts[arrange[i].charAt(d) + 1] += 1;
            }

            for (int r = 0; r < R; r++) {
                counts[r + 1] += counts[r];
            }

            for (int i = 0; i < N; i++) {
                sorted[counts[arrange[i].charAt(d)]++] = arrange[i];
            }

            for (int i = 0; i < N; i++) {
                arrange[i] = sorted[i];
            }
        }

        for (int i = 0; i < arrange.length; i++) {
            int pos = 0;
            if (arrange[i].contains("0")) {
                for (int j = 0; j < arrange[i].length(); j++) {
                    if (arrange[i].charAt(j) == '0') {
                        pos = j;
                        break;
                    }
                }
                arrange[i] = arrange[i].substring(0, pos);
            }
        }
        return arrange;
    }

    private static int findLongestLength(String[] str) {
        int length = 0;
        for (String s : str) {
            if (s.length() > length) {
                length = s.length();
            }
        }
        return length;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     *
     * @param asciis Input array of Strings
     * @param index  The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        // Optional LSD helper method for required LSD radix sort
        return;
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start  int for where to start sorting in this method (includes String at start)
     * @param end    int for where to end sorting in this method (does not include String at end)
     * @param index  the index of the character the method is currently sorting on
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }
}
