package problem.p0200_0299;

class P235 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
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
        var tree = new TreeNode(6,
                new TreeNode(2,
                        new TreeNode(0),
                        new TreeNode(4,
                                new TreeNode(3),
                                new TreeNode(5))),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)));

        System.out.println(new P235().lowestCommonAncestor(tree, new TreeNode(2), new TreeNode(8)));
        System.out.println(new P235().lowestCommonAncestor(tree, new TreeNode(2), new TreeNode(4)));
        System.out.println(new P235().lowestCommonAncestor(tree, new TreeNode(7), new TreeNode(9)));
        System.out.println(new P235().lowestCommonAncestor(tree, new TreeNode(0), new TreeNode(9)));

        System.out.println();

        System.out.println(new P235().lowestCommonAncestorFlat(tree, new TreeNode(2), new TreeNode(8)));
        System.out.println(new P235().lowestCommonAncestorFlat(tree, new TreeNode(2), new TreeNode(4)));
        System.out.println(new P235().lowestCommonAncestorFlat(tree, new TreeNode(7), new TreeNode(9)));
        System.out.println(new P235().lowestCommonAncestorFlat(tree, new TreeNode(0), new TreeNode(9)));
    }

    public TreeNode lowestCommonAncestorFlat(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            var temp = p;
            p = q;
            q = temp;
        }

        while (root != null) {
            if (q.val < root.val) {
                root = root.left;
            } else if (root.val < p.val) {
                root = root.right;
            } else {
                return root;
            }
        }

        return null;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            return process(root, q, p);
        } else {
            return process(root, p, q);
        }

    }

    private TreeNode process(TreeNode root, TreeNode p, TreeNode q) {
        if (q.val < root.val) {
            return root.left == null ? root : lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val) {
            return root.right == null ? root : lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}
