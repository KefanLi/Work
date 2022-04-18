package CMUJavaQuestions;

public class PrintPrimes {

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        int threshold = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                threshold += 1;
            }
        }
        if (threshold == 2) {
            return true;
        } else {
            return false;
        }
    }

    public static void printFirstHundredPrimes() {
        int times = 0;
        int num = 2;
        while (times < 100) {
            if (isPrime(num)) {
                System.out.print(num + " ");
                times += 1;
            }
            num += 1;
        }
    }

    public static void main(String[] args) {
        printFirstHundredPrimes();
    }
}
