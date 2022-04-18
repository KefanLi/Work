import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestArrayDequeGold {
    /* Markdown it for a moment
    public String getStringFromArray(String[] A) {
        String S = "";
        for (Integer i = 0; i < A.length; i++) {
            S = S + A[i];
            if (A[i + 1] == null) {
                break;
            }
        }
        S.replaceAll("null\n", "");
        return S;
    }
     */

    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution();
        // String[] messages = new String[100];
        String message = "";


        for (Integer i = 0; i < 100; i++) {
            Integer randomNumber = StdRandom.uniform(4);

            if (randomNumber == 0) {
                Integer temp = StdRandom.uniform(100);
                stu.addFirst(temp);
                ads.addFirst(temp);
                message += "addFirst(" + temp + ")\n";
            }
            if (randomNumber == 1) {
                Integer temp = StdRandom.uniform(100);
                stu.addLast(temp);
                ads.addLast(temp);
                message += "addLast(" + temp + ")\n";
            }
            if (randomNumber == 2) {
                Integer temp = StdRandom.uniform(100);
                if (stu.size() == 0) {
                    continue;
                } else {
                    message += "removeFirst()\n";
                    assertEquals(message, ads.removeFirst(), stu.removeFirst());
                }
            }
            if (randomNumber == 3) {
                Integer temp = StdRandom.uniform(100);
                if (stu.size() == 0) {
                    continue;
                } else {
                    message += "removeLast()\n";
                    assertEquals(message, ads.removeLast(), stu.removeLast());
                }
            }
        }
    }
}
