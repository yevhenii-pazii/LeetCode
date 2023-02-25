import java.util.Deque;
import java.util.LinkedList;

public class P98 {

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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {
        System.out.println(new P98().isValidBST(new TreeNode(2147483647)));

        System.out.println(new P98().isValidBST(new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3))));

        System.out.println(new P98().isValidBST(new TreeNode(5,
                new TreeNode(4),
                new TreeNode(6, new TreeNode(3), new TreeNode(7)))));

        System.out.println(new P98().isValidBST(new TreeNode(3,
                new TreeNode(1, new TreeNode(0), new TreeNode(2)),
                new TreeNode(5, new TreeNode(4), new TreeNode(6)))));

        System.out.println();

        System.out.println(new P98().isValidBSTFlat(new TreeNode(2147483647)));

        System.out.println(new P98().isValidBSTFlat(new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3))));

        System.out.println(new P98().isValidBSTFlat(new TreeNode(5,
                new TreeNode(4),
                new TreeNode(6, new TreeNode(3), new TreeNode(7)))));

        System.out.println(new P98().isValidBSTFlat(new TreeNode(3,
                new TreeNode(1, new TreeNode(0), new TreeNode(2)),
                new TreeNode(5, new TreeNode(4), new TreeNode(6)))));

    }

    public boolean isValidBST(TreeNode root) {
        return isValid(null, root, null);
    }

    private boolean isValid(Integer from, TreeNode node, Integer to) {
        if (node == null) return true;
        return (from == null || from < node.val)
                && (to == null || node.val < to)
                && isValid(from, node.left, node.val)
                && isValid(node.val, node.right, to);
    }

    /**
     * Not my solution, really difficult to understand
     * @param root
     * @return
     */
    public boolean isValidBSTFlat(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
