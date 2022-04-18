package Demo;

/**
 * From that class of demo, we could know Java treats
 * the char as it's ASCII code.
 * a's ASCII code is 97, not 1.
 */
public class ASCIIDemo {
    public static void intCharDemo() {
        char a = 'a';
        char b = 'b';
        int[] arr = new int[26];
        arr[a] = 1;
        arr[b] = 2;
        char c = ' ';
        arr[c] = 1;
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        intCharDemo();
    }
}
