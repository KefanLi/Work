public class Trie {

    private static int R = 256;
    private Node root = new Node();

    private static class Node {
        private Node[] next = new Node[R];
    }

    private Node put(Node x, String Key, int d) {
        if (x == null) {
            x = new Node();
        }
        if (d == Key.length()) {
            return x;
        }
        char c = Key.charAt(d);
        x.next[c] = put(x.next[c], Key, d + 1);
        return x;
    }

    public void put(String Key) {
        root = put(root, Key, 0);
    }


}
