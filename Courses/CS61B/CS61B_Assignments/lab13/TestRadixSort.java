import org.junit.Test;

public class TestRadixSort {

    @Test
    public void testFindLongestLength() {
        String[] arr1 = new String[] {"ab", "cd", "acb", "cde"};
        String[] arr2 = RadixSort.sort(arr1);
        for (String s : arr2) {
            System.out.print(s + " ");
        }
    }

    @Test
    public void testRadixSort() {
        String[] arr1 = new String[] {"ab", "cd", "acb", "cde"};
        String[] arr2 = RadixSort.sort(arr1);
        for (String s : arr2) {
            System.out.print(s + " ");
        }
    }

}
