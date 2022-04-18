package HeapsAndPriorityQueue;

import java.util.NoSuchElementException;

/**
 * A Generic heap class. Unlike Java's priority queue, this heap doesn't just
 * store Comparable objects. Instead, it can store any type of object
 * (represented by type T), along with a priority value. Why do it this way? It
 * will be useful later on in the class...
 */
public class MinHeap<T> {
    private Node[] contents;
    private int size;

    public MinHeap() {
        contents = new MinHeap.Node[16];

        /* Add a dummy item at the front of the ArrayHeap so that the getLeft,
         * getRight, and parent methods are nicer. */
        contents[0] = null;

        /* Even though there is an empty spot at the front, we still consider
         * the size to be 0 since nothing has been inserted yet. */
        size = 0;
    }

    /**
     * Returns the index of the node to the left of the node at i.
     */
    private static int leftIndex(int i) {
        /* TODO: Your code here! */
        return 2 * i;
    }

    /**
     * Returns the index of the node to the right of the node at i.
     */
    private static int rightIndex(int i) {
        /* TODO: Your code here! */
        return 2 * i + 1;
    }

    /**
     * Returns the index of the node that is the parent of the node at i.
     */
    private static int parentIndex(int i) {
        /* TODO: Your code here! */
        return i / 2;
    }

    /**
     * Gets the node at the ith index, or returns null if the index is out of
     * bounds.
     */
    private Node getNode(int index) {
        if (!inBounds(index)) {
            return null;
        }
        return contents[index];
    }

    /**
     * Returns true if the index corresponds to a valid item. For example, if
     * we have 5 items, then the valid indices are 1, 2, 3, 4, 5. Index 0 is
     * invalid because we leave the 0th entry blank.
     */
    private boolean inBounds(int index) {
        if ((index > size) || (index < 1)) {
            return false;
        }
        return true;
    }

    /**
     * Swap the nodes at the two indices.
     */
    private void swap(int index1, int index2) {
        Node node1 = getNode(index1);
        Node node2 = getNode(index2);
        contents[index1] = node2;
        contents[index2] = node1;
    }


    /**
     * Returns the index of the node with smaller priority. Precondition: not
     * both nodes are null.
     */
    private int min(int index1, int index2) {
        Node node1 = getNode(index1);
        Node node2 = getNode(index2);
        if (node1 == null) {
            return index2;
        } else if (node2 == null) {
            return index1;
        } else if (node1.myPriority < node2.myPriority) {
            return index1;
        } else {
            return index2;
        }
    }

    /**
     * Bubbles up the node currently at the given index.
     */
    private void swim(int index) {
        // Throws an exception if index is invalid. DON'T CHANGE THIS LINE.
        validateSinkSwimArg(index);
        while (index > 1 && min(index, parentIndex(index)) == index) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
        return;
    }

    /**
     * Bubbles down the node currently at the given index.
     */
    private void sink(int index) {
        // Throws an exception if index is invalid. DON'T CHANGE THIS LINE.
        validateSinkSwimArg(index);
        while (2 * index <= size) {
            int j = 2 * index;
            if (j < size && min(j, j + 1) == j + 1) {
                j += 1;
            }
            if (min(index, j) == index) {
                break;
            }
            swap(index, j);
            index = j;
        }
        return;
    }

    /**
     * Inserts an item with the given priority value. This is enqueue, or offer.
     * To implement this method, add it to the end of the ArrayList, then swim it.
     */
    public void insert(T item, double priority) {
        /* If the array is totally full, resize. */
        if (size + 1 == contents.length) {
            resize(contents.length * 2);
        }
        Node nodeToInsert = new Node(item, priority);
        size += 1;
        contents[size] = nodeToInsert;
        validateSinkSwimArg(size);
        swim(size);
    }

    /**
     * Returns the Node with the smallest priority value, but does not remove it
     * from the heap. To implement this, return the item in the 1st position of the ArrayList.
     */
    public T peek() {
        if (contents[1] == null) {
            return null;
        } else {
            return contents[1].item();
        }
    }

