package problem.p0100_0199;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

import structure.TreeNode;

public class P144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        return null;
    }


    /*
        Time Complexity O(N) 100%
        Space Complexity O(N) 84.77%
     */
    public List<Integer> preorderTraversalRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursionHelper(root, result);
        return result;
    }

    private static void recursionHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        recursionHelper(node.left, result);
        recursionHelper(node.right, result);
    }

    /*
        Time Complexity O(N) 100%
        Space Complexity O(N) 35.16%
     */
    public List<Integer> preorderTraversalLoop(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        List<Integer> result = new ArrayList<>();

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }
}
