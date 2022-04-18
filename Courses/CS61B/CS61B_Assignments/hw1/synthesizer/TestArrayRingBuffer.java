package synthesizer;
import org.junit.Test;

import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void testEnqueueDequeue() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(8);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.enqueue(5);
        arb.enqueue(6);
        arb.enqueue(7);
        arb.enqueue(8);
        arb.dequeue();
        arb.dequeue();
        arb.enqueue(9);
        arb.enqueue(10);
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        arb.dequeue();
        int expected = 7;
        int actual = arb.peek();
        assertEquals(expected, actual);
        arb.dequeue();
        arb.dequeue();
        int expected1 = 9;
        int actual1 = arb.peek();
        assertEquals(expected1, actual1);
    }

    @Test
    public void testIterations() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer(8);
        arb.enqueue(1);
        arb.enqueue(2);
        arb.enqueue(3);
        arb.enqueue(4);
        arb.enqueue(5);
        arb.enqueue(6);
        arb.enqueue(7);
        arb.enqueue(8);
        for (int i : arb) {
            System.out.println(i);
        }
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
