package problem.p0400_0499;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class P404 {

    public int sumOfLeftLeaves(TreeNode root) {
        return 0;
    }

    /*
        Time complexity O(N)
        Space complexity O(N)
     */
    public int sumOfLeftLeavesBreadthFirst(TreeNode root) {
        var result = 0;
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        rightQueue.add(root);

        while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
            while (!leftQueue.isEmpty()) {
                var node = leftQueue.poll();
                if (node.left == null && node.right == null) {
                    result += node.val;
                } else {
                    if (node.left != null) {
                        leftQueue.add(node.left);
                    }

                    if (node.right != null) {
                        rightQueue.add(node.right);
                    }
                }
            }

            while (!rightQueue.isEmpty()) {
                var node = rightQueue.poll();
                if (node.left != null) {
                    leftQueue.add(node.left);
                }
                if (node.right != null) {
                    rightQueue.add(node.right);
                }

            }

        }

        return result;
    }

    /*
        Time complexity O(N)
        Space complexity O(N)
     */
    public int sumOfLeftLeavesDepth(TreeNode root) {
        return recursion(root, false);
    }

    private int recursion(TreeNode node, boolean left) {
        if (node == null) return 0;

        if (left && node.left == null && node.right == null) {
            return node.val;
        }

        return recursion(node.left, true) + recursion(node.right, false);
    }
}
