package structure;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode treeNode)) return false;
        return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val + "," +
                "left=" + (left != null) + "," +
                "right=" + (right != null) +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    public static TreeNode node(int val) {
        return new TreeNode(val);
    }

    public static TreeNode node(int val, TreeNode left, TreeNode right) {
        return new TreeNode(val, left, right);
    }

    public static TreeNode tree(Integer... vals) {
        TreeNode root = node(vals[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        var index = 1;

        var left = true;
        while (index < vals.length && !queue.isEmpty()) {
            var currentNode = left ? queue.peek() : queue.poll();
            if (vals[index] != null) {
                var newNode = node(vals[index]);
                if (left) {
                    currentNode.setLeft(newNode);
                } else {
                    currentNode.setRight(newNode);
                }
                queue.add(newNode);
            }

            left = !left;
            index++;
        }

        return root;
    }

}
