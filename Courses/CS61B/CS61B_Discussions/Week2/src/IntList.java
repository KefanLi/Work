public class IntList {
    /**
     * Implement square and squareMutative which are static methods that both take in
     * an IntList L and return an IntList with its integer values all squared. square does
     * this non-mutatively with recursion by creating new IntLists while squareMutative
     * uses a recursive approach to change the instance variables of the input IntList L.
     */

    public int first;
    public IntList rest;

    public IntList(int first, IntList rest) {
        this.first = first;
        this.rest = rest;
    }

    /* Using recursive
    public static IntList square(IntList L) {
        if (L == null) {
            return L;
        } else {
            IntList rest = square(L.rest);
            IntList M = new IntList(L.first * L.first, L.rest);
            return M;
        }
    }

     */

    // Using iteration
    public static IntList square(IntList L) {
        if (L == null) {
            return null;
        } else {
            IntList B = new IntList(L.first * L.first, null);
            IntList C = B;
            L = L.rest;

            while (L != null) {
                B.rest = new IntList(L.first * L.first, null);
                B = B.rest;
                L = L.rest;
            }

            return C;
        }
    }

    /* Using iteration
    public static IntList squareMutative(IntList L) {
        IntList B = L;
        while (L.rest != null) {
            L.first = L.first * L.first;
            L = L.rest;
        }

        return B;
    }

     */

    // Using recursive
    public static IntList squareMutative(IntList L) {
        if (L == null) {
            return L;
        } else {
            L.first = L.first * L.first;
            squareMutative(L.rest);
        }
        return L;
    }


    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(10, null);
        L.rest.rest = new IntList(15, null);
        IntList LAfterSquare = square(L);
        System.out.println(LAfterSquare.first);
    }
}
