package problem.p0700_0799;

import structure.ListNode;

class P708 {

    // Too slow
    public ListNode insertV1(ListNode head, int insertVal) {
        if (head == null) {
            var node = new ListNode(insertVal);
            node.next = node;
            return node;
        }

        if (head.next == head) {
            head.next = new ListNode(insertVal, head);
            return head;
        }

        var max = head.val;
        var current = head.next;

        while (current != head) { // loop once to find max
            max = Math.max(max, current.val);
            current = current.next;
        }

        while (current.val != max) { // loop to the max
            current = current.next;
        }

        var previous = current; // move one step forward
        current = current.next;

        if (insertVal > current.val) { // else means that insert is smaller than the smallest available
            previous = current;
            current = current.next;

            while (previous.val < insertVal && current.val < insertVal) { //find place to insert
                previous = current;
                current = current.next;
            }
        }

        var newNode = new ListNode(insertVal, current);
        previous.next = newNode;

        return head;
    }

    public ListNode insertV2(ListNode head, int insertVal) {
        if (head == null) {
            var node = new ListNode(insertVal);
            node.next = node;
            return node;
        }

        if (head.next == head) {
            head.next = new ListNode(insertVal, head);
            return head;
        }

        var previous = head;
        var current = previous.next;

        while (!(previous.val <= insertVal && insertVal <= current.val) // p<=i<=c
                && !(current.val < previous.val && insertVal < current.val) // c<p (beginning/end of the loop)  i<c (i is smallest)
                && !(current.val < previous.val && insertVal > previous.val) // c<p (beginning/end of the loop) i>p (i is the biggest)
                && current != head) { // passed the whole loop, so can insert at the end
            previous = current;
            current = current.next;
        }

        var newNode = new ListNode(insertVal, current);
        previous.next = newNode;

        return head;
    }
}
