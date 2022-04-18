package UnionFind;

public class QuickFind implements UnionFind{
    private int[] id;
    private int count;

    /* The running time is Θ(N) */
    public QuickFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /* The running time is Θ(N) */
    @Override
    public void union(int p, int q) {
        if (id[p] == id[q]) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == id[p]) {
                id[i] = id[q];
                count -= 1;
            }
        }
    }

    /* The running time is Θ(1) */
    @Override
    public int find(int p) {
        return id[p];
    }

    /* The running time is Θ(1) */
    @Override
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    /* The running time is Θ(1) */
    @Override
    public int count() {
        return count;
    }
}
