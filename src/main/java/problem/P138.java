package problem;

import java.util.HashMap;
import java.util.Map;

public class P138 {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }

        static Node find(int index, Node head) {
            if (index < 0) return null;

            for (var i = 0; i < index; i++) {
                head = head.next;

            }
            return head;
        }

        static Node list(int[]... definition) {
            var sentinel = new Node(0);
            var current = sentinel;

            for (var node : definition) {
                current.next = new Node(node[0]);
                current = current.next;
            }

            current = sentinel;
            for (var i = 0; i < definition.length; i++) {
                current = current.next;
                current.random = find(definition[i][1], sentinel.next);
            }

            return sentinel.next;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        var resultSentinel = new Node(0);
        var resultCurrent = resultSentinel;
        var originalCurrent = head;

        Map<Node, Integer> indexByNode = new HashMap<>();
        Node[] nodeByIndex = new Node[1000];
        for (var i = 0; originalCurrent != null;
             i++, originalCurrent = originalCurrent.next, resultCurrent = resultCurrent.next) {
            indexByNode.put(originalCurrent, i);
            resultCurrent.next = new Node(originalCurrent.val);
            nodeByIndex[i] = resultCurrent.next;
        }

        resultCurrent = resultSentinel.next;
        originalCurrent = head;
        while (originalCurrent != null) {
            var randomIndex = indexByNode.get(originalCurrent.random);
            resultCurrent.random = randomIndex == null ? null : nodeByIndex[randomIndex];
            originalCurrent = originalCurrent.next;
            resultCurrent = resultCurrent.next;
        }

        return resultSentinel.next;
    }

    //translation table
    public Node copyRandomListV2(Node head) {
        if (head == null) return null;

        var sentinel = new Node(0);
        var current = sentinel;

        Map<Node, Node> translation = new HashMap<>();

        while (head != null) {

            Node copyNode = translation.get(head);
            if (copyNode == null) {
                copyNode = new Node(head.val);
                translation.put(head, copyNode);
            }

            if (head.random != null) {
                Node randomNode = translation.get(head.random);
                if (randomNode == null) {
                    randomNode = new Node(head.random.val);
                    translation.put(head.random, randomNode);
                }
                copyNode.random = randomNode;
            }

            current.next = copyNode;
            current = current.next;
            head = head.next;
        }

        return sentinel.next;
    }

    //inplace
    public Node copyRandomListV3(Node head) {
        if (head == null) return null;
        var current = head;

        while (current != null) {
            current.next = new Node(current.val, current.next);

            current = current.next.next;
        }

        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        var sentinel = new Node(0);
        var resultCurrent = sentinel;
        current = head;
        while (current != null) {
            resultCurrent.next = current.next;
            current.next = current.next.next;

            current = current.next;
            resultCurrent = resultCurrent.next;
        }

        return sentinel.next;
    }
}
