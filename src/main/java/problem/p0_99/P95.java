package problem.p0_99;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class P95 {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> result = new ArrayList<>();

        for (var i = 1; i <= n; i++) {
            List<Integer> leftSide = new ArrayList<>();
            for (var j = 1; j < i; j++) {
                leftSide.add(j);
            }
            List<Integer> rightSide = new ArrayList<>();
            for (var k = i + 1; k <= n; k++) {
                rightSide.add(k);
            }
            var node = new TreeNode(i);
            recursion(node, leftSide, rightSide, result);
        }

        return result;
    }

    private void recursion(TreeNode root,
                           List<Integer> leftSide, List<Integer> rightSide,
                           List<TreeNode> result) {

        if (leftSide.size() == 0 && rightSide.size() == 0) {
            result.add(root);
            return;
        }

//        if (leftSide.size() > 1) {
//            for (var n : leftSide) {
//                addTo(root);
//            }
//        } else {
//            addTo();
//        }







    }

    private TreeNode clone(TreeNode root) {
        if (root == null) return null;
        return new TreeNode(root.val, clone(root.left), clone(root.right));
    }

    private void addTo(TreeNode root, int n) {
        if (n < root.val) {
            if (root.left == null) {
                root.left = new TreeNode(n);
            } else {
                addTo(root.left, n);
            }
        } else {
            if (root.right == null) {
                root.right = new TreeNode(n);
            } else {
                addTo(root.right, n);
            }
        }
    }





    public List<TreeNode> generateTreesOfficial(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }
    private LinkedList<TreeNode> generateTrees(int start, int end) {
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        if (start > end) {
            treeNodes.add(null);
            return treeNodes;
        }

        // pick up a root
        for (int i = start; i <= end; i++) {
            // all possible left subtrees if i is chosen to be a root
            LinkedList<TreeNode> leftTrees = generateTrees(start, i - 1);

            // all possible right subtrees if i is chosen to be a root
            LinkedList<TreeNode> rightTrees = generateTrees(i + 1, end);

            // connect left and right trees to the root i
            for (TreeNode l : leftTrees) {
                for (TreeNode r : rightTrees) {
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = l;
                    currentTree.right = r;
                    treeNodes.add(currentTree);
                }
            }
        }
        return treeNodes;
    }

}
