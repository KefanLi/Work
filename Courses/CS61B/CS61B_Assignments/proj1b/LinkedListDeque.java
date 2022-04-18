/**
 * The data structure of LinkedListDeque containing any primitive data type.
 */
public class LinkedListDeque<T> implements Deque<T> {
    /**
     * the front node of the deque
     */
    private IntNode senFront;
    /**
     * the end node of the deque
     */
    private IntNode senBack;
    /**
     * the size of LinkListDeque
     */
    private int size;

    private class IntNode {
        private IntNode prev;
        private T item;
        private IntNode next;

        /**
         * the general constructor
         *
         * @param p
         * @param i
         * @param n
         */
        public IntNode(IntNode p, T i, IntNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /**
     * The constructor of LinkedListDeque
     */
    public LinkedListDeque() {
        size = 0;
        senFront = new IntNode(null, null, null);
        senBack = new IntNode(null, null, null);
        senFront.next = senBack;
        senBack.prev = senFront;
    }

    /**
     * add the item in front of the deque
     *
     * @param item
     */
    @Override
    public void addFirst(T item) {
        IntNode p;
        p = senFront.next;
        senFront.next = new IntNode(senFront, item, p);
        p.prev = senFront.next;
        size += 1;
    }

    /**
     * add the item at the last of the deque
     *
     * @param item
     */
    @Override
    public void addLast(T item) {
        IntNode p;
        p = senBack.prev;
        senBack.prev = new IntNode(p, item, senBack);
        p.next = senBack.prev;
        size += 1;
    }

    /**
     * find whether a deque is empty
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * get the size of the deque
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * prints the items in the deque from first to last, separated by a space
     */
    @Override
    public void printDeque() {
        IntNode p = senFront.next;
        if (p == senBack) {
            System.out.print("null");
        }
        while (p != senBack) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    /**
     * remove the first item in the deque
     * return the value of first item
     *
     * @return
     */
    @Override
    public T removeFirst() {
        if (senFront.next == senBack) {
            return null;
        }

        IntNode p = senFront.next;
        senFront.next = p.next;
        p.next.prev = senFront;
        size = size - 1;
        return p.item;
    }

    /**
     * remove and return last item in the deque
     *
     * @return
     */
    @Override
    public T removeLast() {
        if (senFront.next == senBack) {
            return null;
        }

        IntNode p = senBack.prev;
        senBack.prev = p.prev;
        p.prev.next = senBack;
        size = size - 1;
        return p.item;
    }

    /**
     * get the item at the given index
     *
     * @param index
     * @return
     */
    @Override
    public T get(int index) {
        if (senFront.next == senBack) {
            return null;
        }

        int i = 0;
        IntNode p = senFront.next;
        while (i != index) {
            p = p.next;
            i += 1;
        }
        return p.item;
    }

    private IntNode getHelper(IntNode p, int index) {
        if (index == 0) {
            return p;
        }
        return getHelper(p.next, index - 1);
    }

    public T getRecursive(int index) {
        IntNode p = getHelper(senFront.next, index);
        return p.item;
    }
}
