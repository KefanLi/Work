public class SLList {

    private class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    /**
     * print the SLList from the beginning of SLList
     * to the end of the SLList
     */
    public void print() {
        IntNode p = first;
        while (p != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
    }

    /**
     * helper method to get an IntNode by given index
     *
     * @param index
     * @return
     */
    private IntNode getNode(int index) {
        IntNode p = first;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }

        return p;

    }

    /**
     * Implement SLList.insert which takes in an integer x and inserts it at the given
     * position. If the position is after the end of the list, insert the new node at the end.
     * For example, if the SLList is 5 → 6 → 2, insert(10, 1) results in 5 → 10 → 6 → 2.
     */
    public void insert(int item, int position) {
        IntNode p = first;
        IntNode q = first;
        IntNode createdNode;
        int i = 0;

        if (position == 0) {
            createdNode = new IntNode(item, first);
            first = createdNode;
        } else {
            while (i < position) {
                q = p;
                p = p.next;
                i += 1;
            }
            createdNode = new IntNode(item, p);
            q.next = createdNode;
        }
    }

    /**
     * Add another method to the SLList class that reverses the elements. Do this using
     * the existing IntNodes (you should not use new).
     */
    public void reverse() {
        int size = 0;
        IntNode p = first;

        if (first == null) {
            size = 0;
            return;
        } else {
            size += 1;
            p = p.next;
            while (p != null) {
                size += 1;
                p = p.next;
            }
            p = first;
        }

        int[] originArray = new int[size];
        int[] reverseArray = new int[size];

        for (int i = 0; i < size; i++) {
            originArray[i] = p.item;
            p = p.next;
        }

        int end = size - 1;
        int begin = 0;
        while (begin < size) {
            reverseArray[begin] = originArray[end];
            begin += 1;
            end -= 1;
        }

        p = first;
        int numInReverseArray = 0;
        while (numInReverseArray < size) {
            p.item = reverseArray[numInReverseArray];
            p = p.next;
            numInReverseArray += 1;
        }
    }

    /**
     * The standard method to reverse the SLList
     * the author of this method is Hug
     */
    public void reverseSolution() {
        IntNode rBack = null;
        IntNode rFront = first;
        while (rFront != null) {
            IntNode nextrFront = rFront.next;
            rFront.next = rBack;
            rBack = rFront;
            rFront = nextrFront;
        }
        first = rBack;
    }

    public void reverseRecursive() {
        first = reverseRecursiveHelper(first);
    }

    private IntNode reverseRecursiveHelper(IntNode front) {
        if (front == null || front.next == null) {
            return front;
        } else {
            IntNode reversed = reverseRecursiveHelper(front.next);
            front.next.next = front;
            front.next = null;
            return reversed;
        }
    }
}
