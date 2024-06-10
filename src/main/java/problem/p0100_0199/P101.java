package problem.p0100_0199;

import java.util.ArrayDeque;
import java.util.Deque;

import structure.TreeNode;

class P101 {

    public boolean isSymmetric(TreeNode root) {
        return false;
    }

    /*
        Time Complexity O(N) 100%
        Space Complexity O(N) 96.30%
     */
    public boolean isSymmetricRecursion(TreeNode root) {
        return recursionHelper(root.left, root.right);
    }

    private static boolean recursionHelper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }

        if (left.val == right.val) {
            return recursionHelper(left.left, right.right) && recursionHelper(left.right, right.left);
        } else {
            return false;
        }
    }

    /*
        Time Complexity O(N) 15.14%
        Space Complexity O(N) 85.74%
     */
    public boolean isSymmetricDepthFirst(TreeNode root) {
        if (root.left == null || root.right == null) {
            return root.left == root.right;
        }

        Deque<TreeNode> leftStack = new ArrayDeque<>();
        Deque<TreeNode> rightStack = new ArrayDeque<>();
        leftStack.push(root.left);
        rightStack.push(root.right);

        while (!leftStack.isEmpty() || !rightStack.isEmpty()) {
            var left = leftStack.pop();
            var right = rightStack.pop();
            if (left.val != right.val) {
                return false;
            }


            if (left.left == null || right.right == null) {
                if (left.left != right.right) {
                    return false;
                }
            } else {
                leftStack.push(left.left);
                rightStack.push(right.right);
            }


            if (left.right == null || right.left == null) {
                if (left.right != right.left) {
                    return false;
                }
            } else {
                leftStack.push(left.right);
                rightStack.push(right.left);
            }
        }

        return true;
    }

    //TODO had no time
    public boolean isSymmetricBreadthFirst(TreeNode root) {
        return false;
    }
}
