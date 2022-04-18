package Graph;

import InheritanceImplements.In;

import java.util.LinkedList;

public class Graph {
    /* Number of Vertices */
    private final int V;
    /* Number of Edges */
    private int E;
    /* Adjacency list */
    private LinkedList<Integer>[] adj;

    /* Constructor used V vertices */
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = (LinkedList<Integer>[]) new LinkedList[V];
    }

    /* Constructor used in */
    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /* added Edge between vertices v and w */
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E += 1;
    }

    public Iterable<Integer> adj(int V) {
        return adj[V];
    }

    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v))
                s += w + " ";
            s += "\n";
        }
        return s;
    }
}
