package MinimumSpanningTree;

public class Edge implements Comparable<Edge> {
    /* one vertex */
    private final int v;

    /* the other vertex */
    private final int w;

    /* edge weight */
    private final double weight;

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return weight;
    }

    public int either() {
        return v;
    }

    public int other(int vertex) {
        if (vertex == v) {
            return w;
        } else if (vertex == w) {
            return v;
        } else {
            throw new RuntimeException("Inconsistent Edge");
        }
    }

    @Override
    public int compareTo(Edge e) {
        if (this.weight < e.weight) {
            return -1;
        } else if (this.weight > e.weight) {
            return 1;
        } else {
            return 0;
        }
    }

    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }
}
