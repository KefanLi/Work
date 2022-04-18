package MinimumSpanningTree;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.UF;

public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new Queue<>();
        MinPQ<Edge> fringe = new MinPQ<>();
        for (Edge e : G.edges()) {
            fringe.insert(e);
        }
        UF uf = new UF(G.V());
        while (fringe.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = fringe.delMin(); // Get min weight edge on pq
            int v = e.either(); // Get vertices
            int w = e.other(v); // Get vertices
            if (uf.connected(v, w)) {
                continue;
            }
            uf.union(v, w);
            mst.enqueue(e);
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        double weight = 0;
        for (Edge e : edges()) {
            weight += e.weight();
        }
        return weight;
    }
}
