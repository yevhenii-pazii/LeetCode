package problem.p0000_0099;

import structure.ListNode;

class P61 {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) return head;

        var reversed = reverseLoop(head);
        head.next = reversed;
        var previous = head;

        for (; k > 0; k--) {
            previous = reversed;
            reversed = reversed.next;
        }

        previous.next = null;
        return reverseLoop(reversed);
    }

    private ListNode reverse(ListNode input) {
        if (input == null || input.next == null) return input;
        var reversed = reverse(input.next);
        input.next.next = input;
        input.next = null;
        return reversed;
    }

    private ListNode reverseLoop(ListNode input) {
        if (input == null) return null;

        var sentinel = new ListNode(0);
        var current = input;
        ListNode temp = null;

        while (current != null) {
            temp = current.next;
            current.next = sentinel.next;
            sentinel.next = current;
            current = temp;
        }

        return sentinel.next;
    }

    public ListNode rotateRightV2(ListNode head, int k) {
        if (k == 0 || head == null) return head;
        var i = k;
        var current = head;
        for (; i > 0 && current.next != null; i--) {
            current = current.next;
        }

        ListNode result;
        if (i == 0) { //in this case we moved but didn't reach end -> two point
            var pointer = head;
            while (current.next != null) { //move to the end to find kth element from end
                current = current.next;
                pointer = pointer.next;
            }
            current.next = head; //create loop
            result = pointer.next;
            pointer.next = null; //break loop
        } else { // reach end, k > length -> calculation and simple loop
            current.next = head; //create a loop
            var length = k - i + 1;
            var stepsToMove = (length - k % length) % length; // "(...) % length" special case
            for (var step = 0; step < stepsToMove; step++) {
                current = current.next;
            }
            result = current.next;
            current.next = null; // break loop
        }

        return result;
    }
}
