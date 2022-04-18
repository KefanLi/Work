package Demo;

public class StaticVariableDemo {
    private int M;
    private int N;
    private static int F;

    public int test1() {
        return M + N + F;
    }

    public static int test2() {
        //return M + N;
        return F;
    }
}
