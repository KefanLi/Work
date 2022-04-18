package UnionFind;

public interface UnionFind {
    /**
     * add connection between p and q
     * @param p
     * @param q
     */
    void union(int p, int q);

    /**
     * component identifier for p (0 to N-1)
     * @param p
     * @return
     */
    int find(int p);

    /**
     * return true if p and q are in the same component
     * @param p
     * @param q
     * @return
     */
    boolean connected(int p, int q);

    /**
     * number of components
     * @return
     */
    int count();
}
