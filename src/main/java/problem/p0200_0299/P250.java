package problem.p0200_0299;

import structure.TreeNode;

class P250 {

    public int countUnivalSubtrees(TreeNode root) {
        return 0;
    }

    //TODO need to reconsider had a bad day.

    /*
        Time Complexity O(N)? 100%
        Space Complexity O(N) 97.47%
     */
    public int countUnivalSubtreesRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int result = isHelper(root, root.val) ? 1 : 0;
        return result + countUnivalSubtreesRecursion(root.left) + countUnivalSubtreesRecursion(root.right);
    }

    private static boolean isHelper(TreeNode root, int uni) {
        if (root == null) {
            return true;
        }
        return root.val == uni && isHelper(root.left, uni) && isHelper(root.right, uni);
    }
}
