package ADTs;

import java.util.Stack;

public class Queue<E> {
    private Stack<E> stack = new Stack<E>();

    public void push(E element) {
        stack.push(element);
    }

    /* Kefan's solution for poll()
    public E poll() {
        E[] containerArray = (E[]) new Object[stack.size()];
        for (int i = 0; stack.pop() != null; i++) {
            containerArray[i] = stack.pop();
        }
        Stack<E> stack2 = new Stack<E>();
        for (int i = containerArray.length - 2; i > -1; i--) {
            stack2.push(containerArray[i]);
        }
        stack = stack2;
        return containerArray[containerArray.length - 1];
    }

     */

    /**
     * the official solution which uses two stacks
     *
     * @return
     */
    public E poll() {
        Stack<E> temp = new Stack<>();
        while (!stack.isEmpty()) {
            temp.push(stack.pop());
        }
        E returnValue = temp.pop();
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        stack = temp;
        return returnValue;
    }
}
