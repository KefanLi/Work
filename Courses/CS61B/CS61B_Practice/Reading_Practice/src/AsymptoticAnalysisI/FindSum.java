package AsymptoticAnalysisI;

public class FindSum {
    public static boolean findSumNaive(int[] A, int x) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (A[i] + A[j] == x) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean findSum(int[] A, int x) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            if (A[left] + A[right] == x) {
                return true;
            } else if (A[left] + A[right] < x) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
