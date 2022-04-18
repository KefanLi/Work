package Demo;

public class InstanceVariableDemo {
    private int a;
    private int b;

    public InstanceVariableDemo(int a) {
        this.a = a;
    }

    public void show() {
        System.out.println(a);
        System.out.println(b);
    }

    public static void main(String[] args) {
        InstanceVariableDemo ivd = new InstanceVariableDemo(1);
        ivd.show();
    }
}
