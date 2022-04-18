import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.MinPQ;

public class BinaryTrie implements Serializable {

    private Node root;
    private Map<Character, BitSequence> lookUpTable;

    private static class Node implements Comparable<Node>, Serializable {
        private final char value;
        private final int freq;
        private final Node left, right;

        Node(char value, int freq, Node left, Node right) {
            this.value = value;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        // Is the node a leaf node?
        private boolean isLeaf() {
            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return (left == null) && (right == null);
        }

        // Compare, based on frequency
        @Override
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    public BinaryTrie(Map<Character, Integer> frequencyTable) {
        root = buildTrie(frequencyTable);
        lookUpTable = new HashMap<>();
        buildCode(root, "");
    }

    private Node buildTrie(Map<Character, Integer> frequencyTable) {
        // Initialize priority queue with singleton trees
        MinPQ<Node> pq = new MinPQ<Node>();
        for (Character key : frequencyTable.keySet()) {
            pq.insert(new Node(key, frequencyTable.get(key), null, null));
        }
        // Merge two smallest trees
        while (pq.size() > 1) {
            Node left = pq.delMin();
            Node right = pq.delMin();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            pq.insert(parent);
        }
        return pq.delMin();
    }

    // Make a lookup table from symbols and their encodings
    private void buildCode(Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(x.left, s + '0');
            buildCode(x.right, s + '1');
        } else {
            lookUpTable.put(x.value, new BitSequence(s));
        }
    }

    public Map<Character, BitSequence> buildLookupTable() {
        return lookUpTable;
    }

    private Node get(Node x, BitSequence querySequence, int d) {
        if (x == null) {
            return null;
        }
        if (d == querySequence.length()) {
            return x;
        }
        int i = querySequence.bitAt(d);
        if (i == 0) {
            return get(x.left, querySequence, d + 1);
        } else {
            return get(x.right, querySequence, d + 1);
        }
    }

    private char get(BitSequence querySequence) {
        Node x = get(root, querySequence, 0);
        if (x == null) {
            return '\0';
        } else {
            return x.value;
        }
    }

    public Match longestPrefixMatch(BitSequence querySequence) {
        int length = search(root, querySequence, 0, 0);
        return new Match(querySequence.firstNBits(length), get(querySequence.firstNBits(length)));
    }

    private int search(Node x, BitSequence querySequence, int d, int length) {
        if (x == null) {
            return length;
        }
        if (x.value != '\0') {
            length = d;
        }
        if (d == querySequence.length()) {
            return length;
        }
        int i = querySequence.bitAt(d);
        if (i == 0) {
            return search(x.left, querySequence, d + 1, length);
        } else {
            return search(x.right, querySequence, d + 1, length);
        }
    }
}
