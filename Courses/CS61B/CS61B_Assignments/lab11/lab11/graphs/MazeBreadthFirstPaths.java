package lab11.graphs;

import edu.princeton.cs.algs4.Queue;

/**
 * @author Josh Hug
 */
public class MazeBreadthFirstPaths extends MazeExplorer {
    /* Inherits public fields:
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] marked;
    */
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;

    public MazeBreadthFirstPaths(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        // Add more variables here!
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
    }

    /**
     * Conducts a breadth first search of the maze starting at the source.
     */
    private void bfs(int v) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(v);
        marked[v] = true;
        announce();
        while (!queue.isEmpty()) {
            int w = queue.dequeue();
            if (w == t) {
                targetFound = true;
            }
            if (targetFound) {
                return;
            }
            for (int i : maze.adj(w)) {
                if (!marked[i]) {
                    edgeTo[i] = w;
                    announce();
                    distTo[i] = distTo[w] + 1;
                    marked[i] = true;
                    announce();
                    queue.enqueue(i);
                }
            }
        }
    }

    @Override
    public void solve() {
        bfs(s);
    }
}

