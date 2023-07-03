package problem;

import structure.TreeNode;

public class P270 {

    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int closestValue(TreeNode root, double target) {
        var result = root.val;
        var resultDif = Math.abs(result - target);

        while (root != null) {
            var dif = Math.abs(root.val - target);
            if (dif < 0.5) {
                return root.val;
            }

            if (dif < resultDif) {
                resultDif = dif;
                result = root.val;
            } else if (dif == resultDif) {
                result = Math.min(result, root.val);
            }

            if (root.val > target) {
                root = root.left;
            } else {
                root = root.right;
            }

        }

        return result;
    }
}
