package problem.p0500_0599;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class P589 {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public static void main(String[] args) {
        System.out.println(new P589().preorder(new Node(1,
                List.of(new Node(3, List.of(new Node(5), new Node(6))),
                        new Node(2),
                        new Node(4)))));

        System.out.println(new P589().preorderRecursion(new Node(1,
                List.of(new Node(3, List.of(new Node(5), new Node(6))),
                        new Node(2),
                        new Node(4)))));
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Deque<Node> elementStack = new LinkedList<>();
        elementStack.push(root);

        while (!elementStack.isEmpty()) {
            Node element = elementStack.pop();
            result.add(element.val);

            if (element.children != null) {
                for (var i = element.children.size() - 1 ; i >= 0; i-- ) {
                    elementStack.push(element.children.get(i));
                }
            }
        }

        return result;
    }

    public List<Integer> preorderRecursion(Node root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        preorderRecursion(root, result);
        return result;
    }

    private void preorderRecursion(Node node, List<Integer> result) {
        result.add(node.val);
        if (node.children != null) {
            for (var n : node.children) {
                preorderRecursion(n, result);
            }
        }
    }
}
