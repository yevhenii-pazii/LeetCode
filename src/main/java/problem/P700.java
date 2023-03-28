package problem;

import structure.TreeNode;

public class P700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;

        return root.val > val ? searchBST(root.left, val) : searchBST(root.right, val);
    }

    public TreeNode searchBSTLoop(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = root.val > val ? root.left : root.right;
        }

        return root;
    }
}
