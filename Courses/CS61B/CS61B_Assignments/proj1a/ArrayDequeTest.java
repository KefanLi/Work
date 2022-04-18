public class ArrayDequeTest {
    /*
    private static void addLastTest() {
        System.out.println("running addLastTest");
        ArrayDeque<String> ad1 = new ArrayDeque();
        ad1.addLast("a");
        ad1.addLast("b");
        ad1.addFirst("c");
        ad1.addLast("d");
        ad1.addLast("e");
        ad1.addLast("f");
        ad1.addLast("g");
        ad1.addLast("h");
        ad1.addLast("i");
        String s8 = ad1.get(8);
        String s0 = ad1.get(0);
        String s3 = ad1.get(3);
        System.out.println(s0);
        System.out.println(s8);
        System.out.println(s3);
    }

    private static void addFirstLastTest() {
        System.out.println("running addFirstLastTest");
        ArrayDeque<String> ad1 = new ArrayDeque();
        ad1.addLast("a");
        ad1.addLast("b");
        ad1.addFirst("c");
        ad1.addLast("d");
        ad1.addLast("e");
        ad1.addFirst("f");
        ad1.addFirst("g");
        ad1.addLast("h");
        ad1.addLast("i");
        ad1.addLast("j");
        ad1.addFirst("k");
        ad1.addFirst("l");
        String s2 = ad1.get(2);
        String s3 = ad1.get(3);
        String s15 = ad1.get(15);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s15);
    }

    private static void sizeTest() {
        System.out.println("running sizeTest");
        ArrayDeque<String> ad1 = new ArrayDeque();
        ad1.addLast("a");
        ad1.addLast("b");
        ad1.addFirst("c");
        ad1.addLast("d");
        ad1.addLast("e");
        ad1.addFirst("f");
        ad1.addFirst("g");
        ad1.addLast("h");
        ad1.addLast("i");
        ad1.addLast("j");
        ad1.addFirst("k");
        ad1.addFirst("l");
        int ad1Size = ad1.size();
        System.out.println(ad1Size);
    }

    private static void printDequeTest() {
        System.out.println("running printDequeTest");
        ArrayDeque<String> ad1 = new ArrayDeque();
        ad1.addLast("a");
        ad1.addLast("b");
        ad1.addFirst("c");
        ad1.addLast("d");
        ad1.addLast("e");
        ad1.addFirst("f");
        ad1.addFirst("g");
        ad1.addLast("h");
        ad1.addLast("i");
        ad1.addLast("j");
        ad1.addFirst("k");
        ad1.addFirst("l");
        ad1.printDeque();
        System.out.println();
    }

    private static void removeFirstLastTest() {
        System.out.println("running removeFirstTest");
        ArrayDeque<String> ad1 = new ArrayDeque();
        ad1.addLast("a");
        ad1.addLast("b");
        ad1.addFirst("c");
        ad1.addLast("d");
        ad1.addLast("e");
        ad1.addFirst("f");
        ad1.addFirst("g");
        ad1.addLast("h");
        ad1.addLast("i");
        ad1.addLast("j");
        ad1.addFirst("k");
        ad1.addFirst("l");
        ad1.printDeque();
        System.out.println();
        String rmf1 = ad1.removeFirst();
        System.out.println(rmf1);
        String rml1 = ad1.removeLast();
        System.out.println(rml1);
        ad1.printDeque();
        ad1.removeFirst();
        ad1.removeFirst();
        ad1.removeFirst();
        System.out.println();
        ad1.printDeque();
    }
     */
    /*
    private static void addFirstLastTest() {
        System.out.println("running removeFirstTest");
        ArrayDeque<String> ad1 = new ArrayDeque();
        ad1.addFirst("a");
        ad1.addFirst("b");
        ad1.addFirst("c");
        ad1.addFirst("d");
        ad1.addFirst("e");
        ad1.addFirst("f");
        ad1.addLast("g");
        ad1.addFirst("h");
        ad1.addFirst("i");
        ad1.printDeque();
    }

     */

    private static void removeFirstLastTest() {
        System.out.println("running removeFirstLastTest");
        ArrayDeque<String> ad1 = new ArrayDeque();
        ad1.addFirst("a");
        ad1.addFirst("b");
        ad1.addFirst("c");
        ad1.addFirst("d");
        ad1.removeLast();
        ad1.removeLast();
        String get0 = ad1.get(0);
        System.out.println(get0);
    }

    private static void getTest() {
        System.out.println("running getTest");

        ArrayDeque<Integer> ad = new ArrayDeque();

        /*
        ad.addLast(0);
        ad.removeLast();
        ad.addFirst(2);
        ad.addFirst(3);
        ad.addFirst(4);
        ad.addFirst(5);
        ad.removeLast();
        ad.addFirst(7);
        ad.get(3);
        ad.removeLast();
        ad.removeLast();
        int get1 = ad.get(1);
        System.out.println(get1);

         */

        ad.addLast(2);
        ad.addFirst(1);
        int get0 = ad.get(0);
        System.out.println(get0);

        /*
        ad.addLast(3);
        ad.removeLast();
        ad.addLast(5);
        ad.removeFirst();
        ad.addFirst(7);
        ad.addFirst(8);
        ad.removeFirst();
        ad.removeFirst();
        ad.removeLast();
        ad.addLast(12);
        ad.get(0);
        System.out.println(get0);
        ad.get(0);
        ad.removeLast();
        ad.addFirst(16);
        ad.removeLast();
        ad.addFirst(18);
        ad.removeFirst();
        ad.addFirst(20);
        int i = ad.get(0);
        System.out.println(i);
    }

         */
    }

    private static void newTest1() {
        System.out.println("running newTest1");
        ArrayDeque<String> ad1 = new ArrayDeque();
        ad1.addLast("a");
        ad1.addLast("b");
        ad1.addFirst("c");
        ad1.addLast("d");
        ad1.addLast("e");
        ad1.addLast("f");
        ad1.addLast("g");
        ad1.addLast("h");
        ad1.addLast("i");
        ad1.printDeque();
    }

    private static void sizeDecreaseTest() {
        System.out.println("running sizeDecreaseTest");
        ArrayDeque<String> ad1 = new ArrayDeque();
        ad1.addLast("a");
        ad1.addLast("b");
        ad1.addFirst("c");
        ad1.addLast("d");
        ad1.addLast("e");
        ad1.addLast("f");
        ad1.addLast("g");
        ad1.addLast("h");
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        ad1.printDeque();
        //int length = ad1.getLength();
        //System.out.println(length);
    }

    private static void getTestNew() {
        ArrayDeque<Integer> ad1 = new ArrayDeque();
        ad1.addLast(0);
        ad1.addFirst(1);
        ad1.addFirst(2);
        ad1.removeFirst();
        ad1.addFirst(4);
        ad1.addLast(5);
        ad1.addFirst(6);
        ad1.addFirst(7);
        ad1.get(1);
        ad1.addFirst(9);
        ad1.addFirst(10);
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeFirst();
        ad1.removeLast();
        ad1.printDeque();
    }

    public static void main(String[] args) {
        //addFirstLastTest();
        //removeFirstLastTest();
        //getTest();
        //newTest1();
        //sizeDecreaseTest();
        getTestNew();
    }
}
