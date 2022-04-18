package MinimumSpanningTree;

import InheritanceImplements.In;

import java.util.LinkedList;

public class EdgeWeightedGraph {
    /* number of vertices */
    private final int V;

    /* number of edges */
    private int E;

    /* adjacency list */
    private LinkedList<Edge>[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Edge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<Edge>();
        }
    }

    /* Constructor used in */
    public EdgeWeightedGraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            double weight = in.readDouble();
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E += 1;
    }

    public Iterable<Edge> adj(int v) {
        return adj[v];
    }

    public Iterable<Edge> edges() {
        LinkedList<Edge> edges = new LinkedList<>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj[v]) {
                if (e.other(v) > v) {
                    edges.add(e); // Keep edge unique
                }
            }
        }
        return edges;
    }
}
