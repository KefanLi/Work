package Graph;

import java.util.Queue;
import java.util.ArrayDeque;

import java.util.Stack;

public class DepthFirstOrder {
    private boolean[] marked;

    /* vertices in preorder */
    private Queue<Integer> pre;

    /* vertices in postorder */
    private Queue<Integer> post;

    /* vertices in reverse postorder */
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph G) {
        pre = new ArrayDeque<Integer>();
        post = new ArrayDeque<Integer>();
        reversePost = new Stack<Integer>();

        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        pre.add(v);
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        post.add(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return pre;
    }

    public Iterable<Integer> post() {
        return post;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
