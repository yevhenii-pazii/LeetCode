package problem.p0100_0199;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

import structure.TreeNode;

class P112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return false;
    }

    /*
        Time Complexity O(N) 100%
        Space Complexity O(N) 99.48%
     */
    public boolean hasPathSumRecursion(TreeNode root, int targetSum) {
        return helper(root, targetSum);
    }

    private static boolean helper(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        return helper(root.left, targetSum - root.val)
            || helper(root.right, targetSum - root.val);
    }

    /*
        Time Complexity O(N) 7.08%
        Space Complexity O(N) 95.46%
     */
    public boolean hasPathSumDepthFirst(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> targetStack = new ArrayDeque<>();

        nodeStack.push(root);
        targetStack.push(targetSum);

        while (!nodeStack.isEmpty()) {
            var node = nodeStack.pop();
            var target = targetStack.pop();

            if (node.left == null && node.right == null && node.val == target) {
                return true;
            }

            if (node.right != null) {
                nodeStack.push(node.right);
                targetStack.push(target - node.val);
            }

            if (node.left != null) {
                nodeStack.push(node.left);
                targetStack.push(target - node.val);
            }
        }

        return false;
    }

    /*
        Time Complexity O(N) 9.11%
        Space Complexity O(N) 90.76%
     */
    public boolean hasPathSumBreadthFirst(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        Queue<Integer> targetQueue = new ArrayDeque<>();

        nodeQueue.add(root);
        targetQueue.add(targetSum);

        while (!nodeQueue.isEmpty()) {
            var size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                var node = nodeQueue.remove();
                var target = targetQueue.remove();

                if (node.left == null && node.right == null && node.val == target) {
                    return true;
                }

                if (node.left != null) {
                    nodeQueue.add(node.left);
                    targetQueue.add(target - node.val);
                }
                if (node.right != null) {
                    nodeQueue.add(node.right);
                    targetQueue.add(target - node.val);
                }
            }
        }

        return false;
    }
}
