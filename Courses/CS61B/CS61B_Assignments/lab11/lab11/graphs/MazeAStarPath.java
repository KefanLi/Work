package lab11.graphs;

import edu.princeton.cs.algs4.IndexMinPQ;

/**
 * @author Josh Hug
 */
public class MazeAStarPath extends MazeExplorer {
    private int s;
    private int t;
    private boolean targetFound = false;
    private Maze maze;
    private IndexMinPQ<Integer> pq;

    public MazeAStarPath(Maze m, int sourceX, int sourceY, int targetX, int targetY) {
        super(m);
        maze = m;
        s = maze.xyTo1D(sourceX, sourceY);
        t = maze.xyTo1D(targetX, targetY);
        distTo[s] = 0;
        edgeTo[s] = s;
        pq = new IndexMinPQ<>(maze.V());
    }

    /**
     * Estimate of the distance from v to the target.
     */
    private int h(int v) {
        return Math.abs(maze.toX(v) - maze.toX(t)) + Math.abs(maze.toY(v) - maze.toY(t));
    }

    /**
     * Finds vertex estimated to be closest to target.
     */
    private int findMinimumUnmarked() {
        return -1;
        /* You do not have to use this method. */
    }

    /**
     * Performs an A star search from vertex s.
     */
    private void astar(int s) {
        // TODO
        pq.insert(s, h(s));
        while (!pq.isEmpty()) {
            int v = pq.delMin();
            marked[v] = true;
            announce();
            if (v == t) {
                return;
            }
            for (int w : maze.adj(v)) {
                if (distTo[w] > distTo[v] + 1) {
                    distTo[w] = distTo[v] + 1;
                    edgeTo[w] = v;
                    if (pq.contains(w)) {
                        pq.changeKey(w, distTo[w] + h(w));
                    } else {
                        pq.insert(w, distTo[w] + h(w));
                    }
                }
            }
        }
    }

    @Override
    public void solve() {
        astar(s);
    }
}

