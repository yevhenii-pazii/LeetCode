package problem.p0100_0199;

import java.util.HashSet;
import java.util.Set;

class P142 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this(x, null);
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {
        var head = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
        head.next.next.next.next = head.next;
        System.out.println(new P142().detectCycle(head));
    }


    class SolutionV1 {
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> nodes = new HashSet<>();
            while (head != null && !nodes.contains(head)) {
                nodes.add(head);
                head = head.next;

            }
            return head;
        }
    }

    public ListNode detectCycle(ListNode head) {
        var slow = head;
        var fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }

        return null;
    }
}
