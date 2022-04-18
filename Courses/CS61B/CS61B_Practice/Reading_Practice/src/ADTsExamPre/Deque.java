package ADTsExamPre;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class Deque<Item> {
    private Stack<Item> a;
    private Stack<Item> b;

    public Deque() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(Item t) {
        while (!a.empty()) {
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
    public void testQueue() {
        Queue<Integer> test = new Queue<>();
        test.push(1);
        test.push(2);
        test.push(3);
        int actual = test.poll();
        int expected = 1;
        assertEquals(expected, actual);
    }
}