public class ArraysTest {

    private static void insertTest() {

        int[] arr1 = new int[4];
        int valueInArray = 1;

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = valueInArray;
            valueInArray += 1;
        }

        Arrays.printArray(arr1);
        int[] array2 = Arrays.insert(arr1, 5, 10);
        System.out.println();
        Arrays.printArray(array2);
        System.out.println();
        Arrays.printArray(arr1);
    }

    private static void reverseTest() {
        int[] arr1 = new int[4];
        int valueInArray = 1;

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = valueInArray;
            valueInArray += 1;
        }

        Arrays.printArray(arr1);
        System.out.println();
        Arrays.reverse(arr1);
        Arrays.printArray(arr1);
    }

    private static void replicateTest() {
        int[] arr1 = new int[4];
        int valueInArray = 1;

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = valueInArray;
            valueInArray += 1;
        }

        Arrays.printArray(arr1);
        System.out.println();
        int[] arr2;
        arr2 = Arrays.replicate(arr1);
        Arrays.printArray(arr1);
        System.out.println();
        Arrays.printArray(arr2);
    }

    public static void main(String[] args) {
        //insertTest();
        //reverseTest();
        replicateTest();
    }

}
