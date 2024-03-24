package problem.p0100_0199;

import structure.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

class P143 {

    public void reorderList(ListNode head) {

    }

    public void reorderListRecursion(ListNode head) {
        reorderListRecursionHelper(head);
    }

    private ListNode reorderListRecursionHelper(ListNode head) { //returns last one
        if (head == null || head.next == null) {
            return head;
        }

        var next = head.next;

        var reordered = reorderListRecursionHelper(head.next);
        head.next = reordered;

        reordered.next = next;

        return reordered;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public void reorderListStack(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        var current = head;

        while (current != null) {
            deque.add(current);
            current = current.next;
        }

        var first = true;
        ListNode last = deque.getFirst();
        while (!deque.isEmpty()) {
            if (first) {
                last.next = deque.pollFirst();
            } else {
                last.next = deque.pollLast();
            }

            first = !first;
            last = last.next;
        }

        last.next = null;
    }



    public void reorderListSlowFast(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        var middleHead = reverseCyclic(slow.next);

        slow.next = null; // remove the circle

        while (head != null) {
            var headNext = head.next;

            head.next = middleHead;
            if (middleHead != null) {
                var middleNext =  middleHead.next;
                middleHead.next = headNext;
                middleHead = middleNext;
            }

            head = headNext;
        }
    }

    private ListNode reverseRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        var reversed = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return reversed;
    }

    private ListNode reverseCyclic(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            var temp = curr.next;

            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
