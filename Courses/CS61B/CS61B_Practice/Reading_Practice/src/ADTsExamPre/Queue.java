package ADTsExamPre;

import java.util.Stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class Queue<E> {
    private Stack<E> items;

    public Queue() {
        items = new Stack<E>();
    }

    public void push(E element) {
        items.push(element);
    }

    public E poll() {
        Stack<E> container = new Stack<>();
        while (!items.isEmpty()) {
            container.push(items.pop());
        }
        E top = container.pop();
        while (!container.isEmpty()) {
            items.push(container.pop());
        }
        return top;
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
