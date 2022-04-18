package Demo;

public class ClassVariableDemo {
    public int a;
    public int b;
    public int[] c;
    public String[] d;

    public int sum() {
        return a + b;
    }

    public String get() {
        return d[a];
    }

    public static void main(String[] args) {
        ClassVariableDemo cvd = new ClassVariableDemo();
        System.out.println(cvd.sum());
        // Running time error occurs.
        System.out.println(cvd.get());
    }
}
