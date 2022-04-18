public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        this.first = f;
        this.rest = r;
    }

    /**
     * Given a sorted linked list of items - remove duplicates. * For example given 1 -> 2 -> 2 -> 2 -> 3,
     * Mutate it to become 1 -> 2 -> 3 (destructively)
     */
    public static void removeDuplicates(IntList p) {
        if (p == null) {
            return;
        }

        IntList current = p.rest;
        IntList previous = p;
        while (current != null) {
            if (current.first == previous.first) {
                previous.rest = current.rest;
            } else {
                previous = previous.rest;
            }
            current = current.rest;
        }
    }

    /**
     * Suppose we have the following IntList class, as defined in lecture and lab, with an added skippify function.
     * Suppose that we define two IntLists as follows.
     * IntList A = IntList.list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
     * IntList B = IntList.list(9, 8, 7, 6, 5, 4, 3, 2, 1);
     * Fill in the method skippify such that the result of calling skippify on A and B are as below:
     * - After calling A.skippify(), A: (1, 3, 6, 10)
     * - After calling B.skippify(), B: (9, 7, 4)
     */
    public void skippify() {
        IntList p = this;
        int n = 1;
        while (p != null) {
            IntList next = p.rest;
            for (int i = 0; i < n; i++) {
                if (next == null) {
                    break;
                }
                next = next.rest;
            }
            p.rest = next;
            p = next;
            n += 1;
        }
    }
}
