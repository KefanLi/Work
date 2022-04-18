package Demo;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        for (int i = 0; i < 3; i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
