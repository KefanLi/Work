package ShortestPaths;

import HeapsAndPriorityQueue.MinHeap;

import java.util.Stack;

public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private MinHeap<Integer> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        this.edgeTo = new DirectedEdge[G.V()];
        this.distTo = new double[G.V()];
        this.pq = new MinHeap<Integer>();
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0;
        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            relax(G, pq.removeMin());
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) {
                    pq.changePriority(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e);
        return path;
    }
}
