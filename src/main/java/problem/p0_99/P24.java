package problem.p0_99;

import structure.ListNode;

class P24 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        var tail = swapPairs(head.next.next);
        var result = head.next;
        head.next = tail;
        result.next = head;

        return result;
    }

    public ListNode swapPairsLoop(ListNode head) {
        var sentinel = new ListNode(0 , head);
        var current = sentinel;

        while (head != null && head.next != null) {
            current.next = head.next;
            current = current.next;

            head.next = head.next.next;
            current.next = head;

            current = current.next;
            head = head.next;
        }

        return sentinel.next;
    }
}
