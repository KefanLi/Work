package hw4.puzzle;

import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayDeque;


public class Solver {

    private MinPQ<SearchNode> pq;
    private ArrayDeque<WorldState> solution;
    private SearchNode finishNode;

    private class SearchNode implements Comparable<SearchNode> {
        private SearchNode pre;
        private int moves;
        private int estimate;
        private WorldState word;

        public SearchNode(SearchNode pre, int moves, WorldState word) {
            this.pre = pre;
            this.moves = moves;
            this.estimate = word.estimatedDistanceToGoal();
            this.word = word;
        }

        @Override
        public int compareTo(SearchNode s) {
            return (this.moves + this.estimate)
                    - (s.moves + s.estimate);
        }
    }

    public Solver(WorldState initial) {
        pq = new MinPQ<>();
        SearchNode firstNode = new SearchNode(null, 0, initial);
        pq.insert(firstNode);
        while (!pq.isEmpty()) {
            SearchNode x = pq.delMin();
            if (x.estimate == 0) {
                finishNode = x;
                return;
            }
            Iterable<WorldState> neighbors = x.word.neighbors();
            for (WorldState n : neighbors) {
                if (x.pre == null || !n.equals(x.pre.word)) {
                    pq.insert(new SearchNode(x, x.moves + 1, n));
                }
            }
        }
    }

    public int moves() {
        return finishNode.moves;
    }

    public Iterable<WorldState> solution() {
        solution = new ArrayDeque<>();
        SearchNode tmp = finishNode;
        while (tmp != null) {
            solution.addFirst(tmp.word);
            tmp = tmp.pre;
        }
        return solution;
    }
}
