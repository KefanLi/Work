package UnionFind;

public class WeightedQuickUnion {
    private int[] parent;
    private int count;
    private int[] size;

    /* The running time is Θ(N) */
    public WeightedQuickUnion(int N) {
        count = N;
        parent = new int[N];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        size = new int[N];
        for (int i = 0; i < parent.length; i++) {
            size[i] = 1;
        }
    }

    /* The running time is Θ(N) */
    private int find(int p) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    /* The running time is Θ(logN) */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) {
            return;
        }

        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = parent[rootP];
            size[rootP] = size[rootP] + size[rootQ];
            size[rootQ] = 1;
        } else {
            parent[rootP] = parent[rootQ];
            size[rootQ] = size[rootP] + size[rootQ];
            size[rootP] = 1;
        }

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
