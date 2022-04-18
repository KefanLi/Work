public class SLListTest {
    private static void insertTest() {
        SLList SL1 = new SLList();
        SL1.addFirst(2);
        SL1.addFirst(1);
        SL1.insert(0, 0);
        SL1.insert(3, 1);
        SL1.insert(4, 4);
        SL1.print();
        System.out.println();
    }

    private static void reverseTest() {
        SLList SL1 = new SLList();
        SL1.addFirst(2);
        SL1.addFirst(1);
        SL1.insert(0, 0);
        SL1.insert(3, 1);
        SL1.insert(4, 4);
        SL1.reverse();
        SL1.print();
        System.out.println();
    }

    private static void reverseRecursiveTest() {
        SLList SL1 = new SLList();
        SL1.addFirst(3);
        SL1.addFirst(2);
        SL1.addFirst(1);
        SL1.print();
        System.out.println();
        SL1.reverseRecursive();
        SL1.print();
    }

    public static void main(String[] args) {
        //insertTest();
        //reverseTest();
        reverseRecursiveTest();
    }
}
