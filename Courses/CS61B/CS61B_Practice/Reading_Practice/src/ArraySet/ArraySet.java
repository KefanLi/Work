package ArraySet;

public class ArraySet<T> {
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* check to see if ArraySet contains the key. */
    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (items[i] == null) {
                continue;
            }

            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* add the value to the set if not already present. */
    public void add(T x) {
        if (x == null) {
            return;
        }
        if (contains(x)) {
            return;
        } else {
            items[size] = x;
            size += 1;
        }
    }

    /* return number of values. */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<String>();
        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");
        System.out.println(s.contains("horse"));
        System.out.println(s.size());
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}