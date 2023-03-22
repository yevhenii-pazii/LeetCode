package problem;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class P430 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node node)) return false;
            return val == node.val && Objects.equals(next, node.next) && Objects.equals(child, node.child);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, prev, next, child);
        }

        @Override
        public String toString() {
            return "" + val + "(" + child + ")" + " -> " + next;
        }

        public static Node node(int val) {
            return new Node(val);
        }
        public static Node node(int val, Node prev, Node next, Node child) {
            return new Node(val, prev, next, child);
        }

        public static Node list(int... values) {
            var head = new Node(values[0]);
            var current = head;

            for (var i = 1; i < values.length; i++) {
                current.next = new Node(values[i], current, null, null);
                current = current.next;
            }

            return head;
        }

        public static Node find(int val, Node head) {
            while (head != null && head.val != val) {
                head = head.next;
            }
            return head;
        }
    };

    public Node flatten(Node head) {
        var current = head;

        while (current != null) {
            if (current.child != null) {
                var childTail = current.child;
                while (childTail.next != null) {
                    childTail = childTail.next;
                }

                if (current.next != null) {
                    childTail.next = current.next;
                    current.next.prev = childTail;
                }

                current.next = current.child;
                current.child.prev = current;

                current.child = null;
            }

            current = current.next;
        }

        return head;
    }

    public Node flattenMyWithStack(Node head) {
        var current = head;
        Deque<Node> stack = new ArrayDeque<>();

        while (current != null) {
            if (current.child != null) {
                if (current.next != null) stack.push(current.next);
                current.next = current.child;
                current.child.prev = current;
                current.child = null;
            }

            if (current.next == null && !stack.isEmpty()) {
                current.next = stack.pop();
                current.next.prev = current;
            }

            current = current.next;
        }

        return head;
    }



    //DFS by Recursion (official) Time: O(n)  Space: O(n)
    public Node flattenRecursion(Node head) {
        if (head == null) return head;
        // pseudo head to ensure the `prev` pointer is never none
        Node pseudoHead = new Node(0, null, head, null);

        flattenDFS(pseudoHead, head);

        // detach the pseudo head from the real head
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }
    /* return the tail of the flatten list */
    private Node flattenDFS(Node prev, Node curr) {
        if (curr == null) return prev;
        curr.prev = prev;
        prev.next = curr;

        // the curr.next would be tempered in the recursive function
        Node tempNext = curr.next;

        Node tail = flattenDFS(curr, curr.child);
        curr.child = null;

        return flattenDFS(tail, tempNext);
    }



    //DFS by Iteration (Official) Time: O(n)  Space: O(n)
    public Node flattenStack(Node head) {
        if (head == null) return head;

        Node pseudoHead = new Node(0, null, head, null);
        Node curr, prev = pseudoHead;

        Deque<Node> stack = new ArrayDeque<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            curr = stack.pop();
            prev.next = curr;
            curr.prev = prev;

            if (curr.next != null) stack.push(curr.next);
            if (curr.child != null) {
                stack.push(curr.child);
                // don't forget to remove all child pointers.
                curr.child = null;
            }
            prev = curr;
        }
        // detach the pseudo node from the result
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }
}
