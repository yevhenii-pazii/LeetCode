package problem;

import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class P1372 {

    /*
        Depth first
        Time Complexity O(N) why not N^2?
        Space complexity O(N) N - for the recursion call
     */
    public int longestZigZagPureRecursion(TreeNode root) {
        if (root == null) return 0;

        var maxCurrent = Math.max(zigZagRecursion(root, false), zigZagRecursion(root, true));
        var maxFromChild = Math.max(longestZigZagPureRecursion(root.left), longestZigZagPureRecursion(root.right));
        return Math.max(maxCurrent, maxFromChild);
    }

    private int zigZagRecursion(TreeNode root, boolean rightTurn) {
        if (root == null) return -1;

        return 1 + (rightTurn ?
                zigZagRecursion(root.right, false) :
                zigZagRecursion(root.left, true));
    }

    /*
        Depth first
        Time Complexity O(N) why not N^2?
        Space complexity O(N) N - for the recursion call + map
     */
    public int longestZigZagRecursionWithMemo(TreeNode root) {
        return recursionWithMemo(root, new HashMap<>());
    }

    private int recursionWithMemo(TreeNode root, Map<Map.Entry<TreeNode, Boolean>, Integer> memo) {
        if (root == null) return 0;
        var maxCurrent = Math.max(
                zigZagRecursionWithMemo(root, false, memo),
                zigZagRecursionWithMemo(root, true, memo));
        var maxFromChild = Math.max(
                recursionWithMemo(root.left, memo),
                recursionWithMemo(root.right, memo));

        return Math.max(maxCurrent, maxFromChild);
    }

    private int zigZagRecursionWithMemo(TreeNode root, boolean rightTurn, Map<Map.Entry<TreeNode, Boolean>, Integer> memo) {
        if (root == null) return -1;
        var memoKey = Map.entry(root, rightTurn);

        if (memo.containsKey(memoKey)) {
            return memo.get(memoKey);
        }

        var current = 1 + (rightTurn ?
                zigZagRecursionWithMemo(root.right, false, memo) :
                zigZagRecursionWithMemo(root.left, true, memo));
        memo.put(memoKey, current);

        return current;
    }
}
