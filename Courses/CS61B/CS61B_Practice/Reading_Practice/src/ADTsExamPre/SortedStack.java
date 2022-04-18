package ADTsExamPre;

import java.util.Stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortedStack<Item extends Comparable<Item>> {
    private  Stack<Item> a;
    private  Stack<Item> b;

    public SortedStack() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(Item t) {
        while (!a.empty() && a.peek().compareTo(t) < 0) {
            b.push(a.pop());
        }
        a.push(t);
        while (!b.empty()) {
            a.push(b.pop());
        }
    }

    public Item poll() {
        return a.pop();
    }

    @Test
    public void testSortedStack() {
        SortedStack<Integer> test = new SortedStack<>();
        test.push(1);
        test.push(3);
        test.push(2);
        int[] actual = new int[3];
        for (int i = 0; i < 3; i++) {
            actual[i] = test.poll();
        }
        int[] expected = {1, 2, 3};
        for (int i = 0; i < 3; i++) {
            assertEquals(expected[i], actual[i]);
        }
    }

}
