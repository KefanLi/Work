public class Arrays {

    public static void printArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * Consider a method that inserts item into array arr at the given position. The
     * method should return the resulting array. For example, if x = [5, 9, 14, 15],
     * item = 6, and position = 2, then the method should return [5, 9, 6, 14, 15].
     * If position is past the end of the array, insert item at the end of the array.
     * Is it possible to write a version of this method that returns void and changes arr
     * in place (i.e., destructively)?
     *
     * @param arr
     * @param item
     * @param position
     * @return
     */
    public static int[] insert(int[] arr, int item, int position) {

        int[] result = new int[arr.length + 1];
        position = Math.min(arr.length, position);
        result[position] = item;

        for (int i = 0; i < arr.length; i++) {
            if (i == position) {
                result[i + 1] = arr[i];
            }

            if (i < position) {
                result[i] = arr[i];
            }

            if (i > position) {
                result[i + 1] = arr[i];
            }
        }
        return result;
    }

    /**
     * Consider a method that destructively reverses the items in arr. For example calling
     * reverse on an array [1, 2, 3] should change the array to be [3, 2, 1].
     *
     * @param arr
     */
    public static void reverse(int[] arr) {

        for (int i = 0; i < arr.length / 2; i++) {
            int back = arr.length - 1 - i;
            int temp = arr[i];
            arr[i] = arr[back];
            arr[back] = temp;
        }
    }

    /**
     * Write a non-destructive method replicate(int[] arr) that replaces the
     * number at index i with arr[i] copies of itself. For example, replicate([3, 2,
     * 1]) would return [3, 3, 3, 2, 2, 1].
     *
     * @param arr
     * @return
     */
    public static int[] replicate(int[] arr) {
        int size = 0;

        for (int i = 0; i < arr.length; i++) {
            size += arr[i];
        }

        int[] result = new int[size];

        /*
        int indexInResult = 0;
        int iterateNumber = 0;

        for (int i = 0; i < arr.length; i++) {
            while (iterateNumber < arr[i]) {
                result[indexInResult] = arr[i];
                iterateNumber += 1;
                indexInResult += 1;
            }
            iterateNumber = 0;
        }
        return result;

         */

        int position = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                result[position] = arr[i];
                position += 1;
            }
        }

        return result;
    }

    /**
     * that takes in a 2-D array x and returns a 1-D array
     * that contains all of the arrays in x concatenated together.
     * @param x
     * @return
     */
    public static int[] flatten(int[][] x) {
        int totalLength = 0;

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                totalLength += 1;
            }
        }

        int[] a = new int[totalLength];
        int aIndex = 0;

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                a[aIndex] = x[i][j];
                aIndex += 1;
            }
        }

        return a;
    }
}
