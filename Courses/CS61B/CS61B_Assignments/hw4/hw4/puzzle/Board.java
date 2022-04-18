package hw4.puzzle;

import edu.princeton.cs.algs4.Queue;

public class Board implements WorldState {

    private static final int BLANK = 0;
    private final int[][] tiles;
    private int size;

    /**
     * Constructor of Board using tiles
     */
    public Board(int[][] tiles) {
        this.size = tiles.length;
        this.tiles = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.tiles[i][j] = tiles[i][j];
            }
        }
    }

    /**
     * Returns value of tile at row i, column j (or 0 if blank)
     */
    public int tileAt(int i, int j) {
        if (i < 0 || i > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (j < 0 || j > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return tiles[i][j];
    }

    /**
     * Returns neighbors of this board.
     * SPOILERZ: This is the answer.
     * Copy form Hug's solution
     */
    @Override
    public Iterable<WorldState> neighbors() {
        Queue<WorldState> neighbors = new Queue<>();
        int hug = size();
        int bug = -1;
        int zug = -1;
        for (int rug = 0; rug < hug; rug++) {
            for (int tug = 0; tug < hug; tug++) {
                if (tileAt(rug, tug) == BLANK) {
                    bug = rug;
                    zug = tug;
                }
            }
        }
        int[][] ili1li1 = new int[hug][hug];
        for (int pug = 0; pug < hug; pug++) {
            for (int yug = 0; yug < hug; yug++) {
                ili1li1[pug][yug] = tileAt(pug, yug);
            }
        }
        for (int l11il = 0; l11il < hug; l11il++) {
            for (int lil1il1 = 0; lil1il1 < hug; lil1il1++) {
                if (Math.abs(-bug + l11il) + Math.abs(lil1il1 - zug) - 1 == 0) {
                    ili1li1[bug][zug] = ili1li1[l11il][lil1il1];
                    ili1li1[l11il][lil1il1] = BLANK;
                    Board neighbor = new Board(ili1li1);
                    neighbors.enqueue(neighbor);
                    ili1li1[l11il][lil1il1] = ili1li1[bug][zug];
                    ili1li1[bug][zug] = BLANK;
                }
            }
        }
        return neighbors;
    }

    /**
     * Returns the board size N
     */
    public int size() {
        return size;
    }

    /**
     * Hamming estimate
     */
    public int hamming() {
        int hamDistance = 0;
        int goal = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == size - 1 && j == size - 1) {
                    break;
                }
                if (tiles[i][j] != goal) {
                    hamDistance += 1;
                }
                goal += 1;
            }
        }
        return hamDistance;
    }

    /**
     * Private helper method to locate tile
     */
    private int[] locate(int target) {
        int[] outcome = new int[2];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tiles[i][j] == target) {
                    outcome[0] = i;
                    outcome[1] = j;
                    break;
                }
            }
        }
        return outcome;
    }

    /**
     * Manhattan estimate
     */
    public int manhattan() {
        int manDistance = 0;
        int goal = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == size - 1 && j == size - 1) {
                    break;
                }
                int[] location = locate(goal);
                int xDistance = location[0] - i;
                if (xDistance < 0) {
                    xDistance = -xDistance;
                }
                int yDistance = location[1] - j;
                if (yDistance < 0) {
                    yDistance = -yDistance;
                }
                manDistance += xDistance;
                manDistance += yDistance;
                goal += 1;
            }
        }
        return manDistance;
    }

    @Override
    public int estimatedDistanceToGoal() {
        return this.manhattan();
    }

    /**
     * Returns the string representation of the board.
     * Uncomment this method.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        int N = size();
        s.append(N + "\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                s.append(String.format("%2d ", tileAt(i, j)));
            }
            s.append("\n");
        }
        s.append("\n");
        return s.toString();
    }

    @Override
    public boolean equals(Object O) {
        if (this == O) {
            return true;
        }
        if (O == null || O.getClass() != this.getClass()) {
            return false;
        }
        Board B = (Board) O;
        if (this.size != B.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (tiles[i][j] != B.tileAt(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int code = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                code += tiles[i][j] * 31;
            }
        }
        return code;
    }
}
