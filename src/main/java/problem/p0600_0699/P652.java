package problem.p0600_0699;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class P652 {

    //TODO check second approach from Editorial

    /*
        Time Complexity O(N * N)
        Space Complexity O(N * N)

        Map: Node Key(calculated), Node itself
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, TreeNode> table = new HashMap<>();
        Set<String> duplicates = new HashSet<>();

        traverse(root, table, duplicates);

        List<TreeNode> result = new ArrayList<>();
        for (var duplicate : duplicates) {
            result.add(table.get(duplicate));
        }

        return result;
    }

    private static String traverse(TreeNode root, Map<String, TreeNode> table, Set<String> duplicates) {
        if (root == null) return "\0";

        String key = (char) root.getVal() + 201 // by the task constraints
                + traverse(root.left, table, duplicates)
                + traverse(root.right, table, duplicates);

        if (!duplicates.contains(key)) {
            if (table.containsKey(key)) {
                duplicates.add(key);
            } else {
                table.put(key, root);
            }
        }

        return key;
    }
}
