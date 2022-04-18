package Exceptions;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class KthIntList implements Iterator<Integer> {

    private static class IntList {
        public Integer first;
        public IntList next;

        public IntList(Integer first, IntList next) {
            this.first = first;
            this.next = next;
        }
    }

    public int k;
    private IntList curList;
    private boolean hasNext;
    private IntList head;

    public KthIntList(IntList I, int k) {
        this.k = k;
        this.curList = I;
        this.hasNext = true;
        this.head = curList;
    }

    /**
     * Returns true if there is a next Kth element. Do not modify.
     */
    @Override
    public boolean hasNext() {
        return this.hasNext;
    }

    /**
     * Returns the next Kth element of the IntList given in the constructor.
     * Returns the 0th element first. Throws a NoSuchElementException if
     * there are no Integers available to return.
     */
    @Override
    public Integer next() {
        if (curList == null) {
            throw new NoSuchElementException();
        }
        Integer returnItem = head.first;
        for (int i = 0; i < k; i++) {
            head = head.next;
            if (head == null) {
                this.hasNext = false;
                break;
            }
        }
        return returnItem;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L = new IntList(4, L);
        L = new IntList(3, L);
        L = new IntList(2, L);
        L = new IntList(1, L);
        L = new IntList(0, L);
        for (Iterator<Integer> p = new KthIntList(L, 3); p.hasNext(); ) {
            System.out.println(p.next());
        }
    }
}
