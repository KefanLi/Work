package HeapsAndPriorityQueue;

public class MaxPQ<K extends Comparable<K>> {
    private K[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = (K[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        K t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && less((k / 2), k)) {
            exch((k / 2), k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j += 1;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    public void insert(K key) {
        pq[N + 1] = key;
        N += 1;
        swim(N);
    }

    public K delMax() {
        K max = pq[1];
        exch(1, N);
        pq[N] = null;
        N -= 1;
        sink(1);
        return max;
    }
}
