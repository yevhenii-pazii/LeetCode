import java.util.Objects;

public class P19 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" + "val=" + val + ", next=" + next + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ListNode listNode)) return false;
            return val == listNode.val && Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        var endNode = head;
        for (var i = 0; i < n; i++) {
            endNode = endNode.next; // not NPE possible by constraints
        }

        head = new P19.ListNode(0, head);
        var preRemoveNode = head;

        while (endNode != null) {
            preRemoveNode = preRemoveNode.next;
            endNode = endNode.next;
        }

        preRemoveNode.next = preRemoveNode.next.next;


        return head.next;
    }
}
