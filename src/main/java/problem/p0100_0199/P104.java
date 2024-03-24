package problem.p0100_0199;

import structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class P104 {

    //recursion + depth first + breadth first

    /*
        Pure recursion
        Time Complexity O(N)
        Space complexity O(N)
     */
    public int maxDepthRecursion(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepthRecursion(root.left), maxDepthRecursion(root.right));
    }

    /*
        Depth First
        Time Complexity O(N)
        Space complexity O(log N)
    */
    public int maxDepthDepthFirst(TreeNode root) {
        if (root == null) return 0;
        var max = 0;

        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> depth = new ArrayDeque<>();
        stack.push(root);
        depth.push(1);
        while (!stack.isEmpty()) {
            var node = stack.pop();
            var currentDepth = depth.pop();
            max = Math.max(max, currentDepth);

            if (node.right != null) {
                stack.push(node.right);
                depth.push(currentDepth + 1);
            }

            if (node.left != null) {
                stack.push(node.left);
                depth.push(currentDepth + 1);
            }
        }

        return max;
    }


    /*
        Breadth First - Best in this case
        Time Complexity O(N)
        Space complexity O(log N)
    */
    public int maxDepthBreadthFirst(TreeNode root) {
        if (root == null) return 0;
        var level = 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            level++;

            var length = queue.size();
            while (length-- > 0) {
                var node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return level;
    }

}
