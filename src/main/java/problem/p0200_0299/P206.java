package problem.p0200_0299;

import structure.ListNode;

class P206 {


    ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        var result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }


    ListNode reverseListLoop(ListNode head) {
        if (head == null) return null;

        var mover = head;
        head = new ListNode(0, head);

        while (mover.next != null) {
            var currentHead = head.next;
            head.next =  mover.next;
            mover.next = mover.next.next;
            head.next.next = currentHead;
        }

        return head.next;
    }

    public ListNode reverseListOfficial(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}