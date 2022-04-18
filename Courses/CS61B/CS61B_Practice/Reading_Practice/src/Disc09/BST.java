package Disc09;

import InheritanceImplements.In;

public class BST {

    private class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }

    public static boolean isBSTHelper(TreeNode T, int max, int min) {
        if (T == null) {
            return true;
        } else if (T.val < min || T.val > max) {
            return false;
        } else {
            return isBSTHelper(T.left, T.val, min) && isBSTHelper(T.right, max, T.val);
        }
    }

    public static boolean isBSTGood(TreeNode T) {
        return isBSTHelper(T, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
}
