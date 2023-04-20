package problem;

import structure.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class P662 {

    public int widthOfBinaryTree(TreeNode root) {
        var maxWidth = 0;
        LinkedList<TreeNode> queue = new LinkedList<>(); // linked?
        queue.add(root);

        var layerWidth = 1;
        while (layerWidth > 0) {
            while (queue.size() > 0 && queue.getFirst() == null) { //remove leading nulls
                queue.removeFirst();
            }

            while (queue.size() > 0 && queue.getLast() == null) { //remove training nulls
                queue.removeLast();
            }

            layerWidth = queue.size();
            maxWidth = Math.max(maxWidth, layerWidth);

            for (var i = 0; i < layerWidth; i++) { //produce new layer
                var node = queue.removeFirst(); //element will be at the beginning all the time

                if (node == null) {
                    queue.add(null);
                    queue.add(null);
                } else {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }

        return maxWidth;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public int widthOfBinaryTreeImproved(TreeNode root) {
        var maxWidth = 1;
        LinkedList<Map.Entry<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(Map.entry(root, 0));

        while (!queue.isEmpty()) {
            maxWidth = Math.max(maxWidth, queue.getLast().getValue() - queue.getFirst().getValue() + 1);

            var queueLength = queue.size();
            for (var i = 0; i < queueLength; i++) {
                var entry = queue.removeFirst();
                if (entry.getKey().left != null) {
                    queue.add(Map.entry(entry.getKey().left, entry.getValue() * 2));
                }

                if (entry.getKey().right != null) {
                    queue.add(Map.entry(entry.getKey().right, entry.getValue() * 2 + 1));
                }

            }

        }
        return maxWidth;
    }
}
