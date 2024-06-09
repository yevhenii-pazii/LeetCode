package problem.p0900_0999;

import structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

class P938 {

    public int rangeSumBST(TreeNode root, int low, int high) {
        return 0;
    }


    /*
        Time Complexity O(N)
        Space Complexity O(N)

        DFS (Depth-First Search) traversal.
     */
    public int rangeSumBSTRecursion(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBSTRecursion(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBSTRecursion(root.left, low, high);
        } else {
            return root.val
                    + rangeSumBSTRecursion(root.left, low, high)
                    + rangeSumBSTRecursion(root.right, low, high);
        }
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)

        DFS (Depth-First Search) traversal.
    */
    public int rangeSumBSTIterative(TreeNode root, int low, int high) {
        var result = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            var node = stack.pop();

            if (node.val < low) {
                Optional.ofNullable(node.right).ifPresent(stack::push);
            } else if (node.val > high) {
                Optional.ofNullable(node.left).ifPresent(stack::push);
            } else {
                result += node.val;
                Optional.ofNullable(node.right).ifPresent(stack::push);
                Optional.ofNullable(node.left).ifPresent(stack::push);
            }
        }

        return result;
    }
}
