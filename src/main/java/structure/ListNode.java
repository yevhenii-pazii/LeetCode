package structure;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
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

    @Override
    public String toString() {
        return "{" + "v=" + val + ", n=" + next + '}';
    }


    public static ListNode node(int value) {
        return new ListNode(value);
    }

    public static ListNode node(int value, ListNode next) {
        return new ListNode(value, next);
    }

    public static ListNode list(int... nodes) {
        var sentinel = new ListNode(0);
        var current = sentinel;

        for (var n : nodes) {
            current.next = new ListNode(n);
            current = current.next;
        }

        return sentinel.next;
    }

    public static ListNode loopList(int... nodes) {
        var sentinel = new ListNode(0);
        var current = sentinel;

        for (var n : nodes) {
            current.next = new ListNode(n);
            current = current.next;
        }

        current.next = sentinel.next; //loop

        return sentinel.next;
    }

    public static ListNode find(int val, ListNode head) {
        while (head != null && head.val != val) {
            head = head.next;
        }
        return head;
    }
}
