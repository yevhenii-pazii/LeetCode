package structure;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public static TreeNode node(int val) {
        return new TreeNode(val);
    }

    public static TreeNode tree(Integer... vals) {
        Queue<TreeNode> queue = new LinkedList<>();

        var result = new TreeNode(vals[0]);
        var index = 1;
        queue.offer(result);

        while (index < vals.length) {
            var queueSize = queue.size();
            for (var i = 0; i < queueSize; i++) {
                var node = queue.remove();
                if (node == null) {
                    queue.add(null);
                    queue.add(null);
                    index += 2;
                } else {
                    if (index == vals.length) {
                        break;
                    }
                    var lefLeaf = vals[index++];
                    if (lefLeaf != null) {
                        node.left = new TreeNode(lefLeaf);
                    }
                    queue.add(node.left);

                    if (index == vals.length) {
                        break;
                    }
                    var rightLeaf = vals[index++];
                    if (rightLeaf != null) {
                        node.right = new TreeNode(rightLeaf);
                    }
                    queue.add(node.right);
                }
            }
        }

        return result;
    }

}
