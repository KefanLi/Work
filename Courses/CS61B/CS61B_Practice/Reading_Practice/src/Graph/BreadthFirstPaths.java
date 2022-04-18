package Graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstPaths {
    /* Is a shortest path to this vertex known? */
    private boolean[] marked;

    /* last vertex on known path to this vertex */
    private int[] edgeTo;

    /* source */
    private final int s;

    public BreadthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new ArrayDeque<>();
        marked[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    queue.add(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int i = v; i != s; i = edgeTo[i]) {
            path.push(i);
        }
        path.push(s);
        return path;
    }
}
