package ShortestPaths;

import InheritanceImplements.In;

import java.util.LinkedList;

public class EdgeWeightedDigraph {
    /* number of vertices */
    private final int V;

    /* number of edges */
    private int E;

    /* adjacency list */
    private LinkedList<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<DirectedEdge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<DirectedEdge>();
        }
    }

    /* Constructor used in */
    public EdgeWeightedDigraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            DirectedEdge e = new DirectedEdge(v, w, weight);
            addEdge(e);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        LinkedList<DirectedEdge> edges = new LinkedList<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v]) {
                edges.add(e);
            }
        }
        return edges;
    }
}
