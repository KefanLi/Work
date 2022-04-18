package synthesizer;


import java.util.Iterator;

public interface BoundedQueue<T> extends Iterable<T> {
    /**
     * return size of the buffer
     *
     * @return
     */
    int capacity();

    /**
     * return number of items currently in the buffer
     *
     * @return
     */
    int fillCount();

    /**
     * add item x to the end
     *
     * @param x
     */
    void enqueue(T x);

    /**
     * delete and return item from the front
     *
     * @return
     */
    T dequeue();

    /**
     * return (but do not delete) item from the front
     *
     * @return
     */
    T peek();

    /**
     * is the buffer empty (fillCount equals zero)?
     *
     * @return
     */
    default boolean isEmpty() {
        return this.fillCount() == 0;
    }

    /**
     * is the buffer full (fillCount is same as capacity)?
     *
     * @return
     */
    default boolean isFull() {
        return this.capacity() == this.fillCount();
    }

    Iterator<T> iterator();
}
