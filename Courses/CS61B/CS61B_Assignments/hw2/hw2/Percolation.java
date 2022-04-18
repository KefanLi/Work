package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private int numberOfOpenSite;
    private int N;
    private boolean[] items;
    private WeightedQuickUnionUF itemsConnected;
    private WeightedQuickUnionUF itemsConnectedBW;

    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N should be larger than 0");
        }
        this.numberOfOpenSite = 0;
        this.N = N;
        this.items = new boolean[N * N];
        for (int i = 0; i < N * N - 1; i++) {
            items[i] = false;
        }
        itemsConnected = new WeightedQuickUnionUF((N * N) + 2);
        itemsConnectedBW = new WeightedQuickUnionUF((N * N) + 1);
    }

    private int xyTo1D(int row, int col) {
        return row * N + col;
    }

    // open the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row >= N || col >= N) {
            throw new IndexOutOfBoundsException();
        }
        int ith = xyTo1D(row, col);
        if (items[ith]) {
            return;
        }
        items[ith] = true;
        numberOfOpenSite += 1;
        if (row == 0) {
            itemsConnected.union(ith, N * N);
            itemsConnectedBW.union(ith, N * N);
        }
        if (row == N - 1) {
            itemsConnected.union(ith, N * N + 1);
        }
        if (ith % N != 0 && items[ith - 1]) {
            itemsConnected.union(ith, ith - 1);
            itemsConnectedBW.union(ith, ith - 1);
        }
        if ((ith + 1) % N != 0 && items[ith + 1]) {
            itemsConnected.union(ith, ith + 1);
            itemsConnectedBW.union(ith, ith + 1);
        }
        if ((ith - N) >= 0 && items[ith - N]) {
            itemsConnected.union(ith, ith - N);
            itemsConnectedBW.union(ith, ith - N);
        }
        if ((ith + N) < (N * N) && items[ith + N]) {
            itemsConnected.union(ith, ith + N);
            itemsConnectedBW.union(ith, ith + N);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row >= N || col >= N) {
            throw new IndexOutOfBoundsException();
        }
        int ith = xyTo1D(row, col);
        return items[ith];
    }

    // is the site (row, col) full? To check whether this site
    // is connected to the top
    public boolean isFull(int row, int col) {
        if (row >= N || col >= N) {
            throw new IndexOutOfBoundsException();
        }
        int ith = xyTo1D(row, col);
        if (!isOpen(row, col)) {
            return false;
        }
        return itemsConnectedBW.connected(ith, N * N);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return numberOfOpenSite;
    }

    // does the system percolate?
    public boolean percolates() {
        if (N == 1 && !items[0]) {
            return false;
        }
        return itemsConnected.connected(N * N, N * N + 1);
    }

    public static void main(String[] args) {

    }
}
