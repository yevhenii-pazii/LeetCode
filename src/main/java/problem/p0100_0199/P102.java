package problem.p0100_0199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class P102 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
    }

    public static void main(String[] args) {
        System.out.println(new P102().levelOrder(new TreeNode(3,
                new TreeNode(9),

                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)))));

        System.out.println(new P102().levelOrderFlat(new TreeNode(3,
                new TreeNode(9),

                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)))));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        levelOrder(root, result, 0);
        return result;
    }

    private void levelOrder(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) return;

        List<Integer> levelList;
        if (result.size() == level) {
            levelList = new LinkedList<>();
            result.add(levelList);
        } else {
            levelList = result.get(level);
        }
        levelList.add(node.val);
        levelOrder(node.left, result, ++level);
        levelOrder(node.right, result, level);
    }


    public List<List<Integer>> levelOrderFlat(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>(levelSize);
            for (var i = 0; i < levelSize; i++) {
                var node = queue.remove();
                levelList.add(node.val);
                if (node.left != null)  queue.add(node.left);
                if (node.right != null)  queue.add(node.right);
            }
            result.add(levelList);
        }

        return result;
    }


}
