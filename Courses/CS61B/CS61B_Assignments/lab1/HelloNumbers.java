public class HelloNumbers {
    public static void main(String[] args) {
        int x = 0;
	int z = 0;
        while (x < 10) {
	    z = z + x;
	    System.out.print(z + " ");
            x = x + 1;
        }
    }
}
