package problem.p0_99;

import structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class P94 {


    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursionHelper(root, result);
        return result;
    }

    private void recursionHelper(TreeNode node, List<Integer> result) {
        if (node == null) return;

        recursionHelper(node.left, result);
        result.add(node.val);
        recursionHelper(node.right, result);
    }


    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public List<Integer> inorderTraversalStack(TreeNode root) {
        if (root == null) return Collections.emptyList();

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);

        Set<TreeNode> visited = new HashSet<>();

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            var current = stack.peek();

            if (current.left != null && !visited.contains(current.left)) {
                stack.push(current.left);
            } else {
                result.add(current.val);
                visited.add(current);
                stack.pop();
                if (current.right != null) {
                    stack.push(current.right);
                }
            }
        }

        return result;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public List<Integer> inorderTraversalStackV2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        List<Integer> result = new ArrayList<>();
        var current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }

        return result;
    }

    //TODO additional solution, that reorganizes tree to have single branch to traverse (Morris Traversal)
}
