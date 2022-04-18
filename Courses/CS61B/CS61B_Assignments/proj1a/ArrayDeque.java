public class ArrayDeque<T> {
    /**
     * if we want to insert at the first of the array,
     * the item which we insert should be at this position
     */
    private int nextFirst;

    /**
     * if we want to insert at the last of the array,
     * the item which we insert should be at this position
     */
    private int nextLast;

    /**
     * the size of this array
     */
    private int size;

    /**
     * items is the pointer of this array
     */
    private T[] items;

    /**
     * the constructor of ArrayDeque
     */
    public ArrayDeque() {
        nextFirst = 0;
        nextLast = 1;
        size = 0;
        items = (T[]) new Object[8];
    }

    /**
     * helper method to get an array which
     * contains the items in real order
     *
     * @param num
     * @return
     */
    private T[] itemsInRealOrder(int num) {
        T[] a = (T[]) new Object[num];

        int indexIna = 0;
        int iterateNumber = 0;
        int indexInItems = nextFirst + 1;

        while (iterateNumber < size) {
            indexInItems = indexInItems % items.length;
            a[indexIna] = items[indexInItems];
            indexInItems += 1;
            indexIna += 1;
            iterateNumber += 1;
        }

        return a;
    }

    /**
     * helper method for addFirst or addLast function
     */
    private void sizeIncrease() {
        int refactor = 2;
        T[] a = itemsInRealOrder(refactor * items.length);
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    /**
     * adds an item of type T to the front of deque
     *
     * @param item
     */
    public void addFirst(T item) {
        if (items.length - size == 2) {
            sizeIncrease();
        }
        items[nextFirst] = item;

        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }

        size = size + 1;
    }

    /**
     * adds an item of type T to the back of deque
     *
     * @param item
     */
    public void addLast(T item) {
        if (items.length - size == 2) {
            sizeIncrease();
        }
        items[nextLast] = item;

        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }

        size += 1;
    }

    /**
     * helper method to keep the usage ration
     */
    private void sizeDecrease() {
        int refactor = 2;
        T[] a = itemsInRealOrder(items.length / refactor);
        items = a;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    /**
     * remove the first item in the deque
     *
     * @return
     */
    public T removeFirst() {

        if (isEmpty()) {
            return null;
        }

        if (nextFirst == items.length - 1) {
            nextFirst = 0;
        } else {
            nextFirst = nextFirst + 1;
        }

        T returnItem = items[nextFirst];
        items[nextFirst] = null;
        size = size - 1;
        if (size == 0) {
            nextLast = 1;
            nextFirst = 0;
        }

        int lengthofArray = items.length;
        if (items.length >= 16 && size < lengthofArray * 0.25) {
            sizeDecrease();
        }
        return returnItem;
    }

    /**
     * remove the last item in the deque
     *
     * @return
     */
    public T removeLast() {

        if (isEmpty()) {
            return null;
        }

        if (nextLast == 0) {
            nextLast = items.length - 1;
        } else {
            nextLast = nextLast - 1;
        }

        T returnItem = items[nextLast];
        items[nextLast] = null;
        size = size - 1;
        if (size == 0) {
            nextLast = 1;
            nextFirst = 0;
        }

        int lengthofArray = items.length;
        if (items.length >= 16 && size < lengthofArray * 0.25) {
            sizeDecrease();
        }
        return returnItem;
    }

    /**
     * returns the number of items in the deque
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * return true if the deque is empty
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * print the deque from first to last
     */
    public void printDeque() {
        T[] a = itemsInRealOrder(size);

        for (int i = 0; i < size; i++) {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * get the item at given index
     *
     * @param index
     * @return
     */
    public T get(int index) {
        T[] a = itemsInRealOrder(size);
        return a[index];
    }
}
