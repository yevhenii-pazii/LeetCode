package problem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class P1857 {

    public int largestPathValue(String colors, int[][] edges) {
        var color = colors.toCharArray();
        var colorCount = 'z' - 'a' + 1;
        var visited = new boolean[colors.length()];
        var nodePath = new int[colors.length()][colorCount];
        var max = new int[colors.length()];
        Set<Integer> endNodes = new HashSet<>();

        visited[0] = true;
        endNodes.add(0);
        nodePath[0][color[0] - 'a']++;
        max[0] = 1;

        for (var edge : edges) {
            endNodes.remove(edge[0]); // Nod from can't be end node

            var newNode = edge[1];

            for (var i = 0; i < colorCount; i++) { // merge previous and new one
                nodePath[newNode][i] = Math.max(nodePath[newNode][i], nodePath[edge[0]][i]);
            }

            if (!visited[newNode]) { //if already visited then calculations are done ???
                visited[newNode] = true;
                endNodes.add(newNode);
                nodePath[newNode][color[newNode] - 'a']++;
                max[newNode] = Math.max(max[newNode], nodePath[newNode][color[newNode] - 'a']);
            } else {
                max[newNode] = Math.max(max[newNode], max[edge[0]]);
            }

        }

        var result = -1;

        for (var endNode : endNodes) {
            result = Math.max(result, max[endNode]);
        }

        return result;
    }


    /*
     Not mine
     */
    public int largestPathValueRecursion(String colors, int[][] edges) {
        int n = colors.length();
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>())
                    .add(edge[1]);
        }

        int[][] count = new int[n][26];
        boolean[] visit = new boolean[n];
        boolean[] inStack = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dfs(i, colors, adj, count, visit, inStack));
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private int dfs(int node, String colors, Map<Integer, List<Integer>> adj, int[][] count,
                    boolean[] visit, boolean[] inStack) {
        // If the node is already in the stack, we have a cycle.
        if (inStack[node]) {
            return Integer.MAX_VALUE;
        }
        if (visit[node]) {
            return count[node][colors.charAt(node) - 'a'];
        }
        // Mark the current node as visited and part of current recursion stack.
        visit[node] = true;
        inStack[node] = true;

        if (adj.containsKey(node)) {
            for (int neighbor : adj.get(node)) {
                if (dfs(neighbor, colors, adj, count, visit, inStack) == Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                for (int i = 0; i < 26; i++) {
                    count[node][i] = Math.max(count[node][i], count[neighbor][i]);
                }
            }
        }

        // After all the incoming edges to the node are processed,
        // we count the color on the node itself.
        count[node][colors.charAt(node) - 'a']++;
        // Remove the node from the stack.
        inStack[node] = false;
        return count[node][colors.charAt(node) - 'a'];
    }
}
