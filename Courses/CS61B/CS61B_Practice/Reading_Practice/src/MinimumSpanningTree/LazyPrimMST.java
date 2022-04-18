package MinimumSpanningTree;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.MinPQ;

public class LazyPrimMST {
    /* MST vertices */
    private boolean[] marked;

    /* MST edges */
    private Queue<Edge> mst;

    /* Crossing (and ineligible) edges */
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G) {
        marked = new boolean[G.V()];
        mst = new Queue<Edge>();
        pq = new MinPQ<Edge>();

        visit(G, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.delMin(); // Get lowest-weight
            int v = e.either(); // Edge from pq
            int w = e.other(v); // Edge from pq
            if (marked[v] && marked[w]) {
                continue; // Skip if ineligible.
            }
            mst.enqueue(e); // Add edge to tree.
            if (!marked[v]) {
                visit(G, v); // Add vertex to tree
            }
            if (!marked[w]) {
                visit(G, w); // Add vertex to tree
            }
        }
    }

    /* Mark v and add to pq all edges from v to unmarked vertices. */
    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    /* Total weight of all MST's edges */
    public double weight() {
        double weight = 0;
        for (Edge e : mst) {
            weight += e.weight();
        }
        return weight;
    }
}
