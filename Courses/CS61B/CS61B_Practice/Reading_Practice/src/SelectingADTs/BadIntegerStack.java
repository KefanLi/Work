package SelectingADTs;

public class BadIntegerStack {

    private class Node {
        private Integer value;
        private Node prev;

        public Node(Integer v, Node p) {
            value = v;
            prev = p;
        }
    }

    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Integer num) {
        top = new Node(num, top);
    }

    public Integer pop() {
        if (isEmpty()) {
            return null;
        } else {
            Integer ans = top.value;
            top = top.prev;
            return ans;
        }
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        } else {
            return top.value;
        }
    }

    public static void main(String[] args) {
        /* Exploit the flaw by filling in the main method below so that it prints “Success”
           by causing BadIntegerStack to produce a NullPointerException.
         */
        try {
            BadIntegerStack bis = new BadIntegerStack();
            bis.peek();
        } catch (NullPointerException e) {
            System.out.println("Success");
        }

        /* Cause infinite loop
         */
        BadIntegerStack stack = new BadIntegerStack();
        stack.push(1);
        stack.top.prev = stack.top;
        while (!stack.isEmpty()) {
            stack.pop();
        }
        System.out.println("This print statement is unreachable");
    }
}


