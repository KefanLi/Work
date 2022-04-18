package lab11.graphs;

/**
 * @author Josh Hug
 */
public class MazeCycles extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    public MazeCycles(Maze m) {
        super(m);
        distTo[0] = 0;
        edgeTo[0] = 0;
    }

    @Override
    public void solve() {
        // TODO: Your code here!
        dfs(0);
    }

    // Helper methods go here
    private void dfs(int v) {
        marked[v] = true;
        announce();
        for (int w : maze.adj(v)) {
            if (marked[w] && w != edgeTo[v]) {
                return;
            }
            if (!marked[w]) {
                edgeTo[w] = v;
                announce();
                distTo[w] = distTo[v] + 1;
                dfs(w);
            }
        }
    }
}

