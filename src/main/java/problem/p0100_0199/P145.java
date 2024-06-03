package problem.p0100_0199;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import structure.TreeNode;

class P145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        return null;
    }

    /*
        Time Complexity O(N) 100%
        Space Complexity O(N) 51.74%
     */
    public List<Integer> postorderTraversalRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private static void helper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        helper(node.left, result);
        helper(node.right, result);
        result.add(node.val);
    }

    /*
        Time Complexity O(N) 100%
        Space Complexity O(N) 91.83%
     */
    public List<Integer> postorderTraversalStack(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            var node = stack.pop();
            result.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return result;
    }

}
