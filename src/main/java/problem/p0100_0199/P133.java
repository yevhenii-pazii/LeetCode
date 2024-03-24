package problem.p0100_0199;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class P133 {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }
        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        static Node graph(int[]... nodes) {
            var root = nodes[0][0];
            var createdNodes = new Node[101];

            for (var nodeArray : nodes) {
                if (createdNodes[nodeArray[0]] == null) {
                    createdNodes[nodeArray[0]] = new Node(nodeArray[0]);
                }

                var node = createdNodes[nodeArray[0]];

                for (var i = 1; i < nodeArray.length; i++) {
                    if (createdNodes[nodeArray[i]] == null) {
                        createdNodes[nodeArray[i]] = new Node(nodeArray[i]);
                    }

                    node.neighbors.add(createdNodes[nodeArray[i]]);
                }
            }

            return createdNodes[root];
        }
    }

    /*
        Breadth First (loop)

        Time Complexity O(N + M)
        Space Complexity O(N)
        N - number of nodes
        M - number of edges
    */
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        var hash = new Node[101]; //By rules
        hash[node.val] = new Node(node.val);

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            var current = queue.remove();
            var clone = hash[current.val];

            if (current.neighbors.size() != clone.neighbors.size()) {
                for (var neighbor : current.neighbors) {
                    if (hash[neighbor.val] == null) {
                        hash[neighbor.val] = new Node(neighbor.val);
                    }
                    var neighborClone = hash[neighbor.val];
                    clone.neighbors.add(neighborClone);
                    queue.add(neighbor);
                }
            }

        }

        return hash[node.val];
    }

    /*
        Depth First (recursion)

        Time Complexity O(N + M)
        Space Complexity O(N), but I think it is O(N + M);
        N - number of nodes
        M - number of edges
     */
    public Node cloneGraphRecursion(Node node) {
        if (node == null) return null;
        return cloneRecursion(node, new Node[101]);
    }

    private Node cloneRecursion(Node node, Node[] hash) {
        if (hash[node.val] != null) return hash[node.val];

        var clone = new Node(node.val);
        hash[node.val] = clone;

        for (var neighbor : node.neighbors) {
            clone.neighbors.add(cloneRecursion(neighbor, hash));
        }

        return clone;
    }
}
