package problem.p0000_0099;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import structure.TreeNode;

class P94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        return null;
    }

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

    /* Stupid solution, old one - don't consider
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

    /*
        Time Complexity O(N) 100%
        Space Complexity O(N) 53.37%
     */
    public List<Integer> inorderTraversalBrakingTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            var node = stack.pop();

            if (node.left == null) {
                result.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
            } else {
                var left = node.left;
                node.left = null; // this breaks original tree
                stack.push(node);
                stack.push(left);
            }

        }

        return result;
    }

    /*
        Time Complexity O(N) 100%
        Space Complexity O(N) 53.37%
     */
    /* Short explanation

              1
            /   \
           2     3
          / \   /
         4   5 6

             2
            / \
           4   5
                \
                 1
                  \
                   3
                  /
                 6

            4
             \
              2
               \
                5
                 \
                  1
                   \
                    3
                   /
                  6
     */
    public List<Integer> inorderTraversalMorisTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        while (root != null) {
            if (root.left != null) {
                var current = root.left;
                root.left = null;

                var theMostRight = current;
                while (theMostRight.right != null) {
                    theMostRight = theMostRight.right;
                }
                theMostRight.right = root;
                root = current;
            } else {
                result.add(root.val);
                root = root.right;
            }
        }

        return result;
    }

}