    /**
     * Returns the Node with the smallest priority value, and removes it from
     * the heap. This is dequeue, or poll. To implement this, swap the last
     * item from the heap into the root position, then sink the root. This is
     * equivalent to firing the president of the company, taking the last
     * person on the list on payroll, making them president, and then demoting
     * them repeatedly. Make sure to avoid loitering by nulling out the dead
     * item.
     */
    public T removeMin() {
        if (size() == 0) {
            throw new NoSuchElementException("Priority queue under flow");
        }
        if (contents[1] == null) {
            return null;
        }
        T min = contents[1].item();
        validateSinkSwimArg(size);
        validateSinkSwimArg(1);
        swap(1, size);
        size -= 1;
        sink(1);
        contents[size + 1] = null;

        /*
        if ((size > 0) && (size == (contents.length) / 4)) {
            resize(contents.length / 2);
        } */
        return min;
    }

    /**
     * Returns the number of items in the PQ. This is one less than the size
     * of the backing ArrayList because we leave the 0th element empty. This
     * method has been implemented for you.
     */
    public int size() {
        return size;
    }

    /**
     * Change the node in this heap with the given item to have the given
     * priority. You can assume the heap will not have two nodes with the same
     * item. Check item equality with .equals(), not ==. This is a challenging
     * bonus problem, but shouldn't be too hard if you really understand heaps
     * and think about the algorithm before you start to code.
     */
    public void changePriority(T item, double priority) {
        int index = 0;
        for (int i = 1; i <= size; i++) {
            if (contents[i].item() == item) {
                contents[i].myPriority = priority;
                index = i;
                break;
            }
        }
        if (index == 0) {
            return;
        }
        int leftIndex = leftIndex(index);
        int rightIndex = rightIndex(index);
        int parent = parentIndex(index);
        if (min(index, leftIndex) == leftIndex ||
                min(index, rightIndex) == rightIndex) {
            sink(index);
        }
        if (min(index, parent) == index) {
            swim(index);
        }
    }

    /**
     * Returns whether MinHeap is empty
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Find whether the MinHeap contains a specific item
     * @param item
     * @return
     */
    public boolean contains(T item) {
        for (int i = 0; i < size; i++) {
            if (contents[i].myItem.equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prints out the heap sideways. Provided for you.
     */
    @Override
    public String toString() {
        return toStringHelper(1, "");
    }

    /* Recursive helper method for toString. */
    private String toStringHelper(int index, String soFar) {
        if (getNode(index) == null) {
            return "";
        } else {
            String toReturn = "";
            int rightChild = rightIndex(index);
            toReturn += toStringHelper(rightChild, "        " + soFar);
            if (getNode(rightChild) != null) {
                toReturn += soFar + "    /";
            }
            toReturn += "\n" + soFar + getNode(index) + "\n";
            int leftChild = leftIndex(index);
            if (getNode(leftChild) != null) {
                toReturn += soFar + "    \\";
            }
            toReturn += toStringHelper(leftChild, "        " + soFar);
            return toReturn;
        }
    }


    /**
     * Throws an exception if the index is invalid for sinking or swimming.
     */
    private void validateSinkSwimArg(int index) {
        if (index < 1) {
            throw new IllegalArgumentException("Cannot sink or swim nodes with index 0 or less");
        }
        if (index > size) {
            throw new IllegalArgumentException("Cannot sink or swim nodes with index greater than current size.");
        }
        if (contents[index] == null) {
            throw new IllegalArgumentException("Cannot sink or swim a null node.");
        }
    }

    private class Node {
        private T myItem;
        private double myPriority;

        private Node(T item, double priority) {
            myItem = item;
            myPriority = priority;
        }

        public T item() {
            return myItem;
        }

        public double priority() {
            return myPriority;
        }

        @Override
        public String toString() {
            return myItem.toString() + ", " + myPriority;
        }
    }


    /**
     * Helper function to resize the backing array when necessary.
     */
    private void resize(int capacity) {
        Node[] temp = new MinHeap.Node[capacity];
        for (int i = 1; i < this.contents.length; i++) {
            temp[i] = this.contents[i];
        }
        this.contents = temp;
    }
}

