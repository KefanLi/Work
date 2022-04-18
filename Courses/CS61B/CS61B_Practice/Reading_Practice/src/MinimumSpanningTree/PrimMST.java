package MinimumSpanningTree;

import edu.princeton.cs.algs4.IndexMinPQ;

import java.util.ArrayDeque;

public class PrimMST {
    /* Shortest edge from tree vertex */
    private Edge[] edgeTo;

    /* distTo[w] = edgeTO[w].weight() */
    private double[] distTo;

    /* True if v on the tree */
    private boolean[] marked;

    /* Eligible crossing edges */
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph G) {
        this.edgeTo = new Edge[G.V()];
        this.distTo = new double[G.V()];
        this.marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }

        distTo[0] = 0.0;
        pq.insert(0, 0.0); // Initialize pq with 0, weight 0
        while (!pq.isEmpty())
            visit(G, pq.delMin()); // Add the closest vertex to tree.
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            int w = e.other(v);
            if (marked[w]) {
                continue;
            }
            if (e.weight() < distTo[w]) {
                // Edge e is new best connection from tree to w.
                edgeTo[w] = e;
                distTo[w] = e.weight();
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public Iterable<Edge> edges() {
        ArrayDeque<Edge> deque = new ArrayDeque<>();
        for (int i = 1; i < marked.length; i++) {
            if (marked[i]) {
                deque.addLast(edgeTo[i]);
            }
        }
        return deque;
    }

    public double weight() {
        double weight = 0;
        Iterable<Edge> deque = edges();
        for (Edge e : deque) {
            weight += e.weight();
        }
        return weight;
    }
}
