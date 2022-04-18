package UnionFind;

public class QuickUnion {
    private int[] parent;
    private int count;

    /* The running time is Θ(N) */
    public QuickUnion(int N) {
        count = N;
        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
    }

    /* The running time is Θ(N) */
    private int find(int p) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    /* The running time is Θ(N) */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        parent[rootP] = parent[rootQ];
        count -= 1;
    }

    /* The running time is Θ(1) */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /* The running time is Θ(1) */
    public int count() {
        return count;
    }
}
