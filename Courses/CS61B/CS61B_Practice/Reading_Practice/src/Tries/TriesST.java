package Tries;

import java.util.Queue;

import java.util.ArrayDeque;

public class TriesST<V> {
    private static int R = 256;
    private Node root;

    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
    }

    private Node put(Node x, String Key, V value, int d) {
        if (x == null) {
            x = new Node();
        }
        if (d == Key.length()) {
            x.value = value;
            return x;
        }
        char c = Key.charAt(d);
        x.next[c] = put(x.next[c], Key, value, d + 1);
        return x;
    }

    public void put(String Key, V value) {
        root = put(root, Key, value, 0);
    }

    private Node get(Node x, String Key, int d) {
        if (x == null) {
            return null;
        }
        if (d == Key.length()) {
            return x;
        }
        char c = Key.charAt(d);
        return get(x.next[c], Key, d + 1);
    }

    public V get(String Key) {
        Node x = get(root, Key, 0);
        if (x == null) {
            return null;
        } else {
            return (V) x.value;
        }
    }

    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    public Iterable<String> keysWithPrefix(String pre) {
        Queue<String> q = new ArrayDeque<>();
        collect(get(root, pre, 0), pre, q);
        return q;
    }

    private void collect(Node x, String pre,
                         Queue<String> q) {
        if (x == null) return;
        if (x.value != null) {
            q.add(pre);
        }
        for (char c = 0; c < R; c++)
            collect(x.next[c], pre + c, q);
    }

    public Iterable<String> keysThatMatch(String pat) {
        Queue<String> q = new ArrayDeque<>();
        collect(root, "", pat, q);
        return q;
    }

    public void collect(Node x, String pre, String pat, Queue<String> q) {
        int d = pre.length();
        if (x == null) {
            return;
        }
        if (d == pat.length() && x.value != null) {
            q.add(pre);
        }
        if (d == pat.length()) {
            return;
        }
        char next = pat.charAt(d);
        for (char c = 0; c < R; c++) {
            if (next == '.' || next == c) {
                collect(x.next[c], pre + c, pat, q);
            }
        }
    }

    public String longestPrefixOf(String s) {
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(Node x, String s, int d, int length) {
        if (x == null) return length;
        if (x.value != null) length = d;
        if (d == s.length()) return length;
        char c = s.charAt(d);
        return search(x.next[c], s, d + 1, length);
    }

    public void delete(String key) {
        root = delete(root, key, 0);
    }

    private Node delete(Node x, String key, int d) {
        if (x == null) return null;
        if (d == key.length())
            x.value = null;
        else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }
        if (x.value != null) return x;
        for (char c = 0; c < R; c++)
            if (x.next[c] != null) return x;
        return null;
    }
}
