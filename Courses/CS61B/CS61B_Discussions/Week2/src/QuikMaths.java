public class QuikMaths {
    public static void multiplyBy3(int[] A) {
        for (int x : A) {
            x = x * 3; // Here x is pass by value, so this statement cannot change the values in A
        }
    }

    public static void multiplyBy2(int[] A) {
        int[] B = A;
        for (int i = 0; i < B.length; i += 1) {
            B[i] *= 2;
        }
    }

    public static void swap(int A, int B) {
        int temp = B;
        B = A;
        A = temp;
    }

    static void swapValuesUsingThirdVariable(int m, int n)
    {
        // Swapping the values
        int temp = m;
        m = n;
        n = temp;
        System.out.println("Value of m is " + m
                + " and Value of n is " + n);
    }

    public static void main(String[] args) {
        int[] arr;
        arr = new int[]{2, 3, 3, 4};
        multiplyBy3(arr); // This function is void.

        /*Valueofarr:{2,3,3,4}*/

        arr = new int[]{2, 3, 3, 4};
        multiplyBy2(arr); // arr -> {4, 6, 6, 8}

        /*Valueofarr:{4,6,6,8}*/

        int a = 6;
        int b = 7;
        swap(a, b); // a & b is pass by value, it cannot be changed.
        swapValuesUsingThirdVariable(a, b);
        System.out.println(a);
        System.out.println(b);

        /*Valueofa:6 Valueofb:7*/
    }
}

